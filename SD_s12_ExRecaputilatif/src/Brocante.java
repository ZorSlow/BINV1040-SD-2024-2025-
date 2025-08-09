import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class Brocante {

    private int phase = 1;

    private Emplacement[] tableEmplacements;
    private HashMap<String, Integer> mapRiverains;
    private ArrayDeque<Emplacement> pileEmplacementsLibres;

    //private String tableRiverains[] 
    //inutile, regardez bien les schemas, cette table n'apparait pas !


    public int getPhase() {
        return phase;
    }

    /**
     * initialise une brocante avec nombre emplacements
     * @param nombreEmplacements le nombre d'emplacements
     * @param tableRiverains la table des riverains
     * @throws IllegalArgumentException si le nombre d'emplacements est negatif ou nul ou si la table des riverains est null
     */
    public Brocante(int nombreEmplacements, String[] tableRiverains) {
        //TODO
        if (nombreEmplacements <=0 || tableRiverains == null)throw new IllegalArgumentException();
        tableEmplacements = new Emplacement[nombreEmplacements];
        for (int i = 0; i < nombreEmplacements; i++) {
             tableEmplacements[i] = new Emplacement(i);
        }
        mapRiverains = new HashMap<>();
        for (String riverin : tableRiverains)
            mapRiverains.put(riverin,0);
        pileEmplacementsLibres = new ArrayDeque<>();
        for (int i = 0; i < nombreEmplacements; i++) {
            pileEmplacementsLibres.add(tableEmplacements[i]);
        }
    }

    /**
     * Verifie si le nom fourni corespond a un riverain enregistré
     *
     * @param nom
     * @return envoie true si le nom est celui d'un riverrain, sinon false.
     */
    boolean estUnRiverain (String nom){
        return mapRiverains.containsKey(nom);
    }

    /**
     * Renvoie le nombre d'emblpament reservé par le riverain specifié
     * @param nom
     * @return renvoie le nombre d'emplacements réservé par le riverain
     */
    int nombreEmplacementsRiverain (String nom) {
        if (estUnRiverain(nom))
            return mapRiverains.get(nom);
        return 0;
    }// pour la phase 1 uniquement

    /**
     * Vérifie si l'emplcement donné est libre
     * @param numeroEmplacement le numero de l'emplacement
     * @return true si l'emplacement est libre, false
     */
    boolean estLibre (int numeroEmplacement){
     if (numeroEmplacement < 0 || numeroEmplacement >= tableEmplacements.length ) throw new IllegalArgumentException();
     return pileEmplacementsLibres.contains(tableEmplacements[numeroEmplacement]);
    }

    /**
     * Vérifie s'il reste au moins un emplacement libre.
     * @return true s'il reste des emplacements libres, false sinon.
     */
    boolean emplacementLibre (){
        return !pileEmplacementsLibres.isEmpty();
    } // il y a encore des emplacements de libres ?

    /**
     * reserve l'emplacement qui porte le numero passe en parametre au demandeur passe en parametre
     * La reservation reussit si
     *     l'emplacement est libre
     *     le demandeur est bien un riverain
     *     le riverain n'a pas encore 3 emplacements
     * @param demandeur le riverain qui demande un emplacement
     * @param numeroEmplacement le numero de l'emplacement souhaite
     * @return true si la reservation a reussi, false sinon
     * @throws IllegalArgumentException si le numero de l'emplacement n'existe pas
     * @throws IllegalStateException si on n'est pas en phase 1
     */
    public boolean reserver(Exposant demandeur, int numeroEmplacement) {
        //TODO

        //Attention pour augmenter le nombre d'emplacements
        //Solution ko:
        //Integer nombreEmplacements = mapRiverains.get(demandeur);
        //mapRiverains.put(demandeur, nombreEmplacements++);
        //Solutions ok:
        //Integer nombreEmplacements = mapRiverains.get(demandeur);
        //mapRiverains.put(demandeur, ++nombreEmplacements);
        //ou:
        //Integer nombreEmplacements = mapRiverains.get(demandeur);
        //nombreEmplacements++;
        //mapRiverains.put(demandeur, nombreEmplacements);
        if (demandeur == null || numeroEmplacement < 0 || numeroEmplacement >= tableEmplacements.length)throw new IllegalArgumentException();
        if (phase !=1)throw new IllegalStateException();
        if (!estLibre(numeroEmplacement)) return false;
        if(nombreEmplacementsRiverain(demandeur.getNom()) >=3)return false;

        tableEmplacements[numeroEmplacement].setExposant(demandeur);
        pileEmplacementsLibres.remove(tableEmplacements[numeroEmplacement]);

        String nom = demandeur.getNom();
        Integer nompbreEmplacements = mapRiverains.get(nom);
        nompbreEmplacements++;
        mapRiverains.put(nom,nompbreEmplacements);
        return true;

    }

    /**
     * attribue automatiquement un emmplacement libre au demandeur passe en parametre
     * @param demandeur le demandeur d'un emplacement
     * @return le numero de l'emplacement attribue ou -1 si plus d'emplacement libre
     * @throws IllegalStateException si on n'est pas en phase 2
     */
    public int attribuerAutomatiquementEmplacement(Exposant demandeur) {
        //TODO
        if (phase !=2)throw new IllegalStateException();
        if (!pileEmplacementsLibres.isEmpty());
        pileEmplacementsLibres.removeLast();


        return -1;

    }

    /**
     * a comme effet de passer de la phase 1 a la phase 2
     * si deja en phase 2, rien ne doit etre fait
     */
    public void changerPhase() {
        //TODO
        //Pensez a initialiser la pile!!!

    }

    @Override
    public String toString() {
        String aRenvoyer="";
        for (int i = 0; i < tableEmplacements.length; i++) {
            if(tableEmplacements[i].getExposant()==null){
                aRenvoyer +=  ("\n"+i+" : /");
            }else{
                aRenvoyer +=  ("\n"+i+" : "+tableEmplacements[i].getExposant());
            }
        }
        return aRenvoyer;
    }

    //Pour le debug
    public String donnerTableEmplacements() {
        if(tableEmplacements==null)
            return "null";
        return Arrays.toString(tableEmplacements);
    }

    //Pour le debug
    public String donnerMapRiverains() {
        if(mapRiverains==null)
            return "null";
        return mapRiverains.toString();
    }

    //Pour le debug
    public String donnerPileEmplacementsLibres() {
        if(pileEmplacementsLibres==null)
            return "null";
        return pileEmplacementsLibres.toString();
    }
  
}
