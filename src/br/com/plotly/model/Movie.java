
// Pacote :
package br.com.plotly.model;


// Classe responsável pela criação do objeto Movie :
public class Movie {


    // Construtores :

    public Movie(String title, String year, String released, String runtime, String genre, String director, String write, String plot) {


        // Vinculando parametros com os atributos :
        this.title = title;
        this.year = year;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.write = write;
        this.plot = plot;


    }


    // Atributos :
    private String title;
    private String year;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String write;
    private String plot;


    // Metodos getters :

    public String getTitle() {


        return title;


    }

    // Métodos que inicia o Movie :
    public void playMovie() {


        // Criando o atributo de runtime e limpando a string :
        String runtimeClean = runtime.replace(" min" , "");


        // Fazendo a conversão do runtimeClean :
        Integer.parseInt(runtimeClean);



        System.out.println("O filme " + title + " está rodando." + "\n");


    }


    // Metodo que pausa o Movie :
    public void pauseMovie() {


        System.out.println("O filme " + title + " está pausado." + "\n");


    }


    // Sobreescrevendo o metodo toString dos Movies :
    @Override
    public String toString() {


        // Criando uma formatação de texto :
        String textFormated = """
                
                Nome : %s
                
                Ano de Lançamento : %s
                
                Lançamento : %s
                
                Tempo de filme : %s
                
                Gênero : %s
                
                Diretor : %s
                
                Escritor : %s
                
                Trama : %s
                
                """;


        // formatando o text do to String :
        String textFormatedFinal = String.format(textFormated, title, year, released, runtime, genre, director, write, plot);


        // Retornando o formato do texto de exibição do movie :
        return textFormatedFinal;


    }


}
