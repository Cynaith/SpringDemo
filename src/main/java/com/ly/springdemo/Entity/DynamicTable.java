package com.ly.springdemo.Entity;


import java.io.Serializable;

public class DynamicTable implements Serializable {

    private static final long serialVersionUID = -3311641339907293333L;
    int id;
    String key1;
    String key2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }
}
