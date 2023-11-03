package br.com.davisantos.datasetSpotify.colecaoDeMusica;

import br.com.davisantos.datasetSpotify.iteradores.Iterador;
import br.com.davisantos.datasetSpotify.ordenadores.Ordenador;

public interface ColecaoDeMusica {

    public boolean adicionarMusica(Musica musica);

    public boolean excluirMusica(String nomeDaMusica);

    public Musica obterMusica(int posicaoDaMusica);

    public int obterTotalDeMusicas();

    public boolean trocarPosicaoEntreMusicas(int posicaoDaMusica1, int posicaoDaMusica2);

    public boolean alterarMusica(int posicaoDaMusica, Musica novaMusica);

    public Iterador obterIterador();

    public boolean ordenarMusicas(Ordenador ordenador);

}