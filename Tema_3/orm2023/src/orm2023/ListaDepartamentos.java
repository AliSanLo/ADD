/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm2023;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author damiansu
 */
public class ListaDepartamentos {

    public static void main(String[] args) {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        
        //Consulta Departamentos
        Query q = session.createQuery("from Departamentos");
        List <Departamentos> lista = q.list();
        
        Iterator <Departamentos> iter = lista.iterator();
        System.out.println("Número de departamentos: "+lista.size());
        
        while(iter.hasNext()){
            Departamentos depar = iter.next();
            System.out.println(depar.getDeptNo()+" "+depar.getDnombre()+" "+depar.getLoc());
        }
        
        //Consulta Empleados
        System.out.println("Lista de empleados");
        Query qe = session.createQuery("from Empleados");
       
        //qe.setFetchSize(2);
        Iterator iterEmpleados = qe.iterate();
        //System.out.println("Número de empleados: "+iterEmpleados.);
        while(iterEmpleados.hasNext()){
            Empleados emp = (Empleados) iterEmpleados.next();
            //System.out.println(emp.getApellido()+" "+emp.getSalario());
        }
        
        session.close();
        System.exit(0);
  
    }
}
