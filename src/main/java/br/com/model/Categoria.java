/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.model;


public class Categoria {
    
    private int cd;
    private String nome;
    
    public Categoria() {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
     public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }
    
    
    @Override
    public String toString() {
        return super.toString(); 
    }

   
    
    
}
