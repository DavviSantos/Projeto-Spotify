package br.com.davisantos.datasetSpotify.colecaoDeMusica;

import br.com.davisantos.datasetSpotify.iteradores.Iterador;
import br.com.davisantos.datasetSpotify.iteradores.IteradorLista;
import br.com.davisantos.datasetSpotify.ordenadores.Ordenador;

public class ListaDeMusica implements ColecaoDeMusica {
    private NoMusica noInicial = null;
    private int quantidadeNo = 0;
    // Variáveis Globais para o buscador:
    private NoMusica ultimoNoBuscado = null; // Guarda o ultimo nó acessado pelo buscador
    private int ultimaPosicaoBuscada = 0; // Guarda a posição do último nó acessado pelo buscador

    @Override
    public boolean adicionarMusica(Musica musica) {
        NoMusica novaMusica = new NoMusica(musica);
        NoMusica noAtual = this.noInicial;
        if (this.noInicial != null) {
            while (noAtual.obterProximoNo() != null) {
                noAtual = noAtual.obterProximoNo();
            }
            noAtual.definirProximoNo(novaMusica);
        } else {
            this.noInicial = novaMusica;
        }
        this.quantidadeNo++;
        return true;
    }

    @Override
    public boolean excluirMusica(String nomeDaMusica) {
        boolean musicaExcluida = false;
        NoMusica noAnterior = null;
        NoMusica noAtual = this.noInicial;

        if (this.noInicial != null) {
            while ((noAtual.obterProximoNo() != null)
                    && (!noAtual.obterMusicaNo().getTrack().equalsIgnoreCase(nomeDaMusica))) {
                noAnterior = noAtual;
                noAtual = noAtual.obterProximoNo();
            }
            if (noAtual.obterMusicaNo().getTrack().equalsIgnoreCase(nomeDaMusica)) {
                if (noAnterior == null) {
                    this.noInicial = noAtual.obterProximoNo();
                } else {
                    noAnterior.definirProximoNo(noAtual.obterProximoNo());
                }
                quantidadeNo--;
                musicaExcluida = true;
            }
        }
        return musicaExcluida;
    }

    @Override
    public Musica obterMusica(int posicaoDaMusica) {
        if ((posicaoDaMusica >= 0) & (posicaoDaMusica < this.quantidadeNo)) {
            return buscarNoMusica(posicaoDaMusica).obterMusicaNo();
        } else {
            return null;
        }
    }

    @Override
    public int obterTotalDeMusicas() {
        return quantidadeNo;
    }

    @Override
    public boolean trocarPosicaoEntreMusicas(int posicaoDaMusica1, int posicaoDaMusica2) {
        if ((posicaoDaMusica1 >= 0) && (posicaoDaMusica1 < this.quantidadeNo)) {
            if ((posicaoDaMusica2 >= 0) && (posicaoDaMusica2 < this.quantidadeNo)) {
                NoMusica musica1 = buscarNoMusica(posicaoDaMusica1);
                NoMusica musica2 = buscarNoMusica(posicaoDaMusica2);

                NoMusica noAux = new NoMusica(musica1.obterMusicaNo());
                musica1.definirMusicaNo(musica2.obterMusicaNo());
                musica2.definirMusicaNo(noAux.obterMusicaNo());

                return true;
            }
        }
        return false;

    }

    @Override
    public boolean alterarMusica(int posicaoDaMusica, Musica novaMusica) {
        if ((posicaoDaMusica >= 0) & (posicaoDaMusica < this.quantidadeNo)) {
            buscarNoMusica(posicaoDaMusica).definirMusicaNo(novaMusica);
            return true;
        }
        return false;
    }

    @Override
    public Iterador obterIterador() {
        Iterador iterador = new IteradorLista(this.noInicial);
        return iterador;
    }

    @Override
    public boolean ordenarMusicas(Ordenador ordenador) {
        return ordenador.ordenarMusicas(this);
    }

    // Método recursivo para achar um Nó numa posição específica
    public NoMusica buscarNoMusica(int posicaoDaBusca) {
        // if confere se a posicao buscada é >= a ultima posição acessada
        // sendo a ultima posição acessada diferente de zero
        if ((posicaoDaBusca >= this.ultimaPosicaoBuscada) && (ultimaPosicaoBuscada != 0)) {
            // se ultima posição for igual a posição buscada retorna o nó nesse posição
            if (posicaoDaBusca == this.ultimaPosicaoBuscada) {
                return this.ultimoNoBuscado;
            } else {
                // se não vai pro proximo nó e chama novamente a função
                this.ultimoNoBuscado = this.ultimoNoBuscado.obterProximoNo();
                this.ultimaPosicaoBuscada++;
                return buscarNoMusica(posicaoDaBusca);
            }
        } else {
            // inicia no inicio da lista pois o nó procurado está antes do último nó buscado
            this.ultimoNoBuscado = this.noInicial;
            this.ultimaPosicaoBuscada = 0;
            if (posicaoDaBusca == this.ultimaPosicaoBuscada) {
                return this.ultimoNoBuscado;
            } else {
                this.ultimoNoBuscado = this.ultimoNoBuscado.obterProximoNo();
                this.ultimaPosicaoBuscada++;
                return buscarNoMusica(posicaoDaBusca);
            }
        }
    }

}
