
package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LecturaArchivo {
    public static void main(String[] args) {
        String cadena;
         BufferedReader entrada = null;
        try {
            FileReader archivo = new FileReader("movimiento.txt");
            entrada = new BufferedReader(archivo);
            System.out.println("Contenido del archivo:");
            cadena = entrada.readLine();
            while(cadena !=null){
                System.out.println(cadena);
                cadena = entrada.readLine();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturaArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LecturaArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                entrada.close();
            } catch (Exception ex) {
//                Logger.getLogger(LecturaArchivo.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("No se pudo cerrar el archivo");
            }
        }
    }
    
}
