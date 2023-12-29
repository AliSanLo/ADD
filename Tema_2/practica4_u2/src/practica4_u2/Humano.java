/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4_u2;

import java.io.Serializable;

/**
 *
 * @author Alicia
 */
public class Humano implements Serializable {

    private  int edad = 24;
    private String nombre = "Ali";
    

    public Humano (String nombre, int edad){
        this.nombre = nombre;
        this.edad= edad;
    }
    public Humano(String nombre){
        this.nombre = nombre;
    }
     public Humano(int edad){
        this.edad = edad;
    }
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

}
