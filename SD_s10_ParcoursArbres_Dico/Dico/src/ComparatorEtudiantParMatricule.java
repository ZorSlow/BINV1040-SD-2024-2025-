import java.util.Comparator;

public class ComparatorEtudiantParMatricule implements Comparator<Etudiant> {
    public int compare(Etudiant e, Etudiant e2){
        return Integer.compare(e.getNumeroMatricule(),e2.getNumeroMatricule());
    }

}
