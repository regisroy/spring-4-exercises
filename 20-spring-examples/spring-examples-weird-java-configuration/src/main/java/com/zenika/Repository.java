package com.zenika;

@org.springframework.stereotype.Repository
public class Repository {

	@Override
	public String toString() {
		return "Repository{}";
	}

	public Integer get() {
		return Integer.MAX_VALUE;
	}
}
