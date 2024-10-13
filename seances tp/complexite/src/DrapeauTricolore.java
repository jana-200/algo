public class DrapeauTricolore{

	private char[] table ;


	/** Le constructeur aura comme effet d'initialiser la table aleatoirement
	 * avec des caracteres 'b' 'r' et 'w'
	* @param taille la taille de la table 
	*/

	public DrapeauTricolore(int taille) {  
         char[] vals = {'b','r','w'};
   		table = new char[taille];
			for (int i=0; i<taille; i++){
            int index = (int) (Math.random()*vals.length);
				table[i]= vals[index];
			}
	}
   
	public String toString(){
         String s = "";
      	for (int i=0; i<table.length; i++)
            s += table[i] + " ";
      	return s;
	}

	/**
 	*  Reorganise la table pour que les boules apparaissent
	* dans l'ordre suivant : b,w,r 
	*/
	public void triTricolore (){
        //TODO
      int i=0, b=0, r=table.length-1;
      while (i <= r) {
         if (table[i] == 'b') {
            char tmp = table[i];
            table[i] = table[b];
            table[b] = tmp;
            b++;
            i++;
         }
         else if (table[i] == 'r') {
            while ((i < r) && (table[r] == 'r'))
               r--;
            char tmp = table[i];
            table[i] = table[r];
            table[r] = tmp;
            r--;
         }
         else  // table[i] = 'w'
            i++;
      }
 	}
}
