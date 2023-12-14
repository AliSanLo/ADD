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
public class ClaseNoAsociada {

    public static void main(String[] args) {

        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        String hql = "from Empleados e, Departamentos d where "
                + "e.departamentos.deptNo = d.deptNo order by Apellido";
        Query cons = session.createQuery(hql);
        Iterator q = cons.iterate();
        while (q.hasNext()) {
            Object[] par = (Object[]) q.next();
            Empleados em = (Empleados) par[0];
            Departamentos de = (Departamentos) par[1];
            System.out.println(em.getApellido() + ", " + de.getLoc());
        }
        session.close();
        System.exit(0);

    }
}
