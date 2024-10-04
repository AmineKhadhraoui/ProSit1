package tn.tuniprob.gestionmagasin;

public class Magasin {

    private int id;
    private String adresse;
    private int capacite;
    private produit[] produits;


    public Magasin(int id, String adresse) {
        this.id = id;
        this.adresse = adresse;
        this.capacite = 50;
        this.produits = new produit[capacite];

    }
    public String getadresse() {
        return adresse;
    }

    public void ajouterProduit(produit produit) {

        for (produit prod : produits) {
            if (prod != null && prod.comparer(produit)) {
                System.out.println("Le produit '" + produit.getLibelle() + "' existe déjà dans le magasin.");
                return;
            }
        }


        for (int i = 0; i < produits.length; i++) {
            if (produits[i] == null) {
                produits[i] = produit;
                System.out.println("Produit ajouté : " + produit.getLibelle());
                return;
            }
        }
        System.out.println("Le magasin a atteint sa capacité maximale de 50 produits.");
    }

    public void supprimerProduit(produit produit) {
        for (int i = 0; i < produits.length; i++) {
            if (produits[i] != null && produits[i].comparer(produit)) {
                produits[i] = null;
                System.out.println("Produit supprimé : " + produit.getLibelle());
                return;
            }
        }
        System.out.println("Le produit '" + produit.getLibelle() + "' n'existe pas dans le magasin.");
    }
    public void afficherCaracteristiques() {
        System.out.println("Magasin ID: " + id + ", Adresse: " + adresse);
        System.out.println("Capacité: " + capacite + " produits");
        System.out.println("Produits dans le magasin:");

        for (int i = 0; i < produits.length; i++) {
            if (produits[i] != null) { // Vérifier que le produit n'est pas null avant d'accéder à ses méthodes
                System.out.println("- Nom: " + produits[i].getLibelle() + ", Prix: " + produits[i].getPrix());
            }
        }
    }


    public int compterProduits() {
        int count = 0;
        for (int i = 0; i < produits.length; i++) {
            if (produits[i] != null) {
                count++;
            }
        }
        return count;
    }
    public boolean chercherProduit(produit produit) {
        for (produit prod : produits) {
            if (prod != null && prod.comparer(produit)) {  // Using the 'comparer' method to check for equality
                return true;
            }
        }
        return false;
    }

    public static Magasin magasinAvecPlusDeProduits(Magasin m1, Magasin m2) {
        return m1.compterProduits() > m2.compterProduits() ? m1 : m2;
    }

}
