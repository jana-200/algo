
public class Classe {
	private static final int TAILLE = 50;
	private Eleve [] classe;
	private int nombreDEleves; // Taille logique
	private int nbrGar�ons=0;

	/**
	 * Construit un objet de type classe en allouant 
	 * un tableau contenant TAILLE �l�ves.
	 */
	public Classe(){
		this.classe= new Eleve[TAILLE];
	}
	
	/**
	 * Ajoute un �l�ve de la fa�on d�crite dans l'�nonc�
	 * 
	 * @param eleve
	 * @return false s'il n'y a plus de place dans le tableau, true sinon
	 */
	public boolean ajoutEleve(Eleve eleve){
		if(nombreDEleves== TAILLE)
			return false;

		if(eleve.getSexe()==Eleve.FILLE)
			classe[nombreDEleves-nbrGar�ons]= eleve;

		else{
			classe[TAILLE-nbrGar�ons-1]= eleve;
			nbrGar�ons++;
		}

		nombreDEleves++;
		return true;
	}
	
	/**
	 * Renvoie un tableau d'�l�ves dont l'ann�e de naissance est l'ann�e
	 * la moins repr�sent�e dans la classe.
	 * En cas d'�galit� entre deux ann�es, on renvoie les �l�ves appartenant �
	 * l'ann�e la plus ancienne.
	 * L'ann�e choisie doit au moins avoir un �l�ve la repr�sentant dans la classe
	 * 
	 * On supposera que tous les �l�ves sont n�s au 20�me ou 21�me si�cle
	 * (il n'y a donc que 200 valeurs diff�rentes possibles).
	 * @return les �l�ves dont l'ann�e de naissance est l'ann�e
	 * la moins repr�sent�e dans la classe.
	 * S'il n'y a pas d'�l�ve dans la classe, on renverra un tableau 
	 * de taille 0.
	 */
	Eleve [] elevesDELAnneeLaMoinsPresente(){
		int[] compteur = new int[200];
		int moinsPresent = Integer.MAX_VALUE;
		int annee=0;
		for (int i = 0; i < TAILLE; i++) {
			if (classe[i] != null){
				compteur[classe[i].getAnneeNaissance()-1901]++;
			}
		}
		for (int i = 0; i < compteur.length; i++) {
			if ( compteur[i] < moinsPresent && compteur[i]>0 ){
				moinsPresent = compteur[i];
				annee=i;
			}
		}
		Eleve [] elevesDELAnneeLaMoinsPresente = new Eleve[moinsPresent];
		int indice = 0;
		for (int i = 0; i < TAILLE; i++) {
			if(indice<=moinsPresent){
				if(classe[i]!= null && classe[i].getAnneeNaissance() == annee + 1901){
					elevesDELAnneeLaMoinsPresente[indice]=classe[i];
					indice++;
				}
			}
			else break;
		}

		return elevesDELAnneeLaMoinsPresente;
	}

	@Override
	public String toString() {
		String ret= "";
		for (Eleve eleve:classe) {
			if(eleve!= null)
				ret+= eleve.toString()+ "\n";
		}
		return ret;
	}
	
	
}
