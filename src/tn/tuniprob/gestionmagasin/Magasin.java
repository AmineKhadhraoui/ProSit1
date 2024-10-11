package tn.tuniprob.gestionmagasin;

import tn.tuniprod.gestiondesemployés.Caissier;
import tn.tuniprod.gestiondesemployés.Employé;
import tn.tuniprod.gestiondesemployés.Responsable;
import tn.tuniprod.gestiondesemployés.Vendeur;

public class Magasin {

    private int id;
    private String adresse;
    private String nom;
    private int capacite;
    private produit[] produits;
    private Employé[] employés;

    public Magasin(int id, String adresse) {
        this.id = id;
        this.adresse = adresse;
        this.capacite = 50;
        this.produits = new produit[capacite];

    }
    public Magasin(int id, String adresse, String nom) {
        this.id = id;
        this.adresse = adresse;
        this.nom = nom;
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
        System.out.println("Magasin ID: " + id + ", Adresse: " + adresse +" Nom: " + nom);
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

    public void ajouterEmployé(Employé employé) {
        for (int i = 0; i < employés.length; i++) {
            if (employés[i] == null) {
                employés[i] = employé;
                System.out.println("Employé ajouté : " + employé.getNom());
                return;
            }
        }
        System.out.println("Le magasin a atteint sa capacité maximale d'employés.");
    }

    public void afficherEmployés() {
        System.out.println("Magasin ID: " + id + ", Adresse: " + adresse);
        for (Employé employé : employés) {
            if (employé != null) {
                System.out.println(employé);
            }
        }
    }

    public void afficherDetails() {
        System.out.println("ID Magasin: " + id);
        System.out.println("Nom: " + nom);
        System.out.println("Adresse: " + adresse);
        System.out.println("Produits:");
        for (produit produit : produits) {
            if (produit != null) {
                System.out.println(produit);
            }
        }
        System.out.println("Employés:");
        for (Employé employé : employés) {
            if (employé != null) {
                System.out.println(employé);
            }
        }
    }

    public void afficherPrimesResponsables() {
        System.out.println("Primes des responsables:");
        for (Employé employé : employés) {
            if (employé instanceof Responsable) {
                Responsable responsable = (Responsable) employé;
                System.out.println("Responsable: " + responsable.getNom() + ", Prime: " + responsable.getPrime());
            }
        }
    }

    public void afficherSalaires() {
        System.out.println("Salaires des employés:");
        for (Employé employé : employés) {
            if (employé != null) {
                System.out.println("Employé: " + employé.getNom() + ", Salaire: " + employé.calculerSalaire());
            }
        }
    }

    public void AfficheNbEmplyoeParType() {
        int nbCaissier = 0;
        int nbVendeur = 0;
        int nbResponsable = 0;

        for (Employé emp : employés) {
            if (emp instanceof Caissier) {
                nbCaissier++;
            } else if (emp instanceof Vendeur) {
                nbVendeur++;
            } else if (emp instanceof Responsable) {
                nbResponsable++;
            }
        }

        System.out.println("Nombre de Caissiers : " + nbCaissier);
        System.out.println("Nombre de Vendeurs : " + nbVendeur);
        System.out.println("Nombre de Responsables : " + nbResponsable);
    }



}
