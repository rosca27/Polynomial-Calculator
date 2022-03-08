package model;

public class Monom extends CalculatorModel {
    private int coeficient;
    private int power;

    public int getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(int coeficient) {
        this.coeficient = coeficient;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Monom(int exponent, int power) {
        this.coeficient = exponent;
        this.power = power;
    }
}
