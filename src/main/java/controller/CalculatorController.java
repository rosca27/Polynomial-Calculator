package controller;

import main.Main;
import model.CalculatorModel;
import model.Monom;
import model.Polinom;
import view.CalculatorView;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculatorController extends Main {
    private CalculatorView i = new CalculatorView();
    private CalculatorModel c= new CalculatorModel();

    public CalculatorController(CalculatorView i, CalculatorModel c) {
        this.i = i;
        this.c = c;


        this.i.buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Polinom p1;
                    Polinom p2;
                    Polinom p3;
                    String a = i.TextPoly1.getText();
                    String b = i.TextPoly2.getText();
                    System.out.println(a);
                    System.out.println(b);
                    p1 = c.formare_polinom(a);
                    p2 = c.formare_polinom(b);
                    p3 = c.adunare_polinoame(p1, p2);
                    for (Monom i : p3.getV()) {
                        System.out.println(i.getCoeficient() + " " + i.getPower());
                    }
                    c.afisare_monom(p3);
                } catch (NumberFormatException e2) {
                    e2 = new NumberFormatException("Date invalide");
                    JFrame error = new JFrame();
                    JOptionPane.showMessageDialog(error, "Date invalide");
                }
            }
        });
        this.i.buttonSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Polinom p1;
                    Polinom p2;
                    Polinom p3;
                    String a = i.TextPoly1.getText();
                    String b = i.TextPoly2.getText();
                    System.out.println(a);
                    System.out.println(b);
                    p1 = c.formare_polinom(a);
                    p2 = c.formare_polinom(b);
                    p3 = c.scadere_polinoame(p1, p2);
                    for (Monom i : p3.getV()) {
                        System.out.println(i.getCoeficient() + " " + i.getPower());
                    }
                    c.afisare_monom(p3);
                } catch (NumberFormatException e2) {
                    e2 = new NumberFormatException("Date invalide");
                    JFrame error = new JFrame();
                    JOptionPane.showMessageDialog(error, "Date invalide");
                }
            }
        });
        this.i.buttonDeriv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Polinom p1;
                    String a = i.TextPoly1.getText();
                    p1 = c.formare_polinom(a);
                    p1 = c.derivare_polinom(p1);
                    c.afisare_monom(p1);
                } catch (NumberFormatException e2) {
                    e2 = new NumberFormatException("Date invalide");
                    JFrame error = new JFrame();
                    JOptionPane.showMessageDialog(error, "Date invalide");
                }
            }
        });
        this.i.buttonInte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Polinom p1 = c.formare_polinom(i.TextPoly1.getText());
                    String s = c.integrare_polinom(p1);
                    JFrame frame3 = new JFrame("Inegrare");
                    JOptionPane.showMessageDialog(frame3, s);
                } catch (NumberFormatException e2) {
                    e2 = new NumberFormatException("Date invalide");
                    JFrame error = new JFrame();
                    JOptionPane.showMessageDialog(error, "Date invalide");
                }
            }
        });
        this.i.buttonMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Polinom p1;
                    Polinom p2;
                    String t1 = i.TextPoly1.getText();
                    String t2 = i.TextPoly2.getText();
                    p1 = c.formare_polinom(t1);
                    p2 = c.formare_polinom(t2);
                    Polinom p3 = c.inmultire_polinom(p1, p2);
                    c.afisare_monom(p3);
                } catch (NumberFormatException e2) {
                    e2 = new NumberFormatException("Date invalide");
                    JFrame error = new JFrame();
                    JOptionPane.showMessageDialog(error, "Date invalide");
                }
            }
        });
        this.i.buttonDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Polinom p1;
                    Polinom p2;
                    String t1 = i.TextPoly1.getText();
                    String t2 = i.TextPoly2.getText();
                    p1 = c.formare_polinom(t1);
                    p2 = c.formare_polinom(t2);
                    Polinom[] prez = c.impartire_polinom(p1, p2);
                    c.afisare_monom(prez[1]);
                    c.afisare_monom(prez[0]);
                } catch (NumberFormatException e2) {
                    e2 = new NumberFormatException("Date invalide");
                    JFrame error = new JFrame();
                    JOptionPane.showMessageDialog(error, "Date invalide");
                }
            }
        });
    }
}