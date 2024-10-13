public class RecitationTableMultiplication {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args){
        int nombre = unEntierAuHasardEntre(1, 10);
        System.out.println("Tu vas donner la table de multiplication de " +nombre+ ":");
        int resultat=nombre;
        int premierNombre =1;
        System.out.print(premierNombre+" x "+nombre+ "= ");
        int reponse= scanner.nextInt();

        while(reponse==resultat && premierNombre<10){
            premierNombre++;
            System.out.print(premierNombre+" x "+nombre + "= ");
            reponse= scanner.nextInt();
            resultat=premierNombre*nombre;
        }
        if(reponse==resultat)
            System.out.println("Félicitation !");
        else
            System.out.println("Non c’est faux, la bonne réponse est " + resultat);

    }

    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        return (int) (Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
    }
}
