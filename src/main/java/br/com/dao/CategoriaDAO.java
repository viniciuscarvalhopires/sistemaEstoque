package br.com.dao;

import br.com.connectionjdbc.SingleConnection;
import br.com.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import javax.swing.JOptionPane;

//Classe para realizar as operações CRUD na base de dados na tabela categoria.
public class CategoriaDAO {

    private Connection connection;

    //Pega a conexão da classe SingleConnection
    public CategoriaDAO() {
        this.connection = SingleConnection.getConnection();
    }

    //Método para realizar um insert no banco de dados, recebe um objeto como parâmetro, o ID é autoincrementado já pela base de dados;
    public void insert(Categoria categoria) {
        try {
            String sql = "insert into tb_categoria (nm_categoria) values (?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            stmt.execute();
            connection.commit();
            JOptionPane.showMessageDialog(null, "Categoria inserida com sucesso.");
        } catch (Exception e) {
            try {
                //Caso ocorra algum erro, reverte as alterações feitas e exibe o erro.
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Ocorreu um erro e foi feito um rollback: " + e);
            } catch (SQLException ex) {
                //Caso ocorra algum erro ao reverter as alterações retorna a o erro.
                JOptionPane.showMessageDialog(null, "Erro: " + ex);
            }
        }

    }

    //Método para realizar um delete na base de dados, tem como parâmetro o index, que corresponde ao ID da categoria, retirado do item selecionado na tabela.
    public void delete(int index) {
        try {

            //Exclusão em cascata
            //Deleta a categoria deseja da tb_categoria
            String sql = "delete from tb_categoria where cd_categoria = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, index);
            stmt.executeUpdate();

            //Deleta os produtos que pertecem a categoria excluída
            sql = "delete from tb_produto where cd_categoria = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, index);
            stmt.executeUpdate();

            connection.commit();
            JOptionPane.showMessageDialog(null, "Categoria deletada com sucesso.");
        } catch (Exception e) {
            try {
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Ocorreu um erro e as alterações foram revertidas: " + e);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao reverter as alterações: " + ex);
            }
        }
    }

    //Método para realizar alterações na tb_categoria, recebe como parâmetro um objeto categoria com ID e nome já atribuidos retirados de uma categoria já existente na base de dados.
    public void update(Categoria categoria) {
        try {

            //Altera a categoria desejada
            String sql = "update tb_categoria set nm_categoria = ? where cd_categoria = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getCd_categoria());

            stmt.executeUpdate();
            connection.commit();

            JOptionPane.showMessageDialog(null, "Categoria alterada com sucesso!");
        } catch (Exception e) {
            try {
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao alterar a categoria e as alterações foram revertidas: " + e);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao reverter as alterações" + ex);
            }
        }
    }

    //Retorna o ID da categoria baseado na String recebida como parametro 
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
            JOptionPane.showConfirmDialog(null, "Ocorreu um erro: " + e);
        }

        return id;
    }

    //Método que retorna a quantidade de categorias cadastradas para exibir na tela de Inicio
    public String count() {
        int qtCategoria = 0;

        try {
            String sql = "select count(cd_categoria) as count from tb_categoria";
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
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
