package Vista;

import Modelo.Cargas;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Ventana extends JFrame {
    //Cracion de los Objetos
    private Menu ob = new Menu();
    private Cargas o = new Cargas();
    private Pie obj = new Pie();

    public Ventana() {
        // Cargar el Juego por defecto
        juegoDefecto();
        
        //Especificaciones de como sera la ventana
        this.setTitle("Concentrece");
        this.setResizable(false);
        this.setSize(850, 550);
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/concentrece.PNG"));
        this.setVisible(true);

        //Metodo para que al cerrar la ventana se deje de ejecutar el progama
        this.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
    
    //Metodo que carga el nivel del juego con el que comenzara la ventana
    private void juegoDefecto(){
        o.setA(7);
        o.setB(6);
        o.setC(o.getA()*o.getB()/2);
        obj.ref(0, o.getC());
        o.logo();
        o.cargarParejas();
        o.cargarImagenes();
    }

    // Metodo que llama los componentes de la ventana
    public void mostrarInterfaz() {
        ob.setVentana(this);
        obj.setVentana(this);
        o.setVentana(this);
        ob.colocarMenuVentana();
        obj.colocarPieVentana();
        o.colocarJuegoVentana();
    }

    //Metodo para poder reiniciar el panel
    public void ref() {
        o.reiniciar();
        obj.ref(0, o.getC());
        o.Juego.setVisible(false);
        o.Juego.setVisible(true);
        this.repaint();
    }
    
    //Accion a realizar una vez se cambia el nivel del juego
    public void accion(int op){
        o.cambiar(op);
        obj.ref(0, o.getC());
        this.ref();
    }

    //Mettodo que actualiza el panel Pie
    public void actualizarPie(){
        obj.ref(o.getJugadas(), o.getC());
        obj.Pie.setVisible(false);
        obj.Pie.setVisible(true);
        this.repaint();
    }
}
