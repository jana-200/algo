
public class MultiplicationAuFinish {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Entrainement aux multiplications. Voici une multiplication :");
		System.out.println("Tant que tu n'as pas trouve la bonne reponse, tu dois la recommencer! ");

		int premierNombre = unEntierAuHasardEntre(0, 10);
		int secondNombre = unEntierAuHasardEntre(0, 10);
		System.out.print("Calculez : " + premierNombre + " x " + secondNombre + " = ");
		int reponse= scanner.nextInt();

		while(reponse!=premierNombre*secondNombre) {
			System.out.println("C’est faux, réessayez ");
			System.out.print("Calculez : " + premierNombre + " x " + secondNombre + " = ");
			reponse = scanner.nextInt();
		}
		System.out.println("Bravo!!!!!!!!!!");
	}
	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		return (int) (Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
	}
}
