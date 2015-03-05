/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Emile
 */
@Entity
@Table(name="productType"
    ,catalog="stockmanaging"
)public class ProductType extends Business{
    
    private int idProductType;
    private String label;
    

        @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idProductType", unique=true, nullable=false)
    public int getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(int idProductType) {
        this.idProductType = idProductType;
        
        
        
        
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProductType() {
    }

    public ProductType(int idProductType) {
        this.idProductType = idProductType;
    }

    public ProductType(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "ProductType{" + "label=" + label + '}';
    }

  
    
}
