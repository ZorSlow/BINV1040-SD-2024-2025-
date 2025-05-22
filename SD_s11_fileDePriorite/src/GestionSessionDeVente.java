import java.util.Scanner;

public class GestionSessionDeVente {

    //private static Scanner scanner = new Scanner(System.in);
    private static MonScanner scanner = new MonScanner("ventes.txt");
    private static SessionDeVente session;

    public static void main(String[] args) {

        System.out.println("******************************");
        System.out.println("Gestion d'une session de vente");
        System.out.println("******************************");
        System.out.println();
        System.out.print("Entrez le nombre de casiers a vendre : ");
        int nombreCasiersMisEnVente = scanner.nextInt();
        scanner.nextLine();
        session = new SessionDeVente(nombreCasiersMisEnVente);
        int choix = 0;
        do {
            System.out.println("1 -> afficher quelques informations sur l'etat des ventes");
            System.out.println("2 -> mettre un client dans la file d'attente");
            System.out.println("3 -> traiter le client en tete de la file d'attente");
            System.out.println("4 -> fermer le magasin");
            System.out.println();
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    afficherInfo();
                    break;
                case 2:
                    mettreEnAttente();
                    break;
                case 3:
                    traiterClient();
                    break;
            }

        } while (session.getNombreCasiersRestants() > 0 && choix != 4);
        System.out.println("Fin des ventes");
        if(session.getNombreCasiersRestants()==0) {
            System.out.println("Tous les casiers sont vendus");
        }
    }

    private static void traiterClient() {
        // vous pouvez modifier cette methode comme vous voulez
        // cette classe ne sera pas evaluee
        // ne perdez pas de temps sur des affichages!
        String client = session.selectionnerClientSuivant();
        if (client == null) {
            System.out.println("Il n'y a actuellement aucun client en attente");
        } else {
            System.out.println("Le client traite est " + client);
            System.out.println("Il reste actuellement " + session.getNombreCasiersRestants() + " casiers en vente");
            System.out.println("Entrez le nombre de casiers que vous desirez ( ou 0 pour arreter) : ");
            int nombreCasiersDemandes = scanner.nextInt();

            try {
                if (session.passerCommande(client, nombreCasiersDemandes)) {
                    System.out.println("La demande a ete acceptee");
                } else {
                    System.out.println("La demande n'a pas ete acceptee car il ne reste plus assez de casiers");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("IllegalArgumentException");
            } catch (IllegalStateException e) {
                System.out.println("IllegalStateException");
            }

        }
    }

    private static void afficherInfo() {
        // vous pouvez modifier cette methode comme vous voulez
        // cette classe ne sera pas evaluee
        // ne perdez pas de temps sur des affichages!
        System.out.println(session);

    }

    private static void mettreEnAttente() {
        // vous pouvez modifier cette methode comme vous voulez
        // cette classe ne sera pas evaluee
        // ne perdez pas de temps sur des affichages!
        System.out.print("Entrez le client : ");
        String client = scanner.nextLine();
        try{
        if (session.placerDansFileAttente(client)) {
            System.out.println("Le client a ete mis en attente");
        } else {
            System.out.println("Le client n'a pas ete mis en attente");
            System.out.println("Il est peut-etre deja dans la file ou a deja commande");
        }
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException");
        }
    }

}
