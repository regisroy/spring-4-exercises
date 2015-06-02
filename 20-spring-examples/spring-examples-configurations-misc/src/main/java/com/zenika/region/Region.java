package com.zenika.region;

import com.zenika.departement.Departement;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Region implements Comparable<Region> {

    public static final String ILE_DE_FRANCE = "Ile de France";
    public static final String RHONES_ALPES = "Rhones-Alpes";
    private String nom;
    private final List<Departement> departements;

    public Region(String nom, Departement... departements) {
        this.nom = nom;
        this.departements = Arrays.asList(departements);
    }

    public List<Departement> getDepartements() {
        Collections.sort(departements);
        return departements;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public int compareTo(Region o) {
        return this.nom.compareTo(o.nom);
    }
}
