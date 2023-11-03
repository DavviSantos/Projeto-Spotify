package br.com.davisantos.datasetSpotify.ordenadores;

import br.com.davisantos.datasetSpotify.colecaoDeMusica.ColecaoDeMusica;
import br.com.davisantos.datasetSpotify.colecaoDeMusica.Musica;
import br.com.davisantos.datasetSpotify.iteradores.*;

public class SelectionSort implements Ordenador {

    @Override
    public boolean ordenarMusicas(ColecaoDeMusica colecaoDeMusica) {
        Musica musicaAtual = null;
        Musica menorViews = null;
        // Iterador que guarda a posição a receber menorViews
        Iterador iteradorPrincipal = colecaoDeMusica.obterIterador();

        for (int i = 0; i < colecaoDeMusica.obterTotalDeMusicas() - 1; i++) {
            int posicaoMenorViews = i;
            menorViews = iteradorPrincipal.obterProximo();

            // iteradorSecundario que vai pecorrer procurando a musica com menor views
            // recebe a copia do principal pois ele itera da onde o principal parou
            // não modifica o principal pois é uma cópia com outro endereço
            Iterador iteradorSecundario = iteradorPrincipal.clone();

            for (int j = i + 1; j < colecaoDeMusica.obterTotalDeMusicas(); j++) {
                musicaAtual = iteradorSecundario.obterProximo();
                // menorViews vai receber a musica com menorViews
                if (Float.parseFloat(menorViews.getViews()) > Float.parseFloat(musicaAtual.getViews())) {
                    menorViews = musicaAtual;
                    posicaoMenorViews = j;
                }
            }

            if (posicaoMenorViews != i) {
                colecaoDeMusica.trocarPosicaoEntreMusicas(i, posicaoMenorViews);
            }

        }
        return true;
    }

}
