/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm2023;

import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author damiansu
 */
public class ClaseNoAsociadaOtrosResultados {

    public static void main(String[] args) {

        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        String hql = "select avg(e.salario),count(e.apellido),sum(e.salario) from Empleados as e";
        Query cons = session.createQuery(hql);
        Iterator q = cons.iterate();

        while (q.hasNext()) {
            Object[] par = (Object[]) q.next();
            Double mediaSalario = (Double) par[0];
            Long numEmpleados = (Long) par[1];
            Double sumaSalario = (Double) par[2];
            System.out.println(mediaSalario + " " + numEmpleados + " " + sumaSalario);
        }
        
        session.close();
        System.exit(0);

    }
}
