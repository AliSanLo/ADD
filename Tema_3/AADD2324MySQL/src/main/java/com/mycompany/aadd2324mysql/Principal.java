/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.aadd2324mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damiansualdea
 */
public class Principal {

    public static void main(String[] args) throws SQLException {

        String cadenaConexion = "jdbc:mysql://localhost:3306/alumnos1";
        //Sentencias preparadas
        Connection conexion = DriverManager.getConnection(cadenaConexion, "root", "");

        //Hacer la sentencia en SQL y luego lanzarla
        String sqlP = "INSERT INTO `uax` (id, nombre, apellidos) "
                + " VALUES (?, ?, ?)"; //Posiciones
        String sqlP2 = "DELETE FROM uax WHERE uax.id = ?"; //Posiciones
        String sqlP3 = "SELECT * FROM uax WHERE uax.nombre=?;";

        //Lo voy cambiando por INSERT, UPDATE O DELETE, SELECT
        PreparedStatement sentenciaP = conexion.prepareStatement(sqlP3);

        Scanner teclado = new Scanner(System.in);

        //Recogida de datos del Select
        System.out.println("Dame el nombre: ");
        String nombre = teclado.next();

        //Asociar a posiciones los valores recogigos del Select
        sentenciaP.setString(1, nombre);
        
        ResultSet salidaSelect = sentenciaP.executeQuery();
        
        System.out.println("Salida de la consulta...");
        while(salidaSelect.next()){
            int idTabla = salidaSelect.getInt(1);
            String nombreTabla = salidaSelect.getString(2);
            String apellidoTabla = salidaSelect.getString(3);
            System.out.println("id: "+idTabla+" Nombre: "+nombreTabla+" Apellido: "+apellidoTabla);
            
        }
        System.out.println("Fiiiin");

        /*
        //Recogida de datos del Insert

        System.out.println("Dame el id: ");
        int id = teclado.nextInt();
        System.out.println("Dame el nombre: ");
        String nombre = teclado.next();
        System.out.println("Dame el apellido: ");
        String apellido = teclado.next();
        System.out.println(id + " " + nombre + " " + apellido);
         */
 /* //Recogida de datos del delete
        System.out.println("Dame el id: ");
        String id = teclado.next();
       
        
        //Asociar a posiciones los valores recogigos del Insert
        sentenciaP.setInt(1, id);
        sentenciaP.setString(2, nombre);
        sentenciaP.setString(3, apellido);
        /*
        //Asociar a posiciones los valores recogigos del Delete
        sentenciaP.setString(1, id);
         */
 /*
        //Ejecutar la sentencia preparada
        sentenciaP.executeUpdate();
        System.out.println("Datos insertados correctamente");
*/
        /*
String sqlSelect = "SELECT * FROM coches WHERE tipo_motor=? AND anio_lanzamiento=?;";
      PreparedStatement select = conexion.prepareStatement(sqlSelect);        
         */
 /* Sentencias Statement... puras
        //try with resources
        try ( Connection conexion = DriverManager.getConnection(cadenaConexion, "root", "");  Statement sql = conexion.createStatement();) {

            System.out.println("Conexión correcta");

           
            // sql.execute("create database alumnos1");
            //System.out.println("BBDD alumnos1 creada...");
            //sql.execute("CREATE TABLE `alumnos1`.`uax` (`id` INT NOT NULL , `nombre` VARCHAR(255) NOT NULL , `apellidos` VARCHAR(255) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;");
            //System.out.println("Tabla uax creada correctamente");  
            // sql.executeUpdate("INSERT INTO `uax` (`id`, `nombre`, `apellidos`) VALUES ('1', 'Mark', 'Guiu');");//Insert
            //sql.executeUpdate("INSERT INTO `uax` (`id`, `nombre`, `apellidos`) VALUES ('2', 'Fernando', 'Alonso');");//Insert
            //  sql.executeUpdate("DELETE FROM uax WHERE `uax`.`id` = 1");//delete
            //System.out.println("Alumno borrado");
            // sql.executeUpdate("UPDATE `uax` SET `apellidos` = 'Alonso 33' WHERE `uax`.`id` = 2");//update
            //System.out.println("Alumno actualizado");
            ResultSet rs = sql.executeQuery("select * from uax");
            System.out.println("Lo tengo recogido en un ResultSet");
            int contador = 0;
            while (rs.next()) {
                contador++;
                int id = rs.getInt("id");
                String nombre = rs.getString(2);
                String apellidos = rs.getString("apellidos");
                System.out.println(id + " " + nombre + " " + apellidos);
            }
            System.out.println("Hay " + contador + " registros");

        } catch (SQLException ex) {
            System.out.println("Conexión fallida");
            ex.printStackTrace();

        }
         */
    }
}
