import java.util.LinkedHashSet;
import java.util.Set;

public class GestionEtudiantsViaArrivee {
    private static final MonScanner scanner = new MonScanner("InputA.txt");
    private static final Set<Etudiant> ensembleEtudiants = new LinkedHashSet<>();

    public static void main(String[] args) {
        System.out.println("*********************");
        System.out.println("Gestion des etudiants (ordre d'arrivée)");
        System.out.println("*********************");
        int choix;
        do {
            System.out.println();
            System.out.println("1 -> ajouter un etudiant");
            System.out.println("2 -> afficher tous les etudiants");
            System.out.println();
            System.out.print("Entrez votre choix : ");

            choix = scanner.nextInt();
            switch (choix) {
                case 1 -> ajout();
                case 2 -> afficherTous();
                default -> System.out.println("Choix invalide.");
            }
        } while (choix == 1 || choix == 2);
    }

    private static void ajout() {
        System.out.println();
        System.out.print("Entrez le numero de matricule : ");
        int numero = scanner.nextInt();
        System.out.print("Entrez le nom : ");
        String nom = scanner.next();
        System.out.println();
        System.out.print("Entrez le prenom : ");
        String prenom = scanner.next();
        System.out.println();
        if (ensembleEtudiants.add(new Etudiant(numero, nom, prenom))) {
            System.out.println("Étudiant ajouté !");
        } else {
            System.out.println("Étudiant déjà présent.");
        }
    }

    private static void afficherTous() {
        System.out.println();
        for (Etudiant etudiant : ensembleEtudiants) {
            System.out.printf("%d %s %s%n", etudiant.getNumeroMatricule(), etudiant.getNom(), etudiant.getPrenom());
        }
    }
}