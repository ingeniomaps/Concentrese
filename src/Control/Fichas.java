package Control;

import javax.swing.*;

public class Fichas {

    //Creacion de las variables
    public int a = 10;
    public int b = a;
    public int c = a * b / 2;
    public int an = 127;
    public int l = 67;
    public int comprobar = 0, jugadas = 0, hechas;

    public JButton parejas[][];

    //Incializacion de los botones
    public Fichas() {
        parejas = new JButton[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                parejas[i][j] = new JButton();
            }
        }
    }
    
    //Metodos get y set que modificaremos para hacer todas la variaciones 
    //correspondientes al programa y asi cambiar apariencia cantidad de fihcas, parejas, etc.
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
    
    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    
    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
    
    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }
    
        public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }
    public int getJugadas() {
        return jugadas;
    }

    public void setJugadas(int jugadas) {
        this.jugadas = jugadas;
    }
}
