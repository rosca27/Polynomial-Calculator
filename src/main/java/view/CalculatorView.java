package view;
import controller.CalculatorController;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CalculatorView {

    public JTextField TextPoly2;
    JLabel labelPoly1;
    public JTextField TextPoly1;
    JLabel labelPoly2;
    JButton num1;
    JButton num2;
    JButton num3;
    JButton num4;
    JButton num9;
    JButton num6;
    JButton num8;
    JButton num7;
    JButton num5;
    JButton num0;
    JButton numDel;
    JButton numPow;
    JButton numX;
    JButton numPlus;
    JButton numMinus;
    public JButton buttonAdd;
    public JButton buttonSub;
    public JButton buttonMul;
    public JButton buttonDiv;
    public JButton buttonDeriv;
    public JButton buttonInte;
    int input = 0;
    public JFrame frame = new JFrame("MyPanel");
    public CalculatorView() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TextPoly2 = new JTextField ();
        labelPoly1 = new JLabel ("Polynomial 1:");
        TextPoly1 = new JTextField ();
        labelPoly2 = new JLabel ("Polynomial 2:");
        num1 = new JButton ("1");
        num2 = new JButton ("2");
        num3 = new JButton ("3");
        num4 = new JButton ("4");
        num9 = new JButton ("9");
        num6 = new JButton ("6");
        num8 = new JButton ("8");
        num7 = new JButton ("7");
        num5 = new JButton ("5");
        num0 = new JButton ("0");
        numDel = new JButton ("del");
        numPow = new JButton ("^");
        numX = new JButton ("X");
        numPlus = new JButton ("+");
        numMinus = new JButton ("-");
        buttonAdd = new JButton ("Addition");
        buttonSub = new JButton ("Substraction");
        buttonMul = new JButton ("Multiplication");
        buttonDiv = new JButton ("Division");
        buttonDeriv = new JButton ("Derivate");
        buttonInte = new JButton ("Integrate");

        frame.setSize(new Dimension (570, 450));
        frame.setLayout (null);
        frame.setResizable(false);


        frame.add(TextPoly2);
        frame.add (labelPoly1);
        frame.add (TextPoly1);
        frame.add (labelPoly2);
        frame.add (num1);
        frame.add (num2);
        frame.add (num3);
        frame.add (num4);
        frame.add (num9);
        frame.add (num6);
        frame.add (num8);
        frame.add (num7);
        frame.add (num5);
        frame.add (num0);
        frame.add (numDel);
        frame.add (numPow);
        frame.add (numX);
        frame.add (numPlus);
        frame.add (numMinus);
        frame.add (buttonAdd);
        frame.add (buttonSub);
        frame.add (buttonMul);
        frame.add (buttonDiv);
        frame.add (buttonDeriv);
        frame.add (buttonInte);


        TextPoly1.setBounds (90, 25, 400, 30);
        labelPoly1.setBounds (10, 25, 100, 25);
        TextPoly2.setBounds (90, 80, 400, 30);
        labelPoly2.setBounds (10, 85, 90, 25);
        num1.setBounds (90, 245, 50, 35);
        num2.setBounds (145, 245, 50, 35);
        num3.setBounds (200, 245, 50, 35);
        num4.setBounds (90, 195, 50, 35);
        num9.setBounds (200, 150, 50, 35);
        num6.setBounds (200, 195, 50, 35);
        num8.setBounds (145, 150, 50, 35);
        num7.setBounds (90, 150, 50, 35);
        num5.setBounds (145, 195, 50, 35);
        num0.setBounds (145, 290, 50, 35);
        numDel.setBounds (200, 290, 50, 35);
        numPow.setBounds (90, 290, 50, 35);
        numX.setBounds (90, 335, 50, 35);
        numPlus.setBounds (145, 335, 50, 35);
        numMinus.setBounds (200, 335, 50, 35);
        buttonAdd.setBounds (260, 150, 110, 35);
        buttonSub.setBounds (380, 150, 110, 35);
        buttonMul.setBounds (260, 220, 110, 35);
        buttonDiv.setBounds (380, 220, 110, 35);
        buttonDeriv.setBounds (260, 290, 110, 35);
        buttonInte.setBounds (380, 290, 110, 35);

        TextPoly1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                input = 1;
            }
        });

        TextPoly2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                input = 2;
            }
        });

        num0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(input == 1){
                    TextPoly1.setText(TextPoly1.getText()+"0");
                }
                else if(input == 2) {
                    TextPoly2.setText(TextPoly2.getText()+"0");
                }
            }
        });

        num1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(input == 1){
                    TextPoly1.setText(TextPoly1.getText()+"1");
                }
                else if(input == 2) {
                    TextPoly2.setText(TextPoly2.getText()+"1");
                }
            }
        });

        num2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(input == 1){
                    TextPoly1.setText(TextPoly1.getText()+"2");
                }
                else if(input == 2) {
                    TextPoly2.setText(TextPoly2.getText()+"2");
                }
            }
        });

        num3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(input == 1){
                    TextPoly1.setText(TextPoly1.getText()+"3");
                }
                else if(input == 2) {
                    TextPoly2.setText(TextPoly2.getText()+"3");
                }
            }
        });

        num4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(input == 1){
                    TextPoly1.setText(TextPoly1.getText()+"4");
                }
                else if(input == 2) {
                    TextPoly2.setText(TextPoly2.getText()+"4");
                }
            }
        });

        num5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(input == 1){
                    TextPoly1.setText(TextPoly1.getText()+"5");
                }
                else if(input == 2) {
                    TextPoly2.setText(TextPoly2.getText()+"5");
                }
            }
        });

        num6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(input == 1){
                    TextPoly1.setText(TextPoly1.getText()+"6");
                }
                else if(input == 2) {
                    TextPoly2.setText(TextPoly2.getText()+"6");
                }
            }
        });

        num7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(input == 1){
                    TextPoly1.setText(TextPoly1.getText()+"7");
                }
                else if(input == 2) {
                    TextPoly2.setText(TextPoly2.getText()+"7");
                }
            }
        });

        num8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(input == 1){
                    TextPoly1.setText(TextPoly1.getText()+"8");
                }
                else if(input == 2) {
                    TextPoly2.setText(TextPoly2.getText()+"8");
                }
            }
        });

        num9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(input == 1){
                    TextPoly1.setText(TextPoly1.getText()+"9");
                }
                else if(input == 2) {
                    TextPoly2.setText(TextPoly2.getText()+"9");
                }
            }
        });

        numMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(input == 1){
                    TextPoly1.setText(TextPoly1.getText()+"-");
                }
                else if(input == 2) {
                    TextPoly2.setText(TextPoly2.getText()+"-");
                }
            }
        });

        numPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(input == 1){
                    TextPoly1.setText(TextPoly1.getText()+"+");
                }
                else if(input == 2) {
                    TextPoly2.setText(TextPoly2.getText()+"+");
                }
            }
        });

        numPow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(input == 1){
                    TextPoly1.setText(TextPoly1.getText()+"^");
                }
                else if(input == 2) {
                    TextPoly2.setText(TextPoly2.getText()+"^");
                }
            }
        });

        numX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(input == 1){
                    TextPoly1.setText(TextPoly1.getText()+"X");
                }
                else if(input == 2) {
                    TextPoly2.setText(TextPoly2.getText()+"X");
                }
            }
        });

        numDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(input == 1){
                    TextPoly1.setText(TextPoly1.getText().substring(0,TextPoly1.getText().length()-1));
                }
                else if(input == 2) {
                    TextPoly2.setText(TextPoly2.getText().substring(0,TextPoly2.getText().length()-1));
                }
            }
        });

    }
}
