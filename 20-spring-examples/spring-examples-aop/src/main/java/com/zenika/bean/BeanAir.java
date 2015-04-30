package com.zenika.bean;

public class BeanAir {

    private String name;
    private int number;

    public BeanAir setNameAndNumber(String name, int number) {
        this.name = name;
        this.number = number;
        
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String multiply(int multiplicator) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < multiplicator; i++) {
            stringBuilder.append(i).append(" - Name[").append(name).append("] Number[").append(number).append("]\n");
        }
        
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "BeanAir{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
