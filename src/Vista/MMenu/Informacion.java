package Vista.MMenu;

import Vista.InOut;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

public class Informacion extends JFrame {

    //Creacion de las variables y objetos
    private InOut t = new InOut();
    private JPanel info;
    private JPanel logo;
    private JLabel text;
    private JLabel im;
    public ImageIcon ima;
    public ImageIcon imagen;

    public Informacion() {
        //Incializacion de las variables
        info = new JPanel();
        logo = new JPanel();
        text = new JLabel(t.mostrartxt("acerca.txt"));
        im = new JLabel();
        ima = new ImageIcon("Imagenes/concentrece.PNG");
        imagen = new ImageIcon(ima.getImage().getScaledInstance(100, -1, Image.SCALE_DEFAULT));

        //Especificaciones de como sera la ventana
        setTitle("Acerca de Concentrece");
        setResizable(false);
        setSize(320, 220);
        this.setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/concentrece.PNG"));
        setVisible(true);

        //Agregar componentes a la ventana informacion con bordes y variables
        info.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        info.add(text);

        logo.setBorder(BorderFactory.createEmptyBorder(1, 2, 2, 1));
        im.setIcon(imagen);
        logo.add(im);

        add(logo, "West");
        add(info, "East");
    }
}
