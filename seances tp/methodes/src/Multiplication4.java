
public class Multiplication4 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire des multiplications de nombres compris entre 0 et 10");
		System.out.println("Tu peux choisir le nombre d'essais que tu auras pour chaque multiplication");
		System.out.println("Ce nombre sera le meme pour toutes les multiplications");
		System.out.println("Tu recevras la reponse, si tu ne l'as toujours pas trouvee au terme du nombre d'essais accorde");
		System.out.println("Apres chaque multiplication, le programme te demandera si tu en veux une autre");
		char ouiNon='o';
		System.out.print("Choisi le nombre d'essai maximal");
		int nbrEssaiMax= scanner.nextInt();
		int nbrEssai=0;
		while(ouiNon=='o'){
			int entier1=unEntierAuHasardEntre(0,10);
			int entier2=unEntierAuHasardEntre(0,10);
			System.out.print( entier1 + " x "+ entier2+ " = ");
			int reponse = scanner.nextInt();
			while(nbrEssai<nbrEssaiMax-1 && reponse!=faireUneMultiplication(entier1, entier2) ){
				System.out.print( entier1 + " x "+ entier2+ " = ");
				reponse = scanner.nextInt();
				nbrEssai++;
				if(nbrEssai==nbrEssaiMax-1)
					System.out.println("le bonne reponse est "+ faireUneMultiplication(entier1, entier2));
			}
			nbrEssai=0;
			System.out.print("Encore une multiplication (o/n) ? ");
			ouiNon=scanner.next().charAt(0);
		}
		System.out.println("Au revoir :)");
	}

	public static int faireUneMultiplication(int a, int b){
		return a*b;
	}

	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;
		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}
}
