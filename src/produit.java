import java.util.Date;

public class produit {
int id;
String libellé;
String marque;
double prix;
Date date_dexpiration;

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


    @Override
    public String toString() {
        return "ID=" + id +
                ", libellé='" + libellé + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", Date dexpiration=" + date_dexpiration
                ;
    }

}
