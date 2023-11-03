package br.com.davisantos.datasetSpotify.ordenadores;

import br.com.davisantos.datasetSpotify.colecaoDeMusica.ColecaoDeMusica;
import br.com.davisantos.datasetSpotify.colecaoDeMusica.Musica;
import br.com.davisantos.datasetSpotify.iteradores.Iterador;

public class BubbleSort implements Ordenador {

    @Override
    public boolean ordenarMusicas(ColecaoDeMusica colecaoDeMusica) {
        boolean estaOrdenado = true;
        boolean existiuTroca = false;
        Musica musicaAtual = null;
        Musica proximaMusica = null;

        for (int i = 0; i < colecaoDeMusica.obterTotalDeMusicas(); i++) {

            Iterador iterador = colecaoDeMusica.obterIterador(); // Cria Iterador recebendo noInicial
            int posicao = 0; // posicao em que a musica do iterador está, guarda posição da maior musica para
                             // trocar

            proximaMusica = iterador.obterProximo(); // recebe musica inicial

            estaOrdenado = true;
            existiuTroca = false;

            // for para comparar musica e trocar até que a maior esteja na ultima posição
            for (int j = 0; j < colecaoDeMusica.obterTotalDeMusicas() - i - 1; j++) {

                if (existiuTroca) {
                    // se houver troca, musicaAtual permanece com o mesmo dado para ser comparado
                    // e proxima musica recebe o proximo dado
                    proximaMusica = iterador.obterProximo();
                } else {
                    // se não houver troca musicaAtual recebe sua proxima musica
                    // proximaMusica recebe sua proxima
                    musicaAtual = proximaMusica;
                    proximaMusica = iterador.obterProximo();
                }

                // faz a troca se musicaAtual for maior que a proxima
                if (musicaAtual.getTrack().compareToIgnoreCase(proximaMusica.getTrack()) > 0) {
                    colecaoDeMusica.trocarPosicaoEntreMusicas(posicao, posicao + 1);
                    existiuTroca = true;
                    estaOrdenado = false;
                } else {
                    existiuTroca = false;
                }
                posicao++;

            }

        }
        return estaOrdenado;
    }

}
