
public class JeuDuPendu {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Entrez le mot a trouver : ");
		String motATrouver = scanner.next().toUpperCase();
		MotACompleter motACompleter =new MotACompleter(motATrouver);
		FenetrePendu fenetrePendu = new FenetrePendu();


		//Pour amelioration 1 :
		//LettresLues lettreslues = new LettresLues();

		fenetrePendu.afficherMot(motACompleter.toString());
		int essai=0;
		char lettre = Character.toUpperCase(fenetrePendu.lireLettre());
		String lettresLues="";
		while(!motACompleter.estComplet() && essai<6){
			if (motACompleter.contientLettre(lettre)){
				motACompleter.ajouterLettre(lettre);
				fenetrePendu.afficherMot(motACompleter.toString());
			}
			else{
				essai++;
				fenetrePendu.afficherPendu(essai);
				if(essai==3 && !motACompleter.premiereLettreEstAjoutee()){
					motACompleter.ajouterPremiereLettre();
					fenetrePendu.afficherInformation("nous allons vous réveler la premiére lettre");
					fenetrePendu.afficherMot(motACompleter.toString());
				}
			}
			lettresLues+=lettre;
			fenetrePendu.afficherLettresLues(lettresLues);
			lettre = Character.toUpperCase(fenetrePendu.lireLettre());
		}
		if(essai<6)
			fenetrePendu.afficherInformation("vous avez trouvé le mot !!");
		else
			fenetrePendu.afficherInformation("vous avez perdu ... ");
	}
}
