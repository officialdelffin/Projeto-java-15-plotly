
// Pacote :
package br.com.plotly.view;


// Importações :
import br.com.plotly.exception.QueryException;
import br.com.plotly.model.Movie;
import java.io.IOException;
import java.util.Scanner;


// Classe responsável pela comunicação direta com o usuário :
public class Menu {


    // Atributos :
    private String responseUser;
    private int responseUserPlayOrSearch;
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


        // Enquanto a escolha do usuário for 2 a query do queryTitle vai rodar :
        while (userChoice == 2) {


            // Pedindo o usuário para escolher o title :
            System.out.println("Digite o titulo desejado : " + "\n");


            // Armazenando a escolher do user :
            responseUser = inputUser.nextLine();


            // Chamando o metodo e definino path :
            pathCreate(responseUser);


            // Chaman o metodo que faz a request dos titles :
            queryTitle.consutationTitle(path);





        }


    }


    // Função responsável por criar o path :
    public void pathCreate (String nameMovie) throws IOException, InterruptedException {


        // Atribuindo paramentros na variavel :
        this.nameMovie = nameMovie;


        // formatando o name tirando os espaços entre os names :
        nameMovieFormated = this.nameMovie.replace(" ", "+");


        // Definindo o path
        path = "https://www.omdbapi.com/?t=" + nameMovieFormated + "&apikey=49ebfa25";


        // Chamando o metodo de acão dentro do title :
        actionTitle();


    }


    // Metodo que executa ações quando o usuário selecionar o title :
    public void actionTitle () throws IOException, InterruptedException {


        // Pedindo para o usuário escolher entre dar play no movie ou pesquisar outro filme :
        System.out.printf("""
                    
                    Digite alguma opções do filme :
                    
                    
                    1 - Assistir %s
                    2 - Buscar outro filme
                    
                    """ , queryTitle.getNameMovie());


        // Pulando linha e armazenando a escolha do usuário :
        System.out.println(" ");
        responseUserPlayOrSearch = inputUser.nextInt();


        // Chamando o metodo que verifica o que o usuário quer fazer com o title
        playOrPause(responseUserPlayOrSearch);


    }


    // Metodo responsavel por verificar se o usuário quer dar play em um title ou se quer dar pause em um title :
    public void playOrPause (int choiceP) throws IOException, InterruptedException {


        // Atribuindo o paramentro na variavel :
        int choice = choiceP;


        // Se a escolha o usuário for 1 faça :
        if (choice == 1) {


            queryTitle.playTitle();


        }

        // Se a escolha do usuário for 2 faça :
        else if (choice == 2) {


            interactionUser();


        }


        // Se o usuário digitar qualquer outra coisa faça :
        else {}


    }


}
