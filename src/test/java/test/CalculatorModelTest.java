package test;

import model.CalculatorModel;
import model.Monom;
import model.Polinom;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

class CalculatorModelTest {

    @org.junit.jupiter.api.Test
    void formare_polinom() {
        CalculatorModel c = new CalculatorModel();
        String s1 = "X^15+3X^8+8X^3+152X+124532";
        ArrayList<Monom> m1 = new ArrayList<>();
        m1.add(new Monom(124532,0));
        m1.add(new Monom(152,1));
        m1.add(new Monom(8,3));
        m1.add(new Monom(3,8));
        m1.add(new Monom(1,15));
        Polinom p1 = new Polinom(m1);
        Polinom p2 = c.formare_polinom(s1);
        for(Monom i : m1) {
            assertEquals(Integer.valueOf(i.getCoeficient()),Integer.valueOf(p2.getV().get(i.getPower()).getCoeficient()));
            assertEquals(Integer.valueOf(i.getPower()), Integer.valueOf(p2.getV().get(i.getPower()).getPower()));
        }

    }

    @org.junit.jupiter.api.Test
    void adunare_polinoame() {
        CalculatorModel c = new CalculatorModel();
        String s1 ="X^2+3X+4";
        String s2 ="X^14+X^8+12X^2-16X-4";
        String rez ="X^14+X^8+13X^2-13X";
        Polinom p1 = c.formare_polinom(s1);
        Polinom p2 = c.formare_polinom(s2);
        Polinom p3 = c.formare_polinom(rez);
        Polinom prez = c.adunare_polinoame(p1,p2);
        for(Monom i : prez.getV()){
            for(Monom j : p3.getV()){
                if(prez.getV().indexOf(i) == p3.getV().indexOf(j)){
                    assertEquals(i.getCoeficient(),j.getCoeficient());
                    assertEquals(i.getPower(),j.getPower());
                }
            }
        }

    }

    @org.junit.jupiter.api.Test
    void scadere_polinoame() {
        CalculatorModel c = new CalculatorModel();
        String s1 ="X^2+3X+4";
        String s2 ="X^14+X^8+12X^2-16X+1";
        String rez ="-X^14-X^8-11X^2+19X+3";
        Polinom p1 = c.formare_polinom(s1);
        Polinom p2 = c.formare_polinom(s2);
        Polinom p3 = c.formare_polinom(rez);
        Polinom prez = c.scadere_polinoame(p1,p2);
        for(Monom i : prez.getV()) {
            for (Monom j : p3.getV()) {
                if (prez.getV().indexOf(i) == p3.getV().indexOf(j)) {
                    assertEquals(i.getCoeficient(), j.getCoeficient());
                    assertEquals(i.getPower(), j.getPower());
                }
            }
        }
    }

    @org.junit.jupiter.api.Test
    void inmultire_polinom() {
        String s1 ="X^6+2X^4+35X^2+74X+3";
        String s2 ="4X^9+6X^6+8X^4+81X^2+3X+1";
        String rez ="4X^15+8X^13+6X^12+140X^11+316X^10+12X^9+307X^8+447X^7+461X^6+598X^5+2861X^4+6099X^3+500X^2+83X+3";
        CalculatorModel c = new CalculatorModel();
        Polinom p1 = c.formare_polinom(s1);
        Polinom p2 = c.formare_polinom(s2);
        Polinom p3 = c.inmultire_polinom(p1,p2);
        Polinom prez = c.formare_polinom(rez);
        for(Monom i : prez.getV()){
            for(Monom j : p3.getV()){
                if(prez.getV().indexOf(i) == p3.getV().indexOf(j)){
                    assertEquals(i.getCoeficient(),j.getCoeficient());
                    assertEquals(i.getPower(),j.getPower());
                }
            }
        }
    }

    @org.junit.jupiter.api.Test
    void derivare_polinom() {
        CalculatorModel c = new CalculatorModel();
        String s1 = "X^4+4X^3+7X+4";
        String rez = "4X^3+12X^2+7";
        Polinom p1 = c.formare_polinom(s1);
        Polinom prez = c.derivare_polinom(p1);
        for(Monom i : prez.getV()){
            for(Monom j : p1.getV()){
                if(prez.getV().indexOf(i) == p1.getV().indexOf(j)){
                    assertEquals(i.getCoeficient(),j.getCoeficient());
                    assertEquals(i.getPower(),j.getPower());
                }
            }
        }

    }

    @org.junit.jupiter.api.Test
    void integrare_polinom() {
        CalculatorModel c = new CalculatorModel();
        String s1 ="X^3+18X^2+7";
        Polinom p1 = c.formare_polinom(s1);
        String rez ="0,33X^4+9X^3+7X";
        String s3 = c.integrare_polinom(p1);
        assertEquals(s3,rez);
    }

    @org.junit.jupiter.api.Test
    void impartire_polinom() {
        CalculatorModel c = new CalculatorModel();
        String s1 = "2X^4+X^2+X-3";
        String s2 = "X^2-4X";
        String crez = "2X^2+8X+33";
        String rrez = "133X-3";
        Polinom p1 = c.formare_polinom(s1);
        Polinom p2 = c.formare_polinom(s2);
        Polinom pcrez = c.formare_polinom(crez);
        Polinom prrez = c.formare_polinom(rrez);
        Polinom[] rez = c.impartire_polinom(p1,p2);
        for(Monom i : prrez.getV()){
            for(Monom j : rez[0].getV()){
                if(prrez.getV().indexOf(i) == rez[0].getV().indexOf(j)){
                    assertEquals(i.getCoeficient(),j.getCoeficient());
                    assertEquals(i.getPower(),j.getPower());
                }
            }
        }
        for(Monom i : pcrez.getV()){
            for(Monom j : rez[1].getV()){
                if(pcrez.getV().indexOf(i) == rez[1].getV().indexOf(j)){
                    assertEquals(i.getCoeficient(),j.getCoeficient());
                    assertEquals(i.getPower(),j.getPower());
                }
            }
        }

    }
}