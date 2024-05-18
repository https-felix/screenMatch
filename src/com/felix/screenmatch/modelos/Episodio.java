package com.felix.screenmatch.modelos;

import com.felix.screenmatch.calculos.Classificavel;

public class Episodio implements Classificavel {
    private int numero;
    private String nome;
    private Serie serie;

    public int getTotalDeVisualizacoes() {
        return totalDeVisualizacoes;
    }

    public void setTotalDeVisualizacoes(int totalDeVisualizacoes) {
        this.totalDeVisualizacoes = totalDeVisualizacoes;
    }

    private int totalDeVisualizacoes;

    public int getNumero() {
        return numero;
    } //get, vai permitir ver o dado atual, ele PEGA o que tá salvo

    public void setNumero(int numero) {
        this.numero = numero;
    } //set, vai SETAR os dados, inserir, colocar, por informações

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getClassificacao() {
        if (totalDeVisualizacoes > 100) {
            return 4;
        } else {
            return 2;
        }
    }
}
