
public class ConnexionInfo {
   
 	Ensemble<LoginInfo> ensembleDesConnectes;
 	// N'AJOUTEZ PAS D'AUTRES ATTRIBUTS!!!
 	// N'OUBLIEZ PAS DE COMPLETER LA METHODE HASHCODE() DE LA CLASSE LOGININFO
 	
 	public ConnexionInfo(){
		// TODO
		ensembleDesConnectes = new EnsembleTableBooleens<>(139);
	}
 	
 	public	int nombreDeConnectes(){
 		return ensembleDesConnectes.taille();
 		// TODO

	}

 	// ajoute le loginInfo s'il n'est pas encore connecte
	public boolean connecter(LoginInfo loginInfo){
		 if (!ensembleDesConnectes.contient(loginInfo)) {
			 ensembleDesConnectes.ajouter(loginInfo);
			 return true;
		 }
		return false;
		// TODO

	}

	// retire le loginInfo s'il est connecte
	public boolean deconnecter(LoginInfo loginInfo){
		 if (ensembleDesConnectes.contient(loginInfo)) {
			 ensembleDesConnectes.enlever(loginInfo);
			 return true;
		 }
		return false;
		// TODO

	}

	public boolean estConnecte(LoginInfo loginInfo){
		return ensembleDesConnectes.contient(loginInfo);
		// TODO

	}
	

}