import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FileDePrioriteImpl<E> implements FileDePriorite<E>{

	private Noeud racine;
	private Comparator comparateur;
	
	public FileDePrioriteImpl(Comparator<E> comparateur){
		this.comparateur = comparateur;
	}

	@Override
	public void insere(E e) {
		//TODO
		//contrainte : ecrivez cette methode de facon recursive
		//Lisez bien les explications sur l'utilisation de la methode compare() dans l'enonce
		if (racine == null) {
			racine = new Noeud(e);
		} else {
			insere(racine, e);
		}
	}
	private  void insere(Noeud noeud, E e) {
		int comparaison = comparateur.compare(e, noeud.element);

		if (comparaison <= 0) {
			// Insérer à gauche si priorité inférieure ou égale
			if (noeud.gauche == null) {
				noeud.gauche = new Noeud(e);
			} else {
				insere(noeud.gauche, e);
			}
		} else {
			// Insérer à droite si priorité strictement supérieure
			if (noeud.droit == null) {
				noeud.droit = new Noeud(e);
			} else {
				insere(noeud.droit, e);
			}
		}
}


		@Override
	public E max() {
		//TODO
		// contrainte : ecrivez cette methode de facon recursive

		return max(racine);
	}
	public E max(Noeud noeud) {
		if (noeud == null)
			return null;
		if (noeud.droit == null)
			return noeud.element;
		return max(noeud.droit);
	}


	@Override
	public Iterator<E> iterator() {
		return new Iterateur();
	}


	// A NE PAS MODIFIER!!!
	// VA SERVIR POUR LES TESTS!!!
	public String toString () {
		return "[ "+toString(racine)+" ]";
	}

	private String toString (Noeud n) {
		if (n==null) 
			return "";
		if (n.gauche == null && n.droit == null) 
			return ""+n.element;
		if (n.gauche == null) 
			return " [ ] "+n.element+" [ "+toString(n.droit)+" ] ";
		if (n.droit == null) 
			return " [ "+toString(n.gauche)+" ] "+n.element+ " [ ] ";
		return " [ "+toString(n.gauche)+" ] "+n.element+" [ "+toString(n.droit)+" ] ";	
	}

	public class Noeud{

		private E element; 
		private Noeud gauche;
		private Noeud droit;

		private Noeud(E element){
			this.element = element;
			this.gauche = null;
			this.droit = null;
		}

		private Noeud (Noeud gauche, E element, Noeud droit){
			this.element = element;
			this.gauche = gauche;
			this.droit = droit;
		}
	}

	private class Iterateur implements Iterator {

		private ArrayDeque<E> file;

		public Iterateur () {
			file = new ArrayDeque();
			remplirFile(racine);
		}

		private void remplirFile (Noeud n) {
			//TODO
			// cette methode est une methode recursive
			// elle est appelee par le constructeur
			// elle se charge de remplir la file avec tous les elements de l'arbre
			// les elements y apparaitront du plus prioritaire au moins prioritaire
			if (n == null)
				return;
			remplirFile(n.droit);
			file.add(n.element);
			remplirFile(n.gauche);
		}

		public boolean hasNext () {
			return !file.isEmpty();
		}

		public E next () {
			if(!hasNext())
				throw new NoSuchElementException();
			return file.removeFirst();
		}
	}


	// A NE PAS MODIFIER! VA SERVIR POUR LES TESTS
	// permet de construire la file de priorite de l'enonce

	public FileDePrioriteImpl(E e1, E e2, E e3, E e4, E e5, E e6, E e7,Comparator<E> comparateur){
		Noeud nG = new Noeud(null,e2,new Noeud(e5));
		Noeud nG1 = new Noeud(new Noeud(e7),e4,new Noeud(e6));
		Noeud nD = new Noeud(nG1,e3, null);
		racine = new Noeud(nG,e1,nD);
		this.comparateur = comparateur;
	}

}
