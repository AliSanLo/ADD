/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.bbddxml3;

import java.lang.reflect.InvocationTargetException;
import org.xmldb.api.base.*;
import org.xmldb.api.*;
import org.xmldb.api.modules.*;
//import org.exist.Database;

/**
 *
 * @author damiansualdea
 */
public class BBDDXML3 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, XMLDBException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        String driver = "org.exist.xmldb.DatabaseImpl";
        Class cl = Class.forName(driver);
        System.out.println("Correcto");

        Database database = (Database) cl.getDeclaredConstructor().newInstance();
        //database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);
        System.out.println("Correcto");
        //Colección
        String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/UAX-EJEMPLOS";
        String usu = "admin";
        String pass = "";
        Collection col = (Collection) DatabaseManager.getCollection(URI, usu, pass);
        System.out.println("COrrecto");

        if (col == null) {
            System.out.println("La colección no existe");
        }

        XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");

        //ResourceSet result = servicio.query("/*/*");
        //ResourceSet result = servicio.query("/universidad/departamento/codigo[.='IFC1']/../empleado/nombre/text()");
        ///universidad/departamento[@telefono=990034]/empleado/salario/text()
        ResourceSet result = servicio.query("/universidad/departamento[@telefono=990034]/empleado");

        System.out.println("Correcto");

        //Recorremos
        ResourceIterator i;
        i = result.getIterator();
        Double nominas = 0.0;
        if (!i.hasMoreResources()) {
            System.out.println("La consulta no devuelve nada");
        } else {
            while (i.hasMoreResources()) {
                Resource r = i.nextResource();
                //String s = r.getContent().toString();
                //Ojo al parseo Integer.valueOf()
               // Double salario = Double.parseDouble(s);
                //nominas += salario;
                //System.out.println(s);
                System.out.println(r.getContent());
            }
        }
        //System.out.println("Nominas del departamento: " + nominas);

    }
}
