package com.felix.screenmatch.principal;

import com.felix.screenmatch.calculos.CalculadoraDeTempo;
import com.felix.screenmatch.calculos.FiltroRecomendacao;
import com.felix.screenmatch.modelos.Episodio;
import com.felix.screenmatch.modelos.Filme;
import com.felix.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O Poderoso chefinho",1998);
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibeFichaTecnica();

        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(7);

        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.retornaMedia());

        //meuFilme.exibeAvaliacao();
        //System.out.println(meuFilme.retornaMedia());

        Serie lost = new Serie("Lost", 2004);

        lost.setEpisodiosPorTemporada(15);
        lost.setMinutosPorEpisodio(60);
        lost.setTemporada(9);
        lost.exibeFichaTecnica();
        System.out.println("Duração para maratonar " + lost.getNome() + ": " + lost.getDuracaoEmMinutos()) ;

        Filme outroFilme = new Filme("Homem Arranha no arranha verso 2", 1970);
        outroFilme.setDuracaoEmMinutos(110);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();

        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();

        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalDeVisualizacoes(453);
        filtro.filtra(episodio); //pega dois objetos, o que filtra e o que classifica as séries e cruza pra ver se o filme é bom (mais de 4 estrelas) ou ruim (menos de duas estrelas)

        var filmeNovo = new Filme("Dogville",2003);

        filmeNovo.setDuracaoEmMinutos(200);
        filmeNovo.avalia(10);

        //cria uma lista, pode ser tbm: var listaDeFilme = new ArrayList<>();
        ArrayList<Filme> listaDeFilmes = new ArrayList<>();

        //adiciona os filmes criados na lista criada acima
        listaDeFilmes.add(filmeNovo);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);

        //printa o tamanho com o ".size"
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme adicionado: " + listaDeFilmes.get(0).getNome());

        System.out.println("Lista de filmes: " + listaDeFilmes);
        System.out.println("Filme 1: " + listaDeFilmes.get(0).toString());
    }
}

