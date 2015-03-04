/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Emile
 */
@Entity
@Table(name="supplier"
    ,catalog="stockmanaging"
)
public class Supplier extends Business{
    private int idSupplier;
    private String name;
    private String surname;
    private String mail;
    private String password;
    private String Brand;
    private Collection<Product> ProductSet;

    
    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="id_supplier", unique=true, nullable=false)
    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }
    
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="supplier")
    public Collection<Product> getProductSet() {
        return ProductSet;
    }

    public void setProductSet(Collection<Product> ProductSet) {
        this.ProductSet = ProductSet;
    }

    public Supplier() {
    }

    public Supplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public Supplier(int idSupplier, String name, String surname, String mail, String password, String Brand,Set ProductSet) {
        this.idSupplier = idSupplier;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
        this.Brand = Brand;
        this.ProductSet = ProductSet;
    }

    public Supplier(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }



    public Supplier(int idSupplier, String name, String surname, String mail, String password, String Brand) {
        this.idSupplier = idSupplier;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
        this.Brand = Brand;
    }
    
    @Override
    public String toString() {
        return "Supplier{" + "name=" + name + ", surname=" + surname + '}';
    }
    
}
