package Vista.MMenu;

import Vista.InOut;
import java.awt.Toolkit;
import javax.swing.*;

public class Record extends JFrame{
    
    //Creacion de las variables y objetos
    private InOut io = new InOut();
    private JPanel puntajes;
    private JPanel titulo;
    private JLabel text;
    private JLabel ti;
    
    public Record(){
        //Incializacion de las variables
        puntajes = new JPanel();
        titulo = new JPanel();
        text = new JLabel(io.mostrartxt("record.txt"));
        ti = new JLabel("Records");
        
        //Especificaciones de como sera la ventana
        setTitle("Records");
        setResizable(false);
        setSize(400, 430);
        this.setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/concentrece.PNG"));
        setVisible(true);
        
        //Agregar componentes a la ventana informacion con bordes y variables
        puntajes.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 200));
        puntajes.add(text);

        titulo.setBorder(BorderFactory.createEmptyBorder(1, 5, 2, 1));
        titulo.add(ti);

        add(titulo, "North");
        add(puntajes, "Center");
    }
}
