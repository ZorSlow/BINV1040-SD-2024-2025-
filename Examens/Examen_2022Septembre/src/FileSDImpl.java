import java.util.HashSet;

public class FileSDImpl<E> implements FileSD<E>{
    private Noeud tete;
    private Noeud queue;
    private HashSet<E> ensemble;

    public FileSDImpl(){
        tete=null;
        queue=null;
        ensemble = new HashSet<E>();
    }

    @Override
    public boolean estVide() {
        return ensemble.isEmpty();
    }

    @Override
    public int taille() {
        return ensemble.size();
    }

    @Override
    public E premier(){
        if(tete==null)
            return null;
        return tete.element;
    }

    @Override
    public E dernier(){
        if(queue==null)
            return null;
        return queue.element;
    }

    @Override
    public boolean contient(E element) {
        //TODO
        return false;
    }

    @Override
    public boolean enfile(E element) {
        //TODO
        return false;
    }

    @Override
    public E defile() {
        //TODO
        return null;
    }

    @Override
    public int position(E element) {
        //TODO
        return -1;
    }

    // classe interne
    private class Noeud{
        private E element;
        private Noeud suivant;

        private Noeud(E element, Noeud suivant){
            this.element = element;
            this.suivant = suivant;
        }

        private Noeud(E element){
            this.element = element;
            this.suivant = null;
        }

    }

    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    // ["d1","d2","d3"] --> tete "d1" "d2" "d3" queue
    public FileSDImpl(Object[] table) {
        if(table==null)
            throw new IllegalArgumentException("table null");
        if(table.length<1)
            throw new IllegalArgumentException("table vide");
        ensemble = new HashSet<>();
        queue = new Noeud((E)table[table.length-1],null);
        ensemble.add((E)table[table.length-1]);
        Noeud noeud = queue;
        for (int i = table.length-2; i>=0;i--) {
            noeud = new Noeud((E)table[i],noeud);
            ensemble.add((E)table[i]);
        }
        this.tete=noeud;
    }

    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    public String toString(){
        if(tete==null)
            return "";
        return tete.element + toString(tete.suivant,1);
    }

    private String toString(Noeud noeud, int cpt) {
        if(cpt==10)
            return "boucle infinie";
        if(noeud==null)
            return "";
        cpt++;
        return " "+noeud.element+toString(noeud.suivant,cpt);
    }


}
