/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticosia.model;

import java.util.List;

/**
 *
 * @author patrick, rafael
 */
public class Individuo {

    private int tamanho = 280;
    private Cromossomo[] DNA = new Cromossomo[tamanho];
    private double fitnes;
    private int id;

    public Individuo(double fitnes, int id) {
        this.fitnes = fitnes;
        this.id = id;
    }

    public Individuo() {
    }

    public Cromossomo[] getDNA() {
        return DNA;
    }

    public void setDNA(Cromossomo[] DNA) {
        this.DNA = DNA;
    }

    public double getFitnes() {
        return fitnes;
    }

    public void setFitnes(double fitnes) {
        this.fitnes = fitnes;
    }

    public Cromossomo getReturnCity(int i) {
        return DNA[i];
    }

    public void setCity4ID(Cromossomo city, int i) {
        this.DNA[i] = city;
    }

    public int getIndex(Cromossomo city) {
        int i;
        for (i = 0; i < DNA.length; i++) {

            if (DNA[i].getID() == city.getID()) {
                return i;
            }
        }
        return i;
    }

    @Override
    public String toString() {
        return "Individuo{" + "id=" + id + '}';
    }
    
    

}
