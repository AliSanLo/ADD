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

        //las aiguietnes 2 lineas son copia y pega
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();

        //Apellido y salario de los empleados del departamento 20
        Query q = session.createQuery("from Empleados"); //COMO QUEREMOS SACAR INFO DE EMPLEADOS, EN LA SIG LNEA SE LLAMA A LA LISTA EMPLEADOS
        List<Empleados> listaEmpleados = q.list();
        Iterator<Empleados> iterador = listaEmpleados.iterator();

        while (iterador.hasNext()) {
            Empleados emp = iterador.next();
            Departamentos dep = emp.getDepartamentos(); //SESACA UN OBJETO DE TIPO DEPARTAMENOS Y PREGUNTARLE POR SU OBJETO
           // if {dep.get.DeptNo()==10}{ //saca los empleados del departamento 10 (aqui se pregunta por su objeto)
            if (dep.getLoc().equalsIgnoreCase("BARCELONA")) {// 
                System.out.println(emp.getApellido() + " " + emp.getSalario());
            }
        }
        System.out.println("Otro...");
        //MIRAR LOS APUNTES, SE PUEDE HACER CON CONSULTAS DE SQL DIRECTAMENTE. PG 37?
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
