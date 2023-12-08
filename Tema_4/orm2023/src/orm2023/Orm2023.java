/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm2023;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransientPropertyValueException;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author damiansu
 */
public class Orm2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();

        /*System.out.println("Inserta una fila");
         Departamentos dep = new Departamentos();
         dep.setDeptNo((byte) 62);
         dep.setDnombre("RRHH");
         dep.setLoc("Sevilla");
         session.save(dep);
         */
        System.out.println("Insertar un empleado");
        Empleados em = new Empleados();
        em.setEmpNo((short) 6677);
        em.setApellido("Kenva Walker");
        em.setDir((short) 7499);
        em.setOficio("NBA player");
        em.setSalario((float) 2000);
        em.setComision((float) 10);

        Departamentos d = new Departamentos();
        d.setDeptNo((byte) 10);
        em.setDepartamentos(d);

        try {
            session.save(em);//Super importante
            try{
                tx.commit();
            }catch(ConstraintViolationException e){
                System.out.println("Empleado duplicado");
                System.out.println("Error SQL: "+e.getSQL());
            }
        } catch (TransientPropertyValueException e) {
            System.out.println("Departamento no existe");
            System.out.println("Mensaje: " + e.getMessage());
        }

        
        session.close();
        System.exit(0);
    }

}
