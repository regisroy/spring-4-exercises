package com.zenika.departement;

import com.zenika.ville.Ville;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Departement implements Comparable<Departement> {
    public static final String SEINE_SAINT_DENIS = "Seine Saint-Denis";
    public static final String SEINE_SAINT_DENIS_ID = "93";
    public static final String VAL_D_OISE = "Val d'Oise";
    public static final String VAL_D_OISE_ID = "95";
    public static final String YVELINES = "Yvelines";
    public static final String YVELINES_ID = "78";
    public static final String ISERE = "Isere";
    public static final String ISERE_ID = "38";
    public static final String AIN = "Ain";
    public static final String AIN_ID = "01";
    public static final String SEINE_ID = "75";
    public static final String SEINE = "Seine";

    private String id;
    private String nom;
    private Ville prefecture;
    private final List<Ville> villes;

    public Departement(String id, String nom, Ville prefecture, Ville... villes) {
        this.id = id;
        this.nom = nom;
        this.prefecture = prefecture;
        this.villes = Arrays.asList(villes);
    }


    public String getId() {
        return id;
    }


    public String getNom() {
        return nom;
    }


    public Ville getPrefecture() {
        return prefecture;
    }

    public List<Ville> getVilles() {
        Collections.sort(villes);
        return villes;
    }

    @Override
    public int compareTo(Departement o) {
        return this.nom.compareTo(o.nom);
    }
}
