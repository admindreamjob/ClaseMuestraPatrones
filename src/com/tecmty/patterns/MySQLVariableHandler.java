package com.tecmty.patterns;

public class MySQLVariableHandler  extends  DBVariableHandler{

    public MySQLVariableHandler(){
        JDBC_URL = "jdbc:mysql://localhost:3306/Test_Variables?useTimezone=true&serverTimezone=UTC";
        USER = "spring";
        PWD = "P@55w0rd";
    }

}
