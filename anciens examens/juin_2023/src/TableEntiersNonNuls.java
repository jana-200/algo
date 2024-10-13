import java.util.NoSuchElementException;

public class TableEntiersNonNuls {

    private int[] table;
    private int nbEntiers=0;
    private static final int MAX = 10; // taille physique

    // table d'entiers non nuls
    // table de taille physique = MAX
    // table ne peut pas contenir plus de MAX entiers, mais pourrait en contenir moins
    // Les entiers occupent les nbEntiers premieres cases du tableau!
    // L'ordre des entiers n'a pas d'importance


    /**
     * ce constructeur construit une table en y recopiant les entiers non nuls de la table fournie
     * si la table fournie contient plus de MAX entiers non nuls, seuls les MAX premiers entiers non nuls seront recopies
     * les entiers de la table construite doivent apparaitre dans le meme ordre que les entiers de la table fournie
     * Ex table fournie : 1 0 0 4 -3 2 5 1 2 3 0 3 -5 6 7 8 0 9
     * table construite : 1 4 -3 2 5 1 2 3 3 -5
     * @param tableFournie la table avec les entiers a placer dans table
     * @throws IllegalArgumentException si la table fournie est null
     */
    public TableEntiersNonNuls(int[] tableFournie) {
        if(tableFournie==null)
            throw new IllegalArgumentException();
        table = new int[MAX];
        for (int i = 0; i <tableFournie.length ; i++) {
            if(tableFournie[i]!=0) {
                table[nbEntiers] = tableFournie[i];
                nbEntiers++;
            }
            if(nbEntiers>=MAX)
                break;
        }
    }

    public int getNbEntiers() {
        return nbEntiers;
    }

    /**
     * calcule la moyenne des entiers positifs
     * @return la moyenne des entiers positifs ou 0 s'il n'y a pas d'entiers positifs
     */
    public double moyennePositifs(){
        int somme=0;
        int tot=0;

        for (int i = 0; i < table.length; i++) {
            if(table[i]>0){
                somme+=table[i];
                tot++;
            }
        }
        if(tot==0) return 0;
        return (double) somme /tot;
    }


    /**
     * renvoie une table avec les 3 plus petits entiers contenus dans la table
     * les 3 entiers sont places dans la table selon l'ordre croissant
     * cette table peut contenir des ex-aequos
     * @return une table avec les 3 plus petits entiers
     * @throws NoSuchElementException si la table ne contient pas 3 entiers
     */
    public int[] troisPlusPetitsEntiers(){
        if (nbEntiers<3){
            throw new NoSuchElementException();
        }
        int[] newTable= table.clone();
        int[] min3= new int[3];

        for (int i = 0; i < 3 ; i++) {
            int min= newTable[0];
            int indiceMin=0;
            for (int j = 0; j < nbEntiers; j++) {
                if(newTable[j]<min){
                    min=newTable[j];
                    indiceMin=j;
                }
            }
            min3[i]= newTable[indiceMin];
            newTable[indiceMin]= Integer.MAX_VALUE;
        }
        return min3;

        //Contrainte : implementez l'algorithme presente dans l'enonce !
    }

    /**
     * supprime une fois l'entier passe en parametre
     * si l'entier apparait plusieurs fois, c'est le dernier qui est supprime
     * @param entier l'entier a supprimer
     * @return true si une suppression a ete faite, false sinon
     */
    public boolean supprimerDerniereOccurrence(int entier){
        int indice=-1;
        for (int i = nbEntiers-1; i >=0 ; i--) {
            if(table[i]== entier) {
                indice = i;
                break;
            }
        }
        if(indice==-1) return false;

        for (int i = indice; i < nbEntiers-1 ; i++) {
            table[i]=table[i+1];
        }
        nbEntiers--;
        return true;
    }

    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public int nbAjoutsPossibles(){
        return table.length - nbEntiers;
    }


    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public TableEntiersNonNuls(int[] tableARecopier, int nbEntiers) {
        table = new int[MAX];
        for (int i = 0; i < tableARecopier.length; i++) {
            table[i] = tableARecopier[i];
        }
        this.nbEntiers = nbEntiers;

    }

    @Override
    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public String toString() {
        String aRenvoyer = "[";
        if(nbEntiers!=0) {
            aRenvoyer += table[0];
            for (int i = 1; i < nbEntiers; i++) {
                aRenvoyer += ", " + table[i];
            }
        }
        return aRenvoyer+"]";
    }
}