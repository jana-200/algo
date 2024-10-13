import java.util.Arrays;

public class TestClasse {

	public static void main(String[] args) {
		// cas g�n�ral: 1970 est l'ann�e
		Classe classe = new Classe();
		
		classe.ajoutEleve(	new Eleve("Seront", "F.",  Eleve.FILLE, 1969));
		classe.ajoutEleve(	new Eleve("Seront", "D.",  Eleve.FILLE, 1969));
		classe.ajoutEleve(	new Eleve("Seront", "M.",  Eleve.GARCON, 1970));
		classe.ajoutEleve(	new Eleve("Seront", "L.",  Eleve.FILLE, 1970));
		classe.ajoutEleve(	new Eleve("Seront", "G.",  Eleve.FILLE, 1969));

		System.out.println(classe);


		Eleve [] moins = classe.elevesDELAnneeLaMoinsPresente();
		System.out.println(Arrays.toString(moins));
		
	}

}
