package com.felix.screenmatch.principal;

import com.felix.screenmatch.modelos.Titulo;
import com.felix.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome de um filme: ");
        var buscaPorNome = leitura.nextLine();

        String enderecoAPI = "http://www.omdbapi.com/?t=" + buscaPorNome + "&apikey=a6cf96d6";
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(enderecoAPI))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            //invocando o Gson
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            //deprecated, criando o um titulo do Gson;
            //

            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);

            System.out.println(meuTituloOmdb);

            //try {
            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println("Titulo tratado");
            System.out.println(meuTitulo);
        } catch (NumberFormatException e){
            System.out.println("Ocorreu um erro: ");
            System.out.println(e.getMessage() + " por conta de: " + e.getCause());
        } catch (IllegalArgumentException e){
            System.out.println("Algum erro na busca, favor verificar o nome!");
        } finally { //finally vai executar tanto no try quanto no catch;
            System.out.println("Código executado e finalizado! (certo ou errado mais terminou)");
        }
    }
}
