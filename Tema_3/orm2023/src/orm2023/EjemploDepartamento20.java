/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm2023;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author damiansu
 */
public class EjemploDepartamento20 {

    public static void main(String[] args) {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();

        //Apellido y salario de los empleados del departamento 20
        Query q = session.createQuery("from Empleados");
        List<Empleados> listaEmpleados = q.list();
        Iterator<Empleados> iterador = listaEmpleados.iterator();

        while (iterador.hasNext()) {
            Empleados emp = iterador.next();
            Departamentos dep = emp.getDepartamentos();
            if (dep.getLoc().equalsIgnoreCase("BARCELONA")) {
                System.out.println(emp.getApellido() + " " + emp.getSalario());
            }
        }
        System.out.println("Otro...");
        //Otra forma... objetos los metemos en la sentencia HQL
        Query q2 = session.createQuery("from Empleados as e where e.departamentos.loc='BARCELONA'");
        
        listaEmpleados = q2.list();
        
        iterador = listaEmpleados.iterator();

        while (iterador.hasNext()) {
            Empleados emp = iterador.next();
            System.out.println(emp.getApellido() + " " + emp.getSalario());
        }

        session.close();
        System.exit(0);
    }
}
