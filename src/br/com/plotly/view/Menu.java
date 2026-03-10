
// Pacote :
package br.com.plotly.view;


import java.util.Scanner;

// Classe responsável pela comunicação direta com o usuário :
public class Menu {


    // Atributos :
    private String responseUser;
    private String nameMovie;
    private String nameMovieFormated;
    private String path;


    // Instancias :
    Scanner inputUser = new Scanner(System.in);


    // Realiza o fluxo de interação do usuário :
    public void interactionUser() {


        // Apresentação e armazenando a escolhar do movie :
        System.out.printf("""
                
                Olá! Seja bem-vindo ao Plotly. O seu catálogo digital está pronto.
                
                Qual título você deseja explorar hoje?
                
                """);


        // Armazenando a escolher do user :
        responseUser = inputUser.nextLine();


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
