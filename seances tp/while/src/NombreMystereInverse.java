public class NombreMystereInverse {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args){

        int guess=unEntierAuHasardEntre(0, 100);
        System.out.println(guess);
        char reponse = scanner.next().charAt(0);
        int essai=1;

        while(reponse!='='){
            if(reponse=='+'){
                guess=unEntierAuHasardEntre(0, guess-1);
                System.out.println(guess);
                reponse = scanner.next().charAt(0);
                essai++;
            }
            else {
                if(reponse=='-'){
                    guess=unEntierAuHasardEntre(guess+1, 100);
                    System.out.println(guess);
                    reponse = scanner.next().charAt(0);
                    essai++;
                }
            }
        }
        System.out.println("Vous avez trouvé le nombre en "+ essai + " essai");

    }
    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        return (int) (Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
    }
}
