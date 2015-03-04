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
import javax.persistence.Table;

/**
 *
 * @author Emile
 */
@Entity
@Table(name="client"
    ,catalog="stockmanaging"
)
public class Client extends Business{

    private int idClient;
    private String name;
    private String surname;
    private String mail;
    private String password;

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idClient", unique=true, nullable=false)
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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

    
        public Client() {
    }

    public Client(int idClient) {
        this.idClient = idClient;
    }

    public Client(int idClient, String name, String surname, String mail, String password) {
        this.idClient = idClient;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
    }

    public Client(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" + "name=" + name + ", surname=" + surname + '}';
    }
    
    
    
}
