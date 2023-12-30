/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5_u2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Alicia
 */
public class Practica5_u2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File f = new File ("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\practica5_u2\\prueba.dat");
        
        //Acceso a ficheros binarios de forma aleatoria
        RandomAccessFile file = new RandomAccessFile(f, "rw");
        
        //inicializamos arrays
        String  apellido [] = {"Lopez", "Gracía", "Serrano", "Barachina"};
        int dep [] = { 12,12,15,56};
        Double salario [] = {2000.50, 5000.30, 600.2, 10000.9};
        /*os objetos String no pueden modificarse una vez creados),StringBuffer es mutable,
        lo que significa que su contenido puede modificarse después de que el objeto ha sido creado.
        Proporciona métodos como append(), insert(), delete(), y reverse() que permiten realizar 
        operaciones eficientes de concatenación, inserción, eliminación y inversión de cadenas.
        
        El objetivo es ajustar la longitud de la cadena a 10 caracteres, y StringBuffer se utiliza 
        para lograr esto de manera eficiente. La cadena se inicializa con el apellido actual, y 
        luego se ajusta su longitud a 10 caracteres mediante el método setLength(10). Luego, esta 
        cadena modificada se convierte a una cadena regular (String) antes de escribirla en el archiVO*/
        StringBuffer buffer = null; //podría eliminarse sin cambiar el resultado del código.
        int n =  apellido.length; //se está utilizando como un indicador para el número de iteraciones en el bucle for
        

        for(int i =  0;  i < n ; i++){
            file.writeInt(i+1);
            buffer = new StringBuffer (apellido[i]);
            buffer.setLength(10); // se limita el numero de caracteres de cada elemento del array
            file.writeChars(buffer.toString()); //se usa writeChars() y no write() porque el primero
            //lo almacena utilizando una representacion Unicode, y el segundo de bytes
            file.writeInt(dep[i]);
            file.writeDouble (salario[i]);
            }
        file.close();
    }
    
}
