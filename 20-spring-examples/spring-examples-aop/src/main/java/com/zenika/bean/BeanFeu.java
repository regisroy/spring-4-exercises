package com.zenika.bean;

public class BeanFeu {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BeanFeu{" +
                "description='" + description + '\'' +
                '}';
    }
}
