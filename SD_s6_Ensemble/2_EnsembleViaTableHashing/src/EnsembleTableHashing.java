/**
 * implementation de l'interface Ensemble via une table de listes
 * @author 
 *
 */

public class EnsembleTableHashing<E> implements Ensemble<E>{
	
	private ListeSimpleImpl<E>[] tableListes;
	private int taille;
	private double loadFactor;  //pour le defi 

	// taille : taille logique 
	// capacite : taille physique 
	public EnsembleTableHashing(int capacite){	
		// TODO
		taille = 0;
		tableListes = new ListeSimpleImpl[capacite];
		for (int i = 0; i < capacite; i++) {
			tableListes[i] = new ListeSimpleImpl<>();
		}

	}
	
	// taille : taille logique 
	// capacite : taille physique 
	public EnsembleTableHashing(int capacite, double loadFactor){	
		// pour le  defi
		this(capacite);
		this.loadFactor = loadFactor;
	}


	public boolean estVide(){
		return taille == 0;
	}

	
	public int taille(){
		return taille;
	}

	
	public boolean contient(E element){
		// TODO
		// Attention la methode hashCode() renvoie un entier quelconque
		// Il n'est donc pas necessairement compris entre 0 et taille physique de la table
		// Il pourrait meme etre negatif
		// solution pbm compris entre 0 et taille physique : % taille physiqye
		int index = Math.abs(element.hashCode()% tableListes.length);
		if (tableListes[index] == null) return false;
		return tableListes[Math.abs(element.hashCode()% tableListes.length)].contient(element);

	}

	
	public boolean ajouter(E element) {
		// TODO
		int index = Math.abs(element.hashCode() % tableListes.length);
		if (!contient(element)){
			tableListes[index].insererEnTete(element);
			taille++;
			return true;
		}
		return false;

	}


	public boolean enlever(E element) {
		// TODO
		int index = Math.abs(element.hashCode() % tableListes.length);
		if (contient(element)) {
			tableListes[index].supprimer(element);
			taille--;
			return true;
		}
		 return false;

	}
	
	
	public String toString(){
	
		// Pour le debug cette methode renvoie le contenu de la structure de donnees utilisee
		// on y voit apparaitre une table avec les differentes listes, meme celles qui sont vides!
		// la methode proposee est utilisee par la classe de tests pour le defi

		// Cette methode devrait renvoyer uniquement les donnees comprises dans l'ensemble
		// Ex supplementaire 
		
		
		String aRenvoyer="";
		for (int i = 0; i < tableListes.length; i++) {
			aRenvoyer += "\ntable"+i+tableListes[i];
		}
		return aRenvoyer;
	}



}

