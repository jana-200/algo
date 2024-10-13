import java.util.Arrays;

public class Temperatures {

	private String mois;
	private double[] tableDesTemperatures;
	
	// A NE PAS MODIFIER
	public Temperatures(String mois, double [] tableARecopier) {
		if(tableARecopier == null)
			throw new IllegalArgumentException("la table ne peut etre vide");
		if(tableARecopier.length == 0)
			throw new IllegalArgumentException("la table ne peut etre vide");
		this.mois = mois;
		this.tableDesTemperatures = new double[tableARecopier.length];
		for (int i = 0; i < tableARecopier.length; i++) {
			this.tableDesTemperatures[i]=tableARecopier[i];
		}
	}

	// A NE PAS MODIFIER
	public String toString(){
		String aRenvoyer = "temperatures du mois de " + this.mois + " : \n";
		return aRenvoyer + Arrays.toString(tableDesTemperatures);
	}


	/**
	 * calcule la moyenne des temperatures
	 * @return la moyenne
	 */
	public double moyenne(){
		double moyenne;
		double sommeTemp=0;
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			sommeTemp+=tableDesTemperatures[i];
		}
		moyenne = sommeTemp/tableDesTemperatures.length;
		return moyenne;
	}

	/**
	 * recherche la temperature la plus basse
	 * precondition (a ne pas verifier) la table des temperatures est non vide
	 * @return la temperature la plus basse
	 */
	public double temperatureMin(){
		double tempMin=Integer.MAX_VALUE;
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if(tableDesTemperatures[i]<=tempMin)
				tempMin=tableDesTemperatures[i];
		}
		return tempMin;
	}

	/**
	 * calcule le nombre de temperatures negatives (< 0)
	 * @return le nombre de jours de gel
	 */
	public int nombreJoursDeGel(){
		int nbrJoursDeGel=0;
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if(tableDesTemperatures[i]<0)
				nbrJoursDeGel++;
		}
		return nbrJoursDeGel;
	}

	/**
	 * remplit une table avec les numeros des jours de gel
	 * @return une table avec les jours de gel, la dimension de cette table correspond a ce nombre de jours
	 */
	public int[] joursDeGel(){
		int[] joursDeGel= new int[nombreJoursDeGel()];
		int jours=0;
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if(tableDesTemperatures[i]<0){
				joursDeGel[jours]=i+1;
				jours++;}
		}
		return joursDeGel;
	}

	/**
	 * verifie si toutes les temperatures sont positives
	 * @return true si toutes les temperatures sont positives, false sinon
	 */
	public boolean toutesPositives(){
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if(tableDesTemperatures[i]<0)
				return false;
		}
		return true;
	}

	/**
	 * verifie la presence d'au moins une temperature negative (<0)
	 * @return true si la table contient au moins une temperature negative, false sinon
	 */
	public boolean contientAuMoinsUnJourDeGel(){
		if(!toutesPositives())
			return true;
		return false;
	}

	/**
	 * verifie la presence d'au moins une temperature superieure a la temperature passee en parametre
	 * @param temperature la temperature qui sert a cette recherche
	 * @return true si la table contient au moins une temperature superieure a temperature, false sinon
	 */
	public boolean contientAuMoinsUneTemperatureSuperieureA(double temperature){
		int i=0;
		while(i<tableDesTemperatures.length && tableDesTemperatures[i]<=temperature)
			i++;
		if(i==tableDesTemperatures.length)
			return false;
		return true;
	}

	/**
	 * recherche la temperature la plus elevee
	 * precondition (a ne pas verifier) la table des temperatures est non vide
	 * @return la temperature la plus elevee
	 */
	public double temperatureMax(){
		double tempMax=0;
		for(int i = 0; i < tableDesTemperatures.length; i++) {
			if(tableDesTemperatures[i]>tempMax)
				tempMax=tableDesTemperatures[i];
		}
		return tempMax;
	}

	public int nombreJours(double temperature){
		int nbr=0;
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if(tableDesTemperatures[i]==temperature)
				nbr++;
		}
		return nbr;
	}


	/**
	 * remplit une table avec les numeros des jours correspondant a la temperature la plus elevee
	 * @return une table avec les jours de haute temperature, la dimension de cette table correspond à ce nombre de jours
	 */
	public int[] joursMax(){
		double max=temperatureMax();
		int nombreJoursMax =nombreJours(max);
		int[] joursMax= new int[nombreJoursMax];
		int j=0;
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if(tableDesTemperatures[i]==max){
				joursMax[j]=i+1;
				j++;
			}
		}
		return joursMax;
	}


	/**
	 * remplit une table avec les numeros des jours correspondant a la temperature la plus basse
	 * @return une table avec les jours de basse temperature, la dimension de cette table correspond à ce nombre de jours
	 */
	public int[] joursMin(){
		int j=0;
		double min= temperatureMin();
		int[] joursMin= new int[nombreJours(min)];
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if(tableDesTemperatures[i]==min){
				joursMin[j]=i+1;
				j++;}
		}
		return joursMin;

		//TODO
		// Ex supplementaire
		// Suggestion : introduisez la methode nombreJours(double temperature)
		// Les methodes joursDeGel(), joursMax() peuvent aussi utiliser cette methode
		//
	}

}
