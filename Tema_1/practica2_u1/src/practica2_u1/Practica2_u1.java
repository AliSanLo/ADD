/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2_u1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Alicia
 */
public class Practica2_u1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        
        //declaramos el fichero
        File f = new File ("C:\\Users\\Alicia\\Desktop\\Acceso_a_Datos\\fich\\prueba.txt");
        
        
        //FLUJO DE SALIDA:
        FileWriter fiche = new FileWriter(f);
        String t = "Esto sera el texto introducido e el archivo";
        //lo debemos almacenar como una cadena decaracteres
        char[] cad = t.toCharArray();
        //recorremos la cadena 
        for (int x=0 ; x < cad.length ; x++ ){
            fiche.write(cad[x]); // se copia caracter a caracter 
            fiche.append('-');
            
        }
                    fiche.close();
                    
                    
                    //se me sobreescribe a lo que ya hay escrito

                    //FLUJO DE ENTRADA: 
        //inicializamos la clase FileReader y declaramos entre parentesis el archivo que queremos leer
        FileReader fich = new FileReader(f);
        //lectura del fichero
        int i ; //caracteres 
        //el metodo read() lee caracter a caracter. Cuenta hasta que le quedan 0 caracteres por leer
        while ((i = fich.read()) != -1)
            System.out.print((char)i); //casteamos siempre
        fich.close();
    }
    
}
