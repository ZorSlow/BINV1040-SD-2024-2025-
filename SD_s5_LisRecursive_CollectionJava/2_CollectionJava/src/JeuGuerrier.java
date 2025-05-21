
public class JeuGuerrier {
	
	public static void main(String[] args) {
		EquipeGuerriers equipe = new EquipeGuerriers(3, 10);
		int pointsDeVieDuMal = 30;
		
		// A COMPLETER

		int nbEnvie = equipe.nombreGuerriersEnVie();
		while (pointsDeVieDuMal > 0 && nbEnvie >0) {
			System.out.println("L'equipe compte " + nbEnvie + " guerriers en vie");

		int pointDuviePerduGuerrie = lancerDe();
		Guerrier guerrier = equipe.jouer(pointDuviePerduGuerrie);
			System.out.println("Suite au combat entre la creature du mal et le guerrier n°" + guerrier.getNumero());
			System.out.println("Le guerrier vient de perdre points " + pointDuviePerduGuerrie+" de vie");
			int pointsDeVieGuerrier = guerrier.getPointsDeVie();
			if (pointsDeVieGuerrier == 0) System.out.println("Le guerrier est mort");
			else System.out.println("Il lui reste " + pointsDeVieGuerrier + " points de vie");

			int pointsDeViePerduMal = lancerDe();
			pointsDeVieDuMal = Math.max(0, pointsDeVieDuMal - pointsDeViePerduMal);
			System.out.println("La créature du mal vient de perdre " + pointsDeViePerduMal + " points de vie");
			if (pointsDeVieDuMal == 0) System.out.println("La créature du mal est morte");
			else System.out.println("Il lui reste " + pointsDeVieDuMal + " points de vie");

			nbEnvie = equipe.nombreGuerriersEnVie();

			System.out.println();

		}
	}
	
	public static int lancerDe (){
		double nombreReel;
		nombreReel = Math.random();
		return (int) (nombreReel * 6) + 1;
	}
	
}
