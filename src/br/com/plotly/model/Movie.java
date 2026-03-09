

package br.com.plotly.model;


public class Movie {


    // Construtores :

    public Movie (String title , int year, int released, int runtime, String genre, String write, String plot) {


        // Vinculando parametros com os atributos :
        this.title = title;
        this.year = year;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.write = write;
        this.plot = plot;


    }


    // Atributos :
    private String title;
    private int year;
    private int released;
    private int runtime;
    private String genre;
    private String write;
    private String plot;


    // Métodos :

    public void playMovie () {


        System.out.println("O filme " + title + " está rodando.");


    }

    public void stopMovie () {


        System.out.println("O filme " + title + " está pausado.");


    }


}
