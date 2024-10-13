
public class Client {
	
	private String nom;
	private String prenom;
	private double[] tableMontants;			// table triee selon l'ordre decroissant des montants 
	private static final int TAILLE = 10;	// le nombre de montants max retenus

	
	/**
	 * construit un client avec ses 10 meilleurs montants = 0
	 * @param nom nom du client
	 * @param prenom prenom
	 */
	public Client (String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		this.tableMontants = new double[TAILLE];   // par defaut contient des 0!
	}
	
	/**
	 * ajoute le montant si celui-ci fait partie des 10 meilleurs montants
	 * le tri de la table doit etre respecte
	 * @param montant le montant a eventuellement ajouter
	 * @return true si le montant a ete ajoute, false sinon
	 */
	public boolean ajouter (double montant){
		int j=0;
		if(montant<tableMontants[TAILLE-1])
			return false;
		while(j<TAILLE-1 && montant <= tableMontants[j]){
			j++;
		}
		for (int i = TAILLE - 1; i > j; i--) {
			tableMontants[i] = tableMontants[i - 1];
		}
		tableMontants[j] = montant;
		return true;
	}

	/*if(montant < tableMontants[tableMontants.length-1]){
		return false;
	}
	tableMontants[tableMontants.length-1]=montant;

	for (int i = tableMontants.length; i >=1 ; i--) {
		if(montant>tableMontants[i-1]){
			double temp=tableMontants[i-1];
			tableMontants[i-1]=tableMontants[i];
			tableMontants[i]=temp;
		}
	}
		return true;*/

	
	@Override
	public String toString() {
		String aRenvoyer = "" + nom + " " + prenom + "  montants : ";
		for (int i = 0; i < TAILLE; i++) {
			aRenvoyer += " "+tableMontants[i];
		}
		return aRenvoyer;

	}
	
	
	
	
	
	
	
}
