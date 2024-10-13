import java.util.Arrays;

/**
 * Représente une grille de Sudoku d'une taille (presque) quelconque
 * 
 * @author gregory.seront
 *
 */
public class SudokuGeneral {
	
	private int tailleCote;
	private int tailleRegion;
	private int [] [] grille; // Les case non remplies sont représentées par des 0
	
	/**
	 * Constructeur par copie. 
	 * Crée un nouvel objet en faisant une copie profonde de la grille
	 * passée en paramètre.
	 * Il déduit égalementla taille des côtés du carré ainsi que la
	 * taille des côtés des régions.
	 * Notez que la taille des côtés correspond au nombre de symboles
	 * différents que l'on utilise dans la grille
	 * 
	 * NE PAS MODIFIER, utilisé pour les tests
	 * 
	 * @param grille grille qui sera recopiée.
	 * 
	 * Précondition: le tableau grille doit être un carré et la racine carrée
	 * de la taille du côté doit être un nombre entier (ex: 9, 16, 25, 36, ...)
	 * Ce constructeur ne vérifie pas ces préconditions, on suppose qu'elles sont correctes.
	 */
	public SudokuGeneral(int[][] grille) {
		this.tailleCote = grille.length; 
		this.tailleRegion = (int)Math.sqrt(tailleCote);
		this.grille = new int [tailleCote][tailleCote];
		for (int i=0; i<tailleCote; i++) {
			for (int j=0; j<tailleCote; j++) {
				this.grille[i][j] = grille[i][j];
			}
		}
	}
	
	/**
	 * Vérifie que si l'on met le nombre 'nombre' à la position i, j
	 * La grille de sudoku reste légale. 
	 * Cela doit se faire sans parcourir toute la grille!
	 * 
	 * @param i ligne du coup. Les lignes sont numérotées à partir de 0
	 * @param j colonne du coup. Les colonnes sont numérotées à partir de 0
	 * @param nombre nombre que l'on veut placer dans la grille
	 * @return true si le coup est légal (voir énoncé), false sinon
	 */
	public boolean isCoupLegal(int i, int j, int nombre) {
		grille[i][j]=nombre;
		int horizental= (i/tailleRegion)*tailleRegion;
		int vertical= (j/tailleRegion)*tailleRegion;
		if(isLigneLegale(i) && isColonneLegale(j) && isRegionLegale(horizental,vertical))
			return true;
		else {
			grille[i][j]=0;
			return false;
		}
	}
	
	/**
	 * Vérifie que la ligne contient au plus une fois chaque
	 * symbole, à l'exception du 0.
	 * On ne vérifie pas qu'il existe des symboles non attendus
	 * ( <0 ou >tailleCote)
	 * @param i numéro de la ligne
	 * @return true si la ligne est légale, false sinon
	 */
	boolean isLigneLegale(int i) {
		int[] count= new int[tailleCote+1];
		for (int j = 0; j < grille.length ; j++) {
			count[grille[i][j]]++;
			if(grille[i][j]!=0 && count[grille[i][j]]>1)
				return false;
		}

		return true;
	}


	/**
	 * Vérifie que la colonne contient au plus une fois chaque
	 * symbole, à l'exception du 0.
	 * On ne vérifie pas qu'il existe des symboles non attendus
	 * ( <0 ou >tailleCote)
	 * @param j numéro de la colonne
	 * @return true si la colonne est légale, false sinon
	 */	
	boolean isColonneLegale(int j) {
		int[] count= new int[tailleCote+1];

		for (int i = 0; i < grille.length ; i++) {
			count[grille[i][j]]++;
			if( grille[i][j]!= 0 && count[grille[i][j]]>1)
				return false;
		}

		return true;
	}
	
	
	/**
	 * Vérifie que la région contient au plus une fois chaque
	 * symbole, à l'exception du 0.
	 * On ne vérifie pas qu'il existe des symboles non attendus
	 * ( <0 ou >tailleCote)
	 *
	 * @param i numéro de ligne du coin supérieur gauche de la région
	 * @param j numéro de colonne du coin supérieur gauche de la région
	 * @return true si la région est légale, false sinon
	 */
	boolean isRegionLegale(int i, int j) {
		int[] count= new int[tailleCote+1];
		for (int k = i; k < i+tailleRegion; k++) {
			for (int l = j; l <j+tailleRegion ; l++) {
				count[grille[k][l]]++;
				if (count[grille[k][l]]>1 && grille[k][l]!=0){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Vérifie que toutes les lignes, colonnes et régions
	 * de la grille sont légales
	 * @return true si la grille est légale
	 */
	boolean isGrilleLegale() {
		for (int i = 0; i < tailleCote ; i++) {
			if(!isColonneLegale(i)||!isLigneLegale(i))
				return false;
		}
		return true;
	}
}
