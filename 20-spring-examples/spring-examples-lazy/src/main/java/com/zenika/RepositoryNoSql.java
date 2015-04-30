package com.zenika;

public class RepositoryNoSql implements Repository {

	private StringBuilder recorder;

	public RepositoryNoSql(StringBuilder recorder) {
		this.recorder = recorder;
		recorder.append("Constructeur RepositoryNoSql()\n");
	}

	@Override
	public void display() {
		recorder.append("RepositoryNoSql.display()\n");
	}
}
