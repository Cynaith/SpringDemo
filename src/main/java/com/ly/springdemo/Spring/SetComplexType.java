package com.ly.springdemo.Spring;

import java.util.*;

public class SetComplexType {
    public SetComplexType() {
    }

    int arr[];
    List<String> list;
    Map<String,String> map;
    Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "SetComplexType{" +
                "arr=" + Arrays.toString(arr) +
                ", list=" + list +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
