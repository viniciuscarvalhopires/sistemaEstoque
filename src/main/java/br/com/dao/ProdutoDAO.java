/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dao;

import br.com.connectionjdbc.SingleConnection;
import br.com.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius
 */
public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO() {
        this.connection = SingleConnection.getConnection();
    }

    public void insert(Produto produto) {
        try {
            String sql = "insert into tb_produto (nm_produto, vl_produto, cd_categoria, qt_quantidadeProduto, ds_descricao) values (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNm_produto());//produto.getNm_produto());
            stmt.setDouble(2, produto.getVl_produto());//Double.toString(produto.getVl_produto()));
            stmt.setInt(3, produto.getCd_categoria_produto());//Integer.toString(produto.getCd_categoria_produto()));
            stmt.setInt(4, produto.getQt_produto());
            stmt.setString(5, produto.getDs_descricao());
            stmt.execute();

            connection.commit();
            JOptionPane.showMessageDialog(null, "Produto inserida com sucesso.");
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void delete(String index) {
        try {
            String sql = "delete from tb_produto where cd_produto = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, index);
            stmt.executeUpdate();

            connection.commit();
            JOptionPane.showMessageDialog(null, "Produto deletado com sucesso.");

        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
