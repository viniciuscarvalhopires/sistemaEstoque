/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.views;

import br.com.connectionjdbc.SingleConnection;
import br.com.dao.CategoriaDAO;
import br.com.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class categoria extends javax.swing.JFrame {

    public categoria() {
        initComponents();
        atualizarTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCategorias = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        produto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inicio = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        categoryName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearFields = new javax.swing.JButton();
        insertButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCategorias);
        if (tabelaCategorias.getColumnModel().getColumnCount() > 0) {
            tabelaCategorias.getColumnModel().getColumn(0).setMinWidth(30);
            tabelaCategorias.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabelaCategorias.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        produto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        produto.setForeground(new java.awt.Color(255, 255, 255));
        produto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        produto.setText("Produtos");
        produto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        produto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        produto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                produtoMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Categorias");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        inicio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inicio.setForeground(new java.awt.Color(255, 255, 255));
        inicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        inicio.setText("Início");
        inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inicioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inicio)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(produto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(produto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categoria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        categoryName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryNameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Nome");

        editButton.setText("Alterar");
        editButton.setToolTipText("Para alterar uma categoria selecione na tabela abaixo e insira o novo nome no campo acima");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Deletar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        clearFields.setText("Limpar");
        clearFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFieldsActionPerformed(evt);
            }
        });

        insertButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        insertButton.setText("Salvar");
        insertButton.setToolTipText("Clique para salvar");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(insertButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(deleteButton))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryName)))
                .addGap(46, 46, 46)
                .addComponent(clearFields)
                .addGap(38, 38, 38))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(deleteButton)
                    .addComponent(clearFields)
                    .addComponent(insertButton))
                .addContainerGap())
        );

        insertButton.getAccessibleContext().setAccessibleDescription("Clique para salvar categoria");

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        jLabel3.setLabelFor(searchField);
        jLabel3.setText("Pesquisar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Método para atualizar a tabela de categorias exibida na tela
    private void atualizarTabela() {
        int count = 0;

        try {
            Connection con = SingleConnection.getConnection();
            String sql = "select * from tb_categoria";

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            count = rsmd.getColumnCount(); //Retorna a quantidade de colunas na tabela a ser realizado o select

            DefaultTableModel tabelaModel = (DefaultTableModel) tabelaCategorias.getModel();

            tabelaModel.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector(); //Vetor criado para armazenar os valores das colunas do ResultSet

                for (int i = 0; i < count; i++) {
                    v.add(rs.getInt("cd_categoria"));
                    v.add(rs.getString("nm_categoria"));
                }

                tabelaModel.addRow(v); //Adiciona o vetor a linha da tabela
            }

        } catch (SQLException ex) {
            Logger.getLogger(categoria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void categoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryNameActionPerformed

    }//GEN-LAST:event_categoryNameActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed

        if (("".equals(categoryName.getText())) || (categoryName.getText() == null)) {
            JOptionPane.showMessageDialog(null, "Insira um nome válido!");
        } else {

            Categoria categoria = new Categoria(); //Instancia a classe categoria 
            CategoriaDAO dao = new CategoriaDAO();  //Instancia a classe categoriaDAO
            int column = 0;
            int row = tabelaCategorias.getSelectedRow();
            String name = categoryName.getText();
            int cd = (int) tabelaCategorias.getModel().getValueAt(row, column); //Pega o valor do id da linha selecionada na coluna 0, ou seja, na primeira coluna da linha selecionada
            categoria.setNome(name); //Seta o nome da categoria
            categoria.setCd_categoria(cd); //Seta o id da categoria a ser editada
            dao.update(categoria); //Executa o método update da categoriaDAO
            atualizarTabela(); // Executa o método de atualizar a tabela ao editar categoria
        }

        categoryName.setText(""); //Limpa o campo do nome da categoria
    }//GEN-LAST:event_editButtonActionPerformed

    private void clearFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFieldsActionPerformed
        categoryName.setText(""); //Limpa o campo do nome da categoria
    }//GEN-LAST:event_clearFieldsActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        if (("".equals(categoryName.getText())) || (categoryName.getText() == null)) {
            JOptionPane.showMessageDialog(null, "Insira um nome válido!");
        } else {

            Categoria categoria = new Categoria();
            CategoriaDAO dao = new CategoriaDAO();
            categoria.setNome(categoryName.getText());
            dao.insert(categoria); //Insere a categoria, o ID da categoria não foi setado manualmente pois é gerado automaticamente pelo bd
            atualizarTabela();
        }
        categoryName.setText("");
    }//GEN-LAST:event_insertButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed

        int row = tabelaCategorias.getSelectedRow();

        if (row < 0) { // Caso não tenha linha selecionada, exibe uma mensagem
            JOptionPane.showMessageDialog(null, "Selecione um produto da lista.");
        } else {
            //Exibe uma janela de confirmação para o usuário
            int opcao = JOptionPane.showConfirmDialog(null, "Ao deletar uma categoria, todos os produtos associados a ela também serão deletados, deseja prosseguir? ");
            if (opcao == 0) { //Caso seja selecionado SIM
                CategoriaDAO dao = new CategoriaDAO();
                int column = 0;
                int index = (int) tabelaCategorias.getValueAt(row, column); //Seleciona o valor do ID do categoria cadastrada na linha selecionada e na coluna 0;
                dao.delete(index);
                atualizarTabela();
            }
        }
        categoryName.setText("");
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void produtoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_produtoMouseClicked
        produto prdt = new produto();
        this.dispose();
        prdt.setLocationRelativeTo(null);
        prdt.setVisible(true);
    }//GEN-LAST:event_produtoMouseClicked

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
        //Realiza busca em tempo real de acordo com o text digitado no campo de pesquisa
        DefaultTableModel model = (DefaultTableModel) tabelaCategorias.getModel();
        
        TableRowSorter<DefaultTableModel> tableRow = new TableRowSorter<DefaultTableModel>(model);
        tabelaCategorias.setRowSorter(tableRow);
        tableRow.setRowFilter(RowFilter.regexFilter("(?i)" + searchField.getText().trim()));
    }//GEN-LAST:event_searchFieldKeyPressed

    private void tabelaCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCategoriasMouseClicked
        // Exibe no campo do texto o nome da categoria selecionada
        int row = tabelaCategorias.getSelectedRow();
        int columns = tabelaCategorias.getColumnCount();

        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um produto da lista.");
        } else {
            TableModel model = tabelaCategorias.getModel();

            categoryName.setText(model.getValueAt(row, 1).toString());
        }
    }//GEN-LAST:event_tabelaCategoriasMouseClicked

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        //Realiza busca em tempo real de acordo com o text digitado no campo de pesquisa
        DefaultTableModel model = (DefaultTableModel) tabelaCategorias.getModel();
        TableRowSorter<DefaultTableModel> tableRow = new TableRowSorter<DefaultTableModel>(model);
        tabelaCategorias.setRowSorter(tableRow);
        tableRow.setRowFilter(RowFilter.regexFilter("(?i)" + searchField.getText().trim()));
    }//GEN-LAST:event_searchFieldKeyReleased

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        
    }//GEN-LAST:event_searchFieldActionPerformed

    private void inicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioMouseClicked
        Inicio inicio = new Inicio();
        this.dispose();
        inicio.setLocationRelativeTo(null);
        inicio.setVisible(true);
    }//GEN-LAST:event_inicioMouseClicked

    public JTable getTable() {
        return this.tabelaCategorias;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new categoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField categoryName;
    private javax.swing.JButton clearFields;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel inicio;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel produto;
    private javax.swing.JTextField searchField;
    private javax.swing.JTable tabelaCategorias;
    // End of variables declaration//GEN-END:variables
}
