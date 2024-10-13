public class Multiplication3Essais {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Entrainement aux multiplications. Voici une multiplication :");
		System.out.println("Tu as droit a 3 essais");
		int premierNombre = unEntierAuHasardEntre (0, 10);
		int secondNombre = unEntierAuHasardEntre (0, 10);
		System.out.print("Calculez : " + premierNombre + " x " + secondNombre + " = ");
		int reponse= scanner.nextInt();
		int essai=1;
		while(reponse!=premierNombre*secondNombre && essai<3) {
			System.out.print("C’est faux, réessayez : ");
			reponse = scanner.nextInt();
			essai++;
		}
		if (reponse!=premierNombre*secondNombre)
			System.out.println("Dommage...tu n'as pas trouvé la bonne réponse");
		else
			System.out.println("Bravo!!!!!!!!!!");
	}

	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		return (int) (Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
	}
	
}
