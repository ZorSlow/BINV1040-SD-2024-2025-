import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author 													-------> METTEZ ICI VOS NOM ET PRENOM
 *
 *
 */

public class Entrepot {

	//TODO
	private Hangar[] tableHangars;
	private HashMap<Integer, Societe> mapSocietes;
	private int nombreHangars;
	private int nombreHangarsLibres;
	private HashSet<String> ensembleToutesLesPlaques;
	private int nombreHangarsSocietes;


	/**
	 * construit un entrepot contenant nombreHangars
	 * @param nombreHangars le nombre d'hangars
	 * @throws IllegalArgumentException si le nombre d'hangars est negatif ou nul
	 */
	public Entrepot(int nombreHangars) {
		if(nombreHangars<=0)
			throw new IllegalArgumentException();
		// TODO
		this.nombreHangars = nombreHangars;
		this.nombreHangarsLibres = nombreHangars;

		mapSocietes = new HashMap<>();
		tableHangars = new  Hangar[nombreHangars];
		ensembleToutesLesPlaques = new HashSet<>();
		for (int i = 0; i < nombreHangars; i++) {
			tableHangars[i] = new Hangar(i);
		}

	}

	/**
	 * renvoie le nombre d'hangars libres
	 * @return le nombre d'hangars libres
	 */
	public int nombreHangarsLibres(){
		//TODO
		return nombreHangarsLibres;

	}


	/**
	 * renvoie le nombre de societes presentes
	 * @return le nombre de societes presentes
	 */
	public int nombreSocietesPresentes(){
		//TODO
		return mapSocietes.size();

	}

	/**
	 * renvoie la societe dont le numero est passe en parametre
	 * @param numeroSociete le numero de la societe
	 * @return la societe recherchee ou null si aucune societe presente ne possede ce numero
	 */
	public Societe getSociete(int numeroSociete){
		//TODO
		return  mapSocietes.get(numeroSociete);
	}

	/**
	 * attribue un hangar a la societe passee en parametre
	 * Si l'attribution a pu se faire :
	 * la societe est enregistree comme presente (si pas encore presente)
	 * le hangar lui est ajoute
	 * @param numeroSociete le numero de la societe
	 * @param nomSociete le nom de la societe
	 * @return le numero du hangar attribue ou -1 s'il n'y en a plus de libre
	 */
	public int attribuerHangar(int numeroSociete, String nomSociete) {
		// TODO
		if (nombreHangarsLibres == 0) return -1;

		Societe societe = mapSocietes.get(numeroSociete);
		if (societe == null) {
			societe = new Societe(numeroSociete, nomSociete);
			mapSocietes.put(numeroSociete, societe);
		}

		int numHangar = numeroSociete % tableHangars.length;

		for (int i = 0; i < tableHangars.length; i++) {
			int index = (numHangar + i) % tableHangars.length;
			if (tableHangars[index].getSociete() == null) {
				tableHangars[index].setSociete(societe);
				societe.ajouterHangar(index);
				nombreHangarsLibres--;
				return index;
			}
		}

		// Aucun hangar libre trouvé (devrait pas arriver si nombreHangarsLibres > 0)
		return -1;
	}
		// Pour une meilleure repartition des hangars occupes dans l'entrepot,
		// veuillez suivre les indications donnees dans l'enonce!


		public boolean libererHangar(int numeroHangar) {
			if (numeroHangar < 0 || numeroHangar >= tableHangars.length) {
				System.out.println("numero de hangar incorrect");
				return false;
			}

			if (tableHangars[numeroHangar].getSociete() == null)
				return false;

			int numeroSociete = tableHangars[numeroHangar].getSociete().getNumeroSociete();
			mapSocietes.get(numeroSociete).retirerHangar(numeroHangar);
			tableHangars[numeroHangar].setSociete(null);
			nombreHangarsLibres++; // N'oublie pas de l'incrémenter ici !
			return true;
		}
	/**
	 * ajoute une plaque pour une société
	 * @param numeroSociete la société à laquelle il faut ajouter la plaque
	 * @param plaque la plaque qu'il faut ajouter à la société
	 * @return true si la plaque a été ajouter, false sinon
	 */
	public boolean ajouterPlaque(int numeroSociete, String plaque){
		Societe s = mapSocietes.get(numeroSociete);
		if (s != null && plaque != null && !plaque.isEmpty()) {
			// Vérifie si la plaque existe déjà
			if (!ensembleToutesLesPlaques.contains(plaque)) {
				ensembleToutesLesPlaques.add(plaque);
				s.ajouterVoiture(plaque);
				return true;
			}
		}
		return false;
	}


	/**
	 * vérifie si une plaque est autorisée
	 * @param numPlaque la plaque a vérifié
	 * @return true si la plaque est autorisée
	 */
	public boolean estAutorisee(String numPlaque){
		return ensembleToutesLesPlaques.contains(numPlaque);
	}
	}
	


