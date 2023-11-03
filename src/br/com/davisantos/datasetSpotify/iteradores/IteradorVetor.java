package br.com.davisantos.datasetSpotify.iteradores;

import br.com.davisantos.datasetSpotify.colecaoDeMusica.Musica;

public class IteradorVetor implements Iterador {
    private int posicaoCursor = 0;
    private Musica[] vetor;

    public IteradorVetor(Musica[] vetor) {
        this.vetor = vetor;
    }

    @Override
    public Iterador clone() {
        IteradorVetor cloneIterador = new IteradorVetor(this.vetor);
        cloneIterador.setPosicaoCursor(this.posicaoCursor);
        return cloneIterador;
    }

    @Override
    public boolean temProximo() {
        if (this.vetor[posicaoCursor] != null) {
            return true;
        }
        return false;
    }

    @Override
    public Musica obterProximo() {
        Musica musicaAtual = vetor[posicaoCursor];
        posicaoCursor++;
        return musicaAtual;
    }

    public void setPosicaoCursor(int posicaoCursor) {
        this.posicaoCursor = posicaoCursor;
    }

}
