package com.example.login.objetos;

import java.util.ArrayList;

public class Caso {

    private String titulo;
    private String descricao;
    private double valor;
    private int id;
    private static int geradorId = 0;

    public Caso(String titulo, String descricao, double valor) {
        this.id = geradorId++;
        this.titulo = titulo;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getId(){
        return this.id;
    }



    @Override
    public String toString() {
        return this.titulo + "";
    }
}
