
// Pacote :
package br.com.plotly.exception;


// Importações :
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


// Classe responsável pela querry dentro da API Omdb :
public class QueryException {


    // Atributos :
    private String path;
    private String responseFinal;


    // Métodos responsável por fazer a consulta dos movies na API :
    public void consutationTitle (String pathP) throws IOException, InterruptedException {


        // Atribuindo parametros com os atributos :
        this.path = pathP;


        // Configurando o agente que vai pegar a query e trazer um response :
        HttpClient client = HttpClient.newHttpClient();


        // Configurando a request :
        HttpRequest request = HttpRequest.newBuilder()


                .uri(URI.create(path))
                .build();


        // Pegando os dados da request com o client e convertendo para Json :
        HttpResponse<String> response = client


                .send(request, HttpResponse.BodyHandlers.ofString());


        // Armazenando os dados do response.body dentro do respose final :
        responseFinal = response.body();


        System.out.println(responseFinal);


    }



}
