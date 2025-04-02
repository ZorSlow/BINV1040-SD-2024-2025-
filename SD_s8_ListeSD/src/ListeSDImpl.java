import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListeSDImpl<E> implements ListeSD<E>,Iterable<E> {

	private Noeud tete, queue;
	private HashMap<E, Noeud> mapElementNoeud;

	public ListeSDImpl () {
		//TODO
		mapElementNoeud = new HashMap<>();
		tete = new Noeud();
		tete.suivant = new Noeud();
		queue = tete.suivant;
		queue.precedent = tete;


	}

	public int taille () {
		return mapElementNoeud.size();
	}

	public boolean estVide () {
		//TODO
		return mapElementNoeud.isEmpty();
	
	}

	public boolean contient (E element) {
		//TODO
		return mapElementNoeud.containsKey(element);

	}

	public E premier() {
		//TODO
		if (tete.suivant == queue)
			return null;
		return tete.suivant.element;

	}

	public E dernier() {
		//TODO
		if (queue.precedent == tete)
			return null;
		return queue.precedent.element;

	}

	public E donnerPrecedent (E element) {
		//TODO
		Noeud noeud = mapElementNoeud.get(element);
		if (noeud != null && noeud.precedent != null )
			return noeud.precedent.element;
		return null;

	}

	public E donnerSuivant (E element) {
		//TODO
		Noeud noeud = mapElementNoeud.get(element);
		if (noeud != null && noeud.suivant != null)
			return noeud.suivant.element;
		return null;

	}

	public boolean insererEnTete (E element){
		//TODO

		// Verifier si l'élement est déjà présent
		if (mapElementNoeud.containsKey(element)) {
			return false;
		}
		Noeud nouveauNoeud = new Noeud(element);
		// Cas où la liste est vide (seulement les sentinelles )
		if (tete.suivant == queue) {
			nouveauNoeud.precedent = tete;
			nouveauNoeud.suivant = queue;
			tete.suivant = nouveauNoeud;
			queue.precedent = nouveauNoeud;
		}else {
			// Cas général : insertion en tête
			Noeud ancienneTete = tete.suivant;
			nouveauNoeud.precedent = tete;
			nouveauNoeud.suivant = ancienneTete;
			ancienneTete.precedent = nouveauNoeud;
			tete.suivant = nouveauNoeud;

		}
		mapElementNoeud.put(element,nouveauNoeud);

		return true;

}

	public boolean insererEnQueue (E element) {
		//TODO
		if (mapElementNoeud.containsKey(element)){
			return false;
		}
		Noeud nouveauNoeud = new Noeud(element);
		// Cas où la liste est vide (seulement les sentinelles)
		if (queue.precedent == tete){
			nouveauNoeud.suivant = queue;
			nouveauNoeud.precedent = tete;
			queue.precedent = nouveauNoeud;
			tete.suivant = nouveauNoeud;
		}else{
			// Cas général : insertion en tête
			Noeud anceinneQueue = queue.precedent;
			nouveauNoeud.suivant = queue;
			nouveauNoeud.precedent = anceinneQueue;
			anceinneQueue.suivant = nouveauNoeud;
			queue.precedent = nouveauNoeud;
		}
		mapElementNoeud.put(element,nouveauNoeud);

		return true;

	}

	public boolean insererApres (E element, E elementAInserer) {
		//TODO
		return false;

	}

	public boolean insererAvant (E element, E elementAInserer) {
		//TODO
		return false;

	}


	public boolean supprimer (E element) {
		//TODO
		return false;

	}

	
	public boolean permuter (E element1, E element2) {

		//TODO
		return false;

		// REMARQUE : CE SONT LES VALEURS QUI SONT PERMUTEES, PAS LES NOEUDS!!!
		// Il est donc inutile de revoir le chainage
		// N'oubliez pas de modifier les noeuds associes dans le map

	}

	public Iterator<E> iterator() {
		//TODO
		return null;
		// il faut renvoyer un objet de type Iterator :
		//return new IterateurImpl();
		// completez la classe interne IterateurImpl !
	}

	public String toString () {
		String aRenvoyer = "";
		int num = 1;
		Noeud baladeur = tete.suivant;
		while (baladeur != queue) {
			aRenvoyer += num + " - " + baladeur.element + "\n";
			baladeur = baladeur.suivant;
			num++;
		}
		return aRenvoyer;   
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
	private class IterateurImpl implements Iterator{

		private Noeud noeudCourant;

		private IterateurImpl() {
			//TODO

		}

		public boolean hasNext() {
			//TODO
			return false;

		}

		// renvoie l element qui se trouve dans le noeud courant
		// le noeud courant passe au noeud suivant
		public E next() {
			//TODO
			return null;

		}

		// A NE PAS COMPLETER : Les suppressions sont interdites
		public void remove() {
			throw new UnsupportedOperationException();			
		}
	}

	// pour les tests
	public ListeSDImpl(E[] tableACopier) {
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

}
