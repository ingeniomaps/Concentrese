package Vista.MMenu;

import Modelo.*;
import Vista.Ventana;
import java.awt.*;
import javax.swing.*;

public class Opc extends JFrame {

    //Creacion de los objetos y variables de la ventana Opc
    private Aceptar ac = new Aceptar();
    private Cancelar c = new Cancelar();
    private Ventana ven = null;
    public JPanel jug;
    public JPanel dif;
    private JLabel num;
    public JRadioButton j1;
    public JRadioButton j2;
    public ButtonGroup grupo;
    private JLabel opc;
    public JRadioButton fa;
    public JRadioButton me;
    public JRadioButton di;
    public JRadioButton pro;
    public ButtonGroup grupo2;
    private JPanel botones;
    private JButton aceptar;
    private JButton cancelar;

    public Opc() {
        //Inicializacion de las variables
        jug = new JPanel();
        dif = new JPanel();

        num = new JLabel("Numero de Jugadores: ");
        j1 = new JRadioButton("1 Jugador", true);
        j2 = new JRadioButton("2 Jugadores");
        grupo = new ButtonGroup();

        opc = new JLabel("Dificultad: ");
        fa = new JRadioButton("Facil");
        me = new JRadioButton("Medio");
        me.setSelected(true);
        di = new JRadioButton("Dificil");
        pro = new JRadioButton("Profesional");
        grupo2 = new ButtonGroup();

        botones = new JPanel();
        aceptar = new JButton("Aceptar");
        cancelar = new JButton("Cancelar");

        //Apariencia y demas modificaciones que le vamos a dar a nuestra ventana por defecto
        setTitle("Opciones");
        setResizable(false);
        setSize(350, 200);
        this.setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/concentrece.PNG"));
        setVisible(true);

        //Adicionamiento de los paneles, labels, radiobutton, botones y demas
        //cosas que le agregemos a nuestra ventana
        grupo.add(j1);
        grupo.add(j2);
        jug.add(num);
        jug.add(j1);
        jug.add(j2);
        add(jug, "West");
        jug.setLayout(new GridLayout(5, 5, 5, 5));
        jug.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));

        grupo2.add(fa);
        grupo2.add(me);
        grupo2.add(di);
        grupo2.add(pro);
        dif.add(opc);
        dif.add(fa);
        dif.add(me);
        dif.add(di);
        dif.add(pro);
        add(dif, "East");
        dif.setLayout(new GridLayout(5, 5, 5, 5));
        dif.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 60));

        botones.add(aceptar);
        botones.add(cancelar);
        add(botones, "South");

        //Activacion de los metodos de la clase
        activarAceptar();
        activarCancelar();
    }

    //Metodos que permiten efectuar las acciones de las clases Aceptar y Cancelar
    private void activarAceptar() {
        aceptar.addActionListener(ac);
        ac.setOpc(this);
    }

    private void activarCancelar() {
        cancelar.addActionListener(c);
        c.setOpc(this);
    }

    //Metodo para enviar una referencia de la ventana y no tener objetos nulos
    public void activarOpciones(Ventana refVentana) {
        this.ven = refVentana;
        ac.setVentana(ven);
    }
}
