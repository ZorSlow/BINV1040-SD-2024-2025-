
public class Labo {
	
	private int numeroLabo;
	private EquipeDeChercheurs equipe;
	
	public Labo(int numeroLabo) {
		this.numeroLabo = numeroLabo;
	}

	public int getNumeroLabo() {
		return numeroLabo;
	}
	
	public EquipeDeChercheurs getEquipe() {
		return equipe;
	}

	public void setEquipe(EquipeDeChercheurs equipe) {
		this.equipe = equipe;
	}

	@Override
	public String toString() {
		return "Labo{" +
				"numeroLabo=" + numeroLabo +
				", equipe=" + equipe +
				'}';
	}
}
