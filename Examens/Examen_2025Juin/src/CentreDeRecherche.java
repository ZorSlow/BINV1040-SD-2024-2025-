import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class CentreDeRecherche {

	private HashMap<Integer, EquipeDeChercheurs> mapEquipesDeChercheursPresentes;
	private Labo[] tableLabos;
	private ArrayDeque<Labo> fileLabosLibres;

	/**
	 * construit un centre de recherche contenant nombreLabos
	 * @param nombreLabos le nombre de labos
	 * @throws IllegalArgumentException si le nombre de labos est negatif ou nul
	 */
	public CentreDeRecherche(int nombreLabos) {
		if(nombreLabos<=0)
			throw new IllegalArgumentException();
		mapEquipesDeChercheursPresentes = new HashMap<>();
		tableLabos = new Labo[nombreLabos];
		fileLabosLibres = new ArrayDeque<>();
		for (int i = 0; i < nombreLabos; i++) {
			Labo labo = new Labo(i);
			tableLabos[i]=labo;
			fileLabosLibres.add(labo);
		}
	}


	/**
	 * renvoie le nombre de labos libres
	 * @return le nombre de labos libres
	 */
	public int nombreLabosLibres(){
		//TODO
		return fileLabosLibres.size();
	}


	/**
	 * renvoie l'equipe de chercheurs dont le numero est passe en parametre
	 * @param numeroEquipe le numero de l' equipe de chercheurs recherchee
	 * @return l'equipe de chercheurs recherchee ou null si aucune equipe presente ne possede ce numero
	 *
	 */
	public EquipeDeChercheurs getEquipeDeChercheurs(int numeroEquipe){
		//TODO

		return mapEquipesDeChercheursPresentes.get(numeroEquipe);
	}


	/**
	 * attribue un labo a une equipe de chercheurs
	 * Si l'attribution a pu se faire :
	 * l'equipe de chercheurs est enregistree comme presente (si pas encore presente)
	 * le labo lui est ajoute
	 * @param numeroEquipe le numero de l'equipe de chercheurs
	 * @param nomEquipe le nom de l'equipe de chercheurs
	 * @return le numero du labo attribue ou -1 s'il n'y en a plus de libre
	 */
	public int attribuerlabo(int numeroEquipe, String nomEquipe) {
		// TODO
		// aucun labo dispo
		if (fileLabosLibres.isEmpty())
			return -1;
		// prend le labo le moins récemment utilisé
		Labo labo = fileLabosLibres.removeFirst();
		int numeroLabo = labo.getNumeroLabo();
		// récupere ou crée l'equipe
		EquipeDeChercheurs eq = mapEquipesDeChercheursPresentes.get(numeroEquipe);
		if (eq == null) {
			eq = new EquipeDeChercheurs(numeroEquipe, nomEquipe);
			mapEquipesDeChercheursPresentes.put(numeroEquipe,eq);
		}
		//chainer les 2 coter
		eq.ajouterLabo(numeroLabo);
		labo.setEquipe(eq);


		return numeroLabo;
	}


	/**
	 * libere le labo dont le numero est passe en parametre
	 * Si, apres suppression, l'equipe de chercheurs n'a plus de labo, elle doit etre retiree des equipes presentes
	 * @param numeroLabo
	 * @return l'equipe de chercheurs qui occupait le labo avant liberation ou null si le labo n'etait pas occupe
	 * @throws IllegalArgumentException si aucun labo ne porte ce numero
	 */
	public EquipeDeChercheurs libererlabo(int numeroLabo) {
		//TODO
		if (numeroLabo < 0 || numeroLabo >= tableLabos.length) throw new IllegalArgumentException();
		Labo labo = tableLabos[numeroLabo];
		EquipeDeChercheurs eq = labo.getEquipe();

		//déjà libre ?
		if (eq == null)
			return null;

		// enlève ce labo de l’équipe
		eq.supprimerLabo(numeroLabo);

		// si l’équipe n’a plus de labo, la retirer du map
		if (eq.nombreLabos() == 0) {
			mapEquipesDeChercheursPresentes.remove(eq.getNumeroEquipe());
		}

		// re-mettre le labo dans la file des libres et couper le lien
		labo.setEquipe(null);
		fileLabosLibres.addLast(labo);

		return eq;

	}

	//pour le debug
	//inutile de modifier cette methode, elle n'est pas evaluee
	@Override
	public String toString() {
		return "mapEquipesDeChercheursPresentes : " + mapEquipesDeChercheursPresentes +
				"\ntableLabos : " + Arrays.toString(tableLabos) +
				"\nfileLabosLibres : " + fileLabosLibres;
	}
}
