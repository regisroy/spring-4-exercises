package com.zenika.bean;

public class BeanTerre {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BeanTerre{" +
                "name='" + name + '\'' +
                '}';
    }
}
