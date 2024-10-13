import java.util.NoSuchElementException;

public class TableNegatifsPuisPositifs {
    private int[] tableNP;
    private int nbNegatifs;
    private int nbPositifsEtNuls;
    private static final int MAX = 10; // taille physique

    // tableNP ne peut pas contenir plus de MAX entiers, mais pourrait en contenir moins
    // Les entiers occupent les (nbNegatifs + nbPositifsEtNuls) premieres cases du tableau!
    // On trouve d'abord les entiers < 0 ensuite les entiers >= 0
    // L'ordre des entiers parmi les entiers < 0 n'a pas d'importance
    // L'ordre des entiers parmi les entiers >= 0 n'a pas d'importance

    /**
     * ce constructeur construit une tableNP en y placant les entiers de la table recue en parametre
     * L'ordre des entiers < 0 dans tableNP doit correspondre a l'ordre des entiers < 0 de la table fournie
     * L'ordre des entiers >= 0 dans tableNP doit correspondre a l'ordre des entiers >= 0 de la table fournie
     * Ex :
     * tableFournie : -5 7 -8 1 0 2 -1 1
     * -->
     * tableNP : -5 -8 -1 7 1 0 2 1
     * @param tableFournie la table avec les entiers a placer dans tableNP
     * @throws IllegalArgumentException si la table fournie est null ou contient plus de MAX entiers
     */
    public TableNegatifsPuisPositifs(int[] tableFournie) {
        if(tableFournie==null || tableFournie.length > MAX)
            throw new IllegalArgumentException();

        int indice=0;
        tableNP = new int[MAX];
        for (int i = 0; i < tableFournie.length; i++) {
            if(tableFournie[i]<0){
                tableNP[indice]=tableFournie[i];
                indice++;
                nbNegatifs++;
            }
        }
        indice=nbNegatifs;
        for (int i = 0; i <tableFournie.length ; i++) {
            if(tableFournie[i]>=0){
                tableNP[indice]=tableFournie[i];
                indice++;
                nbPositifsEtNuls++;
            }
        }

        //Contrainte : pas plus de 2 parcours de la table fournie pour construire la tableNP
        //Lors du 1er parcours, on place les entiers < 0 et lors du 2eme parcours les entiers >= 0

    }

    public int getNbNegatifs() {
        return nbNegatifs;
    }

    public int getNbPositifsEtNuls() {
        return nbPositifsEtNuls;
    }

    /**
     * calcule la moyenne des entiers > 0 (pas les 0)
     * @return la moyenne des entiers > 0 ou 0 s'il n'y a pas d'entiers > 0
     */
    public double moyenneStrictementPositifs(){
        int tailleLogique=nbNegatifs + nbPositifsEtNuls;
        if(nbPositifsEtNuls==0)
            return 0;
        double moyenne;
        int entiers_positifs=0;
        int somme=0;
        for (int i = nbNegatifs ; i < tailleLogique ; i++) {
            if(tableNP[i]!=0){
                somme=somme+tableNP[i];
                entiers_positifs++;
            }
        }
        //Pensez a optimiser votre methode !
        //Les entiers > 0 se trouvent parmi les entiers >= 0.

        moyenne = (double) somme / entiers_positifs;
        return moyenne;

    }

    /**
     * verifie si tous les entiers de la table sont < entier passe en parametre
     * renvoie true si la table est vide
     * @param entier l'entier verifie
     * @return true si les entiers de la table sont tous < entier passe en parametre ou si la table est vide, false sinon
     */
    public boolean tousStrictementPlusPetits(int entier){
        int tailleLogique=nbNegatifs + nbPositifsEtNuls;
        if(tailleLogique==0) return true;
        if(entier>0 && nbPositifsEtNuls==0) return true;
        if(entier<0 && nbNegatifs==0) return false;

        for (int i = 0; i < tailleLogique; i++) {
            if(tableNP[i]>=entier)
                return false;
        }

        //Pensez a optimiser votre methode !
        //Par exemple, si entier >= 0, tous les negatifs sont forcement plus petits que cet entier ...

        return true;

    }


    /**
     * supprime de la tableNP le plus grand entier
     * en cas d'ex-aequo, c'est la premiere occurrence qui est supprimee
     * Attention, l'ordre des entiers de la table doit etre conserve
     * Ex :
     * tableNP avant suppression : -5 -2 5 0 8 1 2 8 7 3
     * -->
     * tableNP apres suppression min : -5 -2 5 0 1 2 8 7 3
     * @return l'entier supprime
     * @throws NoSuchElementException si la tableNP est vide
     */
    public int supprimerMax(){
        int tailleLogique= nbNegatifs + nbPositifsEtNuls;
        if(tailleLogique == 0)
            throw new NoSuchElementException();

        int max= Integer.MIN_VALUE;
        int indiceMax=0;

        int ptDeDepart=0;                           // ça c'est pour
        if(nbPositifsEtNuls!=0) ptDeDepart=nbNegatifs; //    optimiser (pr pas faire la boucle depuis le début ds certain cas)

        for (int i = ptDeDepart; i < tailleLogique; i++) {
            if(tableNP[i]>max){
                max=tableNP[i];
                indiceMax= i;
            }
        }

        for (int i = indiceMax; i < tailleLogique-1; i++) {
            tableNP[i]=tableNP[i+1];
        }

        if(max>=0) nbPositifsEtNuls--;
        else nbNegatifs--;

        return max;

    }

    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public int nbAjoutsPossible(){
        return tableNP.length-nbNegatifs-nbPositifsEtNuls;
    }

    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public TableNegatifsPuisPositifs(int[] tableARecopier, int nbNegatifs, int nbPositifsEtNuls) {
        tableNP = new int[MAX];
        for (int i = 0; i < tableARecopier.length; i++) {
            tableNP[i] = tableARecopier[i];
        }
        this.nbNegatifs = nbNegatifs;
        this.nbPositifsEtNuls = nbPositifsEtNuls;
    }

    @Override
    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public String toString() {
        String aRenvoyer = "[";
        if(nbNegatifs+nbPositifsEtNuls!=0) {
            aRenvoyer += tableNP[0];
            for (int i = 1; i < nbNegatifs + nbPositifsEtNuls; i++) {
                aRenvoyer += ", " + tableNP[i];
            }
        }
        return aRenvoyer+"]";
    }
}
