/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Supplier;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Emile
 */
public class DaoSupplier extends DaoGeneric<Supplier>{
    
            @Override
        public List<Supplier> selectAll()
        {
        Session _session = launchSession();
        List<Supplier> sups = new ArrayList<>();
        Query query = _session.createQuery("from Supplier");
        sups = query.list();
        killSession();
        return sups;
    
        }
    
}
