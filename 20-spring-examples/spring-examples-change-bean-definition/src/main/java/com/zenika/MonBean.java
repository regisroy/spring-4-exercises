package com.zenika;

public class MonBean {

	public String reference() {
		return super.toString();
	}

	@Override
	public String toString() {
		return "MonBean cree dynamiquement !!";
	}
}
