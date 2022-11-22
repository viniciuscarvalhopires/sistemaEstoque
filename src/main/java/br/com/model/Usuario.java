/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.model;

import javax.swing.JOptionPane;

/**
 *
 * @author 52215553
 */
public class Usuario {
    private String usuario = "admin";
    private String senha = "admin";

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Boolean validarLogin(String login, String senha) {
        return login.equals(this.usuario) && senha.equals(this.senha);
    }
    
}
