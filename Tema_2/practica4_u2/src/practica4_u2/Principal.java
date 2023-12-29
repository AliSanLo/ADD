/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4_u2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Alicia
 */
public class Principal extends Humano {

    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\practica4_u2\\humanos.dat");
        FileOutputStream entrada = new FileOutputStream(f);
        ObjectOutputStream entradaobjeto = new ObjectOutputStream(entrada);
 try{
  try (ObjectOutputStream salidaObjeto = new ObjectOutputStream(new FileOutputStream(f))) {
            // Crear instancias de la clase Humano y escribir en el archivo
            Humano humano1 = new Humano("Sara", 19);
            Humano humano2 = new Humano("Alex", 24);
            Humano humano3 = new Humano("Rafa", 20);

            salidaObjeto.writeObject(humano1);
            salidaObjeto.writeObject(humano2);
            salidaObjeto.writeObject(humano3);    }
        } catch (IOException e) {
            e.printStackTrace();
        }
 FileInputStream salida = new FileInputStream(f);
ObjectInputStream salidaobjeto = new ObjectInputStream(salida);

        // Leer datos desde el archivo e imprimir por pantalla
        try (ObjectInputStream entradaObjeto = new ObjectInputStream(new FileInputStream(f))) {
            while (true) {
                Humano humanoLeido = (Humano) entradaObjeto.readObject();
                // se castea como clase humano porque si no devuelve un tipo Objeto
                System.out.println("Nombre: " + humanoLeido.getNombre() + ", Edad: " + humanoLeido.getEdad());
            }
        } catch (EOFException e) {
            // Se alcanzó el final del archivo, no es un error
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
