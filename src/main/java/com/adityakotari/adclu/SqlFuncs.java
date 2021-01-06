package com.adityakotari.adclu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlFuncs{

    final static String url = "jdbc:sqlite:./adclu.db";
    
    final static String table = "CREATE TABLE IF NOT EXISTS tasks (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text\n"
                + ");";

    public static void execute(String sqlCommand) {
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            
            stmt.execute(table);
            stmt.execute(sqlCommand);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<String> query(){
        
        String sqlSelect = "SELECT name FROM tasks";
        ArrayList<String> taskList=new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()){
            
            stmt.execute(table);               
            ResultSet rs = stmt.executeQuery(sqlSelect); 
            // loop through the result set
            while (rs.next()) {
                taskList.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return taskList;
    }
}