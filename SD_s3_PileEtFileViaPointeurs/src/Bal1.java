public class Bal1 implements Bal{

    /**
     * Cette classe retient les etudiants inscrits au bal
     * Une liste chainee contient d abord les hommes, ensuite les femmes
     * Dans chacune des sous-listes, l'ordre suit l'ordre des inscription
     */

    private NoeudEtudiant teteS;
    private NoeudEtudiant derM;
    private NoeudEtudiant queueS;

    /**
     * construit un bal avec aucun participant
     */
    public Bal1(){
        // TODO
        // construit une liste avec 2 noeuds sentinelles
        // les elements de ces noeuds sentinelles sont a null
        // regardez bien le schema de l enonce
        teteS = new NoeudEtudiant();
        derM = teteS;
        queueS = new NoeudEtudiant();
        teteS.suivant = queueS;

    }


    /**
     * ajoute l etudiant dans la liste en tenant compte de l'ordre prevu
     * @param etudiant l etudiant a ajouter
     * @throws IllegalArgumentException si l etudiant est null
     */
    public void ajouterEtudiant(Etudiant etudiant){
        if(etudiant==null)
            throw new IllegalArgumentException("etudiant null");
        //TODO

        NoeudEtudiant nouveauNoeud = new NoeudEtudiant(etudiant);

        if (etudiant.getSexe() == 'M') {
            nouveauNoeud.suivant = derM.suivant;
            derM.suivant = nouveauNoeud;
            derM = nouveauNoeud;
        } else {

            NoeudEtudiant courant = derM;
            while (courant.suivant != queueS){
                courant = courant.suivant;
            }
            nouveauNoeud.suivant =queueS;
            courant.suivant = nouveauNoeud;
        }
}

    // A NE PAS MODIFIER
    // VA SERVIR POUR LES TESTS
    public String toString(){

        NoeudEtudiant baladeur = teteS.suivant;
        if(baladeur== queueS){
            return "[]";
        }
        String aRenvoyer = "["+baladeur.etudiant;
        baladeur = baladeur.suivant;
        while(baladeur!= queueS){
            aRenvoyer += ", " + baladeur.etudiant;
            baladeur = baladeur.suivant;
        }
        return aRenvoyer+"]";
    }

    // classe interne
    private class NoeudEtudiant{

        private Etudiant etudiant;
        private NoeudEtudiant suivant;

        public NoeudEtudiant(){
            this.etudiant = null;
            this.suivant = null;
        }

        public NoeudEtudiant(Etudiant etudiant){
            this.etudiant = etudiant;
            this.suivant = null;
        }

        public NoeudEtudiant(Etudiant etudiant, NoeudEtudiant suivant){
            this.etudiant = etudiant;
            this.suivant = suivant;
        }

    }
}


