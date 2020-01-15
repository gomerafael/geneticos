/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticosia.controller;

import geneticosia.model.Individuo;
import geneticosia.model.Cromossomo;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author patrick, rafael
 */
public class GerarIndivido {

    private Individuo mae;
    private Individuo pai;
    private Individuo filho1;
    private Individuo filho2;
    private int tamanho = 280;
    private int taxa_mutaçao = 20;

    public GerarIndivido(Individuo mae, Individuo pai) {
        this.mae = mae;
        this.pai = pai;
        this.filho1 = new Individuo();
        this.filho2 = new Individuo();
    }

    public GerarIndivido() {
        this.mae = new Individuo();
        this.filho1 = new Individuo();
        this.filho2 = new Individuo();
        this.pai = new Individuo();
    }

    public Individuo getMae() {
        return mae;
    }

    public void setMae(Individuo mae) {
        this.mae = mae;
    }

    public Individuo getPai() {
        return pai;
    }

    public void setPai(Individuo pai) {
        this.pai = pai;
    }

    public Individuo getFilho1() {
        return filho1;
    }

    public void setFilho1(Individuo filho1) {
        this.filho1 = filho1;
    }

    public Individuo getFilho2() {
        return filho2;
    }

    public void setFilho2(Individuo filho2) {
        this.filho2 = filho2;
    }

    public double distancia(Cromossomo a, Cromossomo b) {

        double result;
        int x, y;

        x = Math.abs(a.getX() - b.getX());
        y = Math.abs(a.getY() - b.getY());

        BigDecimal bd = new BigDecimal(Math.sqrt((x * x) + (y * y))).setScale(5, RoundingMode.HALF_EVEN);

        result = bd.doubleValue();

        return result;
    }

    public double calcFitness(Individuo indi) {
        double dist = 0;

        for (int i = 0, j = 1; j < this.tamanho; i++, j++) {
            dist += distancia(indi.getReturnCity(i), indi.getReturnCity(j));
        }
        return dist;
    }

    public boolean isRepetido(Individuo ind) {

        for (int i = 0; i < this.tamanho; i++) {
            for (int j = 0; j < this.tamanho; j++) {
                if (i != j) {
                    if (ind.getDNA()[i].getID() == ind.getDNA()[j].getID()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean conteins(Individuo indi, Cromossomo city, int tam) {

        for (int i = 0; i < tam; i++) {
            if (indi.getDNA()[i].getID() == city.getID()) {
                return true;
            }
        }

        return false;

    }

    public void crossingOver() {

        Random random = new Random();
        int rand = random.nextInt(tamanho);
        
        for (int i = 0; i < rand; i++) {

            this.filho1.setCity4ID(this.mae.getReturnCity(i), i);
            this.filho2.setCity4ID(this.pai.getReturnCity(i), i);
        }
        
        for (int i = rand, j = rand; i < this.tamanho; j = (j + 1) % this.tamanho) {
            if (!conteins(this.filho1, this.pai.getReturnCity(j), i)) {
                this.filho1.setCity4ID(this.pai.getReturnCity(j), i);
                i++;
            }
        }

        for (int i = rand, j = rand; i < this.tamanho; j = (j + 1) % this.tamanho) {

            if (!conteins(this.filho2, this.mae.getReturnCity(j), i)) {
                this.filho2.setCity4ID(this.mae.getReturnCity(j), i);
                i++;
            }
        }

        float mutacao_f1 = random.nextInt(100);
        float mutacao_f2 = random.nextInt(100);

        if (mutacao_f1 < taxa_mutaçao) {
            mutacao(this.filho1);
        }

        if (mutacao_f2 < taxa_mutaçao) {
            mutacao(this.filho2);
        }

        
        this.filho1.setFitnes(calcFitness(this.filho1));
        this.filho2.setFitnes(calcFitness(this.filho2));

        pai = filho2;
        mae = filho1;
    }

    public void mutacao(Individuo indi) {
        Random random = new Random();
        int rand = 0;
        int rand1 = 0;
        Cromossomo aux = new Cromossomo();

        while (rand == rand1) {
            rand1 = random.nextInt(tamanho);
            rand = random.nextInt(tamanho);
        }

        aux = indi.getReturnCity(rand);
        indi.setCity4ID(indi.getReturnCity(rand1), rand);
        indi.setCity4ID(aux, rand1);
        /*
        rand = rand1;

        while (rand == rand1) {
            rand1 = random.nextInt(tamanho);
            rand = random.nextInt(tamanho);
        }

        aux = this.filho2.getReturnCity(rand);
        this.filho2.setCity4ID(this.filho2.getReturnCity(rand1), rand);
        this.filho2.setCity4ID(aux, rand1);
         */
    }

}
