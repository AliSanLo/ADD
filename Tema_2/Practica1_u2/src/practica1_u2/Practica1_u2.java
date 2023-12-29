/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_u2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Alicia
 */
public class Practica1_u2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        //1º  Instanciamos el File
        File f = new File ("C:\\Users\\Alicia\\Desktop\\Acceso_a_Datos\\fich\\prueba");
        
        //2ºFlujo de salida
       FileOutputStream salida = new FileOutputStream (f, true); 
        //true hace referencia a se abrirá el archivo en modo de "anexar" (append). 
       //En otras palabras, si el archivo ya existe, los nuevos datos que escribas 
       //se agregarán al final del archivo existente en lugar de sobrescribirlo.
       //Si no queremos ue se añadan mas bytes al final, quitamos el true
       
       //y flujo de entrada
       FileInputStream entrada = new FileInputStream (f);
        //nos esta creando un fichero .dat
       
       int i ;
       
       for(i = 0; i < 101; i++)
           salida.write(i);
           salida.close();
       
            while ((i = entrada.read())!= -1)
            System.out.println(i); //por alguna razon, si casteo, no se copian los numeros en el archivo, aparece codigo asci o algo asi
            entrada.close();
                  
    
    }
    
}
