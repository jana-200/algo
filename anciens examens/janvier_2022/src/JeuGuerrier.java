import java.util.Arrays;
import java.util.Scanner;

public class JeuGuerrier {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Entrez le nombre de guerriers : ");
		int nombreGuerriers = scanner.nextInt();
		System.out.print("Entrez le nombre de points de vie de chaque guerrier : ");
		int pointsDeVieGuerrier = scanner.nextInt();
		EquipeGuerriers equipe = new EquipeGuerriers(nombreGuerriers, pointsDeVieGuerrier);
		System.out.print("Entrez le nombre de points de vie du dragon : ");
		int pointsDeVieDragon = scanner.nextInt();


		while (pointsDeVieDragon!=0 || equipe.nombreGuerriersEnVie()!=0){
			System.out.println("Voici les guerriers en vie :");
			afficherTableGuerriers(equipe.tableGuerriersEnVie());

			int num= equipe.donnerNumeroProchainGuerrier();
			System.out.println("Le guerrier "+ num+" est selectionne pour le combat");
			System.out.println("Le guerrier frappe le dragon");
			int moinsDrag= lancerDe();

			if (pointsDeVieDragon - moinsDrag < 0) {
				System.out.println("Le dragon est mort");
				pointsDeVieDragon=0;
			}

			pointsDeVieDragon-=moinsDrag;
			System.out.println("Le dragon vient de perdre "+ moinsDrag+" point(s) de vie");
			System.out.println("Il lui reste "+ pointsDeVieDragon+ " point(s) de vie");
			System.out.println("Le dragon riposte");
			int moinsGuer= lancerDe();
			if(pointsDeVieGuerrier - moinsGuer < 0){
				System.out.println("Le guerrier est mort");
				pointsDeVieGuerrier=0;
			}
			else{
			pointsDeVieGuerrier-=moinsGuer;
			System.out.println("Le guerrier vient de perdre "+ moinsGuer+" point(s) de vie");
			System.out.println("Il lui reste "+ pointsDeVieGuerrier+" point(s) de vie");
			}
		}







		/*
		System.out.println("Voici les guerriers en vie :");
		System.out.println("Voici les guerriers morts :");
		System.out.println("Le guerrier est selectionne pour le combat");
		System.out.println("Le guerrier frappe le dragon");
		System.out.println("Le dragon riposte");
		System.out.println("Le guerrier vient de perdre point(s) de vie");
		System.out.println("Le dragon vient de perdre point(s) de vie");
		System.out.println("Il lui reste point(s) de vie");
		System.out.println("Le guerrier est mort");
		System.out.println("Le dragon est mort");
		System.out.println("Tous les guerriers sont morts");
		System.out.println("Toutes nos pensees vont au(x) guerrier(s) mort(s) :");
		*/
	}

	public static int lancerDe (){
		double nombreReel;
		nombreReel = Math.random();
		return (int) (nombreReel * 6) + 1;
	}

	public static void afficherTableGuerriers(Guerrier[] table){
		if(table==null)
			System.out.println("null");
		else
			for (int i = 0; i < table.length; i++) {
				System.out.println(table[i]);
			}
	}
}
