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
public class Cromossomo {
    private int ID;
    private int X;
    private int Y;

    public Cromossomo(int ID, int X, int Y) {
        this.ID = ID;
        this.X = X;
        this.Y = Y;
    }

    public Cromossomo() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    @Override
    public String toString() {
        return "Cromossomo{" + "ID=" + ID + '}';
    }
    
    
    
}
