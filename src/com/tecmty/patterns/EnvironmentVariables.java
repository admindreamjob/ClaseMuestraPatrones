package com.tecmty.patterns;

import java.util.Map;

public class EnvironmentVariables implements VariableSuscriber{

    private VariableHandler handler;
    /** Mapa de variables de ambiente */
    private Map variableMap;

    /** Instancia Singleton*/
    private static EnvironmentVariables instance;

    private static String source;

    private EnvironmentVariables(){
        //Carga las variables de por ejemplo, una base de datos
        loadEnvironmentVariables();
    }

    private EnvironmentVariables(String newSource){
        //Carga las variables de por ejemplo, una base de datos
        source = newSource;
        loadEnvironmentVariables();
    }
    /** Metodo para acceder a la unica instancia */
    public static EnvironmentVariables getInstance(){
        //Si no existe, la crea
        if(instance == null){
            instance = new EnvironmentVariables();
        }
        return instance;
    }

    /** Metodo para acceder a la unica instancia */
    public static EnvironmentVariables getInstance(String source){
        //Si no existe, la crea
        if(instance == null){
            instance = new EnvironmentVariables(source);
        }
        return instance;
    }

    /** Mapa que contiene variables de ambiente en memoria*/
    public Map getVariableMap(){
        return variableMap;
    }

    /** Returns variable handler*/
    public VariableHandler getVariableHandler(){
        return handler;
    }

    @Override
    public void update(Variable variable) {
        if(variableMap.containsKey(variable.getKey())) {
            variableMap.replace(variable.getKey(), variable);
        }
        else {
            variableMap.put(variable.getKey(), variable);
        }
    }

    private void loadEnvironmentVariables() {
        VariableFactory factory = new VariableFactory();
        try {
             handler = factory.configureLoader(source);
             variableMap = handler.load();
        }catch(VariableLoaderException vle){
            throw new RuntimeException(vle.getMessage());
        }
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof EnvironmentVariables)
            return true;
        else return false;
    }
}
