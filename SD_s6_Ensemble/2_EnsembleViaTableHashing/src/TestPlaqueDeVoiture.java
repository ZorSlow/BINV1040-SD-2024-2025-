public class TestPlaqueDeVoiture {

	public final static int NBRE_LISTES =500;
	
	public static void main (String args[]) {
		// Attention, la methode hashCode() renvoie un entier
		// Cet entier pourrait etre negatif --> Math.abs()
		// Cet entier doit correspondre a une liste --> %NBRE_LISTES
		Voiture v1 = new Voiture("1ABC123", "Alice");
		Voiture v2 = new Voiture("1ABC124", "Bob");
		Voiture v3 = new Voiture("1ZZZ999", "Charlie");

		afficherIndex(v1);
		afficherIndex(v2);
		afficherIndex(v3);
	}

	public static void afficherIndex(Voiture voiture) {
		int index = Math.abs(voiture.hashCode()) % NBRE_LISTES;
		System.out.println("Voiture " + voiture.getNumPlaque() + " va dans la liste : " + index);
	}
}