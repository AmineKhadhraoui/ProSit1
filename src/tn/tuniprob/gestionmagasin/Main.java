package tn.tuniprob.gestionmagasin;

import java.util.Date;


public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        produit ProduitVide = new produit();
        System.out.println("Produit vide:");
        ProduitVide.Affiché();

        produit produit1 = new produit(1021, "Lait", "Delice", 0.0);
        produit produit2 = new produit(2510, "Yaourt", "Vitalait", 0.0);
        produit produit3 = new produit(3250, "Tomate", "Sicam", 1.200);
        produit produit4 = new produit(1021, "Lait", "Delice", 0.0);

        System.out.println("\nLes produits aprés création:");
        produit1.Affiché();
        produit2.Affiché();
        produit3.Affiché();

        produit1.setPrix(0.700);
        System.out.println("\nProduit 1 aprés modification:");
        produit1.Affiché();

        produit2.setPrix(0.500);
        produit3.setPrix(1.200);

        System.out.println("\nLes produits aprés la modification des prix des autres produits" + ":");
        produit1.Affiché();
        produit2.Affiché();
        produit3.Affiché();

        System.out.println("\nLes produits avec toString():");
        System.out.println(produit1.toString());
        System.out.println(produit2.toString());
        System.out.println(produit3.toString());


        produit1.setDateDexpiration(new Date(2024 - 1900, 11, 31));
        produit2.setDateDexpiration(new Date(2024 - 1900, 10, 15));
        produit3.setDateDexpiration(new Date(2024 - 1900, 9, 5));
        System.out.println("\nLes produits avec les dates d'épiration:");
        produit1.Affiché();
        produit2.Affiché();
        produit3.Affiché();

        Magasin magasin1 = new Magasin(1,"charguia 2");
        magasin1.ajouterProduit(produit1);
        magasin1.ajouterProduit(produit2);
        System.out.println("\nCaractéristiques du magasin 1 :");
        magasin1.afficherCaracteristiques();
        Magasin magasin2 = new Magasin(2,"Centre urbain nord");
        magasin2.ajouterProduit(produit3);
        System.out.println("\nCaractéristiques du magasin 2 :");
        magasin1.ajouterProduit(produit3);
        magasin2.afficherCaracteristiques();

        Magasin[] magasins = {magasin1, magasin2};
        int totalProduits = compterTotalProduitsDansMagasins(magasins);

        System.out.println("\nNombre total de produits dans tous les magasins : " + totalProduits);

        boolean areIdentical1 = produit1.comparer(produit4);
        System.out.println("Produit 1 et Produit 4 sont identiques : " + areIdentical1);

        boolean areIdentical2 = produit.comparer(produit1, produit3);
        System.out.println("Produit 1 et Produit 3 sont identiques : " + areIdentical2);

        boolean produitTrouve = magasin1.chercherProduit(produit1);
        System.out.println("Produit 1 trouvé dans le magasin : " + produitTrouve);

        produit produitInexistant = new produit(9999, "Chocolat", "Cote d'Or", 3.5);
        boolean produitNonTrouve = magasin1.chercherProduit(produitInexistant);
        System.out.println("Produit inexistant trouvé dans le magasin : " + produitNonTrouve);

        System.out.println("\nSuppression du produit 'Yaourt':");
        magasin1.supprimerProduit(produit2);

        magasin1.afficherCaracteristiques();

        Magasin magasinAvecPlusDeProduits = Magasin.magasinAvecPlusDeProduits(magasin1, magasin2);
        System.out.println("\nLe magasin ayant le plus de produits est : " + magasinAvecPlusDeProduits.getadresse());



    }
    public static int compterTotalProduitsDansMagasins(Magasin[] magasins) {
        int total = 0;
        for (Magasin magasin : magasins) {
            total += magasin.compterProduits();
        }
        return total;
    }
}
