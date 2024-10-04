package tn.tuniprob.gestionmagasin;

import java.util.Date;

public class produit {
    private  int id;
    private  String libellé;
    private  String marque;
    private  double prix;
    private  Date date_dexpiration;


    produit() {
        id = 0;
        libellé = "";
        marque = "";
        prix = 0.0;
        date_dexpiration = null;
    }
    produit(int id, String label, String brand, double price) {
        this.id = id;
        this.libellé = label;
        this.marque = brand;
        this.prix = price;
        this.date_dexpiration= date_dexpiration;

    }
    void Affiché() {
        System.out.println("ID: " + id + ", libellé: " + libellé + ", marque: " + marque + ", Prix: " + prix + ", Date dexpiration: " + date_dexpiration);
    }
    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libellé;
    }

    public String getMarque() {
        return marque;
    }

    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        if (prix >= 0) {
            this.prix = prix;
        } else {
            System.out.println("Le prix ne peut pas être négatif. Valeur ignorée.");
        }
    }

    public Date getDateDexpiration() {
        return date_dexpiration;
    }

    public void setDateDexpiration(Date date_dexpiration) {
        this.date_dexpiration = date_dexpiration;
    }

    @Override
    public String toString() {
        return "ID=" + id +
                ", libellé='" + libellé + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", Date dexpiration=" + date_dexpiration
                ;
    }
    public boolean comparer(produit autreProduit) {
        return this.id == autreProduit.id && this.libellé.equals(autreProduit.libellé) && this.prix == autreProduit.prix;
    }

    public static boolean comparer(produit produit1, produit produit2) {
        return produit1.id == produit2.id && produit1.libellé.equals(produit2.libellé) && produit1.prix == produit2.prix;
    }

}
