/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.views;

import br.com.connectionjdbc.SingleConnection;
import br.com.dao.CategoriaDAO;
import br.com.dao.ProdutoDAO;
import br.com.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class produto extends javax.swing.JFrame {

    public produto() {
        initComponents();
        categorias();
        updateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        abrirCategoria = new javax.swing.JLabel();
        inicio = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        produtoNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        listaCategoria = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        sliderValue = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricaoProduto = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        sliderQuantidade = new javax.swing.JSlider();
        jLabel8 = new javax.swing.JLabel();
        valorUnitario = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        insertButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearFields = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("produto"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Produtos");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        abrirCategoria.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        abrirCategoria.setForeground(new java.awt.Color(255, 255, 255));
        abrirCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        abrirCategoria.setText("Categorias");
        abrirCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        abrirCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        abrirCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirCategoriaMouseClicked(evt);
            }
        });

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
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inicio)
                    .addComponent(abrirCategoria)
                    .addComponent(jLabel1))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(abrirCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Nome");

        produtoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoNomeActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Quantidade");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Categoria");

        sliderValue.setEditable(false);

        descricaoProduto.setColumns(20);
        descricaoProduto.setLineWrap(true);
        descricaoProduto.setRows(5);
        jScrollPane1.setViewportView(descricaoProduto);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Descrição");

        sliderQuantidade.setMajorTickSpacing(1);
        sliderQuantidade.setMaximum(200);
        sliderQuantidade.setValue(0);
        sliderQuantidade.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderQuantidadeStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Valor unitário");

        valorUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorUnitarioActionPerformed(evt);
            }
        });

        tabelaProdutos.setAutoCreateRowSorter(true);
        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Produto", "Categoria", "Valor", "Quantidade", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaProdutos);
        if (tabelaProdutos.getColumnModel().getColumnCount() > 0) {
            tabelaProdutos.getColumnModel().getColumn(3).setMaxWidth(50);
            tabelaProdutos.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        insertButton.setText("Inserir");
        insertButton.setToolTipText("Clique para inserir um produto");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Alterar");
        updateButton.setToolTipText("Selecione um produto da lista e clique em alterar produtos");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Deletar");
        deleteButton.setToolTipText("Clique para deletar o produto selecionado");
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

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Pesquisar");

        jFormattedTextField1.setText("jFormattedTextField1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addComponent(valorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(sliderQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(sliderValue, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(produtoNome)
                                    .addComponent(listaCategoria, 0, 200, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(102, 102, 102))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(insertButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(updateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(clearFields))
                    .addComponent(jScrollPane1))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(produtoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(listaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(sliderQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sliderValue, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(valorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteButton)
                            .addComponent(updateButton)
                            .addComponent(insertButton)
                            .addComponent(clearFields)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel4)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateTable() {
        int count;

        try {
            Connection con = SingleConnection.getConnection();
            String sql = "SELECT cd_produto, nm_produto, vl_produto, qt_quantidadeProduto, ds_descricao, nm_categoria FROM tb_produto JOIN tb_categoria on tb_categoria.cd_categoria = tb_produto.cd_categoria";

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            count = rsmd.getColumnCount();

            DefaultTableModel d = (DefaultTableModel) tabelaProdutos.getModel();

            d.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                for (int i = 0; i < count; i++) {
                    v.add(rs.getInt("cd_produto"));
                    v.add(rs.getString("nm_produto"));
                    v.add(rs.getString("nm_categoria"));
                    v.add(rs.getDouble("vl_produto"));
                    v.add(rs.getInt("qt_quantidadeProduto"));
                    v.add(rs.getString("ds_descricao"));
                }

                d.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void categorias() {
        //Atualiza a combobox de categoria sempre que a página de produtos é carregada
        try {
            Connection con = SingleConnection.getConnection();
            String sql = "select * from tb_categoria";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            listaCategoria.removeAllItems();

            while (rs.next()) {
                listaCategoria.addItem(rs.getString("nm_categoria"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar a lista de categoria para a seleção: " + e);
        }
    }

    private double formatValue(double value) {
        DecimalFormat formato = new DecimalFormat("#.##");
        value = Double.parseDouble(formato.format(value));
        return value;
    }

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

    }//GEN-LAST:event_jLabel1MouseClicked

    private void sliderQuantidadeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderQuantidadeStateChanged
        sliderValue.setText("" + sliderQuantidade.getValue());
    }//GEN-LAST:event_sliderQuantidadeStateChanged

    private void produtoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoNomeActionPerformed

    }//GEN-LAST:event_produtoNomeActionPerformed

    private void valorUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorUnitarioActionPerformed

    }//GEN-LAST:event_valorUnitarioActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed

        if ("".equals(produtoNome.getText())) {
            JOptionPane.showMessageDialog(null, "Preencha o nome do produto");
        } else {
            try {

                Produto produto = new Produto();
                ProdutoDAO produtoDao = new ProdutoDAO();
                CategoriaDAO cDao = new CategoriaDAO();

                Double valorUnit = Double.valueOf(valorUnitario.getText());
                valorUnit = formatValue(valorUnit);

                produto.setNm_produto(produtoNome.getText());
                produto.setCd_categoria_produto(cDao.selectID((String) listaCategoria.getSelectedItem()));
                produto.setVl_produto(valorUnit);
                produto.setDs_descricao(descricaoProduto.getText());
                produto.setQt_produto(sliderQuantidade.getValue());

                produtoDao.insert(produto);
                produtoNome.setText("");
                valorUnitario.setText("");
                descricaoProduto.setText("");
                sliderQuantidade.setValue(0);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
            }
        }

        updateTable();
    }//GEN-LAST:event_insertButtonActionPerformed

    private void abrirCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirCategoriaMouseClicked
        categoria ctg = new categoria();
        this.dispose();
        ctg.setLocationRelativeTo(null);
        ctg.setVisible(true);
    }//GEN-LAST:event_abrirCategoriaMouseClicked

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed

        int column = 0;
        int row = tabelaProdutos.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um produto da lista.");
        } else {
            try {
                Produto produto = new Produto();
                ProdutoDAO produtoDao = new ProdutoDAO();
                CategoriaDAO cDao = new CategoriaDAO();
                Double valorUnit = Double.valueOf(valorUnitario.getText());
                valorUnit = formatValue(valorUnit);

                produto.setCd_produto((int) tabelaProdutos.getModel().getValueAt(row, column));
                produto.setNm_produto(produtoNome.getText());
                produto.setCd_categoria_produto(cDao.selectID((String) listaCategoria.getSelectedItem()));
                produto.setVl_produto(valorUnit);
                produto.setDs_descricao(descricaoProduto.getText());
                produto.setQt_produto(sliderQuantidade.getValue());

                produtoDao.update(produto);
                produtoNome.setText("");
                valorUnitario.setText("");
                descricaoProduto.setText("");
                sliderQuantidade.setValue(0);
                updateTable();
                tabelaProdutos.clearSelection();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!");
            }

        }


    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int column = 0;
        int row = tabelaProdutos.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um produto da lista.");
        } else {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja deletar o produto selecionado? ");

            if (opcao == 0) {
                int index = (int) tabelaProdutos.getModel().getValueAt(row, column);
                ProdutoDAO produtoDao = new ProdutoDAO();
                produtoDao.delete(index);
            }
        }

        produtoNome.setText("");
        valorUnitario.setText("");
        descricaoProduto.setText("");
        sliderQuantidade.setValue(0);
        updateTable();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void tabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosMouseClicked
        //Ao clicar em um item da lista de produtos, os atributos do produto selecionado são exibidos nos campos disponíveis para edição.
        int row = tabelaProdutos.getSelectedRow();
        int columns = tabelaProdutos.getColumnCount();

        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um produto da lista.");
        } else {
            TableModel model = tabelaProdutos.getModel();

            produtoNome.setText(model.getValueAt(row, 1).toString());
            valorUnitario.setText(model.getValueAt(row, 3).toString());
            descricaoProduto.setText(model.getValueAt(row, 5).toString());
            sliderQuantidade.setValue(Integer.parseInt(model.getValueAt(row, 4).toString()));
            for (int i = 0; i < listaCategoria.getItemCount(); i++) {
                if (listaCategoria.getItemAt(i).equals(model.getValueAt(row, 2).toString())) {
                    listaCategoria.setSelectedIndex(i);
                }
            }
        }

    }//GEN-LAST:event_tabelaProdutosMouseClicked

    private void clearFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFieldsActionPerformed
        //Limpa os campos
        produtoNome.setText("");
        valorUnitario.setText("");
        descricaoProduto.setText("");
        sliderQuantidade.setValue(0);
        listaCategoria.setSelectedIndex(0);
    }//GEN-LAST:event_clearFieldsActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed

    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
        //Filtra os itens da tabela de acordo com o que é digitado no campo de pesquisa
        DefaultTableModel model = (DefaultTableModel) tabelaProdutos.getModel();
        TableRowSorter<DefaultTableModel> tableRow = new TableRowSorter<DefaultTableModel>(model);
        tabelaProdutos.setRowSorter(tableRow);
        tableRow.setRowFilter(RowFilter.regexFilter("(?i)" + searchField.getText().trim()));
    }//GEN-LAST:event_searchFieldKeyPressed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        //Filtra os itens da tabela de acordo com o que é digitado no campo de pesquisa
        DefaultTableModel model = (DefaultTableModel) tabelaProdutos.getModel();
        TableRowSorter<DefaultTableModel> tableRow = new TableRowSorter<>(model);
        tabelaProdutos.setRowSorter(tableRow);
        tableRow.setRowFilter(RowFilter.regexFilter("(?i)" + searchField.getText().trim()));
    }//GEN-LAST:event_searchFieldKeyReleased

    private void inicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioMouseClicked
        Inicio inicio = new Inicio();
        this.dispose();
        inicio.setLocationRelativeTo(null);
        inicio.setVisible(true);
    }//GEN-LAST:event_inicioMouseClicked

    public JTable getTable() {
        return this.tabelaProdutos;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new produto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel abrirCategoria;
    private javax.swing.JButton clearFields;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextArea descricaoProduto;
    private javax.swing.JLabel inicio;
    private javax.swing.JButton insertButton;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> listaCategoria;
    private javax.swing.JTextField produtoNome;
    private javax.swing.JTextField searchField;
    private javax.swing.JSlider sliderQuantidade;
    private javax.swing.JTextField sliderValue;
    private javax.swing.JTable tabelaProdutos;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField valorUnitario;
    // End of variables declaration//GEN-END:variables
}
