/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticosia.controller;

import geneticosia.model.Individuo;
import geneticosia.model.Populacao;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author patrick, rafael
 */
public class GerarPopulacao {

    private int tamanho = 400;
    private Populacao geracoes;
    private List<Integer> num_aux = new LinkedList<>();

    public GerarPopulacao(Populacao geraçoes) {
        this.geracoes = geraçoes;
    }

    public Populacao getGeraçoes() {
        return geracoes;
    }

    public void setGeraçoes(Populacao geraçoes) {
        this.geracoes = geraçoes;
    }

    public void numeros() {
        for (int i = 0; i < tamanho; i++) {
            num_aux.add(i);
        }
    }

    public void gerar() {
        numeros();
        GerarIndivido gerar;
        Random random = new Random();
        int rand;


        for (int i = 0, j = 400; i < tamanho; i++, j--) {

            rand = random.nextInt(j);
            gerar = new GerarIndivido( geracoes.getMaes4ID(rand),geracoes.getPais4ID(i));
            gerar.crossingOver();
            num_aux.remove(rand);
            geracoes.setFilhos14ID(gerar.getFilho1(), i);
            geracoes.setFilhos24ID(gerar.getFilho2(), i);
        }
    }

    public double best_fitness() {
        double melhor_fitnes = 100000;
        double aux;
        for (int i = 0; i < 400; i++) {
            aux = geracoes.getFilhos14ID(i).getFitnes();
            if (aux < melhor_fitnes) {
                melhor_fitnes = aux;
            }

            aux = geracoes.getFilhos24ID(i).getFitnes();
            if (aux < melhor_fitnes) {
                melhor_fitnes = aux;
            }
        }
        return melhor_fitnes;
    }

}
