
public class Grille9X9 {

	private int[][] table;

	public Grille9X9(int[][] tableARecopier)throws IllegalArgumentException{
		if(tableARecopier==null)
			throw new IllegalArgumentException();
		if(tableARecopier.length!=9)
			throw new IllegalArgumentException();
		for(int i = 0;i<9;i++){
			if(tableARecopier[i]==null||tableARecopier[i].length!=9)throw new IllegalArgumentException();
		}
		table = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(tableARecopier [i][j]<1||tableARecopier[i][j]>9)throw new IllegalArgumentException();
				table[i][j]=tableARecopier[i][j];
			}
		}
	}

	private boolean ligneCorrecte(int ligne){
		// TODO
		// Cette methode a la visibilite private, 
		// 		--> il est inutile de tester le parametre
		// 		--> premiere ligne ligne 0 ou ligne 1? Comme vous voulez!
		// LE BUT DE CET EXERCICE EST D'UTILISER LA CLASSE ENSEMBLE1A9...
		Ensemble1A9 ensemble = new Ensemble1A9();
		for (int i = 0; i < 9; i++) {
			if (!ensemble.ajouter(table[ligne][i]))
				return false;
		}
		return true;
	}

	private boolean colonneCorrecte(int colonne){
		// TODO
		// Cette methode a la visibilite private, il est inutile de tester le parametre
		Ensemble1A9 ensemble = new Ensemble1A9();
		for (int i = 0; i < 9; i++) {
			if (!ensemble.ajouter(table[i][colonne]))
				return false;
		}
		return true;
	}
	
	// verifie le bloc qui commence a la ligne et a la colonne passees en parametre
	private boolean blocCorrect(int ligne, int colonne){
		// TODO
		// Cette methode a la visibilite private, il est inutile de tester le parametre
		// Cette methode a la visibilite private, il est inutile de tester le parametre
		Ensemble1A9 ensemble = new Ensemble1A9();
		for (int i = ligne; i < ligne + 3 ; i++) {
			for (int j = colonne; j < colonne +3; j++) {
			if (!ensemble.ajouter(table[i][j]))
				return false;
			}
		}
		return true;
	}



		
	public boolean estUnSudoku(){
		// TODO
		for (int i = 0; i < 9; i++) {
			if (!ligneCorrecte(i) || !colonneCorrecte(i)){
				return false;
			}
		}
		for (int i = 0; i < 9 ; i +=3) {
			for (int j = 0; j < 9; j +=3) {
				if (!blocCorrect(j,j))
					return false;
			}
		}
		return true;
	
	}
	
	
	
	public boolean estUnSudokuDiagonal(){
		// TODO
		// cette methode est proposee en ex supplementaire
		return false;

	}
	
	

	public boolean estUnHyperSudoku(){
		// TODO
		// cette methode est proposee en ex supplementaire
		return false;

	}



}
