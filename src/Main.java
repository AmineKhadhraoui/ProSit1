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

        System.out.println("\nLes produits aprés création:");
        produit1.Affiché();
        produit2.Affiché();
        produit3.Affiché();

        produit1.prix= 0.700;
        System.out.println("\nProduit 1 aprés modification:");
        produit1.Affiché();

        produit2.prix=0.500;
        produit3.prix=1.200;

        System.out.println("\nLes produits aprés la modification des prix des autres produits" + ":");
        produit1.Affiché();
        produit2.Affiché();
        produit3.Affiché();

        System.out.println("\nLes produits avec toString():");
        System.out.println(produit1.toString());
        System.out.println(produit2.toString());
        System.out.println(produit3.toString());


        produit1.date_dexpiration=new Date(2024 - 1900, 11, 31);
        produit2.date_dexpiration=new Date(2024 - 1900, 10, 15);
        produit3.date_dexpiration=new Date(2024 - 1900, 9, 5);
        System.out.println("\nLes produits avec les dates d'épiration:");
        produit1.Affiché();
        produit2.Affiché();
        produit3.Affiché();

    }
}
