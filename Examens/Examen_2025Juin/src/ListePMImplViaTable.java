import java.util.HashSet;

public class ListePMImplViaTable<E> implements ListePM<E> {

    private E[] table;
    private int taille; //taille logique

    /**
     * construit une liste initiale
     * @param tableInitiale la table initiale avec les elements de la liste de depart
     * @throws IllegalArgumentException si la table passee en parametre est null, contient des null ou des ex-aequos
     */
    public ListePMImplViaTable(E[] tableInitiale ){
        if(!estValide(tableInitiale))
            throw new IllegalArgumentException();
        table = (E[]) new Object[tableInitiale.length];
        for (int i = 0; i < tableInitiale.length; i++) {
            table[i]=tableInitiale[i];
        }
        taille = tableInitiale.length;
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
        return taille;
    }

    @Override
    public boolean estVide() {
        return taille==0;
    }

    @Override
    public boolean contient(E element) {
        if(element==null)
            throw new IllegalArgumentException();
        //TODO
        for (int i = 0; i < taille; i++) {
            if (table[i].equals(element))
                return true;
        }
        return false;

    }


    @Override
    public E donnerNieme(int n) {
        if(n < 1 || n > taille)
            throw new IllegalArgumentException();
        //TODO

        return table[n-1];

    }


    @Override
    public E supprimerDernier() {
        //TODO
        if (taille == 0)
            return null;
        E dernier = table[taille -1];
        table[taille-1] = null;
        taille--;
        return dernier;

    }

    // A NE PAS MODIFIER !!!
    //ce constructeur sert pour les tests
    //la table passee en parametre peut contenir des null en fin de table
    //apres quelques suppressions, la table contiendra des null en fin de table
    //on voudrait tester les methodes dans cette situation
    public ListePMImplViaTable(E[] tableACopier, int taille ){
        table = (E[]) new Object[tableACopier.length];
        for (int i = 0; i < tableACopier.length; i++) {
            table[i]=tableACopier[i];
        }
        this.taille = taille;
    }

}
