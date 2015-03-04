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
@Table(name="employee"
    ,catalog="stockmanaging"
)
public class Employee extends Business{
    
    private int idEmployee;
    private String name;
    private String surname;
    private String mail;
    private String password;

        @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idEmployee", unique=true, nullable=false)
    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
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

    public Employee() {
    }

    public Employee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Employee(int idEmployee, String name, String surname, String mail, String password) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
    }

    public Employee(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", surname=" + surname + '}';
    }

    
}
