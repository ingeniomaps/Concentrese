package Modelo;

import Control.Fichas;
import Vista.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cargas extends Fichas implements ActionListener {
    //Creacion de objetos y variables
    public JPanel Juego;
    private InOut io = new InOut();
    public ImageIcon logo[];
    public ImageIcon ima[];
    public int ficha[][];
    public ImageIcon va;
    public ImageIcon vacio;
    private Ventana ven = null;

    //Referencia de la ventana para que el objeto no sea nulo
    public void setVentana(Ventana refVentana) {
        this.ven = refVentana;
    }

    public Cargas() {
        //Inicializacion de las variables
        Juego = new JPanel();
        logo = new ImageIcon[getC()];
        ima = new ImageIcon[getC()];
        ficha = new int[a][b];
        for (int i = 0; i < getC(); i++) {
            logo[i] = new ImageIcon();
            ima[i] = new ImageIcon();
        }
        va = new ImageIcon("Imagenes/interrogacion.PNG");
        vacio = new ImageIcon(va.getImage().getScaledInstance(an, l, Image.SCALE_DEFAULT));
    }
    
    //Metodo que carga las imagenes
    public void logo() {
        logo = new ImageIcon[getC()];
        for (int i = 0; i < getC(); i++) {
            logo[i] = new ImageIcon("Imagenes/" + Integer.toString(i) + ".JPG");
            ima[i] = new ImageIcon(logo[i].getImage().getScaledInstance(getAn(), getL(), Image.SCALE_DEFAULT));
        }
        va = new ImageIcon("Imagenes/interrogacion.PNG");
        vacio = new ImageIcon(va.getImage().getScaledInstance(getAn(), getL(), Image.SCALE_DEFAULT));
    }

    //Cargar los botones en forma grafica agradable
    public void cargarParejas() {
        for (int i = 0; i < getA(); i++) {
            for (int j = 0; j < getB(); j++) {
                parejas[i][j] = new JButton();
                parejas[i][j].setBackground(Color.WHITE);
                parejas[i][j].addActionListener(this);
                parejas[i][j].setIcon(vacio);
                Juego.setLayout(new GridLayout(getA(), getB(), 10, 10));
                Juego.add(parejas[i][j]);
            }
        }
    }

    //Proceso para posicionar las imagenes en el concentrece
    public void cargarImagenes() {
        int x, y = 0;
        int numero = -1;
        double x1, y1 = 0;
        ficha = new int[a][b];
        //Incializacion de la matriz entera en -1
        for (int i = 0; i < getA(); i++) {
            for (int j = 0; j < getB(); j++) {
                ficha[i][j] = -1;
            }

        }

        //Proceso de introduccion de imagenes en posiciones aleatorias para
        //obtener mas variaciones del juego
        for (int i = 0; i < getA(); i++) {
            for (int j = 0; j < getB(); j++) {
                do {
                    x1 = Math.random() * getA();
                    y1 = Math.random() * getB();
                    x = (int) x1;
                    y = (int) y1;
                } while (ficha[x][y] != -1);
                numero++;
                if (numero == getC()) {
                    numero = 0;
                }
                ficha[x][y] = numero;
                parejas[i][j].setIcon(vacio);
            }
        }
    }

    @Override
    //Proceso que se hace una vez se de clic en algun boton que hay en el panel juego
    public void actionPerformed(ActionEvent e) {
        //Ciclo que se repetira determinada cantidad de veces para comprobar si las
        //imagenes son identicas y para ingresar la imagen que tendra cada boton
        for (int i = 0; i < getA(); i++) {
            for (int j = 0; j < getB(); j++) {
                if (e.getSource() == parejas[i][j]) {
                    if (parejas[i][j].getIcon().equals(vacio)) {
                        comprobar(i, j);
                    }
                }
            }
        }
    }
    //*  Metodo de comprobacion.  
    // Creacion de las variables que resguardaran las posiciones a comprobar
    public int pos1, i1, j1, j2, i2;

    public void comprobar(int i, int j) {
        //Analizaremos cada variable posible con condicionales para poder determinar
        // en que posicion esta cada imagen y revisar si esta repetida con esto sabremos si
        // se hizo la pareja correctamente o no y si no se devolveran a la imagen por defecto
        // y cuando la cantidad de parejas sea la determinada se reiniciara el juego
        if (parejas[i][j].getIcon().equals(vacio)) {
            comprobar++;
            if (comprobar != 3) {
                parejas[i][j].setIcon(ima[ficha[i][j]]);
            }
            if (comprobar == 1) {
                pos1 = ficha[i][j];
                i1 = i;
                j1 = j;

            }
            if (comprobar == 2) {
                this.setJugadas(jugadas + 1);
                ven.actualizarPie();
                if (pos1 == ficha[i][j]) {
                    hechas++;
                    comprobar = 0;
                } else {
                    i2 = i;
                    j2 = j;
                }
            }

            if (comprobar == 3) {
                parejas[i1][j1].setIcon(vacio);
                parejas[i2][j2].setIcon(vacio);
                comprobar = 1;
                parejas[i][j].setIcon(ima[ficha[i][j]]);
                pos1 = ficha[i][j];
                i1 = i;
                j1 = j;
            }
            if (hechas == getC()) {
                String s = "Fin del Juego\n";
                s = s + "N° de Jugadas: ";
                io.mostrarStr(s + this.getJugadas());
                finJuego();
            }
        }
    }

    //  final del metodo */
    
    //Metodo para volver a ocultar y cambiar la posicion de las imagenes una vez
    //terminado el juego completamente
    public void finJuego() {
        comprobar = 0;
        hechas = 0;
        this.setJugadas(0);
        ven.actualizarPie();
        cargarImagenes();
    }

    //Metodo que reiniciara el juego o mejor dicho el panel
    public void reiniciar() {
        Juego.removeAll();
        this.logo();
        this.cargarParejas();
        this.finJuego();
    }

    //Metodo para cambiar las propiedades del panel una vez se cambia 
    //el nivel de dificultad del juego
    public void cambiar(int op) {
        if (op == 1) {
            setA(5);
            setB(4);
            setC(getA() * getB() / 2);
            setAn(200);
            setL(80);
        } else if (op == 2) {
            setA(7);
            setB(6);
            setC(getA() * getB() / 2);
            setAn(127);
            setL(67);
        } else if (op == 3) {
            setA(7);
            setB(9);
            setC(getA() * getB() / 2);
            setAn(80);
            setL(55);
        } else if (op == 4) {
            setA(9);
            setB(10);
            setC(getA() * getB() / 2);
            setAn(70);
            setL(40);
        }
    }

    //Metodo para colocar panel Juego dentro de la Ventana predeterminada en la 
    //clase Ventana
    public void colocarJuegoVentana() {
        Juego.setBackground(Color.BLUE);
        Juego.setBorder(BorderFactory.createEmptyBorder(20, 12, 15, 13));
        this.ven.getContentPane().add(Juego, BorderLayout.CENTER);
    }
}
