// interface File 

public interface FileSD<E> {

	/**
	 * verifie si la file est vide
	 * @return true si la file est vide, false sinon
	 */
	boolean estVide();


	/**
	 * renvoie le nombre d'elements qui se trouvent dans la file
	 * @return nombre d'elements
	 */
	int taille();

	/**
	 * renvoie l'element en tete de file
	 * @return l'element en tete de file ou null si la file est vide
	 */
	E premier();


	/**
	 * renvoie l'element en queue de file
	 * @return l'element en queue de file ou null si la file est vide
	 */
	E dernier();


	/**
	 * verifie la presence d'un element dans la file
	 * @param element l'element recherche
	 * @return true si l'element est present, false sinon
	 */
	boolean contient(E element);


	/**
	 * ajoute un element en fin de file (queue) a condition qu'il n'y etait pas
	 * (les doublons sont refuses)
	 * @param element l'element a ajouter
	 * @return true si l'ajout a pu se faire, false sinon
	 */	
	boolean enfile(E element);


	/**
	 * renvoie l'element qui se trouve en tete de file et l'enleve de la file
	 * @return l'element en tete ou null si la file est vide
	 */
	E defile();


	/**
	 * donne la position d'un element dans la file
	 * (le 1er element se trouve en position 1, le 2eme en position 2, et ainsi de suite
	 * @param element l'element recherche
	 * @return la position de l'element ou -1 si cet element ne se trouve pas dans la file
	 */
	int position(E element);
		 
} // interface
