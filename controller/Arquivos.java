/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticosia.controller;

import geneticosia.model.Cromossomo;
import geneticosia.model.Individuo;
import geneticosia.model.Populacao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Math.random;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author patrick, rafael
 */
public class Arquivos {

    private int n;
    private List<Cromossomo> list_city1;
    private List<Cromossomo> list_city2;
    private List<Cromossomo> list_city3;
    private Individuo indi1;
    private Individuo indi2;
    private int tamanho = 280;

    public Arquivos() {
        this.list_city1 = new LinkedList<>();
        this.list_city2 = new LinkedList<>();
        this.list_city3 = new LinkedList<>();
        indi1 = new Individuo();
        indi2 = new Individuo();
    }

    public int getN() {
        return n;
    }

    public void abrirArquivo() throws FileNotFoundException {
        //public void abrirArquivo() throws FileNotFoundException {
        this.n = 0;
        int matriz[][] = null;

        JFileChooser fc = new JFileChooser();

        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            Scanner elem = null;

            elem = new Scanner(fc.getSelectedFile());

            for (int i = 0; i < tamanho; i++) {

                int id, x, y;
                Cromossomo city = new Cromossomo();

                id = elem.nextInt();
                x = elem.nextInt();
                y = elem.nextInt();

                city.setID(id);
                city.setX(x);
                city.setY(y);
                this.list_city3.add(city);
                this.list_city1.add(city);
                this.list_city2.add(city);

            }
        }
    }

    public Individuo gerarPai() {
        int k = tamanho;
        Random random = new Random();
        for (int i = 0; i < tamanho; i++, k--) {

            int rand = random.nextInt(k);

            this.indi1.setCity4ID(this.list_city1.get(rand), i);
            this.list_city1.remove(this.list_city1.get(rand));
        }
        this.list_city1 = this.list_city3;

        return this.indi1;
    }

    public Individuo gerarMae() {
        int k = tamanho;
        Random random = new Random();
        for (int i = 0; i < tamanho; i++, k--) {

            int rand = random.nextInt(k);

            this.indi2.setCity4ID(this.list_city2.get(rand), i);
            this.list_city2.remove(this.list_city2.get(rand));
        }
        this.list_city2 = this.list_city3;

        return this.indi2;
    }

    public Populacao getPopulacao() {
        Populacao retorno = new Populacao();

        for (int k = 0; k < 400; k++) {
            this.list_city1 = new LinkedList<>(this.list_city3);
            this.list_city2 = new LinkedList<>(this.list_city3);
            retorno.setMaes4ID(gerarMae(), k);
            retorno.setPais4ID(gerarPai(), k);
        }

        return retorno;
    }
}
