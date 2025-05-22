import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListeLRU<E> {

	private Noeud tete, queue;
	private HashMap<E, Noeud> mapElementNoeud;

	public ListeLRU() {
		mapElementNoeud = new HashMap<E, Noeud>();
		tete = new Noeud();   // sentinelle de tete
		queue = new Noeud();  // sentinelle de queue
		tete.suivant = queue;
		queue.precedent = tete;
	}

	/**
	 * renvoie le nombre d elements dans la liste
	 * @return
	 */
	public int taille () {
		return mapElementNoeud.size();
	}


	/**
	 * verifie la presence de l element passe en parametre dans la liste
	 * @param element l element recherche
	 * @return true si l element est present, false sinon
	 */
	public boolean contient (E element) {
		//TODO
		return mapElementNoeud.containsKey(element);
	}

	/**
	 * insere un nouvel element en tete de liste si celui-ci n'etait pas deja present
	 * @param element le nouvel element a inserer en tete
	 * @return true si l'element a ete ajoute, false sinon
	 */
	public boolean insererEnTete (E element){
		//TODO
		if (mapElementNoeud.containsKey(element))return false;

		Noeud nouveauNoeud = new Noeud(element);

			Noeud noeudAvant = tete;
			Noeud noeudApres = tete.suivant;

			nouveauNoeud.precedent = noeudAvant;
			nouveauNoeud.suivant = noeudApres;
			noeudAvant.suivant = nouveauNoeud;
			noeudApres.precedent = nouveauNoeud;

			mapElementNoeud.put(element, nouveauNoeud);
			return true;
	}

	/**
	 * supprime de la liste l element passe en parametre
	 * @param element l element a supprimer
	 * @return true si l element etait bien present, false sinon
	 */
	public boolean supprimer (E element) {
		//TODO
		if (!mapElementNoeud.containsKey(element))return false;

		Noeud noeudAvant = mapElementNoeud.get(element).precedent;
		Noeud noeudApres = noeudAvant.suivant.suivant;

		noeudAvant.suivant = noeudApres;
		noeudApres.precedent = noeudAvant;

		mapElementNoeud.remove(element);
		return true;
	}

	/**
	 * supprime le dernier element de la liste
	 * @return l'element supprime ou null si la liste etait vide
	 */
	public E supprimerDernier() {
		//TODO
		if (queue.precedent == tete)return null;
		Noeud noeudAvant = queue.precedent.precedent;
		Noeud noeudApres = queue;

		Noeud neoudS = mapElementNoeud.remove(queue.precedent.element);
		noeudAvant.suivant = noeudApres;
		noeudApres.precedent = noeudAvant;

		return neoudS.element;
	}


	public String toString () {
		String aRenvoyer = "";
		Noeud baladeur = tete.suivant;
		if(baladeur!=queue){
			aRenvoyer += baladeur.element;
			baladeur = baladeur.suivant;
		}
		while (baladeur != queue) {
			aRenvoyer += " " + baladeur.element;
			baladeur = baladeur.suivant;
		}
		return aRenvoyer;   
	}

	// pour les tests
	public ListeLRU(E[] tableACopier) {
		mapElementNoeud = new HashMap<E, Noeud>();
		tete = new Noeud();   // sentinelle de tete
		queue = new Noeud();  // sentinelle de queue
		Noeud prec = tete;
		for (int i = 0; i < tableACopier.length; i++) {
			Noeud nouveauNoeud = new Noeud(tableACopier[i]);
			mapElementNoeud.put(tableACopier[i], nouveauNoeud);
			nouveauNoeud.precedent = prec;
			prec.suivant = nouveauNoeud;
			prec = nouveauNoeud;
		}
		prec.suivant = queue;
		queue.precedent = prec;	
	}

	// pour les tests
	public String teteQueue(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = tete.suivant;
			int cpt=0;
			while (baladeur != queue) {
				if(cpt==0)
					aRenvoyer += baladeur.element;
				else
					aRenvoyer += ","+baladeur.element;
				baladeur = baladeur.suivant;
				cpt++;
				if(cpt==100){
					return "boucle infinie";
				}
			}
			return aRenvoyer+")";
		}catch (NullPointerException e){
			return "nullPointerException";
		}
	}

	// pour les tests
	public String queueTete(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = queue.precedent;
			int cpt=0;
			while (baladeur != tete) {
				if(cpt==0)
					aRenvoyer += baladeur.element;
				else
					aRenvoyer += ","+baladeur.element;
				baladeur = baladeur.precedent;
				cpt++;
				if(cpt==100){
					return "boucle infinie";
				}
			}
			return aRenvoyer+")";
		}catch (NullPointerException e){
			return "nullPointerException";
		}
	}

	// Classe interne Noeud
	private class Noeud{
		private E element;
		private Noeud suivant;
		private Noeud precedent;

		private Noeud() {
			this(null, null, null);
		}

		private Noeud(E element) {
			this(null, element, null);
		}

		private Noeud(Noeud precedent, E element, Noeud suivant) {
			this.element = element;
			this.suivant = suivant;
			this.precedent = precedent;
		}
	}

	

	// Classe interne IterateurImpl
	private class IterateurImpl<E> implements Iterator<E>{

		private Noeud noeudCourant;

		private IterateurImpl() {
			noeudCourant = tete.suivant;
		}

		public boolean hasNext() {
			return noeudCourant != queue;
		}

		// renvoie l element qui se trouve dans le noeud courant
		// le noeud courant passe au noeud suivant
		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			E aRenvoyer = (E)noeudCourant.element;
			noeudCourant = noeudCourant.suivant;
			return aRenvoyer;
		}

		// A NE PAS COMPLETER : Les suppressions sont interdites
		public void remove() {
			throw new UnsupportedOperationException();			
		}
	}

}
