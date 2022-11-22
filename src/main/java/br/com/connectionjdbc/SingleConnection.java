/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.connectionjdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SingleConnection {
    private static String userHome = System.getProperty("user.home");
    private static String url = "jdbc:sqlite:" + userHome + "\\database.db";
    
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
            
            //Usamos in-memory database
            
        
            
            
            
            String tb_categoria = "CREATE TABLE IF NOT EXISTS tb_categoria (cd_categoria INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL DEFAULT (0), nm_categoria VARCHAR (255));";
            PreparedStatement stmt = connection.prepareStatement(tb_categoria);
            stmt.executeUpdate();
          
            
            String tb_produto = "CREATE TABLE IF NOT EXISTS tb_produto (cd_produto INTEGER CONSTRAINT pk_produto PRIMARY KEY ASC AUTOINCREMENT UNIQUE ON CONFLICT ROLLBACK NOT NULL DEFAULT (1), nm_produto VARCHAR (255) NOT NULL, vl_produto DOUBLE (9, 2) NOT NULL, cd_categoria INT CONSTRAINT fk_produto_categoria REFERENCES tb_categoria (cd_categoria) NOT NULL, ds_descricao VARCHAR (255), qt_quantidadeProduto INTEGER);";
            stmt = connection.prepareStatement(tb_produto);
            stmt.executeUpdate();
            
            
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() {
        return connection;
    }
    
}
