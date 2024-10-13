public class TableauJeuDeLaVie {

	private boolean[][] table;
	private int nbLignes; 	// nb lignes
	private int nbColonnes; // nb colonnes

	/**
	 * Cree un tableau sans aucune cellule vivante.
	 * @param nbColonnes
	 * @param nbLignes
	 */
	public TableauJeuDeLaVie(int nbLignes, int nbColonnes) {
		table = new boolean[nbLignes][nbColonnes];
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
	}

	/**
	 * modifie la cellule x, y
	 * precondition (a ne pas verifier) x et y sont des coordonnees valides
	 * @param x l'indice de ligne
	 * @param y l'indice de colonne
	 * @param enVie la nouvelle valeur de la cellule x, y
	 */
	public void setXY(int x, int y, boolean enVie){
		table[x][y] = enVie;
	}

	/**
	 * renvoie la valeur de la cellule x, y
	 * precondition (a ne pas verifier) x et y sont des coordonnees valides
	 * @param x l'indice de ligne
	 * @param y l'indice de colonne
	 * @return la valeur de la cellule x, y
	 */
	public boolean getXY(int x, int y){
		return table[x][y];
	}

	/**
	 * Calcule le nombre de voisines vivantes de la cellule x, y
	 * precondition (a ne pas verifier) x et y sont des coordonnees valides
	 * @param x l'indice de ligne
	 * @param y l'indice de colonne
	 * @return Le nombre de voisines vivantes
	 */
	public int nbVoisines(int x, int y){
		int nbr=0;
		for (int i = x-1; i <= x+1; i++) {
			for (int j = y-1; j <= y+1; j++) {
				boolean ligneValide= 0<=i && i< nbLignes;
				boolean ColonneValide= 0<=j && j< nbColonnes;
				boolean pasMoi= i!=x || j!=y;
				if(ligneValide && ColonneValide && pasMoi && table[i][j])
					nbr++;
			}
		}
		return nbr;
	}

	/**
	 * Calcule l'etat d'une cellule a la generation suivante.
	 * Les regles suivantes sont appliquees:
	 * - Une cellule morte possedant exactement trois voisines vivantes devient vivante (elle nait).
	 * - Une cellule vivante possedant deux ou trois voisines vivantes le reste, sinon elle meurt.
         * precondition (a ne pas verifier) x et y sont des coordonnees valides
 	 * @param x l'indice de ligne
	 * @param y l'indice de colonne
	 * @return true si la cellule en x, y sera en vie a la generation suivante
	 */
	private boolean enVieGenerationSuivante(int x, int y) {
		if(!table[x][y] && nbVoisines(x,y)==3)
			return true;
		if(table[x][y] && (nbVoisines(x,y)==3 ||nbVoisines(x,y)==2) )
			return true;
		return false;
	}


	/**
	 * Calcule le tableau de jeu a la generation suivante
	 * en faisant vivre, mourir et naitre des cellules.
	 */
	public void generationSuivante(){
		boolean[][] intermed= new boolean[nbLignes][nbColonnes];
		for (int i = 0; i < nbLignes; i++) {
			for (int j = 0; j < nbColonnes; j++) {
				intermed[i][j]=enVieGenerationSuivante(i,j);
			}
		}
		table=intermed;
	}
}