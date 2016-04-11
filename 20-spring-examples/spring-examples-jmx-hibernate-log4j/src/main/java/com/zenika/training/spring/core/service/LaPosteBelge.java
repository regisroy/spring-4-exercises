package com.zenika.training.spring.core.service;

import com.zenika.training.spring.core.entity.Lettre;
import com.zenika.training.spring.core.repo.LettreRepository;
import org.apache.log4j.Logger;

public class LaPosteBelge implements LaPosteService {

    private Logger logger = Logger.getLogger(this.getClass());
    private LettreRepository lettreRepository;

    public int dernierNombreDeLettres;

    public int cumulNombreDeLettres;

    public LaPosteBelge(LettreRepository lettreRepository) {
        this.lettreRepository = lettreRepository;
    }

    public void distribuer() {
        Iterable<Lettre> lettres = lettreRepository.findAll();

        dernierNombreDeLettres = 0;
        for (Lettre lettre : lettres) {
            logger.debug("Lettre : adresse 1 + ville -> " + lettre.getAdresse1() + " - " + lettre.getVille());
            dernierNombreDeLettres++;
        }
        cumulNombreDeLettres += dernierNombreDeLettres;

        logger.info(">>>    distribuer en level INFO ..................");
        logger.debug(">>>    distribuer en level DEBUG ____________________");
        logger.warn(">>>    distribuer en level WARNING !!!!!!!!!!!!!!!!!");

        logger.fatal("\n");
    }

    public int getCumulNombreDeLettres() {
        return cumulNombreDeLettres;
    }

    public int getDernierNombreDeLettres() {
        return dernierNombreDeLettres;
    }
}

