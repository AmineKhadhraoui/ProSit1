package tn.tuniprod.gestiondesemployés;

public class Vendeur extends Employé {
    private double tauxDeVente;

    public Vendeur(int id, String nom, String adresse, int nbr_heures, double tauxDeVente) {
        super(id, nom, adresse, nbr_heures);
        this.tauxDeVente = tauxDeVente;
    }

    public double getTauxDeVente() {
        return tauxDeVente;
    }

    @Override
    public String toString() {
        return super.toString() + ", Taux de vente: " + tauxDeVente;
    }
    @Override
    public double calculerSalaire() {
        return 450 * tauxDeVente;
    }
}
