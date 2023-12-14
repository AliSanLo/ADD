/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm2023;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author damiansu
 */
public class Borrado {
    public static void main(String[] args) {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        
        String hqlActualizacion = "delete Empleados where emp_no = 6677";
        Query q = session.createQuery(hqlActualizacion);
        
        int filas = q.executeUpdate();
        System.out.println("Me he cargado "+filas+" empleados");
        tx.commit();
    }
 
}
