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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Emile
 */
@Entity
@Table(name="product"
    ,catalog="stockmanaging"
)
@Inheritance(strategy=InheritanceType.JOINED)
public class Product extends Business implements Serializable{
    
    private int idProduct;
    private String label;
    private float price;
    private Supplier supplier;
    Collection<Category> categorySet;
    Collection<CommandLine> commandLineSet;
//    private Set commandLineSet = new HashSet(0);
    

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idProduct", unique=true, nullable=false)
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idSupplier")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }


    @ManyToMany(mappedBy="productSet")
    public Collection<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Collection<Category> categorySet) {
        this.categorySet = categorySet;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="product")
    public Collection<CommandLine> getCommandLineSet() {
        return commandLineSet;
    }

    public void setCommandLineSet(Collection<CommandLine> commandLineSet) {
        this.commandLineSet = commandLineSet;
    }


    

    public Product() {
    }

    public Product(int idProduct) {
        this.idProduct = idProduct;
    }


    public Product(int idProduct, String label, float price, Supplier supplier, Set categorySet, Set commandLineSet) {
        this.idProduct = idProduct;
        this.label = label;
        this.price = price;
        this.supplier = supplier;
        this.categorySet = categorySet;
        this.commandLineSet  = commandLineSet;
        
        
    }

    public Product(int idProduct, String label, float price, Supplier supplier) {
        this.idProduct = idProduct;
        this.label = label;
        this.price = price;
        this.supplier = supplier;
    }

    public Product(String label, float price, Supplier supplier) {
        this.label = label;
        this.price = price;
        this.supplier = supplier;
    }

    public Product(String label, float price, Supplier supplier,Set categorySet) {
        this.label = label;
        this.price = price;
        this.supplier = supplier;
        this.categorySet = categorySet;
    }
    
    
    
    @Override
    public String toString() {
        return "Product{" + "label=" + label + ", price=" + price + ", supplier=" + supplier + '}';
    }
    
    
}
