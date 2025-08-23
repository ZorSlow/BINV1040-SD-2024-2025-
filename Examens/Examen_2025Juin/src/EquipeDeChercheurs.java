import java.util.HashSet;
import java.util.Objects;

public class EquipeDeChercheurs {

	private int numeroEquipe;
	private String nomEquipe;
	private HashSet<Integer> ensembleLabos;

	/**
	 * construit une equipe de chercheurs sans labo
	 * @param numeroEquipe son numero
	 * @param nomEquipe son nom
	 * @throws IllegalArgumentException si le numero d'equipe est negatif ou nul
	 *                                  si le nom d'equipe est null ou ""
	 */
	public EquipeDeChercheurs(int numeroEquipe, String nomEquipe) {
		if(numeroEquipe<=0)
			throw new IllegalArgumentException();
		if(nomEquipe == null || nomEquipe.equals(""))
			throw new IllegalArgumentException();
		this.numeroEquipe = numeroEquipe;
		this.nomEquipe = nomEquipe;
		ensembleLabos = new HashSet<>();
	}

	public int getNumeroEquipe() {
		return numeroEquipe;
	}

	public String getNomEquipe() {
		return nomEquipe;
	}

	/**
	 * renvoie le nombre de labos occupes par l'equipe
	 * @return le nombre de labos occupes par l'equipe
	 */
	public int nombreLabos(){
		return ensembleLabos.size();
	}


	/**
	 * ajoute un labo si celui-ci ne fait pas encore partie des labos occupes par l'equipe
	 * @param numeroLabo le numero du labo a ajouter
	 * @return true si l'ajout a ete fait, false sinon
	 */
	public boolean ajouterLabo(int numeroLabo){
		return ensembleLabos.add(numeroLabo);
	}


	/**
	 * supprime un labo si celui-ci fait partie des labos occupes par l'equipe
	 * @param numeroLabo le numero du labo a supprimer
	 * @return true si la suppression a ete faite, false sinon
	 */
	public boolean supprimerLabo(int numeroLabo){
		return ensembleLabos.remove(numeroLabo);
	}


	/**
	 * renvoie sous forme d'une chaine de caracteres les numeros des labos
	 * @return une chaine de caracteres avec les numeros des labos
	 */
	public String lesLabos() {
		return ensembleLabos.toString();
	}

	@Override
	public String toString() {
		return "Equipe{" +
				"numeroEquipe=" + numeroEquipe +
				", nomEquipe='" + nomEquipe + '\'' +
				", ensembleLabos=" + ensembleLabos +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EquipeDeChercheurs that = (EquipeDeChercheurs) o;
		return numeroEquipe == that.numeroEquipe;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroEquipe);
	}
}
