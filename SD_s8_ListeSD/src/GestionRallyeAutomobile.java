import java.util.Scanner ;

public class GestionRallyeAutomobile {
	private static RallyeAutomobile rallye;
	//private final static Scanner scanner = new Scanner(System.in);
	private static MonScanner scanner = new MonScanner("pilotes.txt");

	public static void main(String args[]) {



		System.out.println("*******************************************") ;
		System.out.println("Programme de gestion d'un rallye automobile") ;
		System.out.println("*******************************************") ;
		System.out.println();
		System.out.print("Entrez le nombre de pilotes : ") ;
		int nbCoureurs = scanner.nextInt() ;
		initialiserLaCourse(nbCoureurs) ;

		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> Afficher toute la course");
			System.out.println("2 -> Afficher le pilote en tete");
			System.out.println("3 -> Enregistrer un depassement");
			//TODO
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			System.out.println();
			switch (choix) {
				case 1:
					System.out.println(rallye);
					break;
				case 2:
					afficherPremier() ;
					break;
				case 3:
					avancerUnPilote();
					break;
				//TODO
				default:
					System.out.println("choix inconnu");
					break;
			}
		} while (rallye.nbPilotesEnCourse()!=0);

		System.out.println() ;
		System.out.println("La course est terminee !") ;
		System.out.println() ;
	}


	public static void initialiserLaCourse(int nbCoureurs) {
		String[] pilotes = new String[nbCoureurs] ;
		for (int i = 0 ; i<nbCoureurs ; i++) {
			System.out.print("Entrez le nom du pilote numero "+(i+1)+" : ") ;
			pilotes[i] = scanner.next() ;
			scanner.nextLine();
		}
		try {
			rallye = new RallyeAutomobile(pilotes);
		} catch (Exception e) {
			System.out.println("la course n'a pas pu etre initialisee");
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static void afficherPremier() {
		String premier = rallye.donnerPiloteDeTete();
		if (premier==null)
			System.out.println("Il n'y a pas de pilote dans la course");
		else
			System.out.println("Le pilote en premiere position est "+premier+".") ;
	}

	public static void avancerUnPilote() {
		System.out.print("Entrez le nom du pilote qui depasse : ") ;
		String nom = scanner.next() ;
		scanner.nextLine() ;
		if (!rallye.avancerPilote(nom))
			System.out.println("Ce pilote n'existe pas ou ne peut etre avance car il est en tete.");
		else
			System.out.println("Ce pilote a ete avance.");
	}

	//TODO
}
