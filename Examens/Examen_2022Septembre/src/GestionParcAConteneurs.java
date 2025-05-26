import java.util.Scanner;

public class GestionParcAConteneurs {
        //private static Scanner scanner = new Scanner(System.in);
        private static MonScanner scanner = new MonScanner("input2022SeptExamen.txt");
        private static ParcAConteneurs recyParc;

        public static void main(String[] args) {
            System.out.println("******************************");
            System.out.println("Gestion d'un parc a conteneurs");
            System.out.println("******************************");
            System.out.println();
            System.out.print("Entrez le nombre de periodes : ");
            int nombrePeriodes = scanner.nextInt();
            System.out.print("Entrez le nombre de voitures max par periode : ");
            int maxVoitures = scanner.nextInt();
            System.out.print("Entrez le nombre de periodes max par voiture : ");
            int maxPeriodes = scanner.nextInt();
            recyParc = new ParcAConteneurs(nombrePeriodes,maxVoitures,maxPeriodes);
            System.out.println();
            int choix = 0;
            do {
                System.out.println();
                System.out.println("1 -> afficher quelques informations sur le parc a conteneurs");
                System.out.println("2 -> enregistrer une voiture");
                System.out.println("3 -> verifier voiture autorisee");
                System.out.println("4 -> afficher la liste des periodes non pleines");
                System.out.println("5 -> quitter");
                System.out.println();
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();
                scanner.nextLine();
                switch (choix) {
                    case 1:
                        afficherInfo();
                        break;
                    case 2:
                        enregistrerVoiture();
                        break;
                    case 3:
                        verifierVoitureAutorisee();
                        break;
                    case 4:
                        afficherListePeriodesNonPleines();
                        break;
                    case 5:
                        break;
                }

            } while (choix!=5);

            System.out.println("Fin !");
        }

    private static void afficherInfo() {
        // vous pouvez modifier cette methode comme vous voulez
        // cette classe ne sera pas evaluee
        // ne perdez pas de temps sur des affichages!
        System.out.println(recyParc);
    }

    private static void enregistrerVoiture() {
        // vous pouvez modifier cette methode comme vous voulez
        // cette classe ne sera pas evaluee
        // ne perdez pas de temps sur des affichages!
        System.out.print("Entrez la plaque de la voiture : ");
        String voiture = scanner.nextLine();
        System.out.print("Entrez le numero de la periode : ");
        int numeroPeriode = scanner.nextInt();
        scanner.nextLine();
        if(recyParc.enregistrerVoiture(voiture,numeroPeriode)){
            System.out.println("La voiture a ete enregistree avec succes");
        }else{
            System.out.println("Le voiture n'a pas ete enregistree");
        }
    }

    private static void verifierVoitureAutorisee() {
        // vous pouvez modifier cette methode comme vous voulez
        // cette classe ne sera pas evaluee
        // ne perdez pas de temps sur des affichages!
        System.out.print("Entrez la plaque de la voiture : ");
        String voiture = scanner.nextLine();
        System.out.print("Entrez le numero de la periode : ");
        int numeroPeriode = scanner.nextInt();
        scanner.nextLine();
        if(recyParc.estAutorisee(voiture,numeroPeriode)){
            System.out.println("La voiture est autorisee");
        }else{
            System.out.println("Le voiture n'est pas autorisee");
        }
    }

    private static void afficherListePeriodesNonPleines() {
        // vous pouvez modifier cette methode comme vous voulez
        // cette classe ne sera pas evaluee
        // ne perdez pas de temps sur des affichages!
        System.out.println(recyParc.listePeriodesNonPleines());
    }

}
