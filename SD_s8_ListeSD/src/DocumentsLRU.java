
public class DocumentsLRU {

	private ListeLRU<String> listeLRU;

	/**
	 * construit une liste de nombreDocuments documents : doc1 doc2 ...
	 * @param nombreDocuments
	 * @throws IllegalArgumentException il faut au moins 1 document
	 */
	public DocumentsLRU(int nombreDocuments){
		if(nombreDocuments<1){
			throw new IllegalArgumentException();
		}
		// TODO
		listeLRU = new ListeLRU<>();
		int numDoc=5;
		for (int i = 1; i <= nombreDocuments; i++) {
			listeLRU.insererEnTete("doc"+numDoc--);
		}

	}


	/**
	 * place le document passe en parametre dans la liste selon le mecanisme LRU
	 * @param document le document a ouvrir
	 * @throws IllegalArgumentException si le document est null ou ""
	 */
	public void ouvrirDocument(String document) {
		if (document == null || document.equals(""))
			throw new IllegalArgumentException();
		//TODO

		if (!listeLRU.contient(document)) {
			listeLRU.insererEnTete(document);
			listeLRU.supprimerDernier();
		}
		listeLRU.insererEnTete(document);
	}
	
	
	public String toString(){
		return listeLRU.toString();
	}
	
}
