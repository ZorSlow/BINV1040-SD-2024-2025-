import java.util.ArrayDeque;
import java.util.Iterator;

public class ABRPrenoms implements Iterable<String> {

    private Noeud racine;

    /**
     * verifie la presence d'homonymes
     * (si au moins 2 enfants portent le meme prenom, il y a homonymes)
     * @return true s'il y a des homonymes, false sinon
     */
    public boolean contientHomonymes() {
        //TODO
        //contrainte : implementation recursive
        return contientHomonymes(racine);

    }private boolean contientHomonymes(Noeud noeud) {
        if (noeud == null){
            return false;
        }
        if (noeud.nombreOccurrences > 1)
            return true;
        return contientHomonymes(noeud.gauche) || contientHomonymes(noeud.droit);
    }


    /**
     * calcule le nombre d'occurrences du prenom passe en parametre
     * @param prenom le prenom recherche
     * @return le nombre d'occurrences du prenom passe en parametre
     * @throws IllegalArgumentException si le prenom est null ou vide
     */
    public int nombreOccurrences(String prenom) {
        if(prenom==null||prenom.length()==0)
            throw new IllegalArgumentException();
        //TODO
        //contrainte : implementation recursive
        return nombreOccurrences(racine,prenom);

    } private int nombreOccurrences(Noeud noeud,String prenom) {
        int nombreOccurence = 0;
        if (noeud == null)
            return 0;
        if (noeud.prenom.equals(prenom)) {
            nombreOccurence += noeud.nombreOccurrences;
            return nombreOccurence + nombreOccurrences(noeud.gauche, prenom) + nombreOccurrences(noeud.droit, prenom);
        }
        return nombreOccurrences(noeud.gauche,prenom) + nombreOccurrences(noeud.droit, prenom);
    }


    public Iterator<String> iterator() {
        return new Iterateur();
    }


    // classe interne
    private class Noeud {

        private String prenom;
        private int nombreOccurrences;
        private Noeud gauche;
        private Noeud droit;

        private Noeud(Noeud gauche, String prenom, int nombreOccurrences,
                      Noeud droit) {
            if(prenom==null||prenom.length()==0)
                throw new IllegalArgumentException();
            if(nombreOccurrences<1)
                throw new IllegalArgumentException();
            this.prenom = prenom;
            this.nombreOccurrences = nombreOccurrences;
            this.gauche = gauche;
            this.droit = droit;
        }

        private Noeud(String prenom, int nombreOccurrences) {
            this(null, prenom, nombreOccurrences, null);
        }
    }

    //classe interne
    private class Iterateur implements Iterator<String> {

        private ArrayDeque<String> filePrenoms;

        public Iterateur() {
            filePrenoms = new ArrayDeque<String>();
            remplirFile(racine);
        }

        private void remplirFile(Noeud noeud) {
            //TODO
            //Suivez bien les indications de l'enonce
            remplirFile(noeud.gauche);
            for (String prenom : this.filePrenoms)
                if (prenom.compareTo(noeud.gauche.prenom) < 0 )
                    filePrenoms.add(prenom);
            remplirFile(noeud.droit);


        }

        public boolean hasNext() {
            return !filePrenoms.isEmpty();
        }

        public String next() {
            return filePrenoms.removeFirst();
        }
    }


    // A NE PAS MODIFIER! VA SERVIR POUR LES TESTS
    public ABRPrenoms(int i) {
        if(i==1){
            Noeud g2 = new Noeud(new Noeud("marie", 1), "sam", 1, new Noeud("tim", 1));
            Noeud d1 = new Noeud(g2, "zoe", 1, null);
            racine = new Noeud(new Noeud("anouk",1), "lea", 1, d1);
        }else {
            if(i==2){
                Noeud g2 = new Noeud(new Noeud("marie", 2), "sam", 1, new Noeud("tim", 1));
                Noeud d1 = new Noeud(g2, "zoe", 1, null);
                racine = new Noeud(new Noeud("anouk",1), "lea", 1, d1);
            }else {
                if (i==3) {
                    Noeud g1 = new Noeud(null, "anouk", 1, new Noeud("hugo", 2));
                    Noeud g2 = new Noeud(new Noeud("marie", 3), "sam", 1, new Noeud("tim", 1));
                    Noeud d1 = new Noeud(g2, "zoe", 2, null);
                    racine = new Noeud(g1, "lea", 1, d1);
                } else {
                    racine = null;
                }
            }
        }
    }


}
