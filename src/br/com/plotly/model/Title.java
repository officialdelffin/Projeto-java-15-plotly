
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


    // Getters :
    public String getTitle() {


        return title;


    }


    public String getRuntime() {


        return runtime;


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


        // Atributos :

        int timeSeconds = 0;
        int pastTime = 0;


        // Atribuindo parametros nos atributos :
        timeSeconds = timeP;


        // Fazendo o calculo da conversão em minutos para segundos :
        timeSeconds = 60 * timeSeconds;


        // Enquanto o tempo passado for meor que
        while (pastTime <= timeSeconds) {


            // Atributos do sistema de loop para o timeLine :


            // Atributos das horas, minutos e segundos do titulo :
            int titleHour;
            int titleMinutes;
            int titleSeconds;


            // Atributos das horas, minutos e segundos que estão sendo passadas do titulo :
            int pastHour;
            int pastMinutes;
            int pastSeconds;


            // Organizando quantidade de horas e minutos com base no runtime em segundos do titulo :

            // Passando os segundos para horas :
            titleHour = timeSeconds / 3600;


            // Passando os segundos para minutos :
            titleMinutes = (timeSeconds % 3600) / 60;


            // Passando o timeSeconds para o titleSeconds :
            titleSeconds = timeSeconds;


            // Organizando quantidade de horas, minutos e segundos restantes do title :


            pastHour = pastTime / 3600;


            pastMinutes = (pastTime % 3600) / 60;


            pastSeconds = pastTime;




        }


    }


}
