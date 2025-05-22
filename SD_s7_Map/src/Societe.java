import java.util.HashSet;

public class Societe {

	private int numeroSociete;
	private String nom;
	private HashSet<Integer> lesHangars;
	private HashSet<String> ensembleVoitureAutorisee;


	/**
	 * construit une societe sans hangar
	 * @param numeroSociete son numero
	 * @param nom son nom
	 * @throws IllegalArgumentException si le numero de la societe est negatif ou nul
	 *                                  si le nom est null ou ""
	 */
	public Societe(int numeroSociete, String nom) {
		if(numeroSociete<=0)
			throw new IllegalArgumentException();
		if(nom == null || nom.equals(""))
			throw new IllegalArgumentException();
		//TODO
		lesHangars = new HashSet<>();
		this.nom = nom;
		this.numeroSociete = numeroSociete;

	}


	/**
	 * ajoute un hangar si celui-ci n'y est pas encore
	 * @param numeroHangar le numero du hangar ajoute
	 * @return
	 */
	public boolean ajouterHangar(int numeroHangar){
		// TODO
		if (!lesHangars.contains(numeroHangar)){
			lesHangars.add(numeroHangar);
			return true;
		}
		return false;
	}

	/**
	 * supprime un hangar si celui-ci n'y est pas encore
	 * @param numeroSociete le numero du hangar supprimer
	 * @return
	 */
	public boolean retirerHangar(int numeroSociete){
		if (!lesHangars.contains(numeroSociete)){
			lesHangars.remove(numeroSociete);
			return true;
		}
		return false;
	}


	/**
	 * renvoie un String avec les hangars occupes par la societe
	 * @return
	 */
	public String lesHangars() {
		return lesHangars.toString();
		// A NE PAS MODIFIER --> VA SERVIR POUR LES TESTS
	}
	/**
	 * ajoute une plaque à un ensemble
	 * @param plaque à ajouter
	 * @return true si la plaque a été ajouter
	 */
	public boolean ajouterVoiture(String plaque){
		return ensembleVoitureAutorisee.add(plaque);
	}

	/**
	 *
	 * @param plaque
	 * @return
	 */
	public boolean retirerVoiture(String plaque){
		return ensembleVoitureAutorisee.remove(plaque);
	}
	public int getNumeroSociete() {
		return numeroSociete;
	}

	public String getNom() {
		return nom;
	}


	@Override
	public String toString() {
		return "Societe [numeroSociete=" + numeroSociete + ", nom=" + nom
				+ ", lesHangars=" + lesHangars + "]";
	}


	@Override
	public int hashCode() {
		return numeroSociete;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Societe other = (Societe) obj;
		if (numeroSociete != other.numeroSociete)
			return false;
		return true;
	}











}