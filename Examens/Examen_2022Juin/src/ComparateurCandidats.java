import java.util.Comparator;

public class ComparateurCandidats implements Comparator<Candidat> {

    @Override
    public int compare(Candidat c1, Candidat c2) {
        return c2.getNombreVotes()-c1.getNombreVotes();
    }
}
