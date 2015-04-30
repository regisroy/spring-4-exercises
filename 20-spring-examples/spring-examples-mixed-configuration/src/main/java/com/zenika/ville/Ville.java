package com.zenika.ville;

public class Ville implements Comparable<Ville> {

    public static final String CERGY = "Cergy";
    public static final String PARIS = "Paris";
    public static final String VERSAILLES = "Versailles";
    public static final String SAINT_DENIS = "Saint-Denis";
    public static final String BOBINY = "Bobiny";
    public static final String GRENOBLE = "Grenoble";
    public static final String BOURG_EN_BRESSE = "Bourg-en-Bresse";

    private String nom;

    public Ville() {
    }

    public Ville(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int compareTo(Ville o) {
        return this.nom.compareTo(o.nom);
    }
}
