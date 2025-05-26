public class Candidat {

    private String nom;
    private int numero;
    private int nombreVotes;

    /**
     * initialise un candidat avec 0 vote
     * @param nom le nom du candidat
     * @param numero le numero du candidat
     */
    public Candidat(String nom, int numero) {
        this.nom = nom;
        this.numero = numero;
        this.nombreVotes = 0;
    }

    public String getNom() {
        return nom;
    }

    public int getNumero() {
        return numero;
    }

    public int getNombreVotes() {
        return nombreVotes;
    }

    /**
     * augmente de 1 le nombre de votes
     */
    public void ajouter1Vote(){
        nombreVotes++;
    }

    @Override
    public String toString() {
        return "Candidat{" +
                "nom = '" + nom + '\'' +
                ", numero = " + numero +
                ", nombre de votes = " + nombreVotes +
                '}';
    }

}
