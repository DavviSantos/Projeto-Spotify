package br.com.davisantos.datasetSpotify.iteradores;

import br.com.davisantos.datasetSpotify.colecaoDeMusica.Musica;

public interface Iterador {

    public Iterador clone();

    public boolean temProximo();

    public Musica obterProximo();

}
