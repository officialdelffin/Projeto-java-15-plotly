
// Pacote :
package br.com.plotly.exception;


// Importações :
import br.com.plotly.model.Movie;
import br.com.plotly.model.TitleRecord;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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


        // Intanciando o Gson e fazendo com que tudo que vier da API omdb fique em upper camel case :
        Gson configueGson = new GsonBuilder()

                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();


        // Criando um objeto de um title record e vinculando o que vem da API com os atributos do record :
        TitleRecord titleDefaute = configueGson.fromJson(responseFinal, TitleRecord.class);


        // Criando um objeto de movie com base no title record e seus atributos :
        Movie movie = new Movie(titleDefaute.title(), titleDefaute.year(), titleDefaute.released(), titleDefaute.runtime(), titleDefaute.genre(), titleDefaute.director(), titleDefaute.writer(), titleDefaute.plot());


        // Exibindo o filme da tela do usuário :
        System.out.println(movie);


    }





}
