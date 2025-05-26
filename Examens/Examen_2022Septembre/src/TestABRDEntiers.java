import java.util.Scanner;


public class TestABRDEntiers {
	
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 *
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a recu en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu==null) {
			if (recu!=null) {
				System.out.println("KO");
				System.out.println("     "+messageErreur+". Attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println("KO");
			System.out.println("    "+messageErreur+". Attendu="+attendu+" recu="+recu);
			System.exit(0);
		}
	}

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("Programme Test ABRDEntiers(juin20022");
		System.out.println("************************************");
		int choix= 0;
		do {
			System.out.println();
			System.out.println("1 ->  Tester la methode nombrePositifsVI()");
			System.out.println("2 ->  Tester la methode nombrePositifsVR()");
			System.out.println("3 ->  Tester la methode auMoins1PositifVI()");
			System.out.println("4 ->  Tester la methode auMoins1PositifVR()");

			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix=scanner.nextInt();
			switch (choix) {
				case 1:
					testNombrePositifsVI();
					break;
				case 2:
					testNombrePositifsVR();
					break;
				case 3:
					testAuMoins1PositifVI();
					break;
				case 4:
					testAuMoins1PositifVR();
					break;
				default:
					break;
			}
		} while (choix >= 1 && choix <= 4);

	}

	private static void testNombrePositifsVI() {
		ABRDEntiers ABR;
		System.out.println();
		ABR = ABR1();
		boolean auMoins1EntierItere = false;
		for (int entier : ABR) {
			auMoins1EntierItere = true;
		}
		if(!auMoins1EntierItere){
			System.out.println("Attention votre iterateur n'itere rien");
			System.out.println("Peut-etre avez-vous oublie de completer la methode remplirFile() !");
			System.exit(0);
		}
		System.out.println("test ABR1");
		ABR = ABR1();
		assertEquals("test ABR1 ko",5,ABR.nombrePositifsVI());
		System.out.println("test ABR1 ok");

		System.out.println();
		System.out.println("test ABR2");
		ABR = ABR2();
		assertEquals("test ABR2 ko",8,ABR.nombrePositifsVI());
		System.out.println("test ABR2 ok");

		System.out.println();
		System.out.println("test ABR3");
		ABR = ABR3();
		assertEquals("test ABR3 ko",9,ABR.nombrePositifsVI());
		System.out.println("test ABR3 ok");

		System.out.println();
		System.out.println("test ABR4");
		ABR = ABR4();
		assertEquals("testABR4 ko",1,ABR.nombrePositifsVI());
		System.out.println("test ABR4 ok");

		System.out.println();
		System.out.println("test ABR5");
		ABR = ABR5();
		assertEquals("test ABR5 ko",0,ABR.nombrePositifsVI());
		System.out.println("test ABR5 ok");

		System.out.println();
		System.out.println("test ABRVide");
		ABR = ABRVide();
		assertEquals("test ABRVide ko",0,ABR.nombrePositifsVI());
		System.out.println("test ABRVide ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi !");
	}

	private static void testNombrePositifsVR() {
		ABRDEntiers ABR;
		System.out.println();
		System.out.println("test ABR1");
		ABR = ABR1();
		assertEquals("test ABR1 ko",5,ABR.nombrePositifsVR());
		System.out.println("test ABR1 ok");

		System.out.println();
		System.out.println("test ABR2");
		ABR = ABR2();
		assertEquals("test ABR2 ko",8,ABR.nombrePositifsVR());
		System.out.println("test ABR2 ok");

		System.out.println();
		System.out.println("test ABR3");
		ABR = ABR3();
		assertEquals("test ABR3 ko",9,ABR.nombrePositifsVR());
		System.out.println("test ABR3 ok");

		System.out.println();
		System.out.println("test ABR4");
		ABR = ABR4();
		assertEquals("testABR4 ko",1,ABR.nombrePositifsVR());
		System.out.println("test ABR4 ok");

		System.out.println();
		System.out.println("test ABR5");
		ABR = ABR5();
		assertEquals("test ABR5 ko",0,ABR.nombrePositifsVR());
		System.out.println("test ABR5 ok");

		System.out.println();
		System.out.println("test ABRVide");
		ABR = ABRVide();
		assertEquals("test ABRVide ko",0,ABR.nombrePositifsVR());
		System.out.println("test ABRVide ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi !");
	}

	private static void testAuMoins1PositifVI() {
		ABRDEntiers ABR;
		System.out.println();
		ABR = ABR1();
		boolean auMoins1EntierItere = false;
		for (int entier : ABR
			 ) {
			auMoins1EntierItere = true;
		}
		if(!auMoins1EntierItere){
			System.out.println("Attention votre iterateur n'itere rien");
			System.out.println("Peut-etre avez-vous oublie de completer la methode remplirFile()");
			System.exit(0);
		}

		System.out.println("test ABR1");
		ABR = ABR1();
		assertEquals("test ABR1 ko",true,ABR.auMoins1PositifVI());
		System.out.println("test ABR1 ok");

		System.out.println();
		System.out.println("test ABR2");
		ABR = ABR2();
		assertEquals("test ABR2 ko",true,ABR.auMoins1PositifVI());
		System.out.println("test ABR2 ok");

		System.out.println();
		System.out.println("test ABR3");
		ABR = ABR3();
		assertEquals("test ABR3 ko",true,ABR.auMoins1PositifVI());
		System.out.println("test ABR3 ok");

		System.out.println();
		System.out.println("test ABR4");
		ABR = ABR4();
		assertEquals("testABR4 ko",true,ABR.auMoins1PositifVI());
		System.out.println("test ABR4 ok");

		System.out.println();
		System.out.println("test ABR5");
		ABR = ABR5();
		assertEquals("test ABR5 ko",false,ABR.auMoins1PositifVI());
		System.out.println("test ABR5 ok");

		System.out.println();
		System.out.println("test ABRVide");
		ABR = ABRVide();
		assertEquals("test ABRVide ko",false,ABR.auMoins1PositifVI());
		System.out.println("test ABRVide ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi !");
	}

	private static void testAuMoins1PositifVR() {
		ABRDEntiers ABR;
		System.out.println();
		System.out.println("test ABR1");
		ABR = ABR1();
		assertEquals("test ABR1 ko",true,ABR.auMoins1PositifVR());
		System.out.println("test ABR1 ok");

		System.out.println();
		System.out.println("test ABR2");
		ABR = ABR2();
		assertEquals("test ABR2 ko",true,ABR.auMoins1PositifVR());
		System.out.println("test ABR2 ok");

		System.out.println();
		System.out.println("test ABR3");
		ABR = ABR3();
		assertEquals("test ABR3 ko",true,ABR.auMoins1PositifVR());
		System.out.println("test ABR3 ok");

		System.out.println();
		System.out.println("test ABR4");
		ABR = ABR4();
		assertEquals("testABR4 ko",true,ABR.auMoins1PositifVR());
		System.out.println("test ABR4 ok");

		System.out.println();
		System.out.println("test ABR5");
		ABR = ABR5();
		assertEquals("test ABR5 ko",false,ABR.auMoins1PositifVR());
		System.out.println("test ABR5 ok");

		System.out.println();
		System.out.println("test ABRVide");
		ABR = ABRVide();
		assertEquals("test ABRVide ko",false,ABR.auMoins1PositifVR());
		System.out.println("test ABRVide ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi !");
	}


	// Positifs et positifs
	public static ABRDEntiers ABR1(){
		ABRDEntiers ag = new ABRDEntiers(-5);
		ABRDEntiers ad = new ABRDEntiers(10);
		ad = new ABRDEntiers(ag,-4,ad);
		ag = new ABRDEntiers(-8);
		ABRDEntiers a = new ABRDEntiers(ag,-6,ad);
		ad = new ABRDEntiers(15);
		ag = new ABRDEntiers(ABRVide(),13,ad);
		ad = new ABRDEntiers(ag,18,ABRVide());
		a = new ABRDEntiers(a,12,ad);
		return a;
	}


	// positifs et un negatif
	public static ABRDEntiers ABR2(){
		ABRDEntiers ag = new ABRDEntiers(6);
		ABRDEntiers ad = new ABRDEntiers(10);
		ad = new ABRDEntiers(ag,8,ad);
		ag = new ABRDEntiers(-4);
		ABRDEntiers a = new ABRDEntiers(ag,6,ad);
		ad = new ABRDEntiers(12);
		ag = new ABRDEntiers(ABRVide(),12,ad);
		ad = new ABRDEntiers(ag,18,ABRVide());
		a = new ABRDEntiers(a,12,ad);
		return a;
	}


	// tous positifs
	public static ABRDEntiers ABR3(){
		ABRDEntiers ag = new ABRDEntiers(7);
		ABRDEntiers ad = new ABRDEntiers(10);
		ad = new ABRDEntiers(ag,8,ad);
		ag = new ABRDEntiers(4);
		ABRDEntiers a = new ABRDEntiers(ag,6,ad);
		ad = new ABRDEntiers(15);
		ag = new ABRDEntiers(ABRVide(),13,ad);
		ad = new ABRDEntiers(ag,18,ABRVide());
		a = new ABRDEntiers(a,12,ad);
		return a;
	}



	// Positifs et 1 positif
	public static ABRDEntiers ABR4(){
		ABRDEntiers ag = new ABRDEntiers(-18);
		ABRDEntiers ad = new ABRDEntiers(-12);
		ad = new ABRDEntiers(ag,-16,ad);
		ag = new ABRDEntiers(-25);
		ABRDEntiers a = new ABRDEntiers(ag,-20,ad);
		ad = new ABRDEntiers(-5);
		ag = new ABRDEntiers(ABRVide(),-6,ad);
		ad = new ABRDEntiers(ag,4,ABRVide());
		a = new ABRDEntiers(a,-10,ad);
		return a;
	}

	// tous Positifs
	public static ABRDEntiers ABR5(){
		ABRDEntiers ag = new ABRDEntiers(-18);
		ABRDEntiers ad = new ABRDEntiers(-12);
		ad = new ABRDEntiers(ag,-16,ad);
		ag = new ABRDEntiers(-25);
		ABRDEntiers a = new ABRDEntiers(ag,-20,ad);
		ad = new ABRDEntiers(-5);
		ag = new ABRDEntiers(ABRVide(),-6,ad);
		ad = new ABRDEntiers(ag,-4,ABRVide());
		a = new ABRDEntiers(a,-10,ad);
		return a;
	}

	// ABR vide
	public static ABRDEntiers ABRVide(){
		return new ABRDEntiers();
	}


}

