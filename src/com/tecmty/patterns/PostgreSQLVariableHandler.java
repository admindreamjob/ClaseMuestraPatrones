package com.tecmty.patterns;

public class PostgreSQLVariableHandler extends DBVariableHandler{

    public PostgreSQLVariableHandler(){
        JDBC_URL = "jdbc:postgresql://localhost:5432/test_variables";
        USER = "ricardoivison";
        PWD = "Man1ngo76";
    }
}
