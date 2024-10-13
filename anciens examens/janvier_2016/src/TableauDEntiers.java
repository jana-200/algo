import java.util.Arrays;

public class TableauDEntiers {
	public static final int TAILLE_PHYSIQUE = 50;
	int [] tab = new int[TAILLE_PHYSIQUE];
	int tailleLogique = 0;
	
	/**
	 * Ajoute un entier dans le tableau
	 * @param entier
	 * @return false si le tableau était déjà plein, true sinon
	 */
	public boolean ajouter(int entier){
		if (tailleLogique == tab.length)
			return false;
		
		tab[tailleLogique] = entier;
		tailleLogique++;
		
		return true;
	}
	
	/**
	 * 
	 * @return le nombre d'éléments dans le tableau
	 */
	public int taille(){
		return tailleLogique;
	}
	
	/**
	 * 
	 * @param position
	 * @return Renvoie l'élément à la position position du tableau
	 */
	public int getElement(int position){
		return tab[position];
	}
	
	@Override
	public String toString() {
		return "TableauDEntiers [tab=" + Arrays.toString(tab)
				+ ", tailleLogique=" + tailleLogique + "]";
	}
	
	Interval sommeExacteEntre(int somme){
		int somme1=0;
		int start=0;
		int end=0;
		for (int i = 0; i < tailleLogique ; i++) {
			for (int j = i; j <tailleLogique ; j++) {
				if(somme1<somme){
					somme1+=tab[j];
					end=j;
				}
				else break;
			}
			if(somme1==somme) {
				start=i;
				break;
			}
		}
		if(somme1!=somme)
			return null;
        else return new Interval(start,end);
	}
	
	int [ ] supprimerIntervalSommeExacte(int somme){
		int debut=sommeExacteEntre(somme).getDebut();
		int fin=sommeExacteEntre(somme).getFin();

		int index=1;
		for (int i = debut; i < tailleLogique; i++) {
			tab[i]=tab[fin+index];
			index++;
		}
		return tab;
	}

	
}
