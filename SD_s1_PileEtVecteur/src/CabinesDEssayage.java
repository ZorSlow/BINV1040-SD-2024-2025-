/**
 * @author 
 *
 */
public class CabinesDEssayage {
	
	private Pile<Integer> pileNumerosCabinesLibres;  // cette pile d'entiers contient les numeros des cabines libres
	private boolean[] tableOccupations;              // attention la numerotation des cabines commence a 1
												     // si tableOccupations[0] contient TRUE --> la cabine 1 est occupee
												     // ...
	// N'ajoutez pas d'autres attributs!
		
	
	/**
	 * construit nombreCabines libres
	 * La numerotation des cabines commence a 1
	 * @param nombreCabines : le nombre de cabines d'essayage
	 * @throws IllegalArgumentException si le nombre de cabines est negatif ou nul
	 */
	public CabinesDEssayage(int nombreCabines){

		// TODO
		if (nombreCabines <= 0) throw new IllegalArgumentException("nombre de cabines est egatif ou nul");
		tableOccupations = new boolean[nombreCabines];
		pileNumerosCabinesLibres = new PileImpl<>();
		for (int i = 1; i <= nombreCabines; i++) {
			pileNumerosCabinesLibres.push(i);
		}

	}
	
	/**
	 * renvoie le nombre de cabines libres
	 * @return le nombre de cabines libres
	 */
	public int nombreCabinesLibres(){
		// TODO
		return pileNumerosCabinesLibres.taille();
	}
	
	/**
	 * attribue une cabine libre
	 * @return le numero d'une cabine libre ou -1 si toutes les cabines sont occupees
	 */
	public int attribuerCabineLibre() {
		// TODO
		if (pileNumerosCabinesLibres.estVide()) {
			return -1;
		}
		int cabineLibres = pileNumerosCabinesLibres.pop();
		tableOccupations[cabineLibres -1] = true;
		return cabineLibres;
	}
	
	/**
	 * libere une cabine
	 * @param numeroCabine le numero de la cabine a liberer
	 * @throws IllegalArgumentException si aucune cabine porte ce numero
	 * @throws IllegalStateException si la cabine a liberer n'est pas occupee
	 */
	public void libererCabine(int numeroCabine) throws IllegalArgumentException, IllegalStateException {
		// TODO
		if (numeroCabine <= 0 || numeroCabine > tableOccupations.length ) throw new IllegalArgumentException("aucun caibne porte ce num");
		if (!tableOccupations[numeroCabine -1]) throw new IllegalStateException("caibne non occupé");
		tableOccupations[numeroCabine -1] = false;
		pileNumerosCabinesLibres.push(numeroCabine);
	}
}
