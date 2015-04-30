package com.zenika;

public class RepositoryLazy implements Repository {

	private StringBuilder recorder;

	public RepositoryLazy(StringBuilder recorder) {
		this.recorder = recorder;
		recorder.append("Constructeur RepositoryLazy()\n");
	}

	@Override
	public void display() {
		recorder.append("RepositoryLazy.display()\n");
	}
}
