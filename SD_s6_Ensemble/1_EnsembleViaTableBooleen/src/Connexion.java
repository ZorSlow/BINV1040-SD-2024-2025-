public class Connexion {
   
	Ensemble<Login> ensembleDesConnectes;
 	// N'AJOUTEZ PAS D'AUTRES ATTRIBUTS!!!
	// N'OUBLIEZ PAS DE COMPLETER LA METHODE HASHCODE() DE LA CLASSE LOGIN

	public Connexion(){
		// A COMPLETER
		ensembleDesConnectes = new EnsembleTableBooleens<>(259);
	}

	public int nombreDeConnectes(){
		// A COMPLETER
		return ensembleDesConnectes.taille();
	}

	// ajoute le login s'il n'est pas encore connecte
	public boolean connecter(Login login){
		if (!estConnecte(login)) {
			ensembleDesConnectes.ajouter(login);
			return true;
		}
		return false;
		// A COMPLETER

	}

	// retire le login s'il est connecte
	public boolean deconnecter(Login login){
		if (estConnecte(login)){
			ensembleDesConnectes.enlever(login);
			return true;
		}
		return false;
		// A COMPLETER

	}

	public boolean estConnecte(Login login) {
		// A COMPLETER
		if (ensembleDesConnectes.contient(login)){
			return true;
		}
		return false;
	}

}

