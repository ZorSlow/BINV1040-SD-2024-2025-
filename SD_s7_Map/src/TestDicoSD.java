public class TestDicoSD {

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
				System.out.println(messageErreur+" attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+" attendu="+attendu+" recu="+recu);
			System.exit(0);			
		}
	}
	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("Programme Test pour la classe DicoSD");
		System.out.println("************************************");
		System.out.println();
		System.out.println("Les tests suivent un scenario : ");

		DicoSD dico = new DicoSD();

		System.out.println();
		System.out.println("Test 1 : Au depart le dico est vide");

		try {
			System.out.print("On verifie la presence de la SD pile (appel de la methode contient()");
			assertEquals("Test ko : le dico est vide : booleen renvoye ko : ",false, dico.contient("pile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			System.out.println("Revoyez votre constructeur et la methode contient()");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("On demande les urls de la SD pile (appel de la methode lesURLs()");
			assertEquals("Test ko : le dico est vide : String renvoye ko : ", "[]", dico.lesURLs("pile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("On essaye de supprimer l'url urlPile de la SD pile (appel de la methode supprimer()");
			assertEquals("Test ko : le dico est vide : booleen renvoye ko : ", false, dico.supprimer("pile","urlPile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		System.out.println("Test 1 ok");

		System.out.println();
		System.out.println("Test 2 : Ajout du lien pile - urlPile1 dans le dico qui est vide");
		try {
			System.out.print("On ajoute le lien pile - urlPile1 (appel de la methode ajouter()");
			assertEquals("Test ko : booleen renvoye ko ",true,dico.ajouter("pile", "urlPile1"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres ajout, on verifie la presence de la SD pile (appel de la methode contient()");
			assertEquals("Test ko : booleen renvoye ko ", true, dico.contient("pile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres ajout, on demande les urls de la SD pile (appel de la methode lesURLs()");
			assertEquals("Test ko : String renvoye ko : ", "[urlPile1]", dico.lesURLs("pile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		System.out.println("Test 2 ok");

		System.out.println();
		System.out.println("Test 3 : Ajout du lien pile - urlPile2 dans le dico qui contient pile - urlPile1");
		try {
			System.out.print("On ajoute le lien pile - urlPile2 (appel de la methode ajouter()");
			assertEquals("Test ko : booleen renvoye ko ",true,dico.ajouter("pile", "urlPile2"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres ajout, on verifie la presence de la SD pile (appel de la methode contient()");
			assertEquals("Test ko : booleen renvoye ko ", true, dico.contient("pile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres ajout, on demande les urls de la SD pile (appel de la methode lesURLs()");
			assertEquals("Test ko :  String renvoye ko : ", "[urlPile1, urlPile2]", dico.lesURLs("pile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		System.out.println("Test 3 ok");

		System.out.println();
		System.out.println("Test 4 : Ajout du lien pile - urlPile2 qui existe deja dans le dico");
		try {
			System.out.print("On ajoute le lien pile - urlPile2 (appel de la methode ajouter()");
			assertEquals("Test ko : booleen renvoye ko ",false,dico.ajouter("pile", "urlPile2"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres ajout, on verifie la presence de la SD pile (appel de la methode contient()");
			assertEquals("Test ko : booleen renvoye ko ", true, dico.contient("pile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres ajout, on demande les urls de la SD pile (appel de la methode lesURLs()");
			assertEquals("Test ko :  String renvoye ko : ", "[urlPile1, urlPile2]", dico.lesURLs("pile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		System.out.println("Test 4 ok");

		System.out.println();
		System.out.println("Test 5 : Ajout du lien pile - urlPile1 qui existe deja dans le dico");
		try {
			System.out.print("On ajoute le lien pile - urlPile1 (appel de la methode ajouter()");
			assertEquals("Test ko : booleen renvoye ko ",false,dico.ajouter("pile", "urlPile1"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres ajout, on verifie la presence de la SD pile (appel de la methode contient()");
			assertEquals("Test ko : booleen renvoye ko ", true, dico.contient("pile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres ajout, on demande les urls de la SD pile (appel de la methode lesURLs()");
			assertEquals("Test ko :  String renvoye ko : ", "[urlPile1, urlPile2]", dico.lesURLs("pile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		System.out.println("Test 5 ok");

		System.out.println();
		System.out.println("Test 6 : Ajout du lien ensemble - urlQcq");
		System.out.println("Le dico contient pile - urlPile1 et pile - urlPile1");
		try {
			System.out.print("On ajoute le lien ensemble - urlEnsemble1 (appel de la methode ajouter()");
			assertEquals("Test ko : booleen renvoye ko ",true,dico.ajouter("ensemble", "urlQcq"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres ajout, on verifie la presence de la SD ensemble (appel de la methode contient()");
			assertEquals("Test ko : booleen renvoye ko ", true, dico.contient("ensemble"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres ajout, on demande les urls de la SD ensemble (appel de la methode lesURLs()");
			assertEquals("Test ko :  String renvoye ko : ", "[urlQcq]", dico.lesURLs("ensemble"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		System.out.println("Test 6 ok");

		System.out.println();
		System.out.println("Test 7 : Suppression du lien pile - urlPile1 qui existe dans le dico");
		System.out.println("Le dico contient pile - urlPile1 et pile - urlPile2 et ensemble - urlQcq");
		try {
			System.out.print("On supprime le lien pile - urlPile1 (appel de la methode supprimer()");
			assertEquals("Test ko : booleen renvoye ko ",true,dico.supprimer("pile", "urlPile1"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres suppression, on verifie la presence de la SD pile (appel de la methode contient()");
			assertEquals("Test ko : booleen renvoye ko ", true, dico.contient("pile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres suppression, on demande les urls de la SD pile (appel de la methode lesURLs()");
			assertEquals("Test ko :  String renvoye ko : ", "[urlPile2]", dico.lesURLs("pile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		System.out.println("Test 7 ok");

		System.out.println();
		System.out.println("Test 8 : Suppression du lien pile - urlPile1 qui n'existe plus dans le dico");
		System.out.println("Le dico contient pile - urlPile2 et ensemble - urlQcq");
		try {
			System.out.print("On supprime le lien pile - urlPile1 (appel de la methode supprimer()");
			assertEquals("Test ko : booleen renvoye ko ",false,dico.supprimer("pile", "urlPile1"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres suppression, on verifie la presence de la SD pile (appel de la methode contient()");
			assertEquals("Test ko : booleen renvoye ko ", true, dico.contient("pile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres suppression, on demande les urls de la SD pile (appel de la methode lesURLs()");
			assertEquals("Test ko :  String renvoye ko : ", "[urlPile2]", dico.lesURLs("pile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		System.out.println("Test 8 ok");

		System.out.println();
		System.out.println("Test 9 : Suppression du lien pile - urlPile2 qui existe dans le dico");
		System.out.println("Le dico contient pile - urlPile2 et ensemble - urlQcq");
		try {
			System.out.print("On supprime le lien pile - urlPile1 (appel de la methode supprimer()");
			assertEquals("Test ko : booleen renvoye ko ",true,dico.supprimer("pile", "urlPile2"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres suppression, on verifie la presence de la SD pile (appel de la methode contient()");
			assertEquals("Test ko : booleen renvoye ko ", false, dico.contient("pile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres suppression, on demande les urls de la SD pile (appel de la methode lesURLs()");
			assertEquals("Test ko :  String renvoye ko : ", "[]", dico.lesURLs("pile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		System.out.println("Test 9 ok");

		System.out.println();
		System.out.println("Test 10 : Ajout du lien vecteur - urlQcq dans le dico qui contient ensemble - urlQcq");
		try {
			System.out.print("On ajoute le lien vecteur - urlQcq (appel de la methode ajouter()");
			assertEquals("Test ko : booleen renvoye ko ",true,dico.ajouter("vecteur", "urlQcq"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres ajout, on verifie la presence de la SD vecteur (appel de la methode contient()");
			assertEquals("Test ko : booleen renvoye ko ", true, dico.contient("vecteur"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres ajout, on demande les urls de la SD vecteur (appel de la methode lesURLs()");
			assertEquals("Test ko :  String renvoye ko : ", "[urlQcq]", dico.lesURLs("vecteur"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		System.out.println("Test 10 ok");

		System.out.println();
		System.out.println("Test 11 : Ajout du lien pile - urlQcq dans le dico qui contient vecteur - urlQcq et ensemble - urlQcq");
		try {
			System.out.print("On ajoute le lien pile - urlQcq (appel de la methode ajouter()");
			assertEquals("Test ko : booleen renvoye ko ",true,dico.ajouter("pile", "urlQcq"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres ajout, on verifie la presence de la SD pile (appel de la methode contient()");
			assertEquals("Test ko : booleen renvoye ko ", true, dico.contient("pile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		try {
			System.out.print("Apres ajout, on demande les urls de la SD pile (appel de la methode lesURLs()");
			assertEquals("Test ko :  String renvoye ko : ", "[urlQcq]", dico.lesURLs("pile"));
			System.out.println(" : ok");
		}catch (Exception e){
			System.out.println("Attention, il y a eu une exception inattendue");
			e.printStackTrace();
			return;
		}
		System.out.println("Test 11 ok");


		System.out.println();
		System.out.println("Le scenario de tests propose a reussi!");
	}

}
