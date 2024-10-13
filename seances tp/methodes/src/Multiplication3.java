
public class Multiplication3 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire 5 multiplications");
		System.out.println("Au depart la valeur minimale des nombres a multiplier est 1 et la valeur maximale est 10");
		System.out.println("Ces 2 bornes augmenteront de 10 a chaque multiplication reussie");
		System.out.println("Pour chaque multiplication, tu as droit a 1 essai");
		System.out.println("Tu recevras la reponse, si tu la rate");
		int max= 10;
		for (int i = 0; i < 5; i++) {
			int entier1=unEntierAuHasardEntre(1,max);
			int entier2=unEntierAuHasardEntre(1,max);
			System.out.print( entier1 + " x "+ entier2+ " = ");
			int reponse = scanner.nextInt();
			if(reponse==faireUneMultiplication(entier1,entier2))
				max+=10;
			else
				System.out.println(faireUneMultiplication(entier1,entier2));
		}
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
