/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Emile
 */
@Entity
@Table(name="commandline"
    ,catalog="stockmanaging"
)
public class CommandLine implements Serializable{
    
     private int idCommandLine;
     private Command command;
     private Product product;
     private Float amount;

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idCommandLine", unique=true, nullable=false)
    public int getIdCommandLine() {
        return idCommandLine;
    }

    public void setIdCommandLine(int idCommandLine) {
        this.idCommandLine = idCommandLine;
    }
    
    @OneToOne
    @JoinColumn(name="Command")
    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @OneToOne
    @JoinColumn(name="Product")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public CommandLine() {
    }

    public CommandLine(int idCommandLine) {
        this.idCommandLine = idCommandLine;
    }

    public CommandLine(int idCommandLine, Command command, Product product, Float amount) {
        this.idCommandLine = idCommandLine;
        this.command = command;
        this.product = product;
        this.amount = amount;
    }

    public CommandLine(Command command, Product product, Float amount) {
        this.command = command;
        this.product = product;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CommandLine{" + "command=" + command + ", product=" + product + '}';
    }
      
    
}
