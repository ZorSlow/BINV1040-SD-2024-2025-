import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class GestionEtudiantsViaMatricule {
    private static final MonScanner scanner = new MonScanner("InputA.txt");
    private final Set<Etudiant> etudiants;

    public GestionEtudiantsViaMatricule() {
        // Utilisation d'un TreeSet ordonné par numéro de matricule
        this.etudiants = new TreeSet<>(Comparator.comparingInt(Etudiant::getNumeroMatricule));
    }

    public void ajouterEtudiant() {
        System.out.print("Entrez le numero de matricule : ");
        int numero = scanner.nextInt();
        System.out.print("Entrez le nom : ");
        String nom = scanner.next();
        System.out.print("Entrez le prenom : ");
        String prenom = scanner.next();

        Etudiant e = new Etudiant(numero, nom, prenom);
        if (etudiants.add(e)) {
            System.out.println("Étudiant ajouté !");
        } else {
            System.out.println("Étudiant déjà présent.");
        }
    }

    public void afficherEtudiants() {
        System.out.println("\nListe des étudiants (par matricule croissant) :");
        for (Etudiant e : etudiants) {
            System.out.printf("%d %s %s%n", e.getNumeroMatricule(), e.getNom(), e.getPrenom());
        }
    }

    public void menu() {
        int choix;
        do {
            System.out.println("\n1 -> ajouter un etudiant");
            System.out.println("2 -> afficher tous les etudiants");
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1 -> ajouterEtudiant();
                case 2 -> afficherEtudiants();
                default -> System.out.println("Choix invalide.");
            }
        } while (choix == 1 || choix == 2);
    }

    public static void main(String[] args) {
        GestionEtudiantsViaMatricule gestion = new GestionEtudiantsViaMatricule();
        gestion.menu();
    }
}