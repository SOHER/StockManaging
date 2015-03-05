/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Emile
 */
@Entity
@PrimaryKeyJoinColumn(name="idProduct")
public class Socket extends Product{
    
        
    private String productSize;
    private String color;


    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Socket() {
    }



    public Socket(String label,float price, Supplier supplier, String productSize, String color) {
        super(label, price, supplier);
        this.productSize = productSize;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Socket{" + "productSize=" + productSize + ", color=" + color + '}';
    }
    
}
