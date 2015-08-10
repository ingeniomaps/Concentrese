package Vista;

import Modelo.Cargas;
import java.awt.*;
import javax.swing.*;

public class Pie {

    //Cracion de las variables y objetos
    private Cargas ob = new Cargas();
    public JPanel Pie;
    private JLabel par = new JLabel(numPa());
    public JLabel intentos;
    private Ventana ven = null;

    public Pie() {
        //Inicializacion de las variables
        Pie = new JPanel();
        intentos = new JLabel("Jugada #: 0");

        Pie.setLayout(new GridLayout(1, 1, 20, 20));
        Pie.setBorder(BorderFactory.createEmptyBorder(2, 200, 2, 0));

        //Se agregan las variables al panel
        Pie.add(par);
        Pie.add(intentos);
    }

    //Metodo para decir cuantas parejas hay
    private String numPa() {
        String s = "# Parejas: " + ob.getC();
        return s;
    }

    //Referencia de la ventana para que el objeto no sea nulo
    public void setVentana(Ventana refVentana) {
        this.ven = refVentana;
    }

    //Metodo para refrescar el panel Pie 
    public void ref(int j, int p) {
        Pie.removeAll();
        par.setText("# Parejas: " + p);
        intentos.setText("Jugada #: " + j);
        Pie.add(par);
        Pie.add(intentos);
        Pie.repaint();
    }

    //Metodo para colocar el panel en la ventana
    public void colocarPieVentana() {
        this.ven.getContentPane().add(Pie, BorderLayout.SOUTH);
    }
}
