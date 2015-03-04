/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import model.Business;

/**
 *
 * @author Emile
 */
public class FactoryDao {
    
     public static DaoGeneric<?> getDAO(Business objet) {

        String className = "dao.Dao" + objet.getClass().getSimpleName();

        Class<?> cl;
        Object o = null;

        try {
            cl = Class.forName(className);
            o = cl.newInstance();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();

        }
        return (DaoGeneric<?>) o;
    }
    public static DaoGeneric<?> getDAO(String classe) {

       
        String className = "dao.Dao"+classe;

        Class<?> cl;
        Object o = null;

        try {
            cl = Class.forName(className);
            o = cl.newInstance();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();

        }
        return (DaoGeneric<?>) o;
    }
    
}
