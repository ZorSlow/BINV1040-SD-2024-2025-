import java.util.HashMap;

public class FileAttenteAvecDesistementImpl<E> implements FileAttenteAvecDesistement<E> {

	private Noeud tete, queue;
	private HashMap<E, Noeud> mapElementNoeud;

	// N'ajoutez pas d'autres attributs

	public FileAttenteAvecDesistementImpl() {
		mapElementNoeud = new HashMap<E, Noeud>();
		tete = new Noeud();   // sentinelle de tete
		queue = new Noeud();  // sentinelle de queue
		tete.suivant = queue;
		queue.precedent = tete;
	}

	// A NE PAS MODIFIER !
	// pour les tests
	public int taille () {
		return mapElementNoeud.size();
	}


	@Override
	public boolean enfile(E element) {
		//TODO
		if (!mapElementNoeud.containsKey(element)) {
			Noeud nouveauNoeud = new Noeud(element);

			Noeud noeudApres = queue;
			Noeud noeudAvant = queue.precedent;

			nouveauNoeud.precedent = noeudAvant;
			nouveauNoeud.suivant = noeudApres ;
			noeudAvant.suivant = nouveauNoeud;
			noeudApres.precedent = nouveauNoeud;

			mapElementNoeud.put(element, nouveauNoeud);

			return true;
		}
		return false;

	}

	@Override
	public E defile() {
		//TODO
		// Récupérer le premier élément à supprimer
		if (tete.suivant == queue)
			return null;
		Noeud noeudASupprimer = tete.suivant;
		E elementARetourner = noeudASupprimer.element;

		// Mettre à jour les liens pour supprimer le nœud
		tete.suivant = noeudASupprimer.suivant;
		noeudASupprimer.suivant.precedent = tete;

		// Supprimer de la HashMap
		mapElementNoeud.remove(elementARetourner);

		return elementARetourner;
	}

	@Override
	public boolean desister(E element) {
		//TODO

		if (mapElementNoeud.containsKey(element)) {

			Noeud noeudS = mapElementNoeud.remove(element);
			Noeud noeudAvant = noeudS.precedent;
			Noeud noeudApres = noeudS.suivant;

			noeudAvant.suivant = noeudApres;
			noeudApres.precedent = noeudAvant;
			return true;
		}
		return false;

	}


	// A NE PAS MODIFIER !
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

	// A NE PAS MODIFIER !
	// pour les tests
	public FileAttenteAvecDesistementImpl(E[] tableACopier) {
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

	// A NE PAS MODIFIER !
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

	// A NE PAS MODIFIER !
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
