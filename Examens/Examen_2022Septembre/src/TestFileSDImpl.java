import java.util.Scanner;


public class TestFileSDImpl {
	
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
			
				System.out.println(messageErreur+"\n --> Attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
		
			System.out.println(messageErreur+"\n --> Attendu="+attendu+" recu="+recu);
			System.exit(0);			
		}
	}
	
	public static void main(String[] args) {
		System.out.println("****************************************");
		System.out.println("Programme Test pour la classe FileSDImpl");
		System.out.println("****************************************");
		int choix = 0;
		do {
			System.out.println("1 -> Tester la methode contient()");
			System.out.println("2 -> Tester la methode enfile()");
			System.out.println("3 -> Tester la methode defile()");
			System.out.println("4 -> Tester la methode position()");
			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
				case 1:
					testContient();
					break;
				case 2:
					testEnfile();
					break;
				case 3:
					testDefile();
					break;
				case 4:
					testPosition();
					break;
				default:
					break;
			}
		} while (choix >= 1 && choix <= 4 );
		
	}

	private static void testContient() {
		FileSDImpl<String> f ;
		System.out.println();

		System.out.println();
		System.out.println("test 1 : file testee : marie pierre hugo : contient pierre ?");
		String[] tableTestee1 = {"marie","pierre","hugo"};
		f = new FileSDImpl<String>(tableTestee1);
		try{
			assertEquals("test 1 ko, booleen renvoye ko", true, f.contient("pierre"));
			assertEquals("test 1 ko, la file a ete modifiee", "marie pierre hugo", f.toString());
			System.out.println("test 1 ok");
		}catch(Exception e){
			System.out.println("test 1 ko, il y a eu une exception non prevue.");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println();
		System.out.println("test 2 : file testee : marie pierre hugo : contient sam ?");
		String[] tableTestee2 = {"marie","pierre","hugo"};
		f = new FileSDImpl<String>(tableTestee2);
		try{
			assertEquals("test 2 ko, booleen renvoye ko", false, f.contient("sam"));
			System.out.println("test 2 ok");
		}catch(Exception e){
			System.out.println("test 2 ko, il y a eu une exception non prevue.");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println();
		System.out.println("test 3 : file vide : contient pierre ?");
		try{
			f = new FileSDImpl<>();
			assertEquals("test 3 ko, booleen renvoye ko", false, f.contient("pierre"));
			System.out.println("test 3 ok");
		}catch(Exception e){
			System.out.println("test 3 ko, il y a eu une exception non prevue.");
			e.printStackTrace();
			System.exit(0);
		}


		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();

	}
	
	private static void testEnfile() {
		FileSDImpl<String> f ;
		System.out.println();

		System.out.println();
		System.out.println("test 1 : file testee : marie pierre hugo : enfile sam");
		String[] tableTestee1 = {"marie","pierre","hugo"};
		f = new FileSDImpl<String>(tableTestee1);
		try{
			assertEquals("test 1 ko, booleen renvoye ko", true, f.enfile("sam"));
			assertEquals("test 1 ko, tete ko", "marie", f.premier());
			assertEquals("test 1 ko, queue ko", "sam", f.dernier());
			assertEquals("test 1 ko, contenu ko", "marie pierre hugo sam", f.toString());
			assertEquals("test 1 ko, contenu file ok, mais taille file ko", 4, f.taille());
			System.out.println("test 1 ok");
		}catch(Exception e){
			System.out.println("test 1 ko, il y a eu une exception non prevue.");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println();
		System.out.println("test 2 : file testee : marie pierre hugo : enfile pierre");
		String[] tableTestee2 = {"marie","pierre","hugo"};
		f = new FileSDImpl<String>(tableTestee2);
		try{
			assertEquals("test 2 ko, booleen renvoye ko", false, f.enfile("pierre"));
			assertEquals("test 2 ko, tete ko", "marie", f.premier());
			assertEquals("test 2 ko, queue ko", "hugo", f.dernier());
			assertEquals("test 2 ko, contenu ko", "marie pierre hugo", f.toString());
			assertEquals("test 2 ko, contenu file ok, mais taille file ko", 3, f.taille());
			System.out.println("test 2 ok");
		}catch(Exception e){
			System.out.println("test 2 ko, il y a eu une exception non prevue.");
			e.printStackTrace();
			System.exit(0);
		}


		System.out.println();
		System.out.println("test 3 : file vide : enfile pierre");
		f = new FileSDImpl<>();
		try{
			assertEquals("test 3 ko, booleen renvoye ko", true, f.enfile("pierre"));
			assertEquals("test 3 ko, tete ko", "pierre", f.premier());
			assertEquals("test 3 ko, queue ko", "pierre", f.dernier());
			assertEquals("test 3 ko, contenu ko", "pierre", f.toString());
			assertEquals("test 3 ko, contenu file ok, mais taille file ko", 1, f.taille());
			System.out.println("test 3 ok");
		}catch(Exception e){
			System.out.println("test 3 ko, il y a eu une exception non prevue.");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
	}

	private static void testDefile() {
		FileSDImpl<String> f ;
		System.out.println();

		System.out.println();
		System.out.println("test 1 : file testee : marie pierre hugo lea : defile");
		String[] tableTestee1 = {"marie","pierre","hugo","lea"};
		f = new FileSDImpl<String>(tableTestee1);
		try{
			assertEquals("test 1 ko, element renvoye ko", "marie", f.defile());
			assertEquals("test 1 ko, tete ko", "pierre", f.premier());
			assertEquals("test 1 ko, queue ko", "lea", f.dernier());
			assertEquals("test 1 ko, contenu ko", "pierre hugo lea", f.toString());
			assertEquals("test 1 ko, contenu file ok, mais taille file ko", 3, f.taille());
			System.out.println("test 1 ok");
		}catch(Exception e){
			System.out.println("test 1 ko, il y a eu une exception non prevue.");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println();
		System.out.println("test 2 : file testee : marie : defile");
		String[] tableTestee2 = {"marie"};
		f = new FileSDImpl<String>(tableTestee2);
		try{
			assertEquals("test 2 ko, element renvoye ko", "marie", f.defile());
			assertEquals("test 2 ko, tete ko", null, f.premier());
			assertEquals("test 2 ko, queue ko", null, f.dernier());
			assertEquals("test 2 ko, contenu ko", "", f.toString());
			assertEquals("test 2 ko, contenu file ok, mais taille file ko", 0, f.taille());
			System.out.println("test 2 ok");
		}catch(Exception e){
			System.out.println("test 2 ko, il y a eu une exception non prevue.");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();

		System.out.println("test 3 : file vide : defile");
		f = new FileSDImpl<String>();
		try{
			assertEquals("test 3 ko, element renvoye ko", null, f.defile());
			assertEquals("test 3 ko, tete ko", null, f.premier());
			assertEquals("test 3 ko, queue ko", null, f.dernier());
			assertEquals("test 3 ko, contenu ko", "", f.toString());
			assertEquals("test 3 ko, contenu file ok, mais taille file ko", 0, f.taille());
			System.out.println("test 2 ok");
		}catch(Exception e){
			System.out.println("test 2 ko, il y a eu une exception non prevue.");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
	}

	private static void testPosition() {
		FileSDImpl<String> f ;
		System.out.println();

		System.out.println();
		System.out.println("test 1 : file testee : marie pierre hugo : position pierre ?");
		String[] tableTestee1 = {"marie","pierre","hugo"};
		f = new FileSDImpl<String>(tableTestee1);
		try{
			assertEquals("test 1 ko, position renvoyee ko", 2, f.position("pierre"));
			assertEquals("test 1 ko, la file a ete modifiee", "marie pierre hugo", f.toString());
			System.out.println("test 1 ok");
		}catch(Exception e){
			System.out.println("test 1 ko, il y a eu une exception non prevue.");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println();
		System.out.println("test 2 : file testee : marie pierre hugo : position sam ?");
		String[] tableTestee2 = {"marie","pierre","hugo"};
		f = new FileSDImpl<String>(tableTestee2);
		try{
			assertEquals("test 2 ko, position renvoyee ko", -1, f.position("sam"));
			System.out.println("test 2 ok");
		}catch(Exception e){
			System.out.println("test 2 ko, il y a eu une exception non prevue.");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println();
		System.out.println("test 3 : file testee : marie pierre hugo lea : position lea?");
		String[] tableTestee3 = {"marie","pierre","hugo","lea"};
		f = new FileSDImpl<String>(tableTestee3);
		try{
			assertEquals("test 3 ko, position renvoyee ko", 4, f.position("lea"));
			System.out.println("test 3 ok");
		}catch(Exception e){
			System.out.println("test 3 ko, il y a eu une exception non prevue.");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println();
		System.out.println("test 4 : file testee : marie : position marie ?");
		String[] tableTestee4 = {"marie"};
		f = new FileSDImpl<String>(tableTestee4);
		try{
			assertEquals("test 4 ko, position renvoyee ko", 1, f.position("marie"));
			System.out.println("test 4 ok");
		}catch(Exception e){
			System.out.println("test 4 ko, il y a eu une exception non prevue.");
			e.printStackTrace();
			System.exit(0);
		}


		System.out.println();
		System.out.println("test 5 : file vide : position pierre ?");
		try{
			f = new FileSDImpl<>();
			assertEquals("test 5 ko, position renvoyee ko", -1, f.position("pierre"));
			System.out.println("test 5 ok");
		}catch(Exception e){
			System.out.println("test 5 ko, il y a eu une exception non prevue.");
			e.printStackTrace();
			System.exit(0);
		}


		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();

	}

	/*
	private static void testSupprimerDernier() {
		FileSDImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test1 : file testee : marie pierre hugo sam lea : supprimer dernier");
		String[] tableTestee1 = {"marie","pierre","hugo","sam","lea"};
		l = new FileSDImpl<String>(tableTestee1);
		String dernier = l.supprimerDernier();
		assertEquals(0,"lea",dernier);
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(marie,pierre,hugo,sam)", l.teteQueue());
		assertEquals(3, "(sam,hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test2 : file testee : marie : supprimer dernier");
		String[] tableTestee2 = {"marie"};
		l = new FileSDImpl<String>(tableTestee2);
		dernier = l.supprimerDernier();
		assertEquals(0,"marie",dernier);
		assertEquals(1, 0, l.taille());
		assertEquals(2, "()", l.teteQueue());
		assertEquals(3, "()", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test3 : file vide : supprimer dernier");
		String[] tableTestee3 = {};
		l = new FileSDImpl<String>(tableTestee3);
		dernier = l.supprimerDernier();
		assertEquals(0,null,dernier);
		assertEquals(1, 0, l.taille());
		assertEquals(2, "()", l.teteQueue());
		assertEquals(3, "()", l.queueTete());
		System.out.println("Test ok");


		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();

	}

*/
	/*
	private static void testSupprimer() {
		FileSDImpl<String> l ;
		System.out.println();
		
		System.out.println();
		System.out.println("Test1 : file testee : marie pierre hugo sam lea : supprimer pierre");
		String[] tableTestee1 = {"marie","pierre","hugo","sam","lea"};
		l = new FileSDImpl<String>(tableTestee1);
		assertEquals(0, true, l.supprimer("pierre"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(marie,hugo,sam,lea)", l.teteQueue());
		assertEquals(3, "(lea,sam,hugo,marie)", l.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test2 : file testee : marie pierre hugo sam lea : supprimer lea");
		String[] tableTestee2 = {"marie","pierre","hugo","sam","lea"};
		l = new FileSDImpl<String>(tableTestee2);
		assertEquals(0, true, l.supprimer("lea"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(marie,pierre,hugo,sam)", l.teteQueue());
		assertEquals(3, "(sam,hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test3 : file testee : marie pierre hugo sam lea : supprimer marie");
		String[] tableTestee3 = {"marie","pierre","hugo","sam","lea"};
		l = new FileSDImpl<String>(tableTestee3);
		assertEquals(0, true, l.supprimer("marie"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(pierre,hugo,sam,lea)", l.teteQueue());
		assertEquals(3, "(lea,sam,hugo,pierre)", l.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test4 : file testee : marie pierre hugo sam lea : supprimer tom");
		String[] tableTestee4 = {"marie","pierre","hugo","sam","lea"};
		l = new FileSDImpl<String>(tableTestee4);
		assertEquals(0, false, l.supprimer("tom"));
		assertEquals(1, 5, l.taille());
		assertEquals(2, "(marie,pierre,hugo,sam,lea)", l.teteQueue());
		assertEquals(3, "(lea,sam,hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test5 : file testee : marie : supprimer marie");
		String[] tableTestee5 = {"marie"};
		l = new FileSDImpl<String>(tableTestee5);
		assertEquals(0, true, l.supprimer("marie"));
		assertEquals(1, 0, l.taille());
		assertEquals(2, "()", l.teteQueue());
		assertEquals(3, "()", l.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test6 : file vide : supprimer marie");
		String[] tableTestee6 = {};
		l = new FileSDImpl<String>(tableTestee6);
		assertEquals(0, false, l.supprimer("marie"));
		assertEquals(1, 0, l.taille());
		assertEquals(2, "()", l.teteQueue());
		assertEquals(3, "()", l.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();
		
		
	}
	
	 */
/*
	private static void testInsererEnTete() {
		FileSDImpl<String> l ;
		System.out.println();
		
		System.out.println();
		System.out.println("Test1 : file testee : marie pierre hugo : insererEnTete tom ?");
		String[] tableTestee1 = {"marie","pierre","hugo"};
		l = new FileSDImpl<String>(tableTestee1);
		assertEquals(0, true, l.insererEnTete("tom"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(tom,marie,pierre,hugo)", l.teteQueue());
		assertEquals(3, "(hugo,pierre,marie,tom)", l.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test1 : file testee : marie pierre hugo : insererEnTete pierre ?");
		String[] tableTestee2 = {"marie","pierre","hugo"};
		l = new FileSDImpl<String>(tableTestee2);
		assertEquals(0, false, l.insererEnTete("pierre"));
		assertEquals(1, 3, l.taille());
		assertEquals(2, "(marie,pierre,hugo)", l.teteQueue());
		assertEquals(3, "(hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test3 : file testee : file vide : insererEnTete tom ?");
		String[] tableTestee3 = {};
		l = new FileSDImpl<String>(tableTestee3);
		assertEquals(0, true, l.insererEnTete("tom"));
		assertEquals(1, 1, l.taille());
		assertEquals(2, "(tom)", l.teteQueue());
		assertEquals(3, "(tom)", l.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();
		
	}
*/

	
}
