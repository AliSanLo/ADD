/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm2023;

import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author damiansu
 */
public class PreparadasEmpleado {

    public static void main(String[] args) {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        
        Query q = session.createQuery("from Empleados where empNo= :numemple");
        
        System.out.println("Introduce el número de empleado que quieres ver: ");
        Scanner teclado = new Scanner(System.in);
        short n = teclado.nextShort();
        
        q.setParameter("numemple", n);
        Empleados emple = (Empleados) q.uniqueResult();
        
        System.out.println(emple.getApellido()+" "+emple.getOficio());
        
        session.close();
        System.exit(0);
    }
}
