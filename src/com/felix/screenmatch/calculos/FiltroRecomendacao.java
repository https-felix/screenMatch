package com.felix.screenmatch.calculos;

public class FiltroRecomendacao {

    public void filtra(Classificavel classificavel){
        if (classificavel.getClassificacao() >=4) {
            System.out.println("É um dos preferidos do momento!");
        } else if (classificavel.getClassificacao() >= 2) {
            System.out.println("Bem avalido esse aqui!");
        } else {
            System.out.println("Coloque na sua lista para assistir depois!");
        }
    }

}
