/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Alicia
 */
public class Principal {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File f = new File("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\practica5_u2\\prueba.dat");
        RandomAccessFile file = new RandomAccessFile(f, "r");
        int id, depa, posicion;
        Double salarios;
        char apellidos[] = new char[10], aux;
        posicion = 0;
        for (;;) {
            file.seek(posicion);
            id = file.readInt();

            for (int i = 0; i < apellidos.length; i++) {
                aux = file.readChar();
                apellidos[i] = aux;
            }
            String apellidoX = new String(apellidos).trim();
            depa = file.readInt();
            salarios = file.readDouble();
            System.out.println("Identificador: " + id + ", Apellido: " + apellidoX + ", Departamento: " + depa + ", Salario: " + salarios);

            posicion = posicion + 36;
            if (file.getFilePointer() == file.length()) {
                break;
            }
        }

        file.close();
    }

}

