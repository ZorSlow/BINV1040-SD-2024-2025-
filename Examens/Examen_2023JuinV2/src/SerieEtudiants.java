import java.util.HashMap;

public class SerieEtudiants {

    private Noeud tete, queue;
    private HashMap<String, Noeud> mapEtudiantNoeud;

    /**
     * cree une nouvelle liste avec le delegue en tete
     * @param delegue
     */
    public SerieEtudiants(String delegue) {
        if(delegue==null||delegue.length()==0)
            throw new IllegalArgumentException();
        //TODO
        mapEtudiantNoeud = new HashMap<>();
        tete = new Noeud(delegue);
        tete.precedent = null;
        tete.suivant = null;
        queue = tete;
        mapEtudiantNoeud.put(delegue, tete);
    }

    /**
     * insere un nouvel etudiant dans la liste a condition qu'il ne soit pas deja present
     * ce nouvel etudiant est place directement apres le delegue de la serie
     * @param nouvelEtudiant
     * @return true si l'ajout a pu etre fait, false sinon
     */
    public boolean insererApresDelegue(String nouvelEtudiant){
        if(nouvelEtudiant==null||nouvelEtudiant.length()==0)
            throw new IllegalArgumentException();
        //TODO
        // Si déjà présent dans la liste → rien à faire
        if (mapEtudiantNoeud.containsKey(nouvelEtudiant))
            return false;

        Noeud nouveauNoeud = new Noeud(nouvelEtudiant);

        // Cas 1 : le délégué est le seul étudiant (liste avec un seul élément)
        if (tete == queue) {
            nouveauNoeud.precedent = tete;
            tete.suivant = nouveauNoeud;
            queue = nouveauNoeud;
        }
        // Cas 2 : il y a déjà d'autres étudiants
        else {
            Noeud noeudApresDelegue = tete.suivant;
            nouveauNoeud.precedent = tete;
            nouveauNoeud.suivant = noeudApresDelegue;
            tete.suivant = nouveauNoeud;
            noeudApresDelegue.precedent = nouveauNoeud;
        }

        // Enregistrer dans la map pour accès O(1)
        mapEtudiantNoeud.put(nouvelEtudiant, nouveauNoeud);
        return true;
    }

    /**
     * supprime tous les etudiants de la liste a partir de l'etudiant passe en parametre
     * ne fait aucune suppression si l'etudiant est le delegue de la serie ou si l'etudiant ne fait pas partie de la liste
     * @param etudiant l'etudiant a partir duquel les suppressions sont effectuees
     * @return true si au moins une suppression a ete faite, false sinon
     */
    public boolean tronquerAPartir(String etudiant){
        if(etudiant==null||etudiant.length()==0)
            throw new IllegalArgumentException();
        //TODO
        if (etudiant == null || etudiant.isEmpty())
            throw new IllegalArgumentException();

        Noeud noeudDebutSuppression = mapEtudiantNoeud.get(etudiant);
        if (noeudDebutSuppression == null) return false;       // pas dans la liste
        if (noeudDebutSuppression == tete) return false;       // ne pas tronquer le délégué

        // Retirer du map tous les étudiants à partir de noeudDebutSuppression
        Noeud courant = noeudDebutSuppression;
        while (courant != null) {
            mapEtudiantNoeud.remove(courant.etudiant);
            courant = courant.suivant;
        }

        // Détacher : l'élément juste avant devient la nouvelle queue
        Noeud noeudAvantSuppression = noeudDebutSuppression.precedent;
        noeudAvantSuppression.suivant = null;
        queue = noeudAvantSuppression;

        // Optionnel pour libérer la mémoire
        noeudDebutSuppression.precedent = null;

        return true;
    }

    /**
     * renvoie le nombre d'etudiants de la serie
     * @return le nombre d'etudiants de la serie
     */
    public int nombreEtudiants () {
        return mapEtudiantNoeud.size();
    }


    //A NE PAS MODIFIER
    // pour les tests
    public SerieEtudiants(String[] tableACopier) {
        if(tableACopier==null||tableACopier.length==0)
            throw new IllegalArgumentException();
        mapEtudiantNoeud = new HashMap<String, Noeud>();
        tete = new Noeud(tableACopier[0]);
        mapEtudiantNoeud.put(tableACopier[0],tete);
        Noeud prec = tete;
        for (int i = 1; i < tableACopier.length; i++) {
            Noeud nouveauNoeud = new Noeud(tableACopier[i]);
            mapEtudiantNoeud.put(tableACopier[i], nouveauNoeud);
            nouveauNoeud.precedent = prec;
            prec.suivant = nouveauNoeud;
            prec = nouveauNoeud;
        }
        queue = prec;
    }

    //A NE PAS MODIFIER
    // pour les tests
    public String teteQueue(){
        try{
            String aRenvoyer = "(";
            Noeud baladeur = tete;
            int cpt=0;
            while (baladeur != null) {
                if(cpt==0)
                    aRenvoyer += baladeur.etudiant;
                else
                    aRenvoyer += ","+baladeur.etudiant;
                baladeur = baladeur.suivant;
                cpt++;
                if(cpt==100){
                    return "boucle infinie";
                }
            }
            return aRenvoyer+")";
        }catch (NullPointerException e){
            return "nullPointerException";
        }
    }

    public String toString(){
        return teteQueue();
    }

    //A NE PAS MODIFIER
    // pour les tests
    public String queueTete(){
        try{
            String aRenvoyer = "(";
            Noeud baladeur = queue;
            int cpt=0;
            while (baladeur != null) {
                if(cpt==0)
                    aRenvoyer += baladeur.etudiant;
                else
                    aRenvoyer += ","+baladeur.etudiant;
                baladeur = baladeur.precedent;
                cpt++;
                if(cpt==100){
                    return "boucle infinie";
                }
            }
            return aRenvoyer+")";
        }catch (NullPointerException e){
            return "nullPointerException";
        }
    }

    // Classe interne Noeud
    private class Noeud{
        private String etudiant;
        private Noeud suivant;
        private Noeud precedent;

        private Noeud() {
            this(null, null, null);
        }

        private Noeud(String etudiant) {
            this(null, etudiant, null);
        }

        private Noeud(Noeud precedent, String etudiant, Noeud suivant) {
            this.etudiant = etudiant;
            this.suivant = suivant;
            this.precedent = precedent;
        }
    }

}
