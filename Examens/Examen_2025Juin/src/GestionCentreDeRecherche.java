import java.util.Scanner;

public class GestionCentreDeRecherche {

    //private static Scanner scanner = new Scanner(System.in);
    private static MonScanner scanner = new MonScanner("inputLabos.txt");

    private static CentreDeRecherche cR;

    public static void main(String[] args) {
        System.out.println("********************************");
        System.out.println("Gestion d'un centre de recherche");
        System.out.println("********************************");
        System.out.println();
        System.out.print("Entrez le nombre de labos : ");
        int nombreLabos = scanner.nextInt();
        cR = new CentreDeRecherche(nombreLabos);
        int choix;
        do {
            System.out.println();
            System.out.println("Menu :");
            System.out.println("1 -> attribuer un labo");
            System.out.println("2 -> lister les labos d'une equipe de chercheurs");
            System.out.println("3 -> liberer un labo");
            System.out.println("4 -> afficher tout (debug)");
            System.out.println("5 -> quitter");
            System.out.println();
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    attribuerUnLabo();
                    break;
                case 2:
                    listerLesLabos();
                    break;
                case 3:
                    libererUnLabo();
                    break;
                case 4:
                    System.out.println(cR.toString());
            }
        } while (choix != 5);

        System.out.println("Fin");
    }

    private static void attribuerUnLabo() {
        System.out.println();
        System.out.println("Il reste " + cR.nombreLabosLibres() + " labo(s) libre(s)");
        System.out.print("Entrez le numero de l'equipe de chercheurs : ");
        int numeroEquipe = scanner.nextInt();
        EquipeDeChercheurs equipe = cR.getEquipeDeChercheurs(numeroEquipe);
        String nomEquipe;
        if (equipe == null) {
            System.out.print("Entrez le nom de l'equipe de chercheurs : ");
            nomEquipe = scanner.next();
            scanner.nextLine();
        } else {
            nomEquipe = equipe.getNomEquipe();
        }
        int numerolabo = cR.attribuerlabo(numeroEquipe, nomEquipe);
        System.out.println("Le numero du labo attribue : " + numerolabo);
    }


    private static void listerLesLabos() {
        System.out.print("Entrez le numero de l'equipe de chercheurs : ");
        int numeroEquipe = scanner.nextInt();
        EquipeDeChercheurs equipe = cR.getEquipeDeChercheurs(numeroEquipe);
        if (equipe == null) {
            System.out.println("Attention, cette equipe n'est pas presente dans le centre de recherche !");
        } else {
            System.out.print("Voici le(s) numero(s) du (des) labo(s) qu'elle occupe : ");
            System.out.println(equipe.lesLabos());
        }
    }


    private static void libererUnLabo() {
        System.out.print("Entrez le numero du labo : ");
        int numeroLabo = scanner.nextInt();
        try {
            EquipeDeChercheurs equipe = cR.libererlabo(numeroLabo);
            if (equipe == null) {
                System.out.println("Le labo n'a pas pu etre libere, car il n'etait pas occupe !");
            } else {
                if (cR.getEquipeDeChercheurs(equipe.getNumeroEquipe()) == null) {
                    System.out.println("L'equipe de chercheurs " + equipe.getNomEquipe() + " ne fait plus partie des equipes presentes");
                } else {
                    System.out.println("L'equipe de chercheurs " + equipe.getNomEquipe() + " fait toujours partie des equipes presentes");
                    System.out.println("Voici le(s) labo(s) qu'elle occupe :" + equipe.lesLabos());
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Aucun labo ne porte ce numero !");
        }
    }


}
