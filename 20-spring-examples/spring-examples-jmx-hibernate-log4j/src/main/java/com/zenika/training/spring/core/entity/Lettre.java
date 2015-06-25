package com.zenika.training.spring.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lettre {

    @Id
    private Long id;


    @Column
    private String adresse1;
    @Column
    private String adresse2;
    @Column
    private String adresse3;
    @Column
    private String codePostal;
    @Column
    private String ville;

    public Lettre() {
    }

    public Lettre(Long id, String adresse1, String adresse2, String adresse3, String codePostal, String ville) {
        this.id = id;
        this.adresse1 = adresse1;
        this.adresse2 = adresse2;
        this.adresse3 = adresse3;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public Long getId() {
        return id;
    }

    public String getAdresse1() {
        return adresse1;
    }

    public String getAdresse2() {
        return adresse2;
    }

    public String getAdresse3() {
        return adresse3;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    @Override
    public String toString() {
        return "Lettre{" +
                "id=" + id +
                ", adresse1='" + adresse1 + '\'' +
                ", adresse2='" + adresse2 + '\'' +
                ", adresse3='" + adresse3 + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
