import java.util.Arrays;

public class test {
    public static void main(String[] args) {


        TableauDEntiers tableauDEntiers= new TableauDEntiers();
        for (int i = 1; i < 11; i++) {
            tableauDEntiers.ajouter(i);
        }
        System.out.println(tableauDEntiers.toString());

        System.out.println(tableauDEntiers.sommeExacteEntre(7));


        System.out.println(Arrays.toString(tableauDEntiers.supprimerIntervalSommeExacte(7)));

    }
}
