package br.com.frederykantunnes.aluraviagens.model;

import java.io.Serializable;

public class Pacote implements Serializable {
    private int id;
    private String valor;
    private int dias;
    private String cidade;
    private String foto;


    public Pacote() {
    }
    public Pacote(String valor, int dias, String cidade, String foto) {
        this.valor = valor;
        this.dias = dias;
        this.cidade = cidade;
        this.foto = foto;
    }
    public Pacote(int id, String valor, int dias, String cidade, String foto) {
        this.id = id;
        this.valor = valor;
        this.dias = dias;
        this.cidade = cidade;
        this.foto = foto;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
