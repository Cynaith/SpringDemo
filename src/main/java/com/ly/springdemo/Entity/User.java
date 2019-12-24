package com.ly.springdemo.Entity;


import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -1612749521204546642L;
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
