/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticosia.model;

/**
 *
 * @author patrick, rafael
 */
public class Populacao {

    private int tamanho = 400;
    private Individuo[] pais = new Individuo[tamanho];
    private Individuo[] maes = new Individuo[tamanho];
    private Individuo[] filhos1 = new Individuo[tamanho];
    private Individuo[] filhos2 = new Individuo[tamanho];

    public Populacao() {
    }

    public Individuo[] getPais() {
        return pais;
    }

    public void setPais(Individuo[] pais) {
        this.pais = pais;
    }

    public Individuo[] getMaes() {
        return maes;
    }

    public void setMaes(Individuo[] maes) {
        this.maes = maes;
    }

    public Individuo[] getFilhos1() {
        return filhos1;
    }

    public void setFilhos1(Individuo[] filhos1) {
        this.filhos1 = filhos1;
    }

    public Individuo[] getFilhos2() {
        return filhos2;
    }

    public void setFilhos2(Individuo[] filhos2) {
        this.filhos2 = filhos2;
    }

    public Individuo getPais4ID(int i) {
        return pais[i];
    }

    public void setPais4ID(Individuo pais, int i) {
        this.pais[i] = pais;
    }

    public Individuo getMaes4ID(int i) {
        return maes[i];
    }

    public void setMaes4ID(Individuo maes, int i) {
        this.maes[i] = maes;
    }

    public Individuo getFilhos14ID(int i) {
        return filhos1[i];
    }

    public void setFilhos14ID(Individuo filhos1, int i) {
        this.filhos1[i] = filhos1;
    }

    public Individuo getFilhos24ID(int i) {
        return filhos2[i];
    }

    public void setFilhos24ID(Individuo filhos2, int i) {
        this.filhos2[i] = filhos2;
    }

}
