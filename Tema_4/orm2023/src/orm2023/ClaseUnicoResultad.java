/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm2023;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author damiansu
 */
public class ClaseUnicoResultad {

    public static void main(String[] args) {

        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        String hql = "select avg(e.salario) from Empleados as e";
        Query cons = session.createQuery(hql);
        
        Double media = (Double) cons.uniqueResult();
        System.out.println("La media de salario es: "+media);
        
        session.close();
        System.exit(0);

    }
}
