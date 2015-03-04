/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Emile
 */
@Entity
@Table(name="command"
    ,catalog="stockmanaging"
)
public class Command implements Serializable{
 
    private int idCommand;
    private Client client;
     private Date dateCde;
     private String cmdState;
     private float total;
     private Collection<CommandLine> commandLineSet;

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idCommand", unique=true, nullable=false)
     public int getIdCommand() {
        return idCommand;
    }

    public void setIdCommand(int idCommand) {
        this.idCommand = idCommand;
    }



    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDateCde() {
        return dateCde;
    }

    public void setDateCde(Date dateCde) {
        this.dateCde = dateCde;
    }

    public String getState() {
        return cmdState;
    }

    public void setState(String cmdState) {
        this.cmdState = cmdState;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="command")
    public Collection<CommandLine> getCommandLineSet() {
        return commandLineSet;
    }

    public void setCommandLineSet(Collection<CommandLine> commandLineSet) {
        this.commandLineSet = commandLineSet;
    }

    public Command(Client client, Date dateCde, String cmdState, float total) {
        this.client = client;
        this.dateCde = dateCde;
        this.cmdState = cmdState;
        this.total = total;
    }

    public Command() {
    }

    public Command(Client client, Date dateCde, float total) {
        this.client = client;
        this.dateCde = dateCde;
        this.total = total;
    }

    public Command(Client client, Date dateCde, String cmdState, float total,Set commandLineSet) {
        this.client = client;
        this.dateCde = dateCde;
        this.cmdState = cmdState;
        this.total = total;
        this.commandLineSet = commandLineSet;
    }
    

    @Override
    public String toString() {
        return "Command{" + "client=" + client + ", dateCde=" + dateCde + ", cmdState=" + cmdState + ", total=" + total + '}';
    }
     
     
    
}
