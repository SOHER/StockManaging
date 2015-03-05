/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.ArrayList;
import java.util.List;
import model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Emile
 */
public class DaoEmployee extends DaoGeneric<Employee>{
    
         public Employee selectByLogin(String mail, String mdp) {
        Session _session = launchSession();
        Query query = _session.createQuery("from Employee where mail ='" + mail + "' and password='"+ mdp +"'");
        Employee client = (Employee)query.uniqueResult();
        killSession();
        return client;
    }
         
         //autre méthode
         @Override
         public Employee connectByLogin(String mail, String mdp)
         {
        Session _session = launchSession();
        Query query2 = _session.createQuery("from Employee where mail = :email and password = :mdp");
        query2.setString("email", mail);
        query2.setString("mdp", mdp);
        Employee client = (Employee)query2.uniqueResult();
        killSession();
//        //a l'ancienne
//        Query query = _session.createQuery("from Employees where EMail = ? and mdp = ?");
//        query.setString(0, mail);
//        query.setString(1, mdp);
        //ou alors avec autre methode
        //autres méthodes de préparation de requête
        return client;
         }
         
        @Override
        public List<Employee> selectAll()
        {
        Session _session = launchSession();
        Query query = _session.createQuery("from Employee");
        List<Employee> employees = query.list();
        killSession();
        return employees;
        }
        

         @Override
        public Employee selectById(int id)
        {
        Session _session = launchSession();
        Query query2 = _session.createQuery("from Employee where idEmployee = :id");
        query2.setInteger("id", id);
        Employee client = (Employee)query2.uniqueResult();
        killSession();
//        //a l'ancienne
//        Query query = _session.createQuery("from Employees where EMail = ? and mdp = ?");
//        query.setString(0, mail);
//        query.setString(1, mdp);
        //ou alors avec autre methode
        //autres méthodes de préparation de requête
        return client;
        }
    
}
