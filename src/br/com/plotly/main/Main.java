
// Pacote :
package br.com.plotly.main;


// Importações :
import br.com.plotly.view.Menu;
import java.io.IOException;


// Classe responsável por rodar o sistema inteiro :
public class Main {


    // Metodo que faz a execução do sistema :
    public static void main(String[] args) throws IOException, InterruptedException {


        // Apresentação :
        System.out.printf("""
                
                Olá! Seja bem-vindo ao Plotly. O seu catálogo digital está pronto.
                
                Clique a tecla enter para iniciar :
                
                """);


        // Instanciando o objeto de menu :
        var menu = new Menu();


        // Chamando o metodo de interação com o usuário :
        menu.interactionUser();


    }


}