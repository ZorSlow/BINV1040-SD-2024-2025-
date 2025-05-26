
import java.util.Arrays;
import java.util.Scanner;

public class GestionConcours {
    //private static Scanner scanner = new Scanner(System.in);
    private static MonScanner scanner = new MonScanner("input.txt");
    private static Concours concours;

    public static void main(String[] args) {
        System.out.println("*********************");
        System.out.println("Gestion d'un concours");
        System.out.println("*********************");
        System.out.println();
        System.out.println("Enregistrement des candidats");
        System.out.print("Entrez le nombre de candidats : ");
        int nombreCandidats = scanner.nextInt();
        scanner.nextLine();
        String[] tableNomsCandidats = new String[nombreCandidats];
        for (int i = 0; i < nombreCandidats; i++) {
            System.out.print("Donnez le nom du candidat n?"+(i+1)+ " : ");
            tableNomsCandidats[i] = scanner.nextLine();
        }
        System.out.print("Entrez le nombre de votes max par votant : ");
        int nombreMaxVotes = scanner.nextInt();
        concours = new Concours(tableNomsCandidats,nombreMaxVotes);
        System.out.println();
        int choix = 0;
        do {
            System.out.println();
            System.out.println("1 -> afficher quelques informations sur le concours");
            System.out.println("2 -> enregistrer un vote via le nom d'un candidat");
            System.out.println("3 -> enregistrer un vote via le numero d'un candidat");
            System.out.println("4 -> afficher le classement");
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
                    voterViaNom();
                    break;
                case 3:
                    voterViaNumero();
                    break;
                case 4:
                    afficherClassement();
                    break;
                case 5:
                    break;
            }

        } while (choix!=5);

        System.out.println("Fin du concours");
    }

    private static void afficherInfo() {
        // vous pouvez modifier cette methode comme vous voulez
        // cette classe ne sera pas evaluee
        // ne perdez pas de temps sur des affichages!
        System.out.println(concours);
    }

    private static void afficherClassement() {
        // vous pouvez modifier cette methode comme vous voulez
        // cette classe ne sera pas evaluee
        // ne perdez pas de temps sur des affichages!
        System.out.println(Arrays.toString(concours.classement()));
    }

    private static void voterViaNom() {
        // vous pouvez modifier cette methode comme vous voulez
        // cette classe ne sera pas evaluee
        // ne perdez pas de temps sur des affichages!
        System.out.print("Entrez le numero de telephone : ");
        String numeroTelephone = scanner.nextLine();
        System.out.print("Entrez le nom du candidat : ");
        String nomCandidat = scanner.nextLine();
        if(concours.voterViaNom(numeroTelephone,nomCandidat)){
            System.out.println("Le vote a ete enregistre avec succes");
        }else{
            System.out.println("Le vote a ete refuse");
        }
    }

    private static void voterViaNumero() {
        // vous pouvez modifier cette methode comme vous voulez
        // cette classe ne sera pas evaluee
        // ne perdez pas de temps sur des affichages!
        System.out.print("Entrez le numero de telephone : ");
        String numeroTelephone = scanner.nextLine();
        System.out.print("Entrez le numero du candidat : ");
        int numeroCandidat = scanner.nextInt();
        scanner.nextLine();
        if(concours.voterViaNumero(numeroTelephone,numeroCandidat)){
            System.out.println("Le vote a ete enregistre avec succes");
        }else{
            System.out.println("Le vote a ete refuse");
        }
    }




}
