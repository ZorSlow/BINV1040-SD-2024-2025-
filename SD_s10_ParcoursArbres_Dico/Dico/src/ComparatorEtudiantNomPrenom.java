import java.util.Comparator;

public class ComparatorEtudiantNomPrenom implements Comparator<Etudiant> {
    public int compare(Etudiant e, Etudiant e2){
        int compareNom = e.getNom().compareTo(e2.getNom());
        if (compareNom != 0)
            return compareNom;
        return e.getPrenom().compareTo(e2.getPrenom());

    }
}
