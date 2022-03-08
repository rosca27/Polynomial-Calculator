package model;

import controller.CalculatorController;
import main.Main;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.text.DecimalFormat;

public class CalculatorModel  {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Polinom formare_polinom (String a) throws NumberFormatException {
        NumberFormatException e = new NumberFormatException();
        if(a == null)
            throw e ;
        ArrayList<Monom> m1 = new ArrayList<Monom>();
        Polinom polinom1 = new Polinom(m1);
        String[] comp = a.split("(?=[+-])");
        if(!comp[0].toString().contains("X")) {
            m1.add(0,new Monom(0,0));
        }
        else {
            if(comp[0].contains("^")) {
                String[] y = comp[0].split("\\^");
                if(y[1].contains("X"))
                    throw e;
                else
                     y = comp[0].split("X\\^");
                int indexMax = Integer.valueOf(y[1]);
                for (int i = 0; i <= indexMax; i++) {
                    m1.add(0, new Monom(0, 0));
                }
            }
            else {
                if(comp[0].matches(".*X{2,}+.*"))
                    throw e;
                String[] y2 = comp[0].split("X");
                if (y2.length > 0) {
                    if (y2[0] != "") {
                        if (y2[0].charAt(0) == '-') {
                            m1.add(0, new Monom(0, 0));
                            m1.add(1, new Monom(-1, 1));
                        } else {
                            int coef = Integer.valueOf(y2[0]);
                            m1.add(0, new Monom(0, 0));
                            m1.add(1, new Monom(coef, 1));
                        }
                    }
                }else{
                    m1.add(0, new Monom(0, 0));
                    m1.add(1, new Monom(1, 1));
                }
            }
            }
            for (int i = 0; i < comp.length; i++) {
                if(comp[i].matches(".*X{2,}+.*"))
                    throw e;
                if (!comp[i].contains("X")) {
                    m1.set(0, new Monom(Integer.valueOf(comp[i]), 0));
                } else {
                    if (comp[0].length() > 1) {
                        if ((comp[i].charAt(1) == 'X' && i != 0) || ((comp[i].charAt(0) == 'X' && i == 0) || (comp[i].charAt(0) == '-' && comp[i].charAt(1) == 'X' && i == 0))) {
                            if (comp[i].charAt(comp[i].length() - 1) == 'X' && comp[i].charAt(comp[i].length() - 2) != '^') {
                                if (comp[i].charAt(0) == '-')
                                    m1.set(1, new Monom(-1, 1));
                                else
                                    m1.set(1, new Monom(1, 1));
                            } else {
                                if (comp[i].charAt(0) == 'X' && i == 0) {
                                    String[] pow1 = comp[i].split("\\^");
                                    if(pow1[1].contains("X"))
                                        throw e;
                                    else
                                        pow1 = comp[i].split("X\\^");
                                    int pow2 = Integer.valueOf(pow1[1]);
                                    m1.set(pow2, new Monom(1, pow2));
                                } else {
                                    String[] pow = comp[i].split("\\^");
                                    if(pow[1].contains("X"))
                                        throw e;
                                    else
                                        pow = comp[i].split("X\\^");
                                    int powerr = Integer.valueOf(pow[1]);
                                    if (pow[0].charAt(0) == '-')
                                        m1.set(powerr, new Monom(-1, powerr));
                                    else {
                                        m1.set(powerr, new Monom(1, powerr));
                                    }
                                }
                            }
                        } else {
                            String[] x = comp[i].split("X\\^");
                            if (x.length == 1) {
                                String c2[] = x[0].split("X");
                                int coeficient2 = Integer.valueOf(c2[0]);
                                m1.set(1, new Monom(coeficient2, 1));
                            } else {
                                int index = Integer.valueOf(x[1]);
                                int coeficient = Integer.valueOf(x[0]);
                                m1.set(index, new Monom(coeficient, index));
                            }
                        }
                    }
                }
            }

        return polinom1;
    }

    public Polinom adunare_polinoame(Polinom p1, Polinom p2){
        ArrayList<Monom> m2 = new ArrayList<Monom>();
        Polinom p3 = new Polinom(m2);
        int indexMin = Math.min(p2.getV().size(),p1.getV().size());
        int indexMax = Math.max(p2.getV().size(),p1.getV().size());
        for(int i = 0; i < indexMin; i++){
            p3.getV().add(new Monom(p1.getV().get(i).getCoeficient()+ p2.getV().get(i).getCoeficient(),i));
        }
        if(indexMax == p1.getV().size()){
            for(int i = indexMin ; i < indexMax; i++){
                p3.getV().add(new Monom(p1.getV().get(i).getCoeficient(),p1.getV().get(i).getPower()));
            }
        }else{
            for(int i = indexMin ; i < indexMax; i++){
                p3.getV().add(new Monom(p2.getV().get(i).getCoeficient(),p2.getV().get(i).getPower()));
            }
        }
        return p3;
    }

    public Polinom scadere_polinoame(Polinom p1, Polinom p2){
        ArrayList<Monom> m2 = new ArrayList<Monom>();
        Polinom p3 = new Polinom(m2);
        int indexMin = Math.min(p2.getV().size(),p1.getV().size());
        int indexMax = Math.max(p2.getV().size(),p1.getV().size());
        for(int i = 0; i < indexMin; i++){
            p3.getV().add(new Monom(p1.getV().get(i).getCoeficient()- p2.getV().get(i).getCoeficient(),i));
        }
        if(indexMax == p1.getV().size()){
            for(int i = indexMin; i  < indexMax; i++){
                p3.getV().add(new Monom(p1.getV().get(i).getCoeficient(),p1.getV().get(i).getPower()));
            }
        }else{
            for(int i = indexMin ; i < indexMax; i++){
                p3.getV().add(new Monom(-p2.getV().get(i).getCoeficient(),p2.getV().get(i).getPower()));
            }
        }
        return p3;
    }

