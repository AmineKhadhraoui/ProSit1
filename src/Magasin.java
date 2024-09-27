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

    public void ajouterProduit(produit produit) {
        for (int i = 0; i < produits.length; i++) {
            if (produits[i] == null) {
                produits[i] = produit;
                System.out.println("Produit ajouté : " + produit.getLibelle());
                return;
            }
        }
        System.out.println("Le magasin a atteint sa capacité maximale de 50 produits.");
    }


    public void afficherCaracteristiques() {
        System.out.println("Magasin ID: " + id + ", Adresse: " + adresse);
        System.out.println("Capacité: " + capacite + " produits");
        System.out.println("Produits dans le magasin:");
        for (int i = 0; i < produits.length; i++) {
            produit produit = produits[i];
            System.out.println("- Nom: " + produit.getLibelle() + ", Prix: " + produit.getPrix());
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
}
