/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.connectionjdbc;


import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
    private static String url = "jdbc:sqlite:database.sqlite";
    private static String database = "";
    private static String user = "root";
    private static String password = "admin";
    
    private static Connection connection = null;
    
    static {
        connect();
    }
    
    public SingleConnection() {
        connect();
    }
    
    private static void connect(){
        try {
            if(connection == null){
            Class.forName("org.sqlite.JDBC");
            
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() {
        return connection;
    }
    
}
