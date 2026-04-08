
// Pacotes :
package br.com.plotly.service;


// Importações :
import br.com.plotly.exception.QueryException;
import br.com.plotly.model.Title;
import br.com.plotly.model.TitleRecord;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


// Classe responsável pela request na API Omdb :
public class QueryOmdb  {


    // Atributos :
    private String path;
    private String responseFinal;
    private String nameTitle;
    private Title title;


    // Metodo getters e setters : :

    // Getters :
    public String getNameTitle() {


        return nameTitle;


    }


    // Métodos responsável por fazer a consulta dos titles na API :
    public void consutationTitle (String pathP) throws IOException, InterruptedException {


        // Atribuindo parametros com os atributos :
        this.path = pathP;


        // Instanciando o tratador de exceções :
        QueryException handle = new QueryException();


        // Fazendo que o código tente rodar o sistema de busca da API :
        try {


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


            // Se a busca do titulo na API e não ter esse titule ele avisa o erro :
            if (responseFinal.contains("False")) {


                handle.handleMovieNotFound(getNameTitle());


            }


            // Intanciando o Gson e fazendo com que tudo que vier da API omdb fique em upper camel case :
            Gson configueGson = new GsonBuilder()

                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();


            // Criando um objeto de um title record e vinculando o que vem da API com os atributos do record :
            TitleRecord titleDefaute = configueGson.fromJson(responseFinal, TitleRecord.class);




            // Se o runtime esiver com a formatação errada o handle exibe o erro :
            if (titleDefaute.runtime() != null && titleDefaute.runtime().equals("N/A")) {


                handle.handleInvalidRuntime(getNameTitle());


            }


            // Se tudo estiver de acordo ele cria um objeto de Title com base no title record e seus atributos :
            title = new Title(


                    titleDefaute.title(),
                    titleDefaute.year(), titleDefaute.released(),
                    titleDefaute.runtime(), titleDefaute.genre(), titleDefaute.director(),
                    titleDefaute.writer(),
                    titleDefaute.plot()


            );


        }


        // Caso a internet falhe ou a API, para não quebrar o sistema chamamos o handle para fazer o tratamento disso sem encerrar o sistema :
        catch (IOException | InterruptedException erroConnection) {


            handle.handleConnectionError(erroConnection);


        }


        // Tratamento para qualquer outro erro :
        catch (Exception generalErro) {


            System.out.println("Erro inesperado : " + generalErro.getMessage());


        }


        // Exibindo o título da tela do usuário :
        System.out.println(title);


        // Armazenando name do title para exibir quando necessário :
        nameTitle = title.getTitle();


    }


    // Delegando o metodo playTitle :
    public void playTitle () throws InterruptedException {


        title.playTitle();


    }


    // Delegando o metodo pauseTitle
    public void pauseTile () {


        title.pauseTitle();


    }


}
