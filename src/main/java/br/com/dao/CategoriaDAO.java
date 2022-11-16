/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dao;

import br.com.connectionjdbc.SingleConnection;
import br.com.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import javax.swing.JOptionPane;


/**
 *
 * @author Vinicius
 */
public class CategoriaDAO {
    
    private Connection connection;
  
    
    public CategoriaDAO() {
        this.connection = SingleConnection.getConnection();
    }
    
    public void insert(Categoria categoria){
        try {
            String sql = "insert into tb_categoria (nm_categoria) values (?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            stmt.execute();
            connection.commit();
            JOptionPane.showMessageDialog(null, "Categoria inserida com sucesso.");
        } catch (Exception e) {
            try {
                connection.rollback();
               JOptionPane.showMessageDialog(null, "Ocorreu um erro e foi feito um rollback!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex);
                ex.printStackTrace();
            }
            e.printStackTrace();
            }
            
    }
    
    public void delete(String index){
        try {
            String sql = "delete from tb_categoria where cd_categoria = " + index;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
            connection.commit();
            JOptionPane.showMessageDialog(null, "Categoria deletada com sucesso.");
        } catch (Exception e) {
        }
    }
    
    public void update(String index, String name){
        try {
            String sql = "update tb_categoria set nm_categoria = ? where cd_categoria = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, index);
            int rowsUpdate = stmt.executeUpdate();
            connection.commit();
            JOptionPane.showMessageDialog(null, "CAtegoria alterada com sucesso!");
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                e.printStackTrace();
            }
        }
    }
    
   /* public void list() throws Exception {
        int count;
        
        List<Categoria> categoriaLista = new ArrayList<>();
        
        String sql = "select * from tb_categoria";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        ResultSetMetaData rsmd = rs.getMetaData();
        count  = rsmd.getColumnCount();
        
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        
        while (rs.next()) {
            
            Categoria categoria = new Categoria();
            categoria.setCd(rs.getInt("cd_categoria"));
            categoria.setNome(rs.getString("nm_categoria"));
            
            categoriaLista.add(categoria);
        }
        
      
    }*/
    
}
