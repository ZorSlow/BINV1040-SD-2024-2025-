import java.util.Comparator;

/**
 * Comparator pour maintenir l'ordre d'arrivée dans un LinkedHashSet.
 * Retourne 0 si et seulement si les deux étudiants sont égaux (même matricule),
 * sinon 1 pour préserver l'ordre d'insertion et éviter de considérer d'autres
 * objets comme identiques.
 */
public class ComparatorEtudiantViaArrivee implements Comparator<Etudiant> {

    @Override
    public int compare(Etudiant e1, Etudiant e2) {
        // Si mêmes coordonnées (equals), considérer identiques
        if (e1.equals(e2)) {
            return 0;
        }
        // Sinon, forcer le LinkedHashSet à ne pas réordonner
        return 1;
    }
}