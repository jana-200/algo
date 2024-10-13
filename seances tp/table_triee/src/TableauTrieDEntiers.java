public class TableauTrieDEntiers{

	private int [] t;  // table d'entiers triee par ordre croissant
	private int nombreEntiers;    // nombre d'entiers dans t
	private static final int TAILLE = 10;


	public TableauTrieDEntiers(){
		t = new int[TAILLE];
		nombreEntiers = 0;
	}

	public int getNombreEntiers(){
		return nombreEntiers;
	}

	/** 
	 * methode qui ajoute un entier si la table n'est pas encore pleine.
	 * La table doit rester triee!
	 * @param entier l'entier a ajouter 
	 * @return boolean signale si l'entier a pu etre ajoute
	 */
	public boolean ajouterUnEntier(int entier){
		int i=0;
		if(nombreEntiers>=TAILLE) {
			return false;
		}

		while(i<nombreEntiers && entier > t[i]){
			i++;
		}

		for (int j = nombreEntiers ; j > i ; j--) {
			t[j]=t[j-1];
		}

		nombreEntiers++;
		t[i]=entier;
		return true;
	}

	/**
	 * methode qui recherche l'indice correspondant a la premiere occurrence de l'entier passe en parametre
	 * @param entier l'entier recherche
	 * @return indice correspondant a l'entier, -1 s'il n'est pas dans la table
	 */
	private int trouverIndiceLineaire(int entier){
		
		//recherche sequentielle cout O(N)

		for (int i = 0; i < this.nombreEntiers; i++) {
			if (t[i]==entier)
				return i;
			if (t[i]>entier)
				return -1;
		}
		return -1;
		
	}

	/** 
	 * methode qui verifie si la table contient l'entier passe en parametre
	 * @param entier l'entier recherche
	 * @return boolean true si l'entier est present dans la table, false sinon
	 */
	public boolean contient(int entier){
		return trouverIndiceLineaire(entier)!=-1;
	}  

	
	/** 
	 * methode qui supprime une occurrence de l'entier passe en parametre.
	 * La table doit rester triee!
	 * @param entier l'entier a supprimer
	 * @return boolean signale si l'entier a pu etre supprime
	 */
	public boolean supprimerUneOccurrence(int entier){
		int i= trouverIndiceLineaire(entier);
		if (i==-1)
			return false;
		for (int j = i; j < nombreEntiers-1; j++) {
			t[j]=t[j+1];
		}
		nombreEntiers--;
		return true;
	} 

	
	/** 
	 * methode qui supprime toutes les occurrences d'un entier
	 * @param entier l'entier a supprimer
	 * @return int le nombre de suppressions effectuees
	 */
	public int supprimerToutesLesOccurrences(int entier){
		int nombreDeSuppression=0;
		int replace=0;
		for (int i = 0; i < nombreEntiers ; i++) {
			if(t[i]!=entier){
				t[replace]=t[i];
				replace++;
			}else{
				nombreDeSuppression++;
			}
		}
		//Dans une table triee, toutes les occurrences de l'entier se suivent
		//Il est possible d'ecrire cette methode en un seul passage dans la boucle
		//Pour une question d'efficacite, evitez d'utiliser la methode supprimerUneOccurrence()

		nombreEntiers-=nombreDeSuppression;
		return nombreDeSuppression;
	}
	
	/** 
	 * methode qui verifie si la table contient des ex-aequos
	 * @return boolean true si la table contient des ex-aequos, false sinon
	 */
	public boolean contientExAequo(){
		for (int i = 0; i <nombreEntiers-1 ; i++) {
			if(t[i+1]==t[i])
				return true;
		}
		// Il est possible d'ecrire cette methode en un seul passage dans la boucle
		// N'oubliez pas que la table est triee!

		return false;
	}
	
	/** 
	 * methode qui supprime tous les ex-aequos
	 * @return int le nombre de suppressions effectuees
	 */
	public int supprimerTousLesExAequos(){
		int supression = 0;
		int i=1;
		for (int j = 1; j < nombreEntiers; j++) {
			if(t[j]!=t[j-1]){
				t[i]=t[j];
				i++;
			}
			else{
				supression++;
			}
		}
		nombreEntiers-=supression;
		return supression;
	}

	//A ne pas modifier
	//Va servir pour les tests
	public String toString(){
		if(nombreEntiers ==0)
			return "[]";
		String aRenvoyer = "["+ t[0];
		for (int i = 1; i < nombreEntiers; i++)
			aRenvoyer = aRenvoyer + ", " + t[i];
		return aRenvoyer+"]";
	}

	/**
	 * constructeur par recopie
	 * ce constructeur leve une exception si la table passee en parametre contient plus de 10 entiers
	 * utile pour les tests et/ou si elle n'est pas triee
	 * @param tableARecopier une table triee d'au plus TAILLE entiers triee par ordre croissant
	 */

	public TableauTrieDEntiers(int[] tableARecopier){
		if (tableARecopier.length>TAILLE)
			throw new IllegalArgumentException();
		this.nombreEntiers = tableARecopier.length;
		t = new int[TAILLE];
		if(tableARecopier.length!=0)
			t[0] = tableARecopier[0];
		for (int i = 1; i< nombreEntiers; i++){
			if(tableARecopier[i]<tableARecopier[i-1]){
				throw new IllegalArgumentException();
			}
			t[i] = tableARecopier[i];
		}
	}


}