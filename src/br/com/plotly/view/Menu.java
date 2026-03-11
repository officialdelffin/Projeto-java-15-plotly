
// Pacote :
package br.com.plotly.view;


import br.com.plotly.exception.QueryException;

import java.io.IOException;
import java.util.Scanner;

// Classe responsável pela comunicação direta com o usuário :
public class Menu {


    // Atributos :
    private String responseUser;
    private String nameMovie;
    private String nameMovieFormated;
    private String path;
    private int userChoice = 2;


    // Instancias :
    Scanner inputUser = new Scanner(System.in);
    QueryException queryTitle = new QueryException();


    // Realiza o fluxo de interação do usuário :
    public void interactionUser() throws IOException, InterruptedException {



        // Apresentação :
        System.out.printf("""
                
                Olá! Seja bem-vindo ao Plotly. O seu catálogo digital está pronto.
                
                """);


        while (userChoice == 2) {


            // Pedindo o usuário para escolher o title :
            System.out.println("Digite o titulo desejado : ");


            // Armazenando a escolher do user :
            responseUser = inputUser.nextLine();


            // chamando o metodo e definino path :
            pathCreate(responseUser);


            // Chaman o metodo que faz a request dos titles :
            queryTitle.consutationTitle(path);


        }


    }


    // Função responsável por criar o path :
    public void pathCreate (String nameMovie) {


        // Atribuindo paramentros na variavel :
        this.nameMovie = nameMovie;


        // formatando o name tirando os espaços entre os names :
        nameMovieFormated = this.nameMovie.replace(" ", "+");


        // Definindo o path
        path = "https://www.omdbapi.com/?t=" + nameMovieFormated + "&apikey=49ebfa25";


    }


}
