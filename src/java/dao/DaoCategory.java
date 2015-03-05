/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.ArrayList;
import java.util.List;
import model.Category;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Emile
 */
public class DaoCategory extends DaoGeneric<Category>{
    
            @Override
        public List<Category> selectAll()
        {
        Session _session = launchSession();
        List<Category> cats = new ArrayList<>();
        Query query = _session.createQuery("from Category");
        cats = query.list();
        killSession();
        return cats;
    
        }
    
}
