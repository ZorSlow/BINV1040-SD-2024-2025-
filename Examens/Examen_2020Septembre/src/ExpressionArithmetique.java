import java.util.HashMap;
import java.util.HashSet;


public class ExpressionArithmetique extends ArbreDeCaracteres { 
	
	public ExpressionArithmetique () {
		super();
	}
	
	/**
	 * Cree une expression arithmetique a partir d'un arbre de caracteres
	 * @param a
	 */
	public ExpressionArithmetique (ArbreDeCaracteres a) {
		super(a);
	}

	public ExpressionArithmetique (char c) {
		super(c);
	}
	
	public ExpressionArithmetique (char c, ArbreDeCaracteres ag, ArbreDeCaracteres ad) {
		super(c, ag, ad);
	}
	
	/**
	 * calcule le nombre d'operateurs moins presents dans l'expression arithmetique
	 * si le parametre est 1, c'est le nombre de moins unaire qui sera renvoye
	 * si le parametre est 2, c'est le nombre de moins binaire qui sera renvoye
	 * @param i permet de distinguer l'operateur unaire de l'operateur binaire (1 ou 2)
	 * @return le nombre calcule
	 * @throws IllegalArgumentException si le parametre est invalide
	 */
	public int nombreMoins(int i)  {
		//TODO
		return 0;
	}
	

	
	/**
	 * verifie si tous les entiers contenus dans l'expression arithmetiques sont differents
	 * @return true si tous les entiers sont differents, false sinon
	 */
	public boolean entiersTousDifferents(){
		// contrainte de programmation :
		// utilisez un ensemble (HashSet<Character>) dans lequel seront places au fur et a mesure les entiers contenus dans l'arbre
		// A chaque entier rencontre, il suffira de verifier s'il n'est pas deja dans l'ensemble
		return false;
		// TODO
	}

	
	
} 

