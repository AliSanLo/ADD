/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3_u2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Alicia
 */
public class Practica3_u2 {

   
    public static void main(String[] args) throws IOException {
        File f = new File ("C:\\Users\\Alicia\\Desktop\\Acceso_a_Datos\\nuevaCarpeta\\prueba.dat");
        
        /*//ESCRITURA DE DATOS
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
    salidadatos.close();*/
    
     //LECTURA DE DATOS
    FileInputStream entrada = new FileInputStream (f);
    DataInputStream entradadatos= new DataInputStream (entrada);
    
    String marca;
    int lanzamiento;
    try{
        while(true){
            marca = entradadatos.readUTF();
            lanzamiento = entradadatos.readInt();
            System.out.println("Marca: " + marca + ".Lanzamiento: " + lanzamiento);
        }
       }catch(EOFException e){
        entradadatos.close();
    }
    

        
    }
    
}
