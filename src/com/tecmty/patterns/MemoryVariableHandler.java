package com.tecmty.patterns;

import java.util.HashMap;
import java.util.Map;

public class MemoryVariableHandler extends VariableHandler{

    private Map<String, Variable> variables = new HashMap<>();

    private void loadVariables(){
          variables.clear();
          variables.put("Discount",
                  new Variable("Discount",Float.valueOf(0.15f),"FLOAT"));
    }
    @Override
    public Map<String, Variable> load() throws VariableLoaderException {
         loadVariables();
        return variables;
    }

    @Override
    public Map<String, Variable> refresh() throws VariableLoaderException {
        loadVariables();
        return variables;
    }

    @Override
    public void update(Variable variable) {

    }

    @Override
    public void clear(Variable variable) {

    }

    @Override
    public void add(Variable variable) {

    }
}
