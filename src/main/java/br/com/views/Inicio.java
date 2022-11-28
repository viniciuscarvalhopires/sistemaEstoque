/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.views;

import br.com.connectionjdbc.SingleConnection;
import br.com.dao.CategoriaDAO;
import br.com.dao.ProdutoDAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vinicius
 */
public class Inicio extends javax.swing.JFrame {

  
    public Inicio() {
        initComponents();
        atualizaDados();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        produto = new javax.swing.JLabel();
        categoria = new javax.swing.JLabel();
        inicio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        qtCategorias = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        qtProdutos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCategoriaProdutos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        somaTotalQuantidade = new javax.swing.JTextField();
        gerarPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        categoria.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        categoria.setForeground(new java.awt.Color(255, 255, 255));
        categoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoria.setText("Categorias");
        categoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        categoria.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoriaMouseClicked(evt);
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
                    .addComponent(categoria)
                    .addComponent(produto))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(produto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 248, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Sistema de gerenciamento de estoque");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Resumo");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Quantidade de categorias cadastradas");

        qtCategorias.setEditable(false);
        qtCategorias.setName(""); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Quantidade de produtos cadastrados");

        qtProdutos.setEditable(false);

        tabelaCategoriaProdutos.setAutoCreateRowSorter(true);
        tabelaCategoriaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Categoria", "Quantidade de produtos cadastrados", "Quantidade total de produtos por categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaCategoriaProdutos);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Quantidade de produtos total em estoque");

        somaTotalQuantidade.setEditable(false);

        gerarPDF.setText("Gerar relatório");
        gerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(somaTotalQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(qtProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(qtCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addComponent(gerarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(172, 172, 172))
                    .addComponent(jScrollPane1))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(qtCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(qtProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gerarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(somaTotalQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atualizaDados() { //Método para atualizar os dados demonstrados em tela e na tabela
        CategoriaDAO categoria = new CategoriaDAO();
        qtCategorias.setText(categoria.count());

        ProdutoDAO produto = new ProdutoDAO();
        qtProdutos.setText(produto.count());
        somaTotalQuantidade.setText(produto.quantidadeSoma()); //Pega da classe produtoDAO o retorno do método quantidadeSoma()

        try {
            int count = 0;
            Connection con = SingleConnection.getConnection();
            String sql = "select nm_categoria, count(cd_produto) as count, sum(qt_quantidadeProduto) as soma  from tb_categoria LEFT JOIN tb_produto on tb_categoria.cd_categoria = tb_produto.cd_categoria group by tb_categoria.cd_categoria";

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            count = rsmd.getColumnCount();

            DefaultTableModel d = (DefaultTableModel) tabelaCategoriaProdutos.getModel();

            d.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector(); //Utiliza os mesmos métodos da classe categoria e produto para atualizar a tabela, armazenando, para cada coluna do result set, uma opsição no vetor

                for (int i = 0; i < count; i++) {
                    v.add(rs.getString("nm_categoria"));
                    v.add(rs.getInt("count"));
                    v.add(rs.getInt("soma"));
                }

                d.addRow(v);
            }
            rs.close();
        } catch (SQLException ex) {

            Logger.getLogger(categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void produtoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_produtoMouseClicked
        //Método para abrir a tela de produto
        produto prdt = new produto();
        this.dispose();
        prdt.setLocationRelativeTo(null);
        prdt.setVisible(true);
    }//GEN-LAST:event_produtoMouseClicked

    private void categoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoriaMouseClicked
        //Método para abrir a tela de categorias
        categoria ctg = new categoria();
        this.dispose();
        ctg.setLocationRelativeTo(null);
        ctg.setVisible(true);
    }//GEN-LAST:event_categoriaMouseClicked

    private void inicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioMouseClicked
        Inicio inicio = new Inicio();
        this.dispose();
        inicio.setVisible(true);
    }//GEN-LAST:event_inicioMouseClicked

    private void gerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarPDFActionPerformed

        String path = ""; //Variável armazenará o caminho para salvar o PDF
        JFileChooser j = new JFileChooser(); 
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int op = j.showSaveDialog(this); //Exibe uma janela para que o usuário selecione o local para salvar o pdf

        if (op == JFileChooser.APPROVE_OPTION) { //Se a opção selecionada for slavar
            path = j.getSelectedFile().getPath(); //Define o atributo path com o caminho selecionado
        }
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "\\relatorio.pdf")); //Define a "saída" para o PDF no local escolhido anteriormente

            doc.open(); 

            //paragrafos
            Paragraph p = new Paragraph("CATEGORIAS CADASTRADAS");
            p.setSpacingAfter(20);
            p.setAlignment(1);
            doc.add(p);

            // tabela categoria
            categoria categoria = new categoria();
            PdfPTable tabela = new PdfPTable(2);
            tabela.addCell("ID");
            tabela.addCell("Categoria");
            
            //categoria.getTable() retorna a tabela de categorias atualizada
            
            for (int i = 0; i < categoria.getTable().getRowCount(); i++) {
                String cd_categoria = categoria.getTable().getValueAt(i, 0).toString();
                String nm_categoria = categoria.getTable().getValueAt(i, 1).toString();

                tabela.addCell(cd_categoria);
                tabela.addCell(nm_categoria);
            }
            doc.add(tabela);
            
            p = new Paragraph("PRODUTOS CADASTRADOS");
            p.setSpacingAfter(20);
            p.setAlignment(1);
            doc.add(p);

            // tabela produtos
            produto produto = new produto();
            tabela = new PdfPTable(5);
            tabela.addCell("ID");
            tabela.addCell("Produto");
            tabela.addCell("Categoria");
            tabela.addCell("Valor");
            tabela.addCell("Quantidade");
            
            //produto.getTable() retorna a tabela de produtos atualizada
            
            for (int i = 0; i < produto.getTable().getRowCount(); i++) {
                String cd_produto = produto.getTable().getValueAt(i, 0).toString();
                String nm_produto = produto.getTable().getValueAt(i, 1).toString();
                String nm_categoria = produto.getTable().getValueAt(i, 2).toString();
                String vl_produto = produto.getTable().getValueAt(i, 3).toString();
                String qt_produto = produto.getTable().getValueAt(i, 4).toString();
                
                tabela.addCell(cd_produto);
                tabela.addCell(nm_produto);
                tabela.addCell(nm_categoria);
                tabela.addCell(vl_produto);
                tabela.addCell(qt_produto);
            }
            doc.add(tabela);
            p = new Paragraph("RELAÇÃO CATEGORIA-PRODUTO");
            p.setSpacingAfter(20);
            p.setAlignment(1);
            doc.add(p);

            //tabelas relação categoria produtos
            tabela = new PdfPTable(3);
            tabela.addCell("Categoria");
            tabela.addCell("Quantidade de produtos");
            tabela.addCell("Total de produtos cadastrados");
            for (int i = 0; i < tabelaCategoriaProdutos.getRowCount(); i++) {
                String nm_categoria = tabelaCategoriaProdutos.getValueAt(i, 0).toString();
                String qt_produtosCategoria = tabelaCategoriaProdutos.getValueAt(i, 1).toString();
                String qt_produtosTotal = tabelaCategoriaProdutos.getValueAt(i, 2).toString();

                tabela.addCell(nm_categoria);
                tabela.addCell(qt_produtosCategoria);
                tabela.addCell(qt_produtosTotal);

            }     
            doc.add(tabela);

        } catch (FileNotFoundException ex) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao gerar o PDF: " + ex);
        } catch (DocumentException ex) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao gerar o PDF: " + ex);
        }

        doc.close();

    }//GEN-LAST:event_gerarPDFActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel categoria;
    private javax.swing.JButton gerarPDF;
    private javax.swing.JLabel inicio;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel produto;
    private javax.swing.JTextField qtCategorias;
    private javax.swing.JTextField qtProdutos;
    private javax.swing.JTextField somaTotalQuantidade;
    private javax.swing.JTable tabelaCategoriaProdutos;
    // End of variables declaration//GEN-END:variables
}
