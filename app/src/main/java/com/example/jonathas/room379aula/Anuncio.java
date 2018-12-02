package com.example.jonathas.room379aula;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "anuncios")
public class Anuncio {

    @PrimaryKey
    private int id;
    private int quantidade;
    private String descricao;
    private String nomeAnunciante;
    private double valor;

    public Anuncio(int id, int quantidade, String descricao, String nomeAnunciante, double valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.nomeAnunciante = nomeAnunciante;
        this.valor = valor;
    }

    public Anuncio(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeAnunciante() {
        return nomeAnunciante;
    }

    public void setNomeAnunciante(String nomeAnunciante) {
        this.nomeAnunciante = nomeAnunciante;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
