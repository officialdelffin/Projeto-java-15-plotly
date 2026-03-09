
// Pacote :
package br.com.plotly.exception;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Classe responsável pela querry dentro da API Omdb :
public class QueryException {


    // Atributos :
    private String path;


    // Configurando o agente que vai pegar a query e trazer um response :
    HttpClient client = HttpClient.newHttpClient();


    // Configurando a request :
    HttpRequest request = HttpRequest.newBuilder()

            .uri(URI.create(path))
            .build();

    HttpResponse<String> response = client;



}
