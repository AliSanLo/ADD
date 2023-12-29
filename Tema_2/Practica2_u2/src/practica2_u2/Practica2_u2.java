/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2_u2;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Alicia
 */
public class Practica2_u2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        /*Escribe un programa en Java llamado FicherosBinariosArray que crea un archivo binario
         llamado "FicheroArrays.dat". El programa almacena información sobre marcas de automóviles 
         y sus respectivos años de lanzamiento. Utiliza las clases FileOutputStream y 
         DataOutputStream para escribir en el archivo. El programa incluye un array de cadenas 
         que representan marcas de automóviles y un array de enteros que representan los años de
         lanzamiento correspondientes. Asegúrate de cerrar adecuadamente las corrientes de salida
         después de escribir en el archivo.*/
        File f = new File("C:\\Users\\Alicia\\Desktop\\Acceso_a_Datos\\nuevaCarpeta\\prueba.dat");
        FileOutputStream salida = new FileOutputStream(f);
        DataOutputStream salidadatos = new DataOutputStream(salida);
        
        //String
        String[] marcas = {
            "marca1", "marca2", "marca3",
            "marca4", "marca5", "marca6"
        }; 
        //cadena de int
        int[] lanzamiento = {
            1954, 1987, 1999, 1878, 1903, 1976
        };
    for(int x = 0; x < lanzamiento.length ; x++){
        salidadatos.writeUTF(marcas[x]); // Para imprimir por pantalla el string
        salidadatos.writeInt(lanzamiento[x]); //para guardar la cadena de int
        
    }
    salidadatos.close();
    }

}
