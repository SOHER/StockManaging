/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import hibernate.HibernateUtil;
import java.util.List;
import model.Client;
import model.Business;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Emile
 * @param <T>
 */
public abstract class DaoGeneric <T extends Business>{
    


    private Session _session;
     private Transaction trx;

    public Session getSession() {
        return _session;
    }

    
    public int insert(Business objet) {
        
        launchSession();
        
        _session.save(objet);
//        System.out.println(_session.byId("38").);
        
        killSession();
        
        return 0;
                
                }

    
    public void delete(Business objet) {
        
        launchSession();
        
        _session.delete(objet);
        
        killSession();
        
        
    }
    
    

    
    public void update(Business objet) {

        launchSession();
        
        _session.saveOrUpdate(objet);
        
        killSession();
    }

    
    public Session launchSession() {
        _session = HibernateUtil.getSession();
        
        trx = _session.beginTransaction();
        
        return _session;
    }
    
    public void killSession()
    {
        _session.close();
        trx.commit();

    }
    
     public Employee connectByLogin(String mail, String mdp) {
        Employee employee =null;
        return employee;
    }
    
    

    public List<T> selectAll()
    {
        return null;

        
    }
    
    
    
}
