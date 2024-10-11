package tn.tuniprod.gestiondesemployés;

public class Caissier extends Employé {
    private int numeroDeCaisse;

    public Caissier(int id, String nom, String adresse, int nbr_heures, int numeroDeCaisse) {
        super(id, nom, adresse, nbr_heures);
        this.numeroDeCaisse = numeroDeCaisse;
    }

    public int getNumeroDeCaisse() {
        return numeroDeCaisse;
    }

    @Override
    public String toString() {
        return super.toString() + ", Numéro de caisse: " + numeroDeCaisse;
    }

    @Override
    public double calculerSalaire() {
        int heuresSupp = Math.max(0, getNbrHeures() - 180);
        double salaireHeuresSupp = heuresSupp * 5 * 1.15; // 15% de plus pour heures supp
        double salaireHeuresNormales = Math.min(getNbrHeures(), 180) * 5;
        return salaireHeuresNormales + salaireHeuresSupp;
    }
}
