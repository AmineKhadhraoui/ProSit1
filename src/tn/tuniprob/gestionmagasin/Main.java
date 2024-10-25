package tn.tuniprob.gestionmagasin;

import tn.tuniprod.gestiondesemployés.Caissier;
import tn.tuniprod.gestiondesemployés.Responsable;
import tn.tuniprod.gestiondesemployés.Vendeur;
import tn.gestionException.PrixNegatifException;
import tn.gestionException.MagasinPleinException;

import java.util.Date;


public class Main {
    public static void main(String[] args) {
        produit ProduitVide = new produit();
        System.out.println("Produit vide:");
        ProduitVide.Affiché();

        produit produit1 = new produit(1021, "Lait", "Delice", 0.0);
        produit produit2 = new produit(2510, "Yaourt", "Vitalait", 0.0);
        produit produit3 = new produit(3250, "Tomate", "Sicam", 1.200);
        produit produit4 = new produit(1021, "Lait", "Delice", 0.0);

        System.out.println("\nLes produits après création:");
        produit1.Affiché();
        produit2.Affiché();
        produit3.Affiché();

        produit1.setPrix(0.700);
        System.out.println("\nProduit 1 après modification:");
        produit1.Affiché();

        produit2.setPrix(0.500);
        produit3.setPrix(1.200);

        System.out.println("\nLes produits après la modification des prix des autres produits :");
        produit1.Affiché();
        produit2.Affiché();
        produit3.Affiché();

        produit1.setDateDexpiration(new Date(2024 - 1900, 11, 31));
        produit2.setDateDexpiration(new Date(2024 - 1900, 10, 15));
        produit3.setDateDexpiration(new Date(2024 - 1900, 9, 5));
        System.out.println("\nLes produits avec les dates d'expiration:");
        produit1.Affiché();
        produit2.Affiché();
        produit3.Affiché();

        Magasin magasin1 = new Magasin(1, "charguia 2");

        try {
            magasin1.ajouterProduit(produit1);
            magasin1.ajouterProduit(produit2);
            magasin1.ajouterProduit(produit3);
        } catch (MagasinPleinException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (PrixNegatifException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println("\nCaractéristiques du magasin 1 :");
        magasin1.afficherCaracteristiques();

        Magasin magasin2 = new Magasin(2, "Centre urbain nord");

        try {
            magasin2.ajouterProduit(produit3);
        } catch (MagasinPleinException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (PrixNegatifException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println("\nCaractéristiques du magasin 2 :");
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

        // Partie pour l'ajout des employés
        Magasin magasin3 = new Magasin(3, "Carrefour", "Centre-Ville");
        Magasin magasin4 = new Magasin(4, "Monoprix", "Menzah 6");

        Caissier caissier1 = new Caissier(1, "Mohsen", "Tunis", 160, 101);
        Vendeur vendeur1 = new Vendeur(2, "Abdesmad", "Tunis", 180, 0.15);
        Responsable responsable1 = new Responsable(3, "Eya", "Tunis", 200, 500);
        Caissier caissier2 = new Caissier(4, "Donya", "Tunis", 150, 102);

        magasin3.ajouterEmployé(caissier1);
        magasin3.ajouterEmployé(vendeur1);
        magasin3.ajouterEmployé(responsable1);
        magasin3.ajouterEmployé(caissier2);

        Caissier caissier3 = new Caissier(5, "Eve", "Tunis", 140, 103);
        Vendeur vendeur2 = new Vendeur(6, "Frank", "Tunis", 160, 0.20);
        Vendeur vendeur3 = new Vendeur(7, "Grace", "Tunis", 180, 0.18);
        Responsable responsable2 = new Responsable(8, "Henry", "Tunis", 190, 550);

        magasin4.ajouterEmployé(caissier3);
        magasin4.ajouterEmployé(vendeur2);
        magasin4.ajouterEmployé(vendeur3);
        magasin4.ajouterEmployé(responsable2);

        System.out.println("\nEmployés du magasin 3 :");
        magasin3.afficherEmployés();

        System.out.println("\nEmployés du magasin 4 :");
        magasin4.afficherEmployés();

        produit produit5 = new produit(5, "Lait", "vitalait", 1.2);
        produit produit6 = new produit(6, "Pain", "Brunch", 0.5);

        try {
            magasin3.ajouterProduit(produit5);
            magasin4.ajouterProduit(produit6);
        } catch (MagasinPleinException | PrixNegatifException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        produit produit7 = new produit(7, "Lait", "vitalait", 1.2);
        produit produit8 = new produit(8, "Pain", "Brunch", 0.5);

        try {
            magasin3.ajouterProduit(produit7);
            magasin4.ajouterProduit(produit8);
        } catch (MagasinPleinException | PrixNegatifException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static int compterTotalProduitsDansMagasins(Magasin[] magasins) {
        int total = 0;
        for (Magasin magasin : magasins) {
            total += magasin.compterProduits();
        }
        return total;
    }
}