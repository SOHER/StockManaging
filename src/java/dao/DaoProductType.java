/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.ProductType;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Emile
 */
public class DaoProductType extends DaoGeneric<ProductType>{
    
            @Override
        public List<ProductType> selectAll()
        {
        Session _session = launchSession();
        List<ProductType> types = new ArrayList<>();
        Query query = _session.createQuery("from ProductType");
        types = query.list();
        killSession();
        return types;
    
        }
    
}
