package Vista.MMenu;

import Vista.InOut;
import java.awt.*;
import javax.swing.*;

public class Instrucciones extends JFrame {

    //Creacion de las variables y objetos
    private InOut t = new InOut();
    private JPanel ins;
    private JPanel lo;
    private JLabel text;
    private JLabel im;
    private ImageIcon ima;
    private ImageIcon imagen;

    public Instrucciones() {

        //Incializacion de las variables
        ins = new JPanel();
        lo = new JPanel();
        text = new JLabel(t.mostrartxt("ins.txt"));
        im = new JLabel();
        ima = new ImageIcon("Imagenes/ins.JPG");
        imagen = new ImageIcon(ima.getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT));

        //Especificaciones de como sera la ventana
        setTitle("Instrucciones");
        setResizable(false);
        setSize(600, 340);
        this.setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/concentrece.PNG"));
        setVisible(true);

        //Agregar componentes a la ventana informacion con bordes y variables
        ins.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 200));
        ins.add(text);

        lo.setBorder(BorderFactory.createEmptyBorder(1, 5, 2, 1));
        im.setIcon(imagen);
        lo.add(im);

        add(lo, "East");
        add(ins, "West");
    }
}
