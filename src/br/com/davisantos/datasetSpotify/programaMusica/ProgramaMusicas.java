package br.com.davisantos.datasetSpotify.programaMusica;

import br.com.davisantos.datasetSpotify.colecaoDeMusica.*;
import br.com.davisantos.datasetSpotify.iteradores.*;
import br.com.davisantos.datasetSpotify.ordenadores.*;

public class ProgramaMusicas {
    public static void main(String[] args) {
        ColecaoDeMusica colecaoDeMusica = new ListaDeMusica();
        // ColecaoDeMusica colecaoDeMusica = new VetorDeMusica(30000);
        // Ordenador ordenador = new BubbleSort();
        Ordenador ordenador = new SelectionSort();

        ManipulaDataset.lerDoArquivoCSV(colecaoDeMusica);

        System.out.println(colecaoDeMusica.obterTotalDeMusicas());

        // listar(colecaoDeMusica);

        // System.out.println(colecaoDeMusica.trocarPosicaoEntreMusicas(0, 9));

        System.out.println(colecaoDeMusica.ordenarMusicas(ordenador));

        ManipulaDataset.escrevaNoArquivoCSV(colecaoDeMusica);

    }

    public static void listar(ColecaoDeMusica colecaoDeMusica) {
        Iterador iterador = colecaoDeMusica.obterIterador();
        int posicaoMusica = 0;
        try {
            while (iterador.temProximo()) {
                System.out.println("\nMúsica Posição: " + posicaoMusica + iterador.obterProximo().getInfoMusica());
                posicaoMusica++;
            }
        } catch (NullPointerException e) {
            System.out.println("Coleção vazia: \n" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
