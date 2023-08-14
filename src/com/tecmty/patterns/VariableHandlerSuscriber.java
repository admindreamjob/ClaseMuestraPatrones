package com.tecmty.patterns;

public class VariableHandlerSuscriber implements VariableSuscriber{

    private VariableHandler handler;
    public VariableHandlerSuscriber(VariableHandler handler){
        this.handler = handler;
    }

    @Override
    public void update(Variable variable) {
         handler.update(variable);
    }
}
