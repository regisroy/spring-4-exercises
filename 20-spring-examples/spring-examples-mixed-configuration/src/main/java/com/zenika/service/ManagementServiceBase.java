package com.zenika.service;

import com.zenika.departement.Departement;
import com.zenika.pays.Pays;
import com.zenika.pays.PaysRepository;
import com.zenika.region.Region;
import com.zenika.ville.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("managementService")
public class ManagementServiceBase implements ManagementService {

    @Autowired
    private PaysRepository paysRepository;

    @Override
    public String doService() {
        List<Pays> payses = paysRepository.findAll();

        StringBuilder stringBuilder = new StringBuilder();
        for (Pays pays : payses) {
            stringBuilder.append("pays = ").append(pays.getNom()).append("\n");

            List<Region> regions = pays.getRegions();
            for (Region region : regions) {
                stringBuilder.append("   region = ").append(region.getNom()).append("\n");

                List<Departement> departements = region.getDepartements();
                for (Departement departement : departements) {
                    stringBuilder.append("      departement = ").append(departement.getNom()).append(" - prefecture:").append(departement.getPrefecture().getNom()).append("\n");

                    List<Ville> villes = departement.getVilles();
                    for (Ville ville : villes) {
                        stringBuilder.append("         ville = ").append(ville.getNom()).append("\n");
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
