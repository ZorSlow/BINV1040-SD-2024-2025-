import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ParcAConteneurs {
    private HashSet<String>[] tablePeriodes; //table avec l'ensemble des voitures autorisees pour chaque periode
    private HashMap<String,Integer> mapVoitures; //voiture (plaque)  --> nombre de periodes reservees pour cette voiture
    private int maxPeriodes; //nombre max de periodes pour une meme voiture
    private int maxVoitures; //nombre max de voitures pour une meme periode

    /**
     * debute une semaine de reservation
     * @param nombrePeriodes le nombre de periodes de cette semaine
     * @param maxVoitures le nombre maximal de voitures autorisees sur une periode
     * @param maxPeriodes le nombre maximal de periodes qu'une meme voiture peut reserver sur cette semaine
     * @throws IllegalArgumentException
     *    s'il n'y a pas au moins une periode
     *    s'il n'y a pas au moins une voiture par periode
     *    s'il n'y a pas au moins une periode par voiture
     */
    public ParcAConteneurs(int nombrePeriodes, int maxVoitures, int maxPeriodes){
        //TODO
        if(maxPeriodes <1 || maxVoitures < 1 || nombrePeriodes < 1)throw new IllegalArgumentException();
        tablePeriodes = new HashSet[nombrePeriodes];
        mapVoitures = new HashMap<>();
        this.maxPeriodes = maxPeriodes;
        this.maxVoitures= maxVoitures;
        for (int i = 0; i < nombrePeriodes; i++) {
            tablePeriodes[i] = new HashSet<>();
        }

    }

    /**
     * enregistre, si possible, la voiture pour la periode demandee
     * (La numerotation des periodes commence a 1)
     * la voiture ne peut pas depasser le nombre max de periodes autorisees par voiture
     * la voiture ne peut pas deja etre enregistree pour cette periode
     * le nombre de voitures max pour la periode demandee ne peut etre atteint
     * @param voiture la voiture a enregistrer
     * @param numeroPeriode la periode demandee
     * @return true si la voiture a ete enregistree pour la periode demandee, false sinon
     * @throws IllegalArgumentException si la voiture est null ou vide
     *                                  si la periode n'existe pas
     */
    public boolean enregistrerVoiture(String voiture, int numeroPeriode) {
        // Vérification de la validité de la voiture
        if (voiture == null || voiture.isEmpty()) {
            throw new IllegalArgumentException("Voiture invalide");
        }

        // Vérification de la validité de la période
        if (numeroPeriode < 1 || numeroPeriode > tablePeriodes.length) {
            throw new IllegalArgumentException("Période invalide");
        }

        int index = numeroPeriode - 1;

        // Vérifier si la voiture est déjà enregistrée pour cette période
        if (tablePeriodes[index].contains(voiture)) {
            return false;
        }

        // Vérifier si la période est déjà pleine
        if (tablePeriodes[index].size() >= maxVoitures) {
            return false;
        }

        // Vérifier le nombre de périodes déjà réservées par cette voiture
        Integer nbrPeriode = mapVoitures.get(voiture);
        if (nbrPeriode == null) {
            nbrPeriode = 0; // Si la voiture n'existe pas, elle a 0 réservation
        }
        if (nbrPeriode >= maxPeriodes)
            return false;
        /*
        Integer nbrPeriode = mapVoitures.get(voiture);
        if (nbrPeriode != null && nbrPeriode >= maxPeriodes)
            return false;
         */

        // Effectuer l'enregistrement
        tablePeriodes[index].add(voiture);
        mapVoitures.put(voiture, nbrPeriode + 1);

        return true;
    }
    /**
     * verifie si la voiture a bien ete enregistree pour cette periode
     * (La numerotation des periodes commence a 1)
     * @param voiture la voiture verifiee
     * @param numeroPeriode la periode verifiee
     * @return true si la voiture est autorisee, false sinon
     * @throws IllegalArgumentException si la voiture est null ou vide
     *                                  si la periode n'existe pas
     */
    public boolean estAutorisee(String voiture, int numeroPeriode) {
        //TODO
        if(voiture == null || voiture.isEmpty() || numeroPeriode < 1 || numeroPeriode> tablePeriodes.length)throw new IllegalArgumentException();

        return tablePeriodes[numeroPeriode -1].contains(voiture);
    }

    /**
     * construit une liste avec les numeros des periodes non pleines
     * cette liste est triee selon l'ordre croissant des periodes
     * @return la liste avec les numeros des periodes non pleines
     */
    public ArrayList<Integer> listePeriodesNonPleines(){
        //TODO
        ArrayList<Integer> resultat = new ArrayList<>();
        for (int i = 0; i < tablePeriodes.length; i++) {
            if (tablePeriodes[i].size() < maxPeriodes)
                resultat.add(i+1);
        }
        return resultat;
        //aucun tri n'est necessaire, reflechissez !
    }

    @Override
    public String toString() {
        //Vous pouvez modifier cette methode
        //MAIS
        //Cette methode ne sera pas evaluee
        //Ne perdez pas de temps
        return "tablePeriodes=" + Arrays.toString(tablePeriodes) +
                "\nmapVoitures=" + mapVoitures +
                "\nmaxVoitures=" + maxVoitures +
                "\nmaxPeriodes=" + maxPeriodes;
    }
}
