package tn.tuniprod.gestiondesemployés;

public abstract class Employé {
    private int id;
    private String nom;
    private String adresse;
    private int nbr_heures;

    public Employé(int id, String nom, String adresse, int nbr_heures) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.nbr_heures = nbr_heures;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }


    public String getAdresse() {
        return adresse;
    }

    public int getNbrHeures() {
        return nbr_heures;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nom: " + nom + ", Adresse: " + adresse + ", Nombre d'heures: " + nbr_heures;
    }

    public abstract double calculerSalaire();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employé employé = (Employé) o;
        return id == employé.id && nom.equals(employé.nom) && adresse.equals(employé.adresse) && nbr_heures == employé.nbr_heures;
    }

}
