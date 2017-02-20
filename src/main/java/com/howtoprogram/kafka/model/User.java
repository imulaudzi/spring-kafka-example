package com.howtoprogram.kafka.model;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable{


    private UUID id;

    private String name;

    private String surname;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

//    @Override
//    public String toString() {
//
//        return "User{id: " + getId() + ", name: " + getName() + ", surname: " + getSurname() + "}";
//    }
}