    public void afisare_monom(Polinom p1){
        String s = "";
        Collections.reverse(p1.getV());
        ArrayList<Monom> m1 = p1.getV();
        for(Monom i : m1){
            if(i.getCoeficient()!= 0 ||(i.getPower()!=0 && i.getCoeficient()!=0)) {
                if(i.getPower() == 0){
                    if(i.getCoeficient()>0) {
                        s += "+"+String.valueOf(i.getCoeficient());
                    }else{
                        s += String.valueOf(i.getCoeficient());
                    }
                }else if (i.getCoeficient() == 1) {
                    if (i.getPower() == 1) {
                        s += "+X";
                    } else {
                        s += "+X^" + String.valueOf(i.getPower());
                    }
                } else if (i.getCoeficient() == -1) {
                    if (i.getPower() == 1) {
                        s += "-X";
                    } else {
                        s += "-X^" + String.valueOf(i.getPower());
                    }
                }else if(i.getPower() == 1){
                    if(i.getCoeficient() > 0) {
                        s += "+"+String.valueOf(i.getCoeficient()) + "X";
                    }
                    else {
                        s += String.valueOf(i.getCoeficient()) + "X";
                    }
                }else{
                    if(i.getCoeficient() >0) {
                        s += "+"+String.valueOf(i.getCoeficient()) + "X^" + String.valueOf(i.getPower());
                    }else
                    {
                        s += String.valueOf(i.getCoeficient()) + "X^" + String.valueOf(i.getPower());
                    }
                }
            }
        }
        Collections.reverse(p1.getV());
        JFrame frame1 = new JFrame("Rezultat");
        JOptionPane.showMessageDialog(frame1,s);
    }

    public Polinom derivare_polinom(Polinom p1){

        ArrayList<Monom> m1 = p1.getV();
        m1.set(0,new Monom(0,0));
        for(Monom i : m1){
            if(m1.indexOf(i)>0) {
                m1.set(m1.indexOf(i) - 1, new Monom(i.getCoeficient() * i.getPower(), i.getPower() - 1));
                m1.set(m1.indexOf(i), new Monom(0, 0));
            }
        }
        Polinom p2 = new Polinom(m1);
        return p2;
    }

    public String integrare_polinom(Polinom p1){

        ArrayList<Monom> m1 = p1.getV();
        ArrayList<Monom> m2 = new ArrayList<>();
        Collections.reverse(m1);
        m1.add(m1.size(),new Monom(0,0));
        String s = "";
        for(Monom i : m1){
            if(i.getCoeficient()!= 0) {
                if(i.getCoeficient()>0 && m1.indexOf(i) > 0)
                    s+="+";
                if (i.getPower() > 0) {
                    if((float) i.getCoeficient() / i.getPower() == (int)i.getCoeficient() / i.getPower())
                        s += String.valueOf((int) i.getCoeficient() / i.getPower()) + "X^" + String.valueOf(i.getPower() + 1);
                        else
                        s += String.valueOf(df.format((float) i.getCoeficient() / i.getPower()) + "X^" + String.valueOf(i.getPower() + 1));
                    } else {
                    s += i.getCoeficient() + "X";
                }
            }
        }
        return s;
    }

    public Polinom  inmultire_polinom(Polinom p1, Polinom p2){
        ArrayList<Monom> m1 = new ArrayList<Monom>();
        Polinom p3 = new Polinom(m1);
        int maxSize = (p1.getV().get(p1.getV().size()-1).getPower()) + (p2.getV().get(p2.getV().size()-1).getPower()) + 2;
        for(int i = 0; i <=maxSize;i++){
            m1.add(new Monom(0,0));
        }
        for(Monom i : p1.getV()){
            for(Monom j : p2.getV()){
                m1.set(i.getPower()+j.getPower(),new Monom(p3.getV().get(i.getPower()+j.getPower()).getCoeficient()+i.getCoeficient()*j.getCoeficient(),i.getPower()+j.getPower()));
            }
        }
        return p3;
    }

    public Polinom  eliminare_zero(Polinom p1){
        ArrayList<Monom> m1 = p1.getV();
        int k = 0;
        for(Monom i : p1.getV()){
            if(i.getCoeficient() == 0){
                k++;
            }
            else
                k = 0;
        }
        if(k!=0) {
            for (int j = 1; j <= k; j++) {
                p1.getV().remove(p1.getV().size()-1);
            }
        }

        Polinom p2 = new Polinom(p1.getV());
        return p2;
    }

    public Polinom[] impartire_polinom(Polinom p1, Polinom p2){
        ArrayList<Monom> m4 = new ArrayList<Monom>();
        ArrayList<Monom> imp = new ArrayList<Monom>();
        Polinom impa;
        Polinom c;
        Polinom r = new Polinom(m4);
        imp.add(new Monom(0,0));
        while(p1.getV().size()>=p2.getV().size()){
            int coef = p1.getV().get(p1.getV().size()-1).getCoeficient()/p2.getV().get(p2.getV().size()-1).getCoeficient();
            int pow = p1.getV().get(p1.getV().size()-1).getPower() - p2.getV().get(p2.getV().size()-1).getPower();
            m4.add(new Monom(coef,pow));
            imp.set(0,new Monom(coef,pow));
            impa = new Polinom(imp);
            c = inmultire_polinom(p2,impa);
            p1 = scadere_polinoame(p1,c);
            p1 = eliminare_zero(p1);
        }
        Collections.reverse(r.getV());
        Polinom[] rez = new Polinom[2];
        rez[0] = p1;
        rez[1] = r;
        return rez;
    }

}
