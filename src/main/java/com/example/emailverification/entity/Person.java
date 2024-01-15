package com.example.emailverification.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String emailId;

    private String password;

    private boolean isEnabled;

    private String uuid;


    public Person(String emailId, String password, boolean isEnabled,String uuid) {
        this.emailId = emailId;
        this.password = password;
        this.isEnabled = isEnabled;
        this.uuid = uuid;
    }

    public Person() {

    }
    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}
