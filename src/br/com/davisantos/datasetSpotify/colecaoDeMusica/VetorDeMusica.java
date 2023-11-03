package br.com.davisantos.datasetSpotify.colecaoDeMusica;

import br.com.davisantos.datasetSpotify.iteradores.Iterador;
import br.com.davisantos.datasetSpotify.iteradores.IteradorVetor;
import br.com.davisantos.datasetSpotify.ordenadores.Ordenador;

public class VetorDeMusica implements ColecaoDeMusica {
    private Musica[] vetor;
    private int posicaoVetor = 0;

    public VetorDeMusica(int tamanhoVetor) {
        this.vetor = new Musica[tamanhoVetor];
    }

    @Override
    public boolean adicionarMusica(Musica musica) {
        if (posicaoVetor < vetor.length) {
            this.vetor[this.posicaoVetor] = musica;
            this.posicaoVetor++;
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean excluirMusica(String nomeDaMusica) {
        boolean musicaExcluida = false;
        for (int i = 0; i < this.posicaoVetor; i++) {
            if (nomeDaMusica.equalsIgnoreCase(this.vetor[i].getTrack())) {
                this.vetor[i].setTrack(null);
                for (int j = i; j < this.posicaoVetor - 1; j++) {
                    this.trocarPosicaoEntreMusicas(j, j + 1);
                }
                this.posicaoVetor--;
                musicaExcluida = true;
            }
        }
        return musicaExcluida;
    }

    @Override
    public Musica obterMusica(int posicaoDaMusica) {
        if ((posicaoDaMusica >= 0) & (posicaoDaMusica < this.posicaoVetor)) {
            return this.vetor[posicaoDaMusica];
        } else {
            return null;
        }
    }

    @Override
    public int obterTotalDeMusicas() {
        return posicaoVetor;
    }

    @Override
    public boolean trocarPosicaoEntreMusicas(int posicaoDaMusica1, int posicaoDaMusica2) {
        Musica aux;
        if ((posicaoDaMusica1 < this.posicaoVetor) & (posicaoDaMusica1 >= 0)) {
            if ((posicaoDaMusica2 < this.posicaoVetor) & (posicaoDaMusica2 >= 0)) {
                aux = this.vetor[posicaoDaMusica1];
                this.vetor[posicaoDaMusica1] = this.vetor[posicaoDaMusica2];
                this.vetor[posicaoDaMusica2] = aux;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean alterarMusica(int posicaoDaMusica, Musica novaMusica) {
        if ((posicaoDaMusica >= 0) & (posicaoDaMusica < this.posicaoVetor)) {
            this.vetor[posicaoDaMusica] = novaMusica;
        } else {
            return false;
        }
        return true;
    }

    @Override
    public Iterador obterIterador() {
        Iterador iterador = new IteradorVetor(this.vetor);
        return iterador;
    }

    @Override
    public boolean ordenarMusicas(Ordenador ordenador) {
        return ordenador.ordenarMusicas(this);
    }

}
