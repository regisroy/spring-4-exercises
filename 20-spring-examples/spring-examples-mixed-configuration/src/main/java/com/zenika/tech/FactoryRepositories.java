package com.zenika.tech;

import com.zenika.departement.Departement;
import com.zenika.departement.DepartementInMemoryRepository;
import com.zenika.departement.DepartementRepository;
import com.zenika.pays.Pays;
import com.zenika.pays.PaysInMemoryRepository;
import com.zenika.pays.PaysRepository;
import com.zenika.region.Region;
import com.zenika.region.RegionInMemoryRepository;
import com.zenika.region.RegionRepository;
import com.zenika.ville.Ville;
import com.zenika.ville.VilleInMemoryRepository;
import com.zenika.ville.VilleRepository;

public class FactoryRepositories {

    private Pays france;
    private Region[] regions;
    private Departement[] departements;
    private Ville[] villes;

    public FactoryRepositories initializeData() {
        Ville cergy = new Ville(Ville.CERGY);
        Ville paris = new Ville(Ville.PARIS);
        Ville versailles = new Ville(Ville.VERSAILLES);
        Ville saintDenis = new Ville(Ville.SAINT_DENIS);
        Ville bobiny = new Ville(Ville.BOBINY);
        Ville grenoble = new Ville(Ville.GRENOBLE);
        Ville bourgEnGresse = new Ville(Ville.BOURG_EN_BRESSE);
        villes = new Ville[]{cergy, paris, versailles, saintDenis, bobiny, grenoble, bourgEnGresse};

        Departement seine = new Departement(Departement.SEINE_ID, Departement.SEINE, paris, paris);
        Departement seineSaintDenis = new Departement(Departement.SEINE_SAINT_DENIS_ID, Departement.SEINE_SAINT_DENIS, saintDenis, saintDenis, bobiny);
        Departement valDOise = new Departement(Departement.VAL_D_OISE_ID, Departement.VAL_D_OISE, cergy, cergy);
        Departement yvelines = new Departement(Departement.YVELINES_ID, Departement.YVELINES, versailles, versailles);
        Departement isere = new Departement(Departement.ISERE_ID, Departement.ISERE, grenoble, grenoble);
        Departement ain = new Departement(Departement.AIN_ID, Departement.AIN, bourgEnGresse, bourgEnGresse);
        departements = new Departement[]{seine, seineSaintDenis, valDOise, yvelines, isere, ain};

        Region ileDeFrance = new Region(Region.ILE_DE_FRANCE, seine, seineSaintDenis, valDOise, yvelines);
        Region rhonesAlpes = new Region(Region.RHONES_ALPES, ain, isere);
        regions = new Region[]{ileDeFrance, rhonesAlpes};

        france = new Pays(Pays.FRANCE, ileDeFrance, rhonesAlpes);

        return this;
    }

    public DepartementRepository createDepartementRepository() {
        return new DepartementInMemoryRepository(departements);
    }

    public VilleRepository createVilleRepository() {
        return new VilleInMemoryRepository(villes);
    }

    public RegionRepository createRegionRepository() {
        return new RegionInMemoryRepository(regions);
    }

    public PaysRepository createPaysRepository() {
        return new PaysInMemoryRepository(france);
    }

}
