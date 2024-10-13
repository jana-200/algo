public class EtudiantCotesTriees{

	private double[] tableCotes;  // table triee
	private int matricule;

	/** 
	 * methode qui calcule la moyenne des cotes de l'etudiant
	 * precondition (a ne pas verifier) : la table contient au moins 1 cote
	 * @return moyenne des cotes de l'etudiant
	 */
	public double moyenne(){
		double somme=0;
		int taille= tableCotes.length;
		for (int i = 0; i < taille; i++) {
			somme+=tableCotes[i];
		}
		return somme/taille;
	}
	/**
	 * methode qui recherche la plus petite cote de l'etudiant
	 * precondition (a ne pas verifier) : la table contient au moins 1 cote
	 * @return la plus petite cote de l'etudiant
	 */
	public double min(){
		double min=tableCotes[0];
		return min;
	}

	/**
	 * methode qui recherche la cote la plus elevee de l'etudiant
	 * precondition (a ne pas verifier) : la table contient au moins 1 cote
	 * @return la cote la plus elevee de l'etudiant
	 */
	public double max(){
		double max=tableCotes[tableCotes.length-1];
		return max;
	}


	/** 
	 * methode qui calcule le nombre d'echecs de l'etudiant
	 * precondition (a ne pas verifier) : la table contient au moins 1 cote
	 * @return nombre d'echecs (cote < 10) de l'etudiant
	 */
	public int nombreEchecs(){
		int echecs=0;
		for (int i = 0; i < tableCotes.length; i++) {
			if(tableCotes[i]<10)
				echecs++;
		}
		return echecs;
	}


	/**
	 * methode qui verifie si l'etudiant n'a pas d'echec
	 * precondition (a ne pas verifier) : la table contient au moins 1 cote
	 * @return true si l'eudiant n'a pas pas d'echec, false sinon
	 */
	public boolean aucunEchec(){
		if(min()>=10)
			return true;
		return false;
	}

	//A NE PAS MODIFIER
	//VA SERVIR POUR LES TESTS
	public EtudiantCotesTriees(int matricule, double[] tableARecopier){
		if(tableARecopier.length==0)
			throw new IllegalArgumentException();
		this.matricule = matricule;
		this.tableCotes = new double[tableARecopier.length];
		tableCotes[0] = tableARecopier[0];
		for(int i = 1; i < tableARecopier.length; i++) {
			if(tableARecopier[i]<tableARecopier[i-1]){
				throw new IllegalArgumentException();
			}
			tableCotes[i] = tableARecopier[i];
		}
	}


	public String toString(){
		String aRenvoyer = "\n matricule : " + this.matricule +"\n cotes : ";
		for(int i = 0; i < tableCotes.length; i++)
			aRenvoyer = aRenvoyer + "  " + tableCotes[i];
		return aRenvoyer;
	}

}