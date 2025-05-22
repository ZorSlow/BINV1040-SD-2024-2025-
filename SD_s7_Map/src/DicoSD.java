import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;

public class DicoSD {

	//TODO
	// suivez l'implementation proposee dans l'enonce!
	private  HashMap<String, LinkedList<String>> mapSite;

	// Au depart le dico est vide
	public DicoSD() {
		//TODO
		mapSite = new HashMap<>();

	}

	/**
	 * ajout dans le dico une association sd-url si cette association n'est pas encore presente 
	 * @param sd une structure de donnees
	 * @param url une url vers un site internet
	 * @return true si cette association n'etait pas encore presente dans le dico, false sinon
	 */
	public boolean ajouter(String sd, String url){
		if (!contient(sd)) {
			LinkedList<String> listeLiens = new LinkedList<>();
			listeLiens.add(url);
			mapSite.put(sd, listeLiens);
			return true;
		}
		if (!mapSite.get(sd).contains(url)) {
			mapSite.get(sd).add(url);
			return true;
		}
		return false;
			//TODO
	}
	
	/**
	 * verifie si la structure de donnees se trouve dans le dico
	 * cette structure de donnees doit posseder au moins une url!
	 * @param sd
	 * @return true si sd est present, false sinon
	 */
	public boolean contient(String sd){
		return mapSite.containsKey(sd) && !mapSite.get(sd).isEmpty();
		//TODO
	}
	
	
	/**
	 * renvoie tous les urls associes a la structure de donnees passee en parametre
	 * @param sd
	 * @return une chaine de caracteres avec les urls selon le format : [urlPile1, urlPile2] ou [] si la structure de donnees n'existe pas
	 */
	public String lesURLs(String sd){
		if (!mapSite.containsKey(sd))
			return "[]";
		return mapSite.get(sd).toString();
		//TODO
	}
	
	/**
	 * supprime dans le dico l'association sd-url si celle-ci est presente 
	 * @param sd une structure de donnees
	 * @param url une url vers un site internet
	 * @return true si l'association etait presente dans le dico, false sinon
	 */
	public boolean supprimer(String sd, String url){
		//TODO
		if (contient(sd)) {
			if (mapSite.get(sd).contains(url)) {
				mapSite.get(sd).remove(url);
				return true;
			}
		}
		return false;
	}
}
