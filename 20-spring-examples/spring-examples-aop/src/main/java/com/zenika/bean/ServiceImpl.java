package com.zenika.bean;

public class ServiceImpl implements Service {

    private String element;

    @Override
	public void setElement(String element) {
        this.element = element;
    }

    @Override
	public String getElement() {
        return element;
    }

    @Override
    public String toString() {
        return "ServiceImpl{" +
                "element='" + element + "\'" +
                "}";
    }
}
