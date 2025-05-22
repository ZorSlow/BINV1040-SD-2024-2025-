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
		// on refuse les doublons
		if (mapElementNoeud.containsKey(element))
			return false;
		Noeud nouveauNoeud = new Noeud(element);
		// selections des noeuds qui se vont se trouver avant et apres ce nouveau noeud
		Noeud noeudAvant = tete;
		Noeud noeudApres = tete.suivant;
		// on fait les 4 raccords
		nouveauNoeud.precedent = noeudAvant;
		nouveauNoeud.suivant = noeudApres;
		noeudAvant.suivant = nouveauNoeud;
		noeudApres.precedent = nouveauNoeud;
		// ne pas oublier de mettre cet element et le noeud qui le contient dans le map
		mapElementNoeud.put(element,nouveauNoeud);
		return true;

}

	public boolean insererEnQueue (E element) {
		//TODO
		if (mapElementNoeud.containsKey(element)) {
			return false;
		}

		Noeud nouveauNoeud = new Noeud(element);

		Noeud noeudAvant = queue.precedent;
		Noeud noeudApres = queue;

		nouveauNoeud.precedent = noeudAvant;
		nouveauNoeud.suivant = noeudApres;
		noeudAvant.suivant = nouveauNoeud;
		noeudApres.precedent = nouveauNoeud;

		mapElementNoeud.put(element, nouveauNoeud);
		return true;
	}

	public boolean insererApres (E element, E elementAInserer) {
		//TODO

		// 1. Veréfier les élements en entrée
		if (!mapElementNoeud.containsKey(element) || mapElementNoeud.containsKey(elementAInserer)) {
			return false; // Élément parent non trouvé OU doublon
		}
		// 2. Créer le nouveau noeud
		Noeud nouveauNoeud = new Noeud(elementAInserer);

		// 3. Recupérer les références
		Noeud noeudAvant = mapElementNoeud.get(element);
		Noeud noeudApres = noeudAvant.suivant;

		// 4. Mettre à jour les liens
		nouveauNoeud.precedent = noeudAvant;
		nouveauNoeud.suivant = noeudApres;

		noeudAvant.suivant = nouveauNoeud;
		noeudApres.precedent = nouveauNoeud;
		// 5. Ajouter à la Map
		mapElementNoeud.put(elementAInserer, nouveauNoeud);

		return true;

	}

	public boolean insererAvant (E element, E elementAInserer) {
		//TODO

		// 1. Vérifications renforcées (sentinelles incluses)
		if (!mapElementNoeud.containsKey(element) || mapElementNoeud.containsKey(elementAInserer)){
			return false;
		}

		// 2. Créer le nouveau noeud
		Noeud nouveauNoeud = new Noeud(elementAInserer);

		// 3. Recupérer les références
		Noeud noeudApres = mapElementNoeud.get(element);
		Noeud noeudAvant = noeudApres.precedent;

		// 4. Mettre à jour les liens
		nouveauNoeud.precedent = noeudAvant;
		nouveauNoeud.suivant = noeudApres;

		noeudAvant.suivant = nouveauNoeud;
		noeudApres.precedent = nouveauNoeud;
		// 5. Ajouter à la Map
		mapElementNoeud.put(elementAInserer, nouveauNoeud);

		return true;

	}


	public boolean supprimer (E element) {
		//TODO

		Noeud noeud = mapElementNoeud.get(element);
		if(noeud==null)
			return false;

		Noeud noeudAvant = noeud.precedent;
		Noeud noeudApres = noeud.suivant;

		noeudAvant.suivant = noeudApres;
		noeudApres.precedent = noeudAvant;

		mapElementNoeud.remove(element);
		return true;

	}

	
	public boolean permuter (E element1, E element2) {

		//TODO

		// REMARQUE : CE SONT LES VALEURS QUI SONT PERMUTEES, PAS LES NOEUDS!!!
		// Il est donc inutile de revoir le chainage
		// N'oubliez pas de modifier les noeuds associes dans le map

		// verifcation les elements d'entrées
		if(!mapElementNoeud.containsKey(element1) || !mapElementNoeud.containsKey(element2)){
			return false;
		}
		// Recupérer les noeuds associés aux élements
		Noeud noeud1 = mapElementNoeud.get(element1);
		Noeud noeud2 = mapElementNoeud.get(element2);

		// Échanger les valeurs stockées dans les nœuds (pas les nœuds eux-mêmes)
		E temp = noeud1.element;
		noeud1.element = noeud2.element;
		noeud2.element = temp;

		// Mettre à jour la Map pour refléter les nouvelles clés
		//mapElementNoeud.remove(element1); // Retirer l'ancienne clé elem1
		//mapElementNoeud.remove(element2); car put ecrase l'ancienne
		mapElementNoeud.put(noeud1.element,noeud1);// Nouvelle clé : valeur de noeud1
		mapElementNoeud.put(noeud2.element,noeud2);

		return true;

	}

	public Iterator<E> iterator() {
		//TODO
		return new IterateurImpl();
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
	private class IterateurImpl implements Iterator<E>{

		private Noeud noeudCourant;

		private IterateurImpl() {
			//TODO
			noeudCourant = tete.suivant;// Démarre après la sentinelle de tête

		}

		public boolean hasNext() {
			//TODO
			return noeudCourant != queue; // S'arrête avant la sentinelle de queue
		}

		// renvoie l element qui se trouve dans le noeud courant
		// le noeud courant passe au noeud suivant
		public E next() {
			//TODO
			if (!hasNext()) {
				throw new NoSuchElementException("Plus d'éléments dans l'itérateur");
			}

			E element = noeudCourant.element;
			noeudCourant = noeudCourant.suivant;
			return element;

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
