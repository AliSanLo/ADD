/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2_u1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
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
    public static void main(String[] args) throws IOException {

        //declaramos el fichero
        File f = new File("C:\\Users\\Alicia\\Desktop\\Acceso_a_Datos\\fich\\prueba.txt");

        //FLUJO DE SALIDA:
        FileWriter fiche = new FileWriter(f);
        String t = "Esto sera el texto introducido e el archivo";
        //lo debemos almacenar como un array de caracteres
        char[] cad = t.toCharArray();
        //recorremos la cadena 
        for (int x = 0; x < cad.length; x++) {
            fiche.write(cad[x]); // se copia caracter a caracter 
            //fiche.append('-');

        }
        fiche.close();

                    //se me sobreescribe a lo que ya hay escrito
        //FLUJO DE ENTRADA: 
        //inicializamos la clase FileReader y declaramos entre parentesis el archivo que queremos leer
        FileReader fich = new FileReader(f);
        //lectura del fichero
        int i; //caracteres 
        //el metodo read() lee caracter a caracter. Cuenta hasta que le quedan 0 caracteres por leer
        //lanza un -1 cuando no hay mas que leer
        while ((i = fich.read()) != -1) {
            System.out.print((char) i); //casteamos siempre
        }
        fich.close();

        try {
            BufferedReader fichero = new BufferedReader(new FileReader("C:\\Users\\Alicia\\Desktop\\Acceso_a_Datos\\fich\\prueba.txt"));
            BufferedWriter ficherow = new BufferedWriter(new FileWriter("C:\\Users\\Alicia\\Desktop\\Acceso_a_Datos\\fich\\prueba.txt"));
            
            //imprimimos 5 lineas y un salto de linea
            for (int j = 0; i < 6; i++) {
                
                ficherow.write("Fila: " + t);
                ficherow.newLine();
            }
            ficherow.close();

            
            //Imprimimos linea a linea
            //readLine da null cuando no hay nada mas que imprimir
            String s;
            while ((s = fichero.readLine()) != null) {
                System.out.println(s);
            }
            fichero.close();
        } catch (FileNotFoundException fn) {
            System.out.print("fichero no encontrado");
        } catch (IOException e) {
            System.out.print("Error de entrada/salida");

        }
    }

}
