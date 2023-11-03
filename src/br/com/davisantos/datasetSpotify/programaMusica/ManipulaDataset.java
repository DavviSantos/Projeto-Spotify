package br.com.davisantos.datasetSpotify.programaMusica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.NullPointerException;

import br.com.davisantos.datasetSpotify.colecaoDeMusica.*;
import br.com.davisantos.datasetSpotify.iteradores.Iterador;

public class ManipulaDataset {

    public static void lerDoArquivoCSV(ColecaoDeMusica colecaoDeMusica) {
        String arquivoCSVParaLer = "lib\\Original_dataset.csv";
        String separadorLinha = "";
        BufferedReader conteudoCSV = null;
        String separadorColuna = ";";

        try {
            conteudoCSV = new BufferedReader(new FileReader(arquivoCSVParaLer));

            while ((separadorLinha = conteudoCSV.readLine()) != null) {

                String[] linha = separadorLinha.split(separadorColuna);

                Musica musica = new Musica(linha[0], linha[1], linha[2], linha[3], linha[4], linha[5], linha[6]);

                colecaoDeMusica.adicionarMusica(musica);
            }
            conteudoCSV.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: \n" + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBounds: \n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO error: \n" + e.getMessage());
        }
    }

    public static void escrevaNoArquivoCSV(ColecaoDeMusica colecaoDeMusica) {
        String arquivoCSVParaEscrever = "lib\\Escrita_dataset.csv";
        Iterador iterador = colecaoDeMusica.obterIterador();
        try {
            FileWriter fw = new FileWriter(new File(arquivoCSVParaEscrever));

            while (iterador.temProximo()) {
                fw.write(iterador.obterProximo().getLinhaMusica());
                fw.write("\n");
            }

            fw.close();

        } catch (NullPointerException e) {
            System.out.println("Coleção Vazia: \n" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
