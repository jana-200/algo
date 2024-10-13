
public class GeneralPoker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println( estMeilleur(5, 2, 3,7));
		
		System.out.println( estMeilleur(50, 7, 30,2));
		
		System.out.println( estMeilleur(5, 2, 7,1));
		
		System.out.println( estMeilleur(1, 2, 1,6));
		
		System.out.println( estMeilleur(1, 2, 1,2));
		
		System.out.println( estMeilleur(10, 100, 10, 200));
		
		int [] jet1 = {1, 2, 1, 5, 6, 5, 5};	
		System.out.println("Jet 1");
		printMeilleurs( meilleursGroupes(jet1) );
		
		// Egalité
		int [] jet2 = {1, 1, 1, 5, 6, 5, 6, 5, 4, 4, 4};
		System.out.println("Jet 2");
		printMeilleurs( meilleursGroupes(jet2) );
		
		// Main minimale
		int [] jet3 = {1, 2};		
		System.out.println("Jet 3");
		printMeilleurs( meilleursGroupes(jet3) );
		
		// Tous différents
		int [] jet4 = {1, 100, 3, 10, 15, 2, 7};
		System.out.println("Jet 4");
		printMeilleurs( meilleursGroupes(jet4) );
		
		// Cas main maximale
		int [] jet5 = {10, 10, 10, 10, 10};
		System.out.println("Jet 5");
		printMeilleurs( meilleursGroupes(jet5) );

	}
	
	public static void printMeilleurs(int [][] meilleurs) {
		System.out.println("  Meilleur(s) groupe(s)");
		for (var groupe : meilleurs) {			
			System.out.println("   taille =  "+ groupe[0] + " valeur = " + groupe[1]);
			
		}
		
	}
	
	/**
	 * Renvoie vrai si le groupe 1 est meilleur que le groupe 2. 
	 * Un groupe est constitué d'un nombre et d'une nature (la valeur)
	 * En cas d'égalité, la valeur est donc fausse
	 * @param nbrDes1 nombre de dés du groupe 1
	 * @param valDes1 valeur sur chaque dé du groupe 1
	 * @param nbrDes2 nombre de dés du groupe 2
	 * @param valDes2 valeur sur chaque dé du groupe 2
	 * @return
	 */
	public static boolean estMeilleur(int nbrDes1, int valDes1, int nbrDes2, int valDes2) {

		return (nbrDes1>nbrDes2 || (nbrDes1==nbrDes2) && valDes1>valDes2);
	}
	
	/**
	 * Renvoie un tableau 2x2 représentant les deux meilleur groupes d'un jet
	 * Chaque ligne représente un groupement de valeurs. 
	 * la case [0][0] est le nombre de des du meilleur groupement
	 * la case [0][1] est la valeur sur chaque des du meilleur groupement
	 * la case [1][0] est le nombre de des du 2ème meilleur groupement
	 * la case [0][1] est la valeur sur chaque des du 2ème meilleur groupement   
	 * 
	 * Vous pouvez supposer que les entiers seront toujours supérieurs à 0. 
	 * Si il n'y a qu'un seul groupement car la taille de celui-ci 
	 * est égal au nombre de des, la méthode renvoie un tableau de
	 * une ligne et deux colonnes.
	 * 
	 * @param jet chaque case de ce tableau représente la valeur d'un des dés 
	 *        du jet.
	 * @return voir description
	 */
	public static int [][] meilleursGroupes(int [] jet){
		int[][] table;
		int max=0;
		for (int i = 0; i < jet.length; i++) {
			if(jet[i]>max) max= jet[i];
		}
		int[] count = new int[max+1];
		for (int i = 0; i < jet.length ; i++) {
			count[jet[i]]++;
		}

		int max1=0;
		int indiceMax1=0;
		for (int i = 0; i < count.length; i++) {
			if(count[i]>=max1) {
				max1 = count[i];
				indiceMax1=i;
			}
		}
		count[indiceMax1]=0;
		int max2=0;
		int indiceMax2=0;
		for (int i = 0; i < count.length; i++) {
			if(count[i]>=max2){
				max2 = count[i];
				indiceMax2=i;
			}
		}
		if(max2==0){
			table = new int[1][2];
			table[0][0] = max1;
			table[0][1] = indiceMax1;
			return table;

		}
		table= new  int[2][2];
		table[0][0]=max1;
		table[0][1]= indiceMax1;
		table[1][0]=max2;
		table[1][1]= indiceMax2;

		return table;
	}

}
