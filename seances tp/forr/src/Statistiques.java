public class Statistiques {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Entrez le nombre de cotes : ");
		int nombreCotes = scanner.nextInt();
		double coteMax = 0; // la plus petite cote possible
		double coteMin = 0;
		double sommeCote =0;

		for (int i = 1; i <= nombreCotes ; i++) {
			System.out.print("Entrez la cote n°" + i + ": ");
			double cote = scanner.nextDouble();
			sommeCote = sommeCote + cote;

			if(cote>coteMax){
				coteMax = cote;
			}
			else{
				coteMin = cote;
			}

		}
		System.out.println("La cote la plus elevee est "+ coteMax);
		System.out.println("La moyenne est "+ (sommeCote/nombreCotes));
		System.out.println("La cote la plus petite est "+ coteMin);

	}
}
