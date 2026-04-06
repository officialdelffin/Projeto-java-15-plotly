
// Pacote :
package br.com.plotly.exception;


// Classe responsável por tratamento de excessões :
public class QueryException {


    // Atributos :
    private String runtime;
    private String title;
    private Exception e;



    // Métodos :

    // Faz o tratamento caso o Runtime esteja em um formato invalido :
    public void handleInvalidRuntime (String runtime) {





    }


    // Faz o tratamento caso a busca não seja realizada por conta de alguma falha na rede :
    public void handleConnectionError (Exception e) {





    }


    // Faz o tratamento caso o filme não foi encontrado no catalogo :
    public void handleMovieNotFound (String title) {






    }



}

