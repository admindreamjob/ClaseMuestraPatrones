package com.tecmty.patterns;

public class VariableFactory {

    VariableHandler configureLoader(String loaderType) throws VariableLoaderException{
         loaderType = loaderType.toUpperCase();
         if(loaderType.equals("DB_MYSQL")){
             return new MySQLVariableHandler();
         }else if(loaderType.equals("DB_POSTGRESQL")){
             return new PostgreSQLVariableHandler();
         } else if(loaderType.equals("FILE")){
             return new FileVariableHandler();
         }else if(loaderType.equals("MEMORY")){
             return new MemoryVariableHandler();
         }else
          throw new VariableLoaderException("Invalid Variable Loader Type: " +loaderType+ "!");
     }
}
