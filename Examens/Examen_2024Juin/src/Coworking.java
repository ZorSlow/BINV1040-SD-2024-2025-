import java.util.*;


public class Coworking {

	// suivez l'implementation imposee dans l'enonce
	// n'ajoutez pas d'autres attributs

	private String[] tableBureaux;
	private HashMap<String, HashSet<Integer>> mapSocietes;
	private static final int MAX = 3; //nombre max de bureaux par societe

	/**
	 * initialise un espace de coworking
	 * @param nombreBureaux le nombre de bureaux
	 * @param tableSocietes la table des societes contributaires
	 * @throws IllegalArgumentException : il faut au moins un bureau et une societe
	 */
	public Coworking(int nombreBureaux, String[] tableSocietes){
		//TODO
		if (nombreBureaux <= 0 || tableSocietes == null || tableSocietes.length == 0)
			throw new IllegalArgumentException("Paramètres invalides");

		tableBureaux = new String[nombreBureaux];
		mapSocietes = new HashMap<>();

		for (String s : tableSocietes) {
			if (s == null || s.isEmpty())
				throw new IllegalArgumentException("Nom de société invalide");
			mapSocietes.put(s, new HashSet<>()); // les doublons se recouvrent, OK
		}

	}
	
	/**
	 * attribue le bureau qui porte le numero passe en parametre a la societe passee en parametre
	 * L'attribution reussit si
	 *     le bureau est libre
	 *     la societe fait partie des societes contributaires
	 *     la societe n'a pas encore MAX bureaux
	 * @param societe la societe qui demande un bureau
	 * @param numeroBureau le numero du bureau souhaite
	 * @return true si l'attribution a reussi, false sinon
	 * @throws IllegalArgumentException si la societe est null et/ou si le numero de bureau n'existe pas
	 */
	public boolean attribuer(String societe,int numeroBureau){

		//TODO
		if(societe == null || numeroBureau <0  || numeroBureau >tableBureaux.length)throw new IllegalArgumentException("la societe est null et/ou si le numero de bureau n'existe pas");
		//bureau libre ?
		if (tableBureaux[numeroBureau] != null)
			return false;
		//societe contributaire ?
		if (!mapSocietes.containsKey(societe))
			return false;
		//societe à moins de max de bureaux ?
		HashSet<Integer> bureaux = mapSocietes.get(societe);
		if (bureaux.size() >= MAX)
			return false;
		//attribuer
		tableBureaux[numeroBureau] = societe;
		bureaux.add(numeroBureau);
		return true;
	}

	/**
	 * libere le bureau qui porte le numero passe en parametre
	 * @param numeroBureau le numero du bureau libere
	 * @return true si la liberation a reussi (le bureau etait bien occupe), false sinon
	 * @throws IllegalArgumentException si le numero de bureau n'existe pas
	 */
	public boolean liberer(int numeroBureau){
		//TODO
		if (numeroBureau < 0 || numeroBureau >= tableBureaux.length)throw new IllegalArgumentException("le numero de bureau n'existe pas");
		if (tableBureaux[numeroBureau] == null)
			return false;
		String societe = tableBureaux[numeroBureau];
		tableBureaux[numeroBureau]  = null;
		mapSocietes.get(societe).remove(numeroBureau);
		return true;

	}

	/**
	 * renvoie une table avec les numeros des bureaux occupes par la societe passee en parametre
	 * cette table doit etre triee selon l'ordre croissant des numeros
	 * cette table pourrait etre vide
	 * @param societe la societe
	 * @return une table avec des numeros des bureaux
	 * @throws IllegalArgumentException si la societe est null
	 */
	public int[] occupationsSociete(String societe) {

		// TODO
		if (societe == null) throw new IllegalArgumentException("societe est null");

		HashSet<Integer> bureaux = mapSocietes.get(societe);
		if (bureaux == null || bureaux.isEmpty())
			return new int[0];
		int[] list = new int[bureaux.size()];
		int i = 0;
		for (int n : bureaux)
			list[i++] = n;
		// Pour trier la table, utilisez la methode static sort() de la classe Arrays
		Arrays.sort(list);
		return list;
	}


	
	/**
	 * renvoie, sous forme d'une chaine de caracteres, l'occupation des bureaux
	 */
	public String toString(){

		// CETTE METHODE NE SERA PAS EVALUEE

		// vous pouvez modifier cette methode comme vous voulez
		// ne perdez pas de temps sur des affichages!

		if(tableBureaux ==null)
			return "attention tableBureaux est null";
		if(mapSocietes==null)
			return "attention mapSocietes est null";
		return "tableBureaux :\n"+ Arrays.toString(tableBureaux)+"\nmapSocietes :\n"+mapSocietes.toString();

	}

}
