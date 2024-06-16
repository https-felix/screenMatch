package com.felix.screenmatch.principal;

import com.felix.screenmatch.modelos.Filme;
import com.felix.screenmatch.modelos.Serie;
import com.felix.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {
    public static void main(String[] args) {

        //Cria os filmes e séries
        Filme meuFilme = new Filme("O Poderoso chefinho",1998);
        Serie lost = new Serie("Lost", 2004);
        Filme outroFilme = new Filme("Homem Arranha no arranha verso 2", 1970);
        var filmeNovo = new Filme("Dogville",2003);


        //cria uma lista, pode ser tbm: var listaDeFilme = new ArrayList<>();
        ArrayList<Titulo> listaDeAssistidos = new ArrayList<>();

        //adiciona os filmes criados na lista criada acima
        listaDeAssistidos.add(filmeNovo);
        listaDeAssistidos.add(meuFilme);
        listaDeAssistidos.add(outroFilme);
        listaDeAssistidos.add(lost);

        for (Titulo item: listaDeAssistidos){
            System.out.println(item.getNome());
           //legacy code, please do not use that way
            if (item instanceof Filme filme) {
                System.out.println("Classificação: " + filme.getClassificacao() + ".");
            }
        }

        //criando a lista e declarando que vai ter string nela
        ArrayList<String> buscaPorArtista = new ArrayList<>();

        //adicionando as strings nela
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Jiafei");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");

        System.out.println(buscaPorArtista);

        //sort ordena por ordem alfabetica
        Collections.sort(buscaPorArtista);
        System.out.println("Após ordenação alfabética:");
        System.out.println(buscaPorArtista);

        System.out.println("Lista de assistidos ordenada:");
        Collections.sort(listaDeAssistidos);
        System.out.println(listaDeAssistidos);
        //o java pega a lista de assistidos, usa um comparador, em que eu especifiquei que ele feve pegar o ano de lanç como paramentro para ordenar
        listaDeAssistidos.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Comparando por ano:");
        System.out.println(listaDeAssistidos);
    }
}
