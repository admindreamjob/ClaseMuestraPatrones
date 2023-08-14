package com.tecmty.patterns;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FileVariableHandler extends VariableHandler{

    File variables =
            new File("/Users/ricardoivison/Dropbox/Proyectos/ClaseMuestraPatrones/variables.txt");

    @Override
    public Map<String, Variable> load() throws VariableLoaderException{
        Map<String,Variable> variableMap = new HashMap<>();

        String varName="";
        String value="";
        String type="";
        try{
            //Reads the file using scanner
            Scanner scanner
                    = new Scanner(variables);
            //Reads all lines from the file
            while (scanner.hasNextLine()) {
                //Gets next line
                String line = scanner.nextLine();
                //Gets separator position
                int pos = line.indexOf(":");
                //Gets variable
                varName = line.substring(0, pos);
                //Extracts remaining of the line
                value = line.substring(pos + 1, line.length());
                //Gets the new separator
                pos = value.indexOf(":");
                //Gets the type
                type = value.substring(pos + 1, value.length());
                //Gets the first part before the :, which is the value
                value = value.substring(0, pos);
                //Creates the variable and adds it to the map
                variableMap.put(varName, variableMapper(varName,value,type));
            }
        }catch(IOException io){
            throw new VariableLoaderException(io.getMessage());
        }catch(VariableLoaderException ve){
            throw new VariableLoaderException(ve.getMessage());
        }
        return variableMap;
    }

    @Override
    public Map<String,Variable> refresh() throws VariableLoaderException {
        return load();
    }

    @Override
    public void update(Variable variable) {
        //Instantiating the Scanner class to read the file
        Scanner scanner = null;
        String varName="";
        String value="";
        String type="";
        try {
            scanner = new Scanner(variables);
            //instantiating the StringBuffer class
            StringBuffer buffer = new StringBuffer();
            //Reading lines of the file and appending them to StringBuffer
            while (scanner.hasNextLine()) {
                //Gets next line
                String line = scanner.nextLine();
                //Gets separator position
                int pos = line.indexOf(":");
                //Gets variable
                varName = line.substring(0, pos);
                //Extracts remaining of the line
                value = line.substring(pos + 1, line.length());
                //Gets the new separator
                pos = value.indexOf(":");
                //Gets the type
                type = value.substring(pos + 1, value.length());
                //Gets the first part before the :, which is the value
                value = value.substring(0, pos);
                if(varName.equals(variable.getKey())){
                    line=varName+":"+variable.getValue()+":"+type;
                }
                buffer.append(line+System.lineSeparator());
            }
            String fileContents = buffer.toString();
            //closing the Scanner object
            scanner.close();
            //instantiating the FileWriter class
            FileWriter writer = new FileWriter(variables);
            writer.append(fileContents);
            writer.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void clear(Variable variable) {
        //Instantiating the Scanner class to read the file
        Scanner scanner = null;
        String varName="";
        String value="";
        String type="";
        try {
            scanner = new Scanner(variables);
            //instantiating the StringBuffer class
            StringBuffer buffer = new StringBuffer();
            //Reading lines of the file and appending them to StringBuffer
            while (scanner.hasNextLine()) {
                //Gets next line
                String line = scanner.nextLine();
                //Gets separator position
                int pos = line.indexOf(":");
                //Gets variable
                varName = line.substring(0, pos);
                //Extracts remaining of the line
                value = line.substring(pos + 1, line.length());
                //Gets the new separator
                pos = value.indexOf(":");
                //Gets the type
                type = value.substring(pos + 1, value.length());
                //Gets the first part before the :, which is the value
                value = value.substring(0, pos);
                if(varName.equals(variable.getKey())){
                    if(scanner.hasNextLine()){
                        line=scanner.nextLine();
                    }else{
                        break;
                    }
                }
                buffer.append(line+System.lineSeparator());
            }
            String fileContents = buffer.toString();
            //closing the Scanner object
            scanner.close();
            //instantiating the FileWriter class
            FileWriter writer = new FileWriter(variables);
            writer.append(fileContents);
            writer.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void add(Variable variable) {
        //Instantiating the Scanner class to read the file
        Scanner scanner = null;
        String varName="";
        String value="";
        String type="";
        try {
            scanner = new Scanner(variables);
            //instantiating the StringBuffer class
            StringBuffer buffer = new StringBuffer();
            //Reading lines of the file and appending them to StringBuffer
            String line;
            while (scanner.hasNextLine()) {
                //Gets next line
                line = scanner.nextLine();
                buffer.append(line+System.lineSeparator());
            }
            line = variable.getKey()+":"+variable.getValue()+":"+variable.getType();
            buffer.append(line+System.lineSeparator());
            String fileContents = buffer.toString();
            //closing the Scanner object
            scanner.close();
            //instantiating the FileWriter class
            FileWriter writer = new FileWriter(variables);
            writer.append(fileContents);
            writer.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
