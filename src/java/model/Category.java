/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Emile
 */
@Entity
@Table(name="category"
    ,catalog="stockmanaging"
)
public class Category extends Business{
    
    private int idCategory;
    private String label;
    private Collection<Product> productSet;

        
    @Id 
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="idCategory", unique=true, nullable=false)
    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }



    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @ManyToMany
    @JoinTable(name="ProductCategory",
    joinColumns=
    @JoinColumn(name="idCategory",referencedColumnName="idCategory"),
    inverseJoinColumns=
    @JoinColumn(name="idProduct",
    referencedColumnName="idProduct"))
    public Collection<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Collection<Product> ProductSet) {
        this.productSet = ProductSet;
    }

    public Category() {
    }

    public Category(int idCategory) {
        this.idCategory = idCategory;
    }

    public Category(int idCategory, String label,Set productSet) {
        this.idCategory = idCategory;
        this.label = label;
        this.productSet = productSet;
    }

    public Category(int idCategory, String label) {
        this.idCategory = idCategory;
        this.label = label;
    }
    

    @Override
    public String toString() {
        return "Category{" + "label=" + label + '}';
    }
    
    
    
}
