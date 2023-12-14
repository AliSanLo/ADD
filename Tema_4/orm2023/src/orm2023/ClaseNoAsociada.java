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
//SE USA CUANDO SABES QEU VA A DAR UN UNICO RESULTADO?
    public static void main(String[] args) {

        SessionFactory sesion = HibernateUtil.getSessionFactory(); //copia y pega hasta la linea 27
        Session session = sesion.openSession();
        String hql = "from Empleados e, Departamentos d where " //añade esta query
                + "e.departamentos.deptNo = d.deptNo order by Apellido"; //cuando usa las mayusculas, se refiere a la clase, ej.: Empleados o Departamentos
        //departamentos en minuscula porque Departamento es una clase hija de empleado, y está como variable "departamento" en esa clase.
        //deptNo también es una variable
        //Aunqeu apellido no es una clase va en mayuscula?
        Query cons = session.createQuery(hql);
        Iterator q = cons.iterate();
        while (q.hasNext()) {
            Object[] par = (Object[]) q.next();
            Empleados em = (Empleados) par[0];//se castea empleados
            Departamentos de = (Departamentos) par[1]; //se castea Departamentos 
            System.out.println(em.getApellido() + ", " + de.getLoc());
        }
        session.close();
        System.exit(0);

    }
}
