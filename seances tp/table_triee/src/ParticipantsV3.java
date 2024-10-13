public class ParticipantsV3 {

    private String[] tableParticipants;
    private int nombreInscrits; 	// taille logique

    // Les nombreInscrits participants occupent les nombreInscrits premieres
    // cases du tableau (pas de trou)
    // la table est triee par ordre alphabetique

    /**
     * construit un objet Participants
     * au depart, il n'y a pas d'inscrit
     * @param nombreMaxParticipants le nombre maximum de participants
     */
    public ParticipantsV3(int nombreMaxParticipants) {
        if (nombreMaxParticipants < 1)
            throw new IllegalArgumentException();
        this.tableParticipants = new String[nombreMaxParticipants];
        this.nombreInscrits = 0;
    }

    /**
     * renvoie le nombre de participants actuellement inscrits
     * @return le nombre de participants actuellement inscrits
     */
    public int getNombreInscrits() {
        return this.nombreInscrits;
    }


    private int trouverIndiceParticipant(String participant){
        //methode private
        //recherche a quel indice se trouve le participant passe en parametre
        //renvoie -1 si le participant n'est pas present
        for (int i = 0; i < nombreInscrits; i++) {
            if(tableParticipants[i].equals(participant))
                return i;
            if(tableParticipants[i].compareTo(participant) > 0)
                return -1;
        }
        return -1;
    }

    /**
     * verifie la presence du participant
     * @param participant le nom du participant recherche
     * @return true si le participant est present, false sinon
     */
    public boolean contientParticipant(String participant){
        return trouverIndiceParticipant(participant)!=-1;
    }

    /**
     * ajoute un participant a la table des participants
     * a condition qu'il ne soit pas deja present
     * et a condition que le nombre maximum de participants ne soit pas atteint
     * @param participant le participant a ajouter
     * @return true si l'ajout a pu se faire, false sinon
     */
    public boolean ajouterUnParticipant(String participant) {
        if(participant==null||participant.length()==0)
            throw new IllegalArgumentException();

        if (!contientParticipant(participant) && nombreInscrits < tableParticipants.length) {
            tableParticipants[nombreInscrits] = participant;
            nombreInscrits++;
            for (int i = nombreInscrits - 1; i >= 0; i--) { // Je ne comprends pas cette étape.
                if (participant.compareTo(tableParticipants[i]) < 0) {
                    String temp = tableParticipants[i];
                    tableParticipants[i] = tableParticipants[i + 1];
                    tableParticipants[i + 1] = temp;
                }
            }
            return true;
        }
        return false;

        // CONTRAINTE : UTILISER L ALGORITHME D INSERTION DANS UNE TABLE TRIEE VU AU COURS
        // Si cela ne va pas refaites le test moodle classe ParticipantsV3
        // et/ou revoyez la video InsertionV3_demo

    }

    /**
     * supprime le participant passe en parametre
     * @param participant Le participant a supprimer
     * @return true si la suppression a pu etre faite, false sinon
     */
    public boolean supprimerUnParticipant(String participant) {
        if(participant==null||participant.length()==0)
            throw new IllegalArgumentException();
        int indice =trouverIndiceParticipant(participant);
        if(indice!=-1) {
            for (int i = indice; i < nombreInscrits - 1; i++) {
                tableParticipants[i] = tableParticipants[i + 1];
            }
            nombreInscrits--;
            return true;
        }
        return false;

        // Pensez a utiliser la methode trouverIndiceParticipant()

        // Si cela ne va pas, refaites le QCM classe ParticipantsV2 sur moovin
        // de la semaine table non triee


    }


    // A NE PAS MODIFIER
    // VA SERVIR POUR LES TESTS
    public ParticipantsV3(int nombreParticipants, String[] tableARecopier) {
        this.tableParticipants = new String[nombreParticipants];
        this.nombreInscrits = tableARecopier.length;
        for (int i = 0; i < nombreInscrits; i++)
            this.tableParticipants[i] = tableARecopier[i];
    }

    // A NE PAS MODIFIER
    // VA SERVIR POUR LES TESTS
    public String toString() {
        if(nombreInscrits==0)
            return "[]";
        String aRenvoyer = "["+tableParticipants[0];
        for (int i = 1; i < nombreInscrits; i++)
            aRenvoyer = aRenvoyer + ", " + this.tableParticipants[i];
        return aRenvoyer+"]";
    }



}
