public class Championnat {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public static void main(String[] args) {
		char reponse='o';
		int ParticipantsEnFinale=0;
		while (reponse=='o'){
			if(resultatUnConcurrent()>=8) ParticipantsEnFinale++;
			System.out.println("Encore un participant (o/n) ? ");
			reponse=Utilitaires.lireOouN();
		}
		System.out.println("Le nombre de participants qui vont en finale est "+ ParticipantsEnFinale );
	}

	/**
	 * lit les cotes, calcule et renvoie le resultat d'un concurrent.
	 * Chaque concurrent est cote pour la presentation de son exercice, sur 10 points, par 8 membres du jury.
     * On elimine de ces cotes la plus haute et la plus basse. Le resultat d un concurrent est egal a�la moyenne des 6 cotes restantes.
	 * @return le resultat du concurrent
	*/
	public static double resultatUnConcurrent() {
		int nombreCote = 8;
		double coteMax = 0; // la plus petite cote possible
		double coteMin = 20;
		double sommeCote =0;

		for (int i = 1; i <=8; i++) {
			System.out.print("Entrez cote numero "+ i + ": ");
			double cote = Utilitaires.lireReelComprisEntre(0,10);
			sommeCote = sommeCote + cote;

			if(cote>coteMax) coteMax = cote;
			if(cote<coteMin) coteMin = cote;
		}
		double moyenne = (sommeCote-coteMax-coteMin)/(nombreCote-2);
		if(moyenne>=8)
			System.out.println("reussi");
		else System.out.println("echoue");
		return moyenne;
	}

}
