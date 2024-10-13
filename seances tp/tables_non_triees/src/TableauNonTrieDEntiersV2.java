import java.util.HashSet;

public class TableauNonTrieDEntiersV2 {

    private int[] t;
    private int nombreEntiers; // taille logique
    private static final int TAILLE = 10; // taille physique

    // Les nombreEntiers entiers occupent les nombreEntiers premieres cases du tableau!
    // PAS DE TROU!
    // L'ordre des entiers doit etre conserve lors des suppressions

    public TableauNonTrieDEntiersV2() {
        t = new int[TAILLE];
        nombreEntiers = 0;
    }


    public int getNombreEntiers() {
        return this.nombreEntiers;
    }

    /**
     * supprime la premiere occurrence d'un entier
     * @param entier l'entier a supprimer
     * @return true si l'entier a pu etre supprime, false sinon
     */

    private int trouverIndice(int entier){
        for (int i = 0; i < nombreEntiers; i++) {
            if(t[i]==entier)
                return i;
        }
        return -1;
    }

    public boolean supprimerPremiereOccurrence(int entier) {
        int indice=-1;
        for (int i = 0; i < nombreEntiers; i++) {
            if(t[i]==entier) {
                indice = i;
                break;
            }

        }
        if(indice!=-1) {
            if (indice == nombreEntiers-1) {
                nombreEntiers--;
                return true;
            }
            for (int i = indice; i < nombreEntiers-1 ; i++) {
                t[i] = t[i + 1];
            }
            nombreEntiers--;
            return true;
        }
        return false;
    }

    /**
     * supprime toutes les occurrences d'un entier
     * @param entier l'entier a supprimer
     * @return le nombre de suppressions effectuees
     */
    public int supprimerToutesLesOccurrences(int entier) {
        int supression=0;
        int i=0;
        while(i<nombreEntiers){
            if (t[i] == entier) {
                for (int j = i; j <nombreEntiers-1 ; j++) {
                    t[j] = t[j + 1];
                }
                nombreEntiers--;
                supression++;

                if(t[i]!=entier)
                    i++;
            }
           else i++;
        }
        return supression;
    }

    /**
     * supprime tous les ex-aequos.
     * Notez que cette methode laisse exactement une occurence de chaque entier qui se trouvait dans le tableau initial.
     * @return int le nombre de suppressions effectuees
     */
    public int supprimerTousLesExAequos() {
        int supression=0;
        return supression ;
    }

    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public TableauNonTrieDEntiersV2(int[] tableARecopier, int tailleLogique) {
        if (tableARecopier == null)
            throw new IllegalArgumentException();
        if (tailleLogique > tableARecopier.length || tableARecopier.length > TAILLE)
            throw new IllegalArgumentException();
        this.nombreEntiers = tailleLogique;
        t = new int[TAILLE];
        for (int i = 0; i < tableARecopier.length; i++) {
            t[i] = tableARecopier[i];
        }
    }

    // A NE PAS MODIFIER
    // VA SERVIR POUR LES TESTS
    public TableauNonTrieDEntiersV2(int[] tableARecopier) {
        this(tableARecopier, tableARecopier.length);
    }

    // A NE PAS MODIFIER
    // VA SERVIR POUR LES TESTS
    public HashSet<Integer> toHashSet(){
        HashSet<Integer> ensemble = new HashSet<Integer>();
        for (int i = 0; i < nombreEntiers; i++) {
            ensemble.add(t[i]);
        }
        return ensemble;
    }

    // A NE PAS MODIFIER
    // VA SERVIR POUR LES TESTS
    @Override
    public String toString() {
        if(nombreEntiers ==0)
            return "[]";
        String aRenvoyer = "["+ t[0];
        for (int i = 1; i < nombreEntiers; i++)
            aRenvoyer = aRenvoyer + ", " + this.t[i];
        return aRenvoyer+"]";
    }

}
