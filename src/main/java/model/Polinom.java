package model;

import java.util.ArrayList;
public class Polinom extends CalculatorModel {
    private ArrayList<Monom> v = new ArrayList<Monom>();

    public ArrayList<Monom> getV() {
        return v;
    }

    public void setV(ArrayList<Monom> v) {
        this.v = v;
    }

    public Polinom(ArrayList<Monom> v) {
        this.v = v;
    }
}
