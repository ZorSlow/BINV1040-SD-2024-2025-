import java.util.HashMap;
import java.util.HashSet;

public class FeteNationale{

	
	private HashMap<String, Noeud> mapNomNoeud;
	private Noeud premierNoir; 
	private Noeud premierJaune;
	private Noeud premierRouge;
	
	// N'ajoutez pas d'autres attributs
		

	// A ne pas changer	
	/**
	 * Le constructeur construit une liste qui contient 3 participants de 3 couleurs differentes
	 * @param nomNoir le nom du premier participant noir
	 * @param nomJaune le nom du premier participant jaune
	 * @param nomRouge le nom du premier participant rouge
	 */
	public FeteNationale(String nomNoir, String nomJaune, String nomRouge){
		mapNomNoeud = new HashMap<String, Noeud>();
		premierNoir = new Noeud(nomNoir);
		premierJaune = new Noeud(nomJaune);
		premierRouge = new Noeud(nomRouge);
		premierNoir.suivant=premierJaune;
		premierJaune.precedent=premierNoir;
		premierJaune.suivant= premierRouge;
		premierRouge.precedent=premierJaune;
		mapNomNoeud.put(nomNoir, premierNoir);
		mapNomNoeud.put(nomJaune, premierJaune);
		mapNomNoeud.put(nomRouge, premierRouge);
	}
	
	 
	// A ne pas changer, va servir pour les tests
	public String toString(){
		String aRenvoyer = "";
		Noeud baladeur = premierNoir;
		int cpt = 0;
		while(baladeur!=null){
			aRenvoyer += " "+baladeur.nom;
			baladeur = baladeur.suivant;
			cpt++;
			if(cpt==100)
				return "boucle infinie";			
		}
		return aRenvoyer;
	}
	
	
	/**
	 * ajoute un participant dans la liste en fonction de sa couleur
	 * apres ajout la liste doit toujours etre triee par couleur
	 * @param nom le nom du participant a ajouter
	 * @param couleur la couleur du participant a ajouter (n,j ou r)
	 * @throws IllegalArgumentException si le nom est null ou vide et/ou si la couleur n'est pas valide 
	 * @throws DejaPresentException si le participant est deja present dans la liste
	 * 
	 */

	public void ajouterParticipant(String nom, char couleur) {
		// Validation (inchangée)
		if (nom == null || nom.isEmpty() ||
				(couleur != 'n' && couleur != 'j' && couleur != 'r'))
			throw new IllegalArgumentException();
		if (mapNomNoeud.containsKey(nom))
			throw new DejaPresentException();

		Noeud nouveau = new Noeud(nom);
		mapNomNoeud.put(nom, nouveau);

		if (couleur == 'n') {
			nouveau.suivant = premierNoir;
			if (premierNoir != null)
				premierNoir.precedent = nouveau;
			premierNoir = nouveau;

			// Lier au jaune si dernier noir
			if (nouveau.suivant == null || donnerCouleur(nouveau.suivant.nom) != 'n') {
				nouveau.suivant = premierJaune;
				if (premierJaune != null)
					premierJaune.precedent = nouveau;
			}
		}
		else if (couleur == 'j') {
			// SOLUTION CLÉ POUR j2:
			// 1. Sauvegarder le précédent lien noir→jaune
			Noeud ancienLienNoirJaune = (premierJaune != null) ? premierJaune.precedent : null;

			// 2. Insérer le nouveau jaune
			nouveau.suivant = premierJaune;
			if (premierJaune != null)
				premierJaune.precedent = nouveau;
			premierJaune = nouveau;

			// 3. Mettre à jour le lien noir→jaune
			if (ancienLienNoirJaune != null) {
				ancienLienNoirJaune.suivant = premierJaune;
				premierJaune.precedent = ancienLienNoirJaune;
			} else if (premierNoir != null) {
				// Cas du premier jaune ajouté
				Noeud dernierNoir = premierNoir;
				while (dernierNoir.suivant != null && donnerCouleur(dernierNoir.suivant.nom) == 'n') {
					dernierNoir = dernierNoir.suivant;
				}
				dernierNoir.suivant = premierJaune;
				premierJaune.precedent = dernierNoir;
			}

			// Lier au rouge si dernier jaune
			if (nouveau.suivant == null || donnerCouleur(nouveau.suivant.nom) != 'j') {
				nouveau.suivant = premierRouge;
				if (premierRouge != null)
					premierRouge.precedent = nouveau;
			}
		}
		else { // couleur == 'r'
			nouveau.suivant = premierRouge;
			if (premierRouge != null)
				premierRouge.precedent = nouveau;
			premierRouge = nouveau;

			// Lier depuis le dernier jaune
			if (premierJaune != null) {
				Noeud dernierJaune = premierJaune;
				while (dernierJaune.suivant != null && donnerCouleur(dernierJaune.suivant.nom) == 'j') {
					dernierJaune = dernierJaune.suivant;
				}
				dernierJaune.suivant = premierRouge;
				premierRouge.precedent = dernierJaune;
			}
		}

	}
	
	
	/**
	 * renvoie la couleur du participant
	 * @param nom le nom du participant recherche
	 * @return une couleur
	 * @throws IllegalArgumentException si le nom est null ou vide
	 * @throws NonPresentException si le participant ne se trouve pas dans la liste
	 */
	public char donnerCouleur(String nom){
		
		// TODO
		// Indication : partez du participant et revenez en arriere dans le chainage
		Noeud n = mapNomNoeud.get(nom);
		if (n == null) throw new NonPresentException();
		Noeud cur = n;
		while (cur != premierNoir && cur != premierJaune && cur != premierRouge) {
			cur = cur.precedent;
		}
		if (cur == premierNoir)  return 'n';
		if (cur == premierJaune) return 'j';
		return 'r';

	}
	
	

	// Classe interne Noeud
	private class Noeud{
		
		private Noeud precedent;
		private String nom;
		private Noeud suivant;
		
		public Noeud(String nom) {
			this.nom = nom;
		}

		public Noeud(Noeud precedent, String nom, Noeud suivant) {
			this.nom = nom;
			this.precedent = precedent;
			this.suivant = suivant;
		}		
	}
}
