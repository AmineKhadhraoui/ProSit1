package tn.tuniprod.gestiondesemployés;

public class Responsable extends Employé {
    private double prime;

    public Responsable(int id, String nom, String adresse, int nbr_heures, double prime) {
        super(id, nom, adresse, nbr_heures);
        this.prime = prime;
    }

    public double getPrime() {
        return prime;
    }

    @Override
    public String toString() {
        return super.toString() + ", Prime: " + prime;
    }
    @Override
    public double calculerSalaire() {
        double salaireBase = getNbrHeures() * 10;
        if (getNbrHeures() > 160) {
            salaireBase += (getNbrHeures() - 160) * 10 * 0.2;
        }
        return salaireBase + prime;
    }
}
