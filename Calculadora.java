import javax.swing.*;

import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.*;


public class Calculadora implements ActionListener{

    JFrame frame;
    static JTextField cajaDeTexto; 
    JButton[] numeroDeBotones = new JButton[10];
    JButton[] funcionDeBotones = new JButton[8];
    JButton sumButton, resButton, mulButton, divButton; 
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;
    static double n1;
    static double n2;
    double resultado;

    Calculadora(){
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        cajaDeTexto = new JTextField(); 
        cajaDeTexto.setBounds(50, 25, 300, 50); //x,y , ancho, altura
        cajaDeTexto.setFont(myFont);
        cajaDeTexto.setEditable(false);

        sumButton = new JButton("+");
        resButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Eliminar");
        clrButton = new JButton("Limpiar");

        funcionDeBotones[0] = sumButton;
        funcionDeBotones[1] = resButton;
        funcionDeBotones[2] = mulButton;
        funcionDeBotones[3] = divButton;
        funcionDeBotones[4] = decButton;
        funcionDeBotones[5] = equButton;
        funcionDeBotones[6] = delButton;
        funcionDeBotones[7] = clrButton; 

        for(int i = 0; i<8; i++){
            funcionDeBotones[i].addActionListener(this);
            funcionDeBotones[i].setFont(myFont);
            funcionDeBotones[i].setFocusable(false);
        }

        for(int i = 0; i<10; i++){
            numeroDeBotones[i] = new JButton(String.valueOf(i));
            numeroDeBotones[i].addActionListener(this);
            numeroDeBotones[i].setFont(myFont);
            numeroDeBotones[i].setFocusable(false);
            
        }

        delButton.setBounds(50, 430, 160, 50);
        clrButton.setBounds(205, 430, 160, 50);

        panel = new JPanel(); 
        panel.setBounds(50, 100, 300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numeroDeBotones[1]);
        panel.add(numeroDeBotones[2]);
        panel.add(numeroDeBotones[3]);
        panel.add(sumButton); 
        panel.add(numeroDeBotones[4]);
        panel.add(numeroDeBotones[5]);
        panel.add(numeroDeBotones[6]);
        panel.add(resButton); 
        panel.add(numeroDeBotones[7]);
        panel.add(numeroDeBotones[8]);
        panel.add(numeroDeBotones[9]);
        panel.add(mulButton); 
        panel.add(delButton); 
        panel.add(decButton); 
        panel.add(numeroDeBotones[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(cajaDeTexto);
        frame.setVisible(true);
    }

    public native double sumar(double a, double b); //*
    public native double restar(double a, double b); //*
    public native double multiplicar(double a, double b); //*
    public native double dividir(double a, double b); //*

    static {
        System.loadLibrary("libreriaCalcu"); //*
    }
    

    Font myFont = new Font("Arial", Font.PLAIN ,30);

    double result = 0;
    char operator; 


    public static void main(String[] args){
        Calculadora ca = new Calculadora();
         //double resultado = ca.sumar(n1, n2);//*
         //String resultado1 = String.format("%.2f", resultado);
         //cajaDeTexto.setText(resultado1);
         //System.out.println("El resultado de la suma es: " + resultado);//*

         //resultado = ca.restar(n1, n2);//*
         //System.out.println("El resultado de la resta es: " + resultado);//*

         //resultado = ca.multiplicar(n1, n2);//*
         //System.out.println("El resultado de la multiplicacion es: " + resultado);//*

        //resultado = ca.dividir(n1, n2);//*
         //System.out.println("El resultado de la division: es" + resultado);//*

     }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Calculadora ca = new Calculadora();
        for (int i = 0; i<10; i++){
            if (e.getSource() == numeroDeBotones[i]){
                cajaDeTexto.setText(cajaDeTexto.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource()==decButton){
            cajaDeTexto.setText(cajaDeTexto.getText().concat("."));
        }
        if (e.getSource()==sumButton){
            n1 = Double.parseDouble(cajaDeTexto.getText());
            operator = '+';
            cajaDeTexto.setText("");
        }
        if (e.getSource()==resButton){
            n1 = Double.parseDouble(cajaDeTexto.getText());
            operator = '-';
            cajaDeTexto.setText("");
        }
        if (e.getSource()==mulButton){
            n1 = Double.parseDouble(cajaDeTexto.getText());
            operator = '*';
            cajaDeTexto.setText("");
        }
        if (e.getSource()==divButton){
            n1 = Double.parseDouble(cajaDeTexto.getText());
            operator = '/';
            cajaDeTexto.setText("");
        }
        if (e.getSource()==equButton){
            n2 = Double.parseDouble(cajaDeTexto.getText());
            
            switch(operator){
                case '+':
                resultado = ca.sumar(n1, n2);//*
                break;

                case '-':
                resultado = ca.restar(n1, n2);//*
                break;

                case '*':
                resultado = ca.multiplicar(n1, n2);//*
                break;

                case '/':
                resultado = ca.dividir(n1, n2);//*
                break;

            }
            cajaDeTexto.setText(String.valueOf(result));
            n1 = result; 
        }
    }

    

}