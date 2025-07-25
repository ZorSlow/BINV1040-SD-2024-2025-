public class DequeImplChaineeAS<E> implements Deque<E>{


    private Noeud teteS;
    private Noeud queueS;
    private int taille ;

    public DequeImplChaineeAS(){
        teteS =new Noeud(null);
        queueS =new Noeud(null);
        teteS.suivant= queueS;
        queueS.precedent= teteS;
        taille=0;
    }

    public int taille() {
        return this.taille ;
    }

    public boolean estVide() {
        return (taille==0) ;
    }

    public E premier() throws DequeVideException {
        //TODO
        if (estVide())throw new DequeVideException();
        return teteS.suivant.element;
    }

    public E dernier() throws DequeVideException {
        //TODO
        if (estVide())throw new DequeVideException();
        return queueS.precedent.element;
    }

    public E retirerPremier() throws DequeVideException {
        if (estVide()) throw new DequeVideException();
        Noeud premier = teteS.suivant;
        E element = premier.element;
        teteS.suivant = premier.suivant;
        premier.suivant.precedent = teteS;
        taille--;
        return element;
    }

    public E retirerDernier() throws DequeVideException {
        if (estVide()) throw new DequeVideException();
        Noeud dernier = queueS.precedent;
        E element = dernier.element;
        queueS.precedent = dernier.precedent;
        dernier.precedent.suivant = queueS;
        taille--;
        return element;
    }

    public void ajouterEnPremier(E element) {
        //TODO
        Noeud nouveauNoeud = new Noeud(element);
        Noeud noeudApres = teteS.suivant;
        nouveauNoeud.suivant  = noeudApres;
        nouveauNoeud.precedent = teteS;
        noeudApres.precedent = nouveauNoeud;
        teteS.suivant = nouveauNoeud;
        taille++;
    }

    public void ajouterEnDernier(E element) {
        //TODO
        Noeud nouveauNoeud = new Noeud(element);
        Noeud noeuAvant = queueS.precedent;
        nouveauNoeud.suivant = queueS;
        nouveauNoeud.precedent = noeuAvant;
        noeuAvant.suivant = nouveauNoeud;
        queueS.precedent = nouveauNoeud;
        taille++;

    }

    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    // teteS 'a' 'b' 'c' queueS : ['a','b','c']
    public DequeImplChaineeAS(Object[] table) {
        if(table == null)
            throw new IllegalArgumentException();
        taille = 0 ;
        teteS = new Noeud(null) ;
        queueS = new Noeud(null) ;
        teteS.suivant= queueS;
        queueS.precedent= teteS;
        if(table.length==0)
            return;
        for (int i = table.length-1; i>=0;i--) {
            this.ajouterTest((E) table[i]) ;
        }
    }

    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    public String toString(){
        String aRenvoyer="";
        Noeud baladeur= teteS.suivant;
        int cpt = 0;
        while(baladeur!= queueS) {
            cpt++;
            if(cpt>taille){
                aRenvoyer = "boucle infinie dans toString(), chainage a verifier";
            }
            aRenvoyer+=baladeur.element;
            if (baladeur.suivant != queueS)
                aRenvoyer += " " ;
            baladeur=baladeur.suivant;
        }
        return aRenvoyer;
    }

    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    public String parcoursInverse(){
        String aRenvoyer="";
        Noeud baladeur= queueS.precedent;
        int cpt = 0;
        while(baladeur!= teteS) {
            cpt++;
            if(cpt>taille){
                aRenvoyer = "boucle infinie dans toString(), chainage a verifier";
            }
            aRenvoyer+=baladeur.element;

            if (baladeur.precedent != teteS)
                aRenvoyer += " " ;
            baladeur=baladeur.precedent;
        }
        return aRenvoyer;
    }

    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    public void ajouterTest(E element) {
        Noeud nouveauNoeud = new Noeud(element) ;
        nouveauNoeud.suivant = teteS.suivant;
        nouveauNoeud.precedent = teteS;
        teteS.suivant.precedent = nouveauNoeud;
        teteS.suivant = nouveauNoeud;
        taille++;
    }


    // classe interne
    private class Noeud{
        private E element;
        private Noeud precedent;
        private Noeud suivant;

        private Noeud(E element){
            this.element = element;
            this.precedent = null ;
            this.suivant = null;
        }

        private Noeud(E element, Noeud precedent, Noeud suivant){
            this.element = element;
            this.precedent = precedent ;
            this.suivant = suivant;
        }
    }
}
