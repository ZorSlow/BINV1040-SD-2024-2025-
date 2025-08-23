import java.util.HashSet;

public class ListePMImplViaListe<E> implements ListePM<E> {

    private Noeud teteS, queueS; //sentinelles de tete et de queue
    private HashSet<E> ensembleElementsPresents;

    /**
     * construit une liste initiale
     * @param tableInitiale la table initiale avec les elements de la liste de depart
     * @throws IllegalArgumentException si la table passee en parametre est null, contient des null ou des ex-aequos
     */
    ListePMImplViaListe(E[] tableInitiale) {
        if(!estValide(tableInitiale))
            throw new IllegalArgumentException();
        ensembleElementsPresents = new HashSet<>();
        teteS = new Noeud();   // sentinelle de tete
        queueS = new Noeud();  // sentinelle de queue
        Noeud prec = teteS;
        for (int i = 0; i < tableInitiale.length; i++) {
            Noeud nouveauNoeud = new Noeud(tableInitiale[i]);
            nouveauNoeud.precedent = prec;
            prec.suivant = nouveauNoeud;
            prec = nouveauNoeud;
            ensembleElementsPresents.add(tableInitiale[i]);
        }
        prec.suivant = queueS;
        queueS.precedent = prec;
    }

    private boolean estValide(E[] tableInitiale){
        if(tableInitiale==null)
            return false;
        HashSet<E> ensemble = new HashSet<>();
        for (int i = 0; i < tableInitiale.length; i++) {
            if (tableInitiale[i] == null)
                return false;
            if (ensemble.contains(tableInitiale[i]))
                return false;
            ensemble.add(tableInitiale[i]);
        }
        return true;
    }

    @Override
    public int taille() {
        return ensembleElementsPresents.size();
    }

    @Override
    public boolean estVide() {
        return taille()==0;
    }

    @Override
    public boolean contient(E element) {
        if(element==null)
            throw new IllegalArgumentException();
        //TODO
        return ensembleElementsPresents.contains(element);

    }

    @Override
    public E donnerNieme(int n) {
        if(n < 1 || n > taille())
            throw new IllegalArgumentException();
        //TODO
        Noeud cur = teteS.suivant;
        for (int i = 1; i < n; i++) {
            cur = cur.suivant;
        }
        return cur.element;
    }

    @Override
    public E supprimerDernier() {
        //TODO
        if (queueS.precedent == teteS)
            return null;
        Noeud noeudASupprimer = queueS.precedent;
        E elementASupprimer = noeudASupprimer.element;
        Noeud noeudAvant = noeudASupprimer.precedent;

        noeudAvant.suivant = queueS;
        queueS.precedent = noeudAvant;

        ensembleElementsPresents.remove(elementASupprimer);
        return elementASupprimer;


    }


    // Classe interne Noeud
    private class Noeud{
        private E element;
        private Noeud suivant;
        private Noeud precedent;

        private Noeud() {
            this(null, null, null);
        }

        private Noeud(E element) {
            this(null, element, null);
        }

        private Noeud(Noeud precedent, E element, Noeud suivant) {
            this.element = element;
            this.suivant = suivant;
            this.precedent = precedent;
        }
    }

    // pour les tests
    public String teteQueue(){
        try{
            String aRenvoyer = "(";
            Noeud baladeur = teteS.suivant;
            int cpt=0;
            while (baladeur != queueS) {
                if(cpt==0)
                    aRenvoyer += baladeur.element;
                else
                    aRenvoyer += ","+baladeur.element;
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

    // pour les tests
    public String queueTete(){
        try{
            String aRenvoyer = "(";
            Noeud baladeur = queueS.precedent;
            int cpt=0;
            while (baladeur != teteS) {
                if(cpt==0)
                    aRenvoyer += baladeur.element;
                else
                    aRenvoyer += ","+baladeur.element;
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

}
