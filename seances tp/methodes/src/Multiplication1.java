public class Multiplication1{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire 5 multiplications");
		System.out.println("La valeur minimale des nombres a multiplier est 0, la valeur maximale est 10");
		System.out.println("Pour chaque multiplication, tu as droit a 1 essai");
		System.out.println("Tu recevras la reponse, si tu la rate");
		System.out.println("A la fin, le programme affichera le nombre de bonnes reponses.");
		int bonnesRep=5;
		for(int i = 0; i <5 ; i++) {
			int entier1=unEntierAuHasardEntre(0,10);
			int entier2=unEntierAuHasardEntre(0,10);
			System.out.print( entier1 + " x "+ entier2+ " = ");
			int reponse= scanner.nextInt();
			if (reponse!=faireUneMultiplication(entier1, entier2)){
				System.out.println(faireUneMultiplication(entier1, entier2));
				bonnesRep--;
			}
		}
		System.out.println("Le nombre de bonnes reponses est "+ bonnesRep);
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