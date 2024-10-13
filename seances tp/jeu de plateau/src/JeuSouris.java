public class JeuSouris {

	public static void main(String[] args){

		int positionSouris = 1;
		int positionFromage=10;
		PlateauJeuSouris jeu = new PlateauJeuSouris();
		jeu.afficherInformation("Vas-y !");
		jeu.placerSouris(positionSouris);
		jeu.placerFromage(positionFromage);
		while(positionSouris<16){
			int lanceDe = jeu.lancerDe();
			if(16-positionSouris<=lanceDe)
				positionSouris=16;

			positionSouris+=lanceDe;

			if(positionSouris>=positionFromage){
				positionSouris=positionFromage;
				jeu.supprimerFromage();
				positionFromage=16;
			}
			jeu.supprimerSouris();
			jeu.placerSouris(positionSouris);
		}

	}
}
