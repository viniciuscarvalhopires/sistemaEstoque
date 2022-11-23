/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dao;

import br.com.connectionjdbc.SingleConnection;
import br.com.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void delete(int index){
        try {
            String sql = "delete from tb_categoria where cd_categoria = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, index);
            stmt.executeUpdate();
            
            sql = "delete from tb_produto where cd_categoria = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, index);
            stmt.executeUpdate();
             
     
            connection.commit();
            JOptionPane.showMessageDialog(null, "Categoria deletada com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(Categoria categoria){
        try {
            String sql = "update tb_categoria set nm_categoria = ? where cd_categoria = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getCd_categoria());
         
            stmt.executeUpdate();
           connection.commit();
    
            JOptionPane.showMessageDialog(null, "CAtegoria alterada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                e.printStackTrace();
            }
        }
    }
    
    public int selectID(String name) {
        int id = 0;
        try {
            String sql = "select cd_categoria from tb_categoria where nm_categoria = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            
            id = rs.getInt("cd_categoria");
            stmt.close();
            rs.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return id;
    }
    
    public String count(){
        int qtCategoria = 0;
        
        try {
            String sql = "select count(cd_categoria) as count from tb_categoria";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
            qtCategoria = rs.getInt("count");
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocorreu um erro: " + e);
        }
        
        return Integer.toString(qtCategoria);
    }
    
   /* public void  throws Exception {
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
