/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.model;

import br.com.connectionjdbc.SingleConnection;

/**
 *
 * @author Vinicius
 */
public class Produto {

    private int cd_produto;
    private String nm_produto;
    private double vl_produto;
    private int cd_categoria_produto;
    private int qt_produto;
    private String ds_descricao;

    public Produto() {

    }

    public int getCd_produto() {
        return cd_produto;
    }

    public void setCd_produto(int cd_produto) {
        this.cd_produto = cd_produto;
    }

    public String getNm_produto() {
        return nm_produto;
    }

    public void setNm_produto(String nm_produto) {
        this.nm_produto = nm_produto;
    }

    public double getVl_produto() {
        return vl_produto;
    }

    public void setVl_produto(double vl_produto) {
        this.vl_produto = vl_produto;
    }

    public int getCd_categoria_produto() {
        return cd_categoria_produto;
    }

    public void setCd_categoria_produto(int cd_categoria_produto) {
        this.cd_categoria_produto = cd_categoria_produto;

    }

    public int getQt_produto() {
        return qt_produto;
    }

    public void setQt_produto(int qt_produto) {
        this.qt_produto = qt_produto;
    }

    public String getDs_descricao() {
        return ds_descricao;
    }

    public void setDs_descricao(String ds_descricao) {
        this.ds_descricao = ds_descricao;
    }

}
