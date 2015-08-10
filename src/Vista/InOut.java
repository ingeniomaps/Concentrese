package Vista;

import java.io.*;
import javax.swing.JOptionPane;

public class InOut {

    public String mostrartxt(String nom) {
        File f;
        FileReader leerArchivo;
        try {
            f = new File(nom);
            leerArchivo = new FileReader(f);
            BufferedReader b = new BufferedReader(leerArchivo);
            String l = "";
            String aux = "";
            while (true) {
                aux = b.readLine();
                if (aux != null) {
                    l = l + aux + "\n";
                } else {
                    break;
                }
            }
            b.close();
            leerArchivo.close();
            return l;
        } catch (IOException e) {
            mostrarStr("Error:" + e.getMessage());
        }
        return null;
    }
    
    //Metodo que muestra en pantalla
    public void mostrarStr(String m){
        JOptionPane.showMessageDialog(null, m);
    }
}
