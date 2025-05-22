import java.util.Iterator;
import java.util.HashSet ;
import java.util.ArrayList ;

public class RallyeAutomobile {

	private ListeSDImpl<String> pilotes ;

	/**
	 * place les pilotes passes en parametre en course
	 * @param lesPilotes la table avec les pilotes tries selon l'ordre des departs
	 * @throws IllegalArgumentException : la table ne peut etre null,
	 *                                    elle ne peut contenir des null,
	 *                                    elle ne peut contenir des homonymes.
	 */
	public RallyeAutomobile(String[] lesPilotes) {
		if (lesPilotes==null)
			throw new IllegalArgumentException("lesPilotes==null") ;
		pilotes = new ListeSDImpl<String>() ;
		for (int i=0 ; i<lesPilotes.length ;i++) {
			if (lesPilotes[i]==null) throw new IllegalArgumentException("lesPilotes[i]==null") ;
			if(!pilotes.insererEnQueue(lesPilotes[i])){
				throw new IllegalArgumentException("Deux pilotes portent le meme nom") ;
			}
		}
	}

	/**
	 * renvoie le nombre de pilotes dans la course
	 * @return le nombre de pilotes dans la course
	 */
	public int nbPilotesEnCourse() {
		//TODO
		return 0 ;
	}

	/**
	 * verifie si le pilote est dans la course
	 * @param pilote le pilote a verifier
	 * @return true si le pilote est dans la course, false sinon
	 */
	public boolean estEnCourse(String pilote) {
		//TODO
		return false ;
	}

	/**
	 * renvoie le pilote de tete
	 * @return le pilote de tete ou null s'il n'y a plus de pilote dans la course
	 */
	public String donnerPiloteDeTete() {
		//TODO
		return null;
	}

	/**
	 * effectue un depassement : echange le pilote avec le pilote precedent
	 * @param pilote le pilote qui depasse
	 * @return true si l'echange a ete fait,
	 *         false sinon (le pilote doit etre dans la course et ne pas etre en tete
	 */
	public boolean avancerPilote(String pilote) {
		//TODO
		return false;
	}

	//TODO

	public String toString() {
		return pilotes.toString();
	}

}
