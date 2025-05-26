import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FileAttenteSDImpl<E> implements FileAttenteSD<E> {

    private Noeud tete, queue;
    private HashSet<E> ensemble;

    // N'ajoutez pas d'autres attributs

    // A NE PAS MODIFIER !
    public FileAttenteSDImpl() {
        ensemble = new HashSet<>();
        tete = null;
        queue = null;
    }

    // A NE PAS MODIFIER !
    public int taille() {
        return ensemble.size();
    }

    // A NE PAS MODIFIER !
    public E premier(){
        if(tete == null)
            return null;
        return tete.element;
    }

    // A NE PAS MODIFIER !
    public E dernier(){
        if(queue == null)
            return null;
        return queue.element;
    }

    @Override
    public boolean enfile(E element) {
        //TODO
        if(!ensemble.contains(element)){
            Noeud nouveauNoeud = new Noeud(element);

            if(tete == null){
                tete = nouveauNoeud;
            }
            else {
                queue.suivant = nouveauNoeud;
            }
            queue = nouveauNoeud;
            ensemble.add(element);
            return true;
        }
        return false;
    }

    @Override
    public E defile() {
        //TODO
        if (tete == null) { // Cas particulier : file vide
            return null;
        }
        E elementASupprimer = tete.element;
        ensemble.remove(elementASupprimer); // Supprime l'élément du HashSet
        tete = tete.suivant; // Déplace la tête de la file au suivant

        if (tete == null) { // Si la file est vide après suppression
            queue = null;
        }
        return elementASupprimer;
    }

    @Override
    public Iterator<E> iterator() {
        return new IterateurImpl();
    }

    private class IterateurImpl implements Iterator {

        private Noeud noeudNext;

        // Au depart le noeud "next" est le noeud de tete
        private IterateurImpl() {
            //TODO
            noeudNext = tete;
        }

        @Override
        // verifie si le noeud "next" est null
        public boolean hasNext() {
            // TODO

            return noeudNext != null;
        }

        @Override
        // renvoie l element qui se trouve dans le noeud "next"
        // le noeud "next" passe au noeud suivant
        public E next() {
            // TODO
            if (!hasNext())throw new NoSuchElementException();
            E element = noeudNext.element;
            noeudNext = noeudNext.suivant;
            return element;
        }

    }

    // classe interne
    private class Noeud {
        private E element;
        private Noeud suivant;

        private Noeud(E element, Noeud suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        private Noeud(E element) {
            this.element = element;
            this.suivant = null;
        }
    }


    // A NE PAS MODIFIER !
    // pour les tests
    public FileAttenteSDImpl(E[] table) {
        ensemble = new HashSet<>();
        if(table.length==0)
            return;
        queue = new Noeud((E)table[table.length-1],null);
        ensemble.add(table[table.length-1]);
        Noeud noeud = queue;
        for (int i = table.length-2; i>=0;i--) {
            noeud = new Noeud((E)table[i],noeud);
            ensemble.add((E)table[i]);
        }
        this.tete=noeud;
    }


    // A NE PAS MODIFIER !
    // pour les tests
    public String toString() {
        try {
            String aRenvoyer = "(";
            Noeud baladeur = tete;
            int cpt = 0;
            while (baladeur != null) {

                if (cpt == 0)
                    aRenvoyer += baladeur.element;
                else
                    aRenvoyer += "," + baladeur.element;
                cpt++;

                if (cpt > 20) {
                    return "boucle infinie dans toString(), chainage a verifier";
                }

                baladeur = baladeur.suivant;
            }
            return aRenvoyer + ")";
        } catch (NullPointerException e) {
            return "nullPointerException";
        }
    }

}
