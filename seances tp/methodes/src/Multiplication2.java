
public class Multiplication2 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire des multiplications.");
		System.out.println("La valeur minimale des 2 nombres a multiplier est 0.");
		System.out.println("Tu peux choisir la valeur maximale de ces 2 nombres.");
		System.out.println("Cette valeur sera la meme pour tous les exercices");
		System.out.println("Pour chaque multiplication, tant que tu n'auras pas donne la bonne reponse, tu devras la recommencer");
		System.out.println("Le programme termine lorsque tu auras reussi 3 multiplications du premier coup");
		int multReussies=0;
		int bonnesRep=0;
		System.out.print("Tu peux choisir la valeur maximale des nombres � multiplier");
		int max= scanner.nextInt();
		while(multReussies<3){
			int entier1=unEntierAuHasardEntre(0,10);
			int entier2= Utilitaires.unEntierAuHasardEntre(0,max);
			System.out.print( entier1 + " x "+ entier2+ " = ");
			int reponse= scanner.nextInt();
			if(reponse!=faireUneMultiplication(entier1, entier2)){
				multReussies=0;
				while (bonnesRep==0){
					System.out.print( entier1 + " x "+ entier2+ " = ");
					reponse= scanner.nextInt();
					if(reponse==faireUneMultiplication(entier1, entier2)) {
						bonnesRep++;
						multReussies++;
					}
			    }
			}
			else multReussies++;
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
