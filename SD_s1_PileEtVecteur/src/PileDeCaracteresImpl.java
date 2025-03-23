// implementation d'une pile en utilisant un tableau de taille variable redimensionnable

import java.util.Arrays;

public class PileDeCaracteresImpl implements PileDeCaracteres{

	private char[] table; 			// ne modifiez pas cet identifiant, va servir pour les tests
	private int nombreCaracteres; 	// taille logique
								  	//ne mofifiez pas cet identifiant, va servir pour les tests

	
	public PileDeCaracteresImpl(){
		table = new char[4];
		nombreCaracteres = 0;
	}

	
	public PileDeCaracteresImpl(int capacite){
		if (capacite <= 0)
			throw new IllegalArgumentException("la taille physique ne peut etre negative ou nulle");
		table = new char[capacite];
		nombreCaracteres = 0;
	}

	
	public int taille(){
		return nombreCaracteres;
	}

	
	public boolean estVide(){
		return nombreCaracteres == 0;
	}


	public char sommet()throws PileVideException{
		if (estVide())throw new PileVideException();
		return table[taille() -1];
		// TODO
		// PENSEZ A CONSULTER LA JAVADOC (cfr Interface PileDeCaracteres)

	}


	public char pop() throws PileVideException{
		if (estVide())throw new PileVideException();
		nombreCaracteres--;
		return table[taille()];
		// TODO
		// PENSEZ A CONSULTER LA JAVADOC (cfr Interface PileDeCaracteres)

	}


	public void push(char c){
	 	 if (taille() == table.length) {
			 char[] nouvelTable = new char[table.length * 2];
			 for (int i = 0; i < table.length; i++) {
				 nouvelTable[i] = table[i];
			 }
			 table = nouvelTable;
		 }
		table[taille()] = c ;
		nombreCaracteres++;
		// TODO
		// PENSEZ A CONSULTER LA JAVADOC (cfr Interface PileDeCaracteres)

	}

	//A NE PAS MODIFIER
	@Override
	public String toString() {
		if(table==null)
			return null;
		String s = "pile =";
		for (int i = 0; i < nombreCaracteres; i++) {
			s = s + " " + table[i];
		}
		return s;
	}

} 
