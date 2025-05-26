import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Concours {

    private Candidat[] tableCandidats;
    private HashMap<String,Candidat> mapCandidats; //nom --> candidat
    private HashMap<String,Integer> mapVotants; //numero de telephone --> nombre de votes
    private int nombreMaxVotes;

    /**
     * debute un concours
     * @param tableNomsCandidats la table avec les noms des candidats
     * @param nombreMaxVotes le nombre maximal de votes qu'un spectateur peut faire
     * @throws IllegalArgumentException
     *           s'il n'y a pas au moins un vote possible par spectateur
     *           si la table des noms des candidats est null ou est vide
     *           s'il y a des homonymes
     */
    public Concours(String[]tableNomsCandidats,int nombreMaxVotes){
        //TODO
        if ( tableNomsCandidats == null || tableNomsCandidats.length == 0)throw new IllegalArgumentException();
        if (nombreMaxVotes < 1 )throw new IllegalArgumentException();

        tableCandidats = new Candidat[tableNomsCandidats.length];
        mapCandidats = new HashMap<>();
        mapVotants = new HashMap<>();
        this.nombreMaxVotes = nombreMaxVotes;

        for (int i = 0; i < tableNomsCandidats.length; i++) {
            String nom = tableNomsCandidats[i];
            if (mapCandidats.containsKey(nom))throw new IllegalArgumentException();

            Candidat c = new Candidat(tableNomsCandidats[i],i+1);
            tableCandidats[i] = c;
            mapCandidats.put(c.getNom(),c);
        }
    }

    public int getNombreMaxVotes() {
        return nombreMaxVotes;
    }

    /**
     * ajoute 1 vote au candidat dont le nom est passe en parametre
     * a condition que le candidat existe
     * et a condition que le nombre max de votes n'est pas atteint pour le numero de telephone passe en parametre
     * @param numeroTelephone le numero de telephone qui fait le vote
     * @param nomCandidat le nom du candidat qui fait l'objet du vote
     * @return true si le vote a ete fait, false sinon
     * @throws IllegalArgumentException
     *              si le numero de telephone est null
     *              si le nom du candidat est null
     */
    public boolean voterViaNom(String numeroTelephone, String nomCandidat) {
        //TODO
        if (numeroTelephone == null || nomCandidat == null)throw new IllegalArgumentException();

        // 1) existe-t-il un candidat de ce nom ?
        Candidat candidat = mapCandidats.get(nomCandidat);
        if (candidat == null)
            return false;

        // 2) combien de fois ce numéro a-t-il déjà voté ?
        Integer nb = mapVotants.get(numeroTelephone);
        if (nb == null)
            nb = 0;  // absent ⇒ 0 vote

        // 3) a-t-il atteint la limite ?
        if (nb >= nombreMaxVotes )
            return false;
        candidat.ajouter1Vote();
        mapVotants.put(numeroTelephone,nb+1);
        return true;
    }

    /**
     * ajoute 1 vote au candidat dont le numero est passe en parametre
     * a condition que le candidat existe
     * et a condition que le nombre max de votes n'est pas atteint pour le numero de telephone passe en parametre
     * @param numeroTelephone le numero de telephone qui fait le vote
     * @param numeroCandidat le numero du candidat qui fait l'objet du vote
     * @return true si le vote a ete fait, false sinon
     * @throws IllegalArgumentException si le numero de telephone est null
     */
    public boolean voterViaNumero(String numeroTelephone, int numeroCandidat) {
        //TODO
        // 1) validation des paramètres
        if (numeroTelephone == null)
            throw new IllegalArgumentException();

        // 2) vérifier que le numéro de candidat existe
        //    (le tableau est indexé de 0 à tableCandidats.length-1,
        //     le candidat 1 est à l’indice 0, etc.)
        if (numeroCandidat < 1 || numeroCandidat > tableCandidats.length)
            return false;
        Candidat candidat = tableCandidats[numeroCandidat - 1];

        // 3) récupérer le nombre de votes déjà faits par ce numéro de téléphone
        Integer nb = mapVotants.get(numeroTelephone);
        if (nb == null)
            nb = 0;  // jamais voté → on part de 0

        // 4) vérification de la limite
        if (nb >= nombreMaxVotes)
            return false;

        // 5) effectuer le vote
        candidat.ajouter1Vote();
        mapVotants.put(numeroTelephone, nb + 1);
        return true;
    }
    /**
     * construit une table dans laquelle les candidats apparaissent tries selon l'ordre decroissant des nombres de vote
     * @return la table dans laquelle les candidats apparaissent tries selon l'ordre decroissant des nombres de vote
     */
    public Candidat[] classement(){
        // Utilisez les methodes copyOf() et sort() de la classe Arrays !
        // cfr enonce
        //TODO
            // copie pour ne pas modifier tableCandidats
            Candidat[] classement = Arrays.copyOf(tableCandidats, tableCandidats.length);

            // tri décroissant sur le nombre de votes, en une seule ligne
            Arrays.sort(classement,
                    (c1, c2) -> Integer.compare(c2.getNombreVotes(), c1.getNombreVotes())
            );

            return classement;

    }

    @Override
    // A NE PAS MODIFIER
    public String toString() {
        return "maxVotes=" + nombreMaxVotes +
                "\ntableCandidats=" + Arrays.toString(tableCandidats) +
                "\nmapCandidats=" + mapCandidats +
                "\nmapVotants=" + mapVotants;
    }

}

