
// Pacote :
package br.com.plotly.exception;

// Importações :
import br.com.plotly.view.Menu;
import java.io.IOException;

// Classe responsável por tratamento de excessões :
public class QueryException {


    // Atributos :
    private String runtime;
    private String title;
    private Exception errorConection;


    // Instanciando a classe main :
    Menu newInitiation = new Menu();


    // Métodos :

    // Faz o tratamento caso o Runtime esteja em um formato invalido :
    public void handleInvalidRuntime(String runtime) throws IOException, InterruptedException {


        // Recebendo paremetros
        this.runtime = runtime;


        System.out.printf("""
                
                [Erro de conversão]
                
                O tempo %s não pode ser convertido
                
                Verifique se a API voltou um valor numérico certo!
                
                """, runtime);


        // Executando novamente a função de escolher um titulo :
        newInitiation.interactionUser();


    }


    // Faz o tratamento caso a busca não seja realizada por conta de alguma falha na rede :
    public void handleConnectionError(Exception errorConection) throws IOException, InterruptedException {


        // Recebendo parametros :
        this.errorConection = errorConection;


        System.out.printf("""
                
                [Erro de Conexão]
                
                Não foi possível fazer a consulta do título!.
                
                Detalhe técnico : %s
                
                """, errorConection.getMessage());


        // Aviso para tentar novamente :
        System.out.println("Clique na tecla ENTER para fazer uma nova consulta: ");


        // Executando novamente a função de escolher um titulo :
        newInitiation.interactionUser();


    }


    // Faz o tratamento caso o filme não foi encontrado no catalogo :
    public void handleMovieNotFound(String title) throws IOException, InterruptedException {


        // Recebendo parametros :
        this.title = title;


        System.out.printf("""
                
                [Filme não encontrado]
                
                O título %s não existe nesse catálogo.
                
                Verifique se o nome do filme está escrito corretamente em inglês.
                
                """);


        // Aviso para tentar novamente :
        System.out.println("Clique na tecla ENTER para fazer uma nova consulta: ");


        // Executando novamente a função de escolher um titulo :
        newInitiation.interactionUser();


    }


}

