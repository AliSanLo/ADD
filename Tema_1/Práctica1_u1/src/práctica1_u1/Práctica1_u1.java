/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package práctica1_u1;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Alicia
 */
public class Práctica1_u1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // 1º CREAMOS UNA VARIABLE PARA EL DIRECTORIO
        String directorio = "C:/Users/Alicia/Desktop/Acceso_a_Datos/fich";
        //2º LLAMAMOS A LA CLASE FILE PARA PODER TRABAJAR CON FICHEROS
        File f = new File(directorio); //Se instancia el directorio y el archivo con el que trabajamos dentr de ee directorio

        //3º array file inicializado con un listado de todas los archivos de ese directorio
        String[] files = f.list();

        if (files != null) {
            for (int x = 0; x < files.length; x++) {
                System.out.println(files[x]);
            }
        } else {
            System.out.println("no existe");
        }
        //4º OTROS METODOS 
        System.out.println(f.getName());
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.canRead());
        System.out.println(f.canWrite());
        System.out.println(f.length());
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
    
    //PARA CREAR UN NUEVO DIRECTORIO
    
        File dir = new File("c:/Users/Alicia/Desktop/Acceso_a_Datos/nuevodirectorio");

        // Para crear ficheros dentro del directorio
        //FORMA A
        File fich1 = new File(dir, "fich1.txt");
        File fich2 = new File(dir, "fich2.txt");

        

        try{
            // Se crea el directorio (si no existe)
            dir.mkdir();
            // Se intenta crear el primer fichero
            if (fich1.createNewFile()) 
                System.out.println("Fichero 1 creado correctamente");
             else {
                System.out.println("Fichero 1 no se ha podido crear");
            }

            // Se intenta crear el segundo fichero
            if (fich2.createNewFile()) 
                System.out.println("Fichero 2 creado correctamente");
             else 
                System.out.println("Fichero 2 no se ha podido crear");
            //
            File fich3 = new File ("C:\\Users\\Alicia\\Desktop\\Acceso_a_Datos\\fich\\fich3.txt");
            fich3.createNewFile();
            File fich4 = new File ("C:\\Users\\Alicia\\Desktop\\Acceso_a_Datos\\fich\\fich4.txt");
            fich4.createNewFile();
            
        } catch (IOException e) {
            // Se imprime la traza de la pila si ocurre una excepción de E/S
            e.printStackTrace();
        }
    }
}


