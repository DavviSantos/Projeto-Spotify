package br.com.davisantos.datasetSpotify.colecaoDeMusica;

public class NoMusica {
    private Musica musica;
    private NoMusica proximo;

    public NoMusica(Musica musica) {
        this.musica = musica;
        this.proximo = null;
    }

    public Musica obterMusicaNo() {
        return musica;
    }

    public void definirMusicaNo(Musica musica) {
        this.musica = musica;
    }

    public NoMusica obterProximoNo() {
        return proximo;
    }

    public void definirProximoNo(NoMusica proximo) {
        this.proximo = proximo;
    }

}
