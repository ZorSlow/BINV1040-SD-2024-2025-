import java.util.Arrays;
import java.util.HashSet;

public class Parking {

	private HashSet<Voiture> ensembleVoitures;

	// construit un ensembleVoitures vide
	public Parking(){
		// TODO
		ensembleVoitures = new HashSet<>();
	}

	/**
	 * ajoute la voiture dans l ensemble des voitures autorisees
	 * @param voiture la voiture autorisee
	 * @return true si la voiture etait pas encore presente, false sinon
	 *
	 */
	public boolean ajouterVoiture(Voiture voiture) {
		// TODO
			return ensembleVoitures.add(voiture);
	}
	
	/**
	 * verifie si la voiture est presente dans l ensemble des voitures autorisees
	 * @param voiture la voiture a verifier
	 * @return true si la voiture est presente, false sinon
	 */
	public boolean voitureAutorisee(Voiture voiture){
		// TODO
		if (voiture == null)throw new IllegalArgumentException();
		return ensembleVoitures.contains(voiture);
	}

	/**
	 * retire la voiture de l ensemble des voitures autorisees
	 * @param voiture la voiture non autorisee
	 * @return true si la voiture etait presente, false sinon
	 */
	public boolean retirerVoiture(Voiture voiture){
		// TODO
		if (voiture == null)throw new IllegalArgumentException();
		return ensembleVoitures.remove(voiture);
	}


	/**
	 * remplit une table avec les plaques des voitures autorisees
	 * cette table doit etre triee par ordre alphabetique
	 * @return une table avec les plaques de voitures autorisees
	 */
	public String[] tableTrieePlaques() {
		//TODO

		// piste la classe Arrays possede une methode static sort
		// qui trie la table passee en parametre !
		String[] tableTrieePlaques = new String[ensembleVoitures.size()];
		int i = 0;
		for (Voiture voiture : ensembleVoitures){
			tableTrieePlaques[i++] = voiture.getNumPlaque();
		}
		Arrays.sort(tableTrieePlaques);
		return tableTrieePlaques;


	}

	//Pour les tests : (A NE PAS MODIFIER, VA SERVIR POUR LES TESTS)
	@Override
	public String toString() {
		return ensembleVoitures.toString();
	}
}