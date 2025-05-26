import java.util.*;

public class Guignol {
	
	// suivez l'implementation imposee dans l'enonce
	// vous ne pouvez pas ajouter d'autres attributs ou modifier ceux presents

	public static int MAX = 4; //nombre max de reservations par enfant
	private String[] tableReservations; //table des reservations
	private HashMap<String, ArrayList<Integer>> mapEnfants; //cle = enfant, valeur = liste de ses places

	/**
	 * initialise un spectacle de guignol
	 * @param nombreTotalPlaces le nombre total de places disponibles
	 * @throws IllegalArgumentException : il faut au moins une place
	 */
	public Guignol(int nombreTotalPlaces){
		if(nombreTotalPlaces<=0)
			throw new IllegalArgumentException();
		tableReservations = new String[nombreTotalPlaces];
		mapEnfants = new HashMap<String,ArrayList<Integer>>();
	}


	private boolean tableValide(int[] tablePlacesDemandees){

		// methode private appelee par la methode reserver()
		// la table doit contenir au moins un numero de place
		// tous les numeros de place doivent exister
		// (a ce stade, on ne verifie pas si les places sont libres, uniquement si elles existent
		// par exemple, il n'existe pas de place qui porte le n? -1)
		// tous les numeros doivent etre differents (pas de doublons)


		//TODO
		if (tablePlacesDemandees.length == 0)
			return false;
		HashSet<Integer> set =new HashSet<>();
		for (int place : tablePlacesDemandees){
			// verifier que la place existe
			if (place <0 || place>= tableReservations.length)
				return  false;
			//Verifier les doublons
			set.add(place);
		}
		// si doublons, la taille du set sera plus petite que celle du tableau

		return set.size() == tablePlacesDemandees.length;

		// Pour verifier la presence de doublons dans la table des places demandees :
		// Utilisez en local un HashSet<Integer> et placez-y les numeros de places.
		// Il y a des doublons si la taille de l'ensemble obtenu n'est pas la meme que celle de la table
		// Dans un ensemble, chaque element est unique !

		// conseil : ecrivez cette methode apres vous etes assure que la methode reserver() fonctionne
		// dans le cas ou il n'y a pas d'IllegalArgumentException



	}


	/**
	 * reserve une ou plusieurs places
	 * c'est du tout ou rien !
	 * un enfant peut faire plusieurs fois la demarche de reserver
	 * la reservation reussit si toutes les places demandees sont libres
	 *                     et si le nombre MAX de places n'est pas atteint
	 * @param prenom le prenom de l'enfant qui demande des places
	 * @param tablePlacesDemandees la table avec les numeros des places demandees
	 * @return true si la reservation a reussi, false sinon
	 * @throws IllegalArgumentException si le prenom est null ou vide
	 *                                  ou si la table est null ou non valide
	 */
	public boolean reserver(String prenom, int[] tablePlacesDemandees) {

		if (prenom == null || prenom.equals(""))
			throw new IllegalArgumentException();
		if (tablePlacesDemandees == null)
			throw new IllegalArgumentException();
		if (!tableValide(tablePlacesDemandees))
			throw new IllegalArgumentException();

		// TODO
		ArrayList<Integer> listePrenom;
		if (mapEnfants.containsKey(prenom)){
			listePrenom = mapEnfants.get(prenom);
		}else {
			listePrenom = new ArrayList<>();
		}

		//Verifier que le total de depasse pas le max
		if (listePrenom.size() + tablePlacesDemandees.length > MAX)
			return false;
		// Verifier que tous les places demandés sont libres
		for (int place : tablePlacesDemandees) {
			if (tableReservations[place] != null)
				return false;
		}
		// Reserver les places
		for (int place : tablePlacesDemandees) {
			tableReservations[place] = prenom;
			listePrenom.add(place);
		}
		// mettre à jour map
		mapEnfants.put(prenom,listePrenom);
		return true;
	}

	/**
	 * renvoie une table contenant les places reservees par un enfant
	 * cette table doit etre triee selon l'ordre croissant des numeros de place
	 * la table est de dimension zero si l'enfant n'a aucune reservation
	 * @param prenom le prenom de l'enfant
	 * @return la table avec les places reservees par l'enfant
	 * @throws IllegalArgumentException si le prenom est null ou vide
	 */
	public int[] placesReservees (String prenom) {

		if (prenom == null || prenom.equals(""))
			throw new IllegalArgumentException();

		//TODO
		ArrayList<Integer> list = mapEnfants.get(prenom);
		if (mapEnfants.get(prenom).isEmpty())
			return new int[0];
		int [] placesReserve = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			placesReserve[i] = list.get(i);

		}
		Arrays.sort(placesReserve);
		return placesReserve;

		// Pour trier la table, utilisez la methode static sort() de la classe Arrays

	}

	/**
	 * renvoie la table des reservations et le map
	 */
	public String toString(){
		// vous pouvez modifier cette methode comme vous voulez
		// MAIS cette methode ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		if(tableReservations ==null)
			return "attention table des reservations est null";
		if(mapEnfants==null)
			return "attention mapEnfants est null";
		return "table des reservations :\n"+Arrays.toString(tableReservations)+"\nmapEnfants :\n"+mapEnfants.toString();
	}
	
}
