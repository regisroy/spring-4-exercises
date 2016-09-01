package fr.enedis;

public class LaPosteFrancaise {



//    private CentreDeDistribution centreDeDistribution;
//
//    public LaPosteFrancaise(CentreDeDistribution centreDeDistribution) {
//        this.centreDeDistribution = centreDeDistribution;
//    }

    public boolean envoyerCourrier(Colis... colis) {
        CentreDeDistribution centreDeDistribution = new CentreDeDistribution();
        return centreDeDistribution.envoyer(colis);
    }
}
