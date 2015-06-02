package com.zenika.ville;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class VilleInMemoryRepository implements VilleRepository {

    private Set<Ville> villes;

    public VilleInMemoryRepository(Set<Ville> villes) {
        this.villes = villes;
    }

    public VilleInMemoryRepository(Ville... villes) {
        this.villes = new HashSet<Ville>();
        Collections.addAll(this.villes, villes);
    }

    public Set<Ville> getVilles() {
        return villes;
    }
}
