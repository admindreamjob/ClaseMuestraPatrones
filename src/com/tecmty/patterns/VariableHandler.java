package com.tecmty.patterns;

import java.util.HashMap;
import java.util.Map;

public abstract class VariableHandler {

    public abstract Map<String,Variable> load() throws VariableLoaderException;
      public abstract Map<String,Variable> refresh() throws VariableLoaderException;
      public abstract void update(Variable variable);
      public abstract void clear(Variable variable);
      public abstract void add(Variable variable);
      protected Variable variableMapper(String key, String value, String type)
      throws VariableLoaderException{
             if(type.equals("STRING")){
                   return new Variable(key,value,type);
             }else if(type.equals("BOOLEAN")){
                   return new Variable(key,Boolean.valueOf(value),type);
             }else if(type.equals("FLOAT")){
                   return new Variable(key,Float.valueOf(value),type);
             }else if(type.equals("INTEGER")){
                   return new Variable(key,Integer.valueOf(value),type);
             }else if(type.equals("DOUBLE")){
                   return new Variable(key,Double.valueOf(value),type);
             }else if(type.equals("LONG")){
                   return new Variable(key,Long.valueOf(value),type);
             }else{
                   throw new VariableLoaderException("Variable of type: " +type+ " not found!");
             }
      }
}
