import java.util.HashSet;

public class TableauNonTrieDEntiers {

	private int[] t;
	private int nombreEntiers; // taille logique
	private static final int TAILLE = 10; // taille physique

	// Les nombreEntiers entiers occupent les nombreEntiers premieres cases du tableau!
	// PAS DE TROU!
	// L'ordre des entiers n'a pas d'importance

	public TableauNonTrieDEntiers() {
		this.t = new int[TAILLE];
		this.nombreEntiers = 0;
	}

	public int getNombreEntiers() {
		return this.nombreEntiers;
	}

	/**
	 * ajoute un entier en fin de table si la table n'est pas encore pleine
	 * @param entier l'entier a ajouter
	 * @return true si l'entier a pu etre ajoute, false sinon
	 */
	public boolean ajouter(int entier) {
		if(nombreEntiers==TAILLE)
			return false;
		t[nombreEntiers]=entier;
		nombreEntiers++;
		return true;
	}

	/**
	 * verifie si la table contient l'entier passe en parametre
	 * @param entier l'entier dont on desire tester la presence
	 * @return true si l'entier est present dans la table, false sinon
	 */

	private int trouverIndice(int entier){
		for (int i = 0; i < nombreEntiers; i++) {
			if(t[i]==entier)
				return i;
		}
		return -1;
	}

	public boolean contient(int entier) {
        return trouverIndice(entier) != -1;
    }

	/**
	 * calcule le nombre d'occurrences de l'entier passe en parametre
	 * @param entier l'entier dont on desire connaitre le nombre d'occurrences
	 * @return le nombre d'occurrences
	 */
	public int nombreOccurrences(int entier){
		int occurrence=0;
		for (int i = 0; i <nombreEntiers ; i++) {
			if(t[i]==entier)
				occurrence++;
		}
		return occurrence;
	}

	/**
	 * supprime la premiere occurrence d'un entier
	 * @param entier l'entier a supprimer
	 * @return true si l'entier a pu etre supprime, false sinon
	 */
	public boolean supprimerPremiereOccurrence(int entier) {
		int indice=trouverIndice(entier);
		if(indice!=-1){
			t[indice]=t[nombreEntiers-1];
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
		int supression = 0;
		for (int i = 0; i < nombreEntiers; i++) {
			if (t[i] == entier) {
				t[i] = t[nombreEntiers - 1];
				nombreEntiers--;
				supression++;
				if(t[i]==entier)
					i--;
			}
		}
		return supression;
	}

	/**
	 * verifie si la table est triee par ordre croissant
	 * @return true si la table est triee, false sinon
	 */
	public boolean estTrie() {
		for (int i = 0; i < nombreEntiers-1; i++) {
			if(t[i]>t[i+1])
				return false;
		}
		return true;
	}

	/**
	 * verifie si la table contient des ex-aequos
	 * @return true si la table contient des ex-aequos, false sinon
	 */
	public boolean contientExAequo() {
		for (int i = 0; i <nombreEntiers ; i++) {
			if(nombreOccurrences(t[i])>1)
				return true;
		}
		return false;
	}

	/**
	 * supprime tous les ex-aequos.
	 * Notez que cette methode laisse exactement une occurence de chaque entier qui se trouvait dans le tableau initial.
	 * @return int le nombre de suppressions effectuees
	 */
	public int supprimerTousLesExAequos() {
		int supression=0;
		if(contientExAequo()){
			for (int i = 0; i < nombreEntiers; i++) {
				while(nombreOccurrences(t[i])>1){
					supprimerPremiereOccurrence(t[i]);
					supression++;
				}
			}
		}

		return supression ;
	}

	//A NE PAS MODIFIER
	//VA SERVIR POUR LES TESTS
	public TableauNonTrieDEntiers(int[] tableARecopier, int tailleLogique) {
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
	public TableauNonTrieDEntiers(int[] tableARecopier) {
		this(tableARecopier, tableARecopier.length);
	}

	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	@Override
	public String toString() {
		if(nombreEntiers ==0)
			return "[]";
		String aRenvoyer = "["+ t[0];
		for (int i = 1; i < nombreEntiers; i++)
			aRenvoyer +=  ", " + t[i];
		return aRenvoyer+"]";
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


}