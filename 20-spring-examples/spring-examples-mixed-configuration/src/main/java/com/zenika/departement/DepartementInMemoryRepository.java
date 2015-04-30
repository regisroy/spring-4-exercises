package com.zenika.departement;

public class DepartementInMemoryRepository implements DepartementRepository {

    @SuppressWarnings("unused")
	private Departement[] departements;

    public DepartementInMemoryRepository(Departement... departements) {
        this.departements = departements;
    }
}
