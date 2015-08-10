package Vista;

import Modelo.Menu.*;
import javax.swing.*;
import java.awt.BorderLayout;

public class Menu {
    //Creacion e inicializacion de la barra y sus items
    private JMenuBar Barra = new JMenuBar();
    private JMenu Archivo = new JMenu("Juego");
    private JMenu Ayuda = new JMenu("Ayuda");
    private JMenuItem Nuevo = new JMenuItem("Nuevo juego");
    private JMenuItem Opciones = new JMenuItem("Opciones");
    private JMenuItem Records = new JMenuItem("Records");
    private JMenuItem Salir = new JMenuItem("Salir");
    private JMenuItem Manual = new JMenuItem("Instrucciones");
    private JMenuItem Acerca = new JMenuItem("Acerca de Concentrece");
    private Nuevo nu = new Nuevo();
    private Opciones opc = new Opciones();
    private Salir sa = new Salir();
    private Manual ma = new Manual();
    private Acerca ac = new Acerca();
    private Puntaje pu = new Puntaje();
    private Ventana ven = null;

    //Metodos para mandar una referencia de la ventana y designar operacion a realizar
    //despues de hacer clic en el item
    public void activarNuevo() {
        Nuevo.addActionListener(nu);
        nu.setVentana(ven);
    }

    public void activarOpciones() {
        Opciones.addActionListener(opc);
        opc.setVentana(ven);
    }

    public void activarSalir() {
        Salir.addActionListener(sa);
        sa.setVentana(ven);
    }

    public void activarManual() {
        Manual.addActionListener(ma);
        ma.setVentana(ven);
    }

    public void activarAcerca() {
        Acerca.addActionListener(ac);
        ac.setVentana(ven);
    }
    
    public void activarPuntaje() {
        Records.addActionListener(pu);
        pu.setVentana(ven);
    }

    public Menu() {

        //Agregar los item a los menus
        Archivo.add(Nuevo);
        Archivo.add(Opciones);
        Archivo.add(Records);
        Archivo.add(Salir);

        Ayuda.add(Manual);
        Ayuda.add(Acerca);

        //Agregar los menus a la barra
        Barra.add(Archivo);
        Barra.add(Ayuda);
    }

    public void setVentana(Ventana refVentana) {
        //Activacion de los metodos a realizar en los clicks
        this.ven = refVentana;
        activarNuevo();
        activarOpciones();
        activarSalir();
        activarPuntaje();

        activarManual();
        activarAcerca();
    }

    //Metodo para colocar el menu en la Ventana
    public void colocarMenuVentana() {
        this.ven.getContentPane().add(Barra, BorderLayout.NORTH);
    }
}
