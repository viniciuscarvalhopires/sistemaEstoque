
package br.com.model;

import br.com.views.categoria;
import br.com.views.produto;
import br.com.views.Inicio;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vinicius
 */
public class Relatorio {
        
        private String path = "";
        JFileChooser j = new JFileChooser(); 
        Document doc = new Document();

        public Relatorio() {
        }
        
        
        
        public void gerarRelatorio(){
            
         //Variável armazenará o caminho para salvar o PDF
        
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int op = j.showSaveDialog(null); //Exibe uma janela para que o usuário selecione o local para salvar o pdf

        if (op == JFileChooser.APPROVE_OPTION) { //Se a opção selecionada for slavar
            path = j.getSelectedFile().getPath(); //Define o atributo path com o caminho selecionado
        }
        
        
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "\\relatorio.pdf")); //Define a "saída" para o PDF no local escolhido anteriormente

            doc.open(); 

            //paragrafos
            Paragraph p = new Paragraph("CATEGORIAS CADASTRADAS");
            p.setSpacingAfter(20);
            p.setSpacingBefore(40);
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
            p.setSpacingBefore(40);
            p.setSpacingAfter(20);
            p.setAlignment(1);
            doc.add(p);

            // tabela produtos
            produto produto = new produto();
            DefaultTableModel modelProduto = (DefaultTableModel) produto.getTable();
            tabela = new PdfPTable(5);
            tabela.addCell("ID"); //Adiciona a célula de ID
            tabela.addCell("Produto"); //Adiciona a célula que ficará na primeira posição da coluna de nomes dos produtos
            tabela.addCell("Categoria");
            tabela.addCell("Valor");
            tabela.addCell("Quantidade");
            
            //produto.getTable() retorna a tabela de produtos atualizada
            
            for (int i = 0; i < modelProduto.getRowCount(); i++) { //Pega os valores da tabela de produtos na posição (x,y) e adiciona uma nova célula na tabela
                String cd_produto = modelProduto.getValueAt(i, 0).toString();
                String nm_produto = modelProduto.getValueAt(i, 1).toString();
                String nm_categoria = modelProduto.getValueAt(i, 2).toString();
                String vl_produto = modelProduto.getValueAt(i, 3).toString();
                String qt_produto = modelProduto.getValueAt(i, 4).toString();
                
                tabela.addCell(cd_produto);
                tabela.addCell(nm_produto);
                tabela.addCell(nm_categoria);
                tabela.addCell(vl_produto);
                tabela.addCell(qt_produto);
            } 
            
            doc.add(tabela);
            p = new Paragraph("RELAÇÃO CATEGORIA-PRODUTO");
            p.setSpacingBefore(40);
            p.setSpacingAfter(20);
            p.setAlignment(1);
            doc.add(p);

            //tabelas relação categoria produtos
            tabela = new PdfPTable(3);
            Inicio inicio = new Inicio(); //Instancia o JFrame Inicio
            DefaultTableModel modelInicio = (DefaultTableModel) inicio.getTable(); //Define um 
            tabela.addCell("Categoria");
            tabela.addCell("Quantidade de produtos");
            tabela.addCell("Total de produtos cadastrados");
            for (int i = 0; i < modelInicio.getRowCount(); i++) {
                String nm_categoria = modelInicio.getValueAt(i, 0).toString();
                String qt_produtosCategoria = modelInicio.getValueAt(i, 1).toString();
                String qt_produtosTotal = modelInicio.getValueAt(i, 2).toString();

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
    }
}
