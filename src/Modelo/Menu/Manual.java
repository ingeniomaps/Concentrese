package Modelo.Menu;

import Vista.MMenu.Instrucciones;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manual implements ActionListener {
    //Creacion del Objeto
    private Ventana objVentana = null;
    
    //Referencia de la Ventana para que el objeto no quede nulo
    public void setVentana(Ventana refVentana) {
        objVentana = refVentana;
    }

    //Acciones a realizar cuando se de clik
    @Override
    public void actionPerformed(ActionEvent ae) {
        Instrucciones p = new Instrucciones();
    }
}
