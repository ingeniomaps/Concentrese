package Modelo;

import Vista.MMenu.Opc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cancelar implements ActionListener {
    // Cracion del objeto
    private Opc ob = null;

    // referencia de la ventana opc para que no quede nulo el objeto
    public void setOpc(Opc refVentana) {
        ob = refVentana;
    }

    //Acciones a realizar una vez se de clik
    @Override
    public void actionPerformed(ActionEvent ae) {
        ob.dispose();
    }
}
