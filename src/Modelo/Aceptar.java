package Modelo;

import Vista.MMenu.Opc;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aceptar implements ActionListener {

    // Se crean los Objetos
    private Opc ob = null;
    private Ventana obj = null;

    //Se trae una referencia de las ventanas para que el metodo no quede nulo
    public void setOpc(Opc refVentana) {
        ob = refVentana;
    }

    public void setVentana(Ventana refVentana) {
        obj = refVentana;
    }

    //Operaciones a realizar una vez se de clic
    @Override
    public void actionPerformed(ActionEvent ae) {
     //   jugadores();
        niveles();
        ob.dispose();
    }

    //Metodo para saber cuantas personas desean jugar ---Proximamente---
  /*  public void jugadores() {
        if (ob.j1.isSelected()) {
            System.out.println("1");
        } else if (ob.j2.isSelected()) {
            System.out.println("2");
        }
    }*/

    //Metodo que permite conocer que nivel de dificultad quiere juegar el cliente
    public void niveles() {
        if (ob.fa.isSelected()) {
            obj.accion(1);
        } else if (ob.me.isSelected()) {
            obj.accion(2);
        } else if (ob.di.isSelected()) {
            obj.accion(3);
        } else if (ob.pro.isSelected()) {
            obj.accion(4);
        }
    }
}