package com.tecmty.patterns;

public class Variable {
    private String key;
    private Object value;
    private String type;

    //Constructores
    public Variable() { }

    /*public Variable(String key, Object value) {
        this.key = key;
        this.value = value;
    }*/

    public Variable(String key, Object value, String type) {
        this.key = key;
        this.value = value;
        this.type = type;
    }

    public String getKey() { return key; }

    public void setKey(String key) { this.key = key; }

    public Object getValue() { return value; }

    public void setValue(Object value) { this.value = value; }

    public String getType() { return type; }

    public void setType(String type) {
        this.type = type;
    }
}
