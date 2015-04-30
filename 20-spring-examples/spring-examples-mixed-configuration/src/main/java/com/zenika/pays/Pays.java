package com.zenika.pays;

import com.zenika.region.Region;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pays implements Comparable<Pays> {
    public static final String FRANCE = "France";

    private String nom;
    private final List<Region> regions;


    public Pays(String nom, Region... regions) {
        this.nom = nom;
        this.regions = Arrays.asList(regions);
    }

    public String getNom() {
        return nom;
    }


    public List<Region> getRegions() {
        Collections.sort(regions);
        return regions;
    }

    @Override
    public int compareTo(Pays o) {
        return this.nom.compareTo(o.nom);
    }
}
