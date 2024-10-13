import java.util.Arrays;

public class StatistiquesTemperatures {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static Temperatures temperatures;
	
	public static void main(String[] args) {
		
		chargerTemperatures();
		System.out.println(temperatures.toString());
		
		System.out.println("*****************************");
		System.out.println("Temperatures : statistiques :");
		System.out.println("*****************************");
		int choix;
		do{
			System.out.println();
			System.out.println("1 -> afficher toutes les temperatures");	
			System.out.println("2 -> calculer la moyenne");
			System.out.println("3 -> afficher la plus petite temperature");
			System.out.println("4 -> afficher le nombre de jours de gel");
			System.out.println("5 -> afficher les jours de gel");
			System.out.println("6 -> tous les jours du mois etaient de temperature positive?");
			System.out.println("7 -> ce mois contenait-il au moins un jour de gel?");
			System.out.println("8 -> ce mois contenait-il au moins un jour supérieur à ...... ?");
			System.out.println("9 -> afficher la plus grande tempertaure");
			System.out.println("10 -> afficher les jours qui on les plus grandes tempertaures");
			System.out.println("11 -> afficher les jours qui on les plus petites tempertaures");
			System.out.println();
			System.out.print("Entrez votre choix : ");	
			choix=scanner.nextInt();
			switch(choix){	
			case 1: afficherTout();   
			break;
			case 2: afficherMoyenne();   
			break;
			case 3: afficherPlusPetiteTemp();
			break;
			case 4: nombreJoursDeGel();
			break;
			case 5: joursDeGel();
			break;
			case 6: toutesPositives();
			break;
			case 7: contientAuMoinsUnJourDeGel();
			break;
			case 8: contientAuMoinsUneTemperatureSuperieureA(scanner.nextDouble());
			break;
			case 9: temperatureMax();
			break;
			case 10: joursMax();
			break;
			case 11: joursMin();
			break;

			}
		}while(choix >=1 && choix<=2);
	}
	
	private static void afficherTout() {
		System.out.println(temperatures.toString());
	}

	private static void afficherMoyenne() {
		System.out.println(temperatures.moyenne());
	}

	private static void afficherPlusPetiteTemp(){
		System.out.println(temperatures.temperatureMin());
	}

	public static void nombreJoursDeGel() {
		System.out.println(temperatures.nombreJoursDeGel());
	}

	public static void joursDeGel() {
		System.out.println(Arrays.toString(temperatures.joursDeGel()));
	}

	public static void toutesPositives() {
		System.out.println(temperatures.toutesPositives());
	}
	public static void contientAuMoinsUnJourDeGel() {
		System.out.println(temperatures.contientAuMoinsUnJourDeGel());
	}

	public static void contientAuMoinsUneTemperatureSuperieureA(double temperature) {
		System.out.println(temperatures.contientAuMoinsUneTemperatureSuperieureA(temperature));
	}

	public static void temperatureMax() {
		System.out.println(temperatures.temperatureMax());
	}

	public static void joursMax() {
		System.out.println(Arrays.toString(temperatures.joursMax()));
	}

	public static void joursMin() {
		System.out.println(Arrays.toString(temperatures.joursMin()));
	}

	public static void chargerTemperatures(){
		double[]tableTemperatures = {-1,1,0,1,-1,-3,-3,-2,0,-1,0,1,1,3,5,4,2,0,1,1,5,3,2,0,-1,0,1,1,3,4,5};
		temperatures = new Temperatures("janvier",tableTemperatures);
	}

	public static void afficherTable(int[]table){
		System.out.println(Arrays.toString(table));
	}
	
}
