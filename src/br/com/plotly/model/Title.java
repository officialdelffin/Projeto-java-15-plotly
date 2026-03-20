
// Pacote :
package br.com.plotly.model;


// Classe responsável pela criação do objeto Title :
public class Title {


    // Construtores :

    public Title(String title, String year, String released, String runtime, String genre, String director, String write, String plot) {


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

    // Métodos que inicia o Title :
    public void playTitle() throws InterruptedException {


        // Criando o atributo de runtime e limpando a string :
        String runtimeClean = runtime.replace(" min", "");


        // Fazendo a conversão do runtimeClean :
        int runtimeConverted = Integer.parseInt(runtimeClean);


        // Avsio que o titulo está rodando :
        System.out.println("O título " + title + " está rodando." + "\n");


        // Chamando o método que contabilizar o cronograma do title :
        timelineTitle(runtimeConverted);


    }


    // Metodo que pausa o Title :
    public void pauseTitle() {


        System.out.println("O título " + title + " está pausado." + "\n");


    }


    // Sobreescrevendo o metodo toString dos Title :
    @Override
    public String toString() {


        // Criando uma formatação de texto :
        String textFormated = """
                
                Nome : %s
                
                Ano de Lançamento : %s
                
                Lançamento : %s
                
                Tempo de titulo : %s
                
                Gênero : %s
                
                Diretor : %s
                
                Escritor : %s
                
                Trama : %s
                
                """;


        // formatando o text do to String :
        String textFormatedFinal = String.format(textFormated, title, year, released, runtime, genre, director, write, plot);


        // Retornando o formato do texto de exibição do Title :
        return textFormatedFinal;


    }


    // Metodo que contabiliza o crongrama dos titles :
    public void timelineTitle(int timeP) throws InterruptedException {


        // Atribuindo parametros nos atributos :
        int time = timeP;


        // Fazendo o calculo da conversão em minutos para segundos :
        time = 60 * time;


        // Criando um for i para fazer o sistema de cronograma :
        for (int i = 0; i <= time; i++) {


            // Faz com que o loop demore um segundo para contabilizar e incrementar mais 1 no i :
            Thread.sleep(1000);


            // Exibe o progresso na mesma linha (usando \r para sobrescrever)
            System.out.print("\rProgresso: " + i + " / " + time + " min assistidos.");


        }


    }


}
