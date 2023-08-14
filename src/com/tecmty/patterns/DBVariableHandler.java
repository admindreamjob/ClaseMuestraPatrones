package com.tecmty.patterns;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;

import java.util.HashMap;
import java.util.Map;

public class DBVariableHandler extends VariableHandler{

    protected Connection connection = null;

    protected String JDBC_URL = "";
    protected String USER = "";
    protected String PWD = "";

    DBVariableHandler(){}

    @Override
    public Map<String,Variable> load() throws VariableLoaderException{
        Map<String,Variable> variables = new HashMap<>();
        try {
            connection = DriverManager.getConnection(JDBC_URL, USER, PWD);

            String sql;
            sql = "Select * from variable";
            Statement query = connection.createStatement();
            ResultSet result = query.executeQuery(sql);
            while (result.next()) {
                String key = result.getString("name");
                variables.put(key,
                        variableMapper(result.getString("name"),
                                result.getString("value"),
                                result.getString("type")));
            }//end while
            result.close();
            connection.close();
            connection = null;
        }catch(SQLException ex){
            throw new VariableLoaderException(ex.getMessage());
        }finally{
             if(connection!=null){
                 try{
                     connection.close();
                 }catch(SQLException sqle){
                     throw new VariableLoaderException(sqle.getMessage());
                 }
             }
        }
        return variables;
    }

    @Override
    public Map<String,Variable> refresh() throws VariableLoaderException {
         return load();
    }

    @Override
    public void update(Variable variable) {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USER, PWD);

            String sql = "UPDATE variable SET value = ? WHERE name = ?";
            PreparedStatement update = connection.prepareStatement(sql);
            update.setString(2, variable.getKey());
            update.setString(1, variable.getValue().toString());
            update.executeUpdate();
            update.close();
            connection.close();
            connection = null;
        }catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }finally{
            if(connection!=null){
                try{
                    connection.close();
                    connection = null;
                }catch(SQLException sqle){
                    throw new RuntimeException(sqle.getMessage());
                }
            }
        }
    }

    @Override
    public void clear(Variable variable) {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USER, PWD);

            String sql = "delete from variable WHERE name = ?";
            PreparedStatement update = connection.prepareStatement(sql);
            update.setString(1, variable.getKey());
            update.executeUpdate();
            update.close();
            connection.close();
            connection = null;
        }catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }finally{
            if(connection!=null){
                try{
                    connection.close();
                    connection = null;
                }catch(SQLException sqle){
                    throw new RuntimeException(sqle.getMessage());
                }
            }
        }


    }

    @Override
    public void add(Variable variable) {
        try {
            String sql = "insert into variable(name,value,type) values(?,?,?)";
            PreparedStatement update = connection.prepareStatement(sql);
            update.setString(1, variable.getKey());
            update.setString(2, variable.getValue().toString());
            update.setString(3, variable.getType());
            update.executeUpdate();
            update.close();
            connection.close();
            connection = null;
        }catch(SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }finally{
            if(connection!=null){
                try{
                    connection.close();
                    connection = null;
                }catch(SQLException sqle){
                    throw new RuntimeException(sqle.getMessage());
                }
            }
        }


    }

}
