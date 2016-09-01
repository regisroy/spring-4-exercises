package fr.enedis;

public class CentreDeDistribution {

    public boolean envoyer(Colis... colis) {
        Camion modeDeTransport = new Camion();
        modeDeTransport.ajouter(colis);

        return modeDeTransport.transporter();
    }
}
