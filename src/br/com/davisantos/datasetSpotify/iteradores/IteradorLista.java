package br.com.davisantos.datasetSpotify.iteradores;

import br.com.davisantos.datasetSpotify.colecaoDeMusica.Musica;
import br.com.davisantos.datasetSpotify.colecaoDeMusica.NoMusica;

public class IteradorLista implements Iterador {
	private NoMusica noAtual;

	public IteradorLista(NoMusica no) {
		this.noAtual = no;
	}

	@Override
	public Iterador clone() {
		IteradorLista cloneIterador = new IteradorLista(this.noAtual);
		return cloneIterador;
	}

	@Override
	public boolean temProximo() {
		if (this.noAtual != null) {
			return true;
		}
		return false;
	}

	@Override
	public Musica obterProximo() {
		NoMusica musicaAtual = this.noAtual;
		this.noAtual = this.noAtual.obterProximoNo();
		return musicaAtual.obterMusicaNo();
	}
}
