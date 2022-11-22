/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.model;


public class Categoria {
    
    private int cd_categoria;
    private String nome;
    
    public Categoria() {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
     public int getCd_categoria() {
        return cd_categoria;
    }

    public void setCd_categoria(int cd_categoria) {
        this.cd_categoria = cd_categoria;
    }
    
    
    @Override
    public String toString() {
        return super.toString(); 
    }

   
    
    
}
