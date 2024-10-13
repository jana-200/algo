
public class Classe {
	private static final int TAILLE = 50;
	private Eleve [] classe;
	private int nombreDEleves; // Taille logique
	private int nbrGarçons=0;

	/**
	 * Construit un objet de type classe en allouant 
	 * un tableau contenant TAILLE élèves.
	 */
	public Classe(){
		this.classe= new Eleve[TAILLE];
	}
	
	/**
	 * Ajoute un élève de la façon décrite dans l'énoncé
	 * 
	 * @param eleve
	 * @return false s'il n'y a plus de place dans le tableau, true sinon
	 */
	public boolean ajoutEleve(Eleve eleve){
		if(nombreDEleves== TAILLE)
			return false;

		if(eleve.getSexe()==Eleve.FILLE)
			classe[nombreDEleves-nbrGarçons]= eleve;

		else{
			classe[TAILLE-nbrGarçons-1]= eleve;
			nbrGarçons++;
		}

		nombreDEleves++;
		return true;
	}
	
	/**
	 * Renvoie un tableau d'élèves dont l'année de naissance est l'année
	 * la moins représentée dans la classe.
	 * En cas d'égalité entre deux années, on renvoie les élèves appartenant à
	 * l'année la plus ancienne.
	 * L'année choisie doit au moins avoir un élève la représentant dans la classe
	 * 
	 * On supposera que tous les élèves sont nés au 20ème ou 21ème siècle
	 * (il n'y a donc que 200 valeurs différentes possibles).
	 * @return les élèves dont l'année de naissance est l'année
	 * la moins représentée dans la classe.
	 * S'il n'y a pas d'élève dans la classe, on renverra un tableau 
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
