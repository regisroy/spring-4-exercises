package fr.enedis;

import java.util.ArrayList;
import java.util.List;

public class Camion {
    private List<Colis> colis = new ArrayList<>();

    public void ajouter(Colis... colis) {
        for (Colis coli : colis) {
            this.colis.add(coli);
        }
    }

    public boolean transporter() {
        return true;
    }
}
