public class NombreMystere {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int nombreMystere = unEntierAuHasardEntre(0, 100);
        System.out.println("Devinez le nombre mystère ");
        int nbr= scanner.nextInt();
        int essai=1;

        while(nbr!=nombreMystere){
            essai++;
            if(nbr<nombreMystere){
                System.out.println("Essayez un nombre plus grand");
                nbr= scanner.nextInt();
            }
            else {
                System.out.println("Essayez un nombre plus petit");
                nbr = scanner.nextInt();
            }
        }
        System.out.println("Bravo vous l'avez trouvé !! Il vous a fallu "+ essai+ " essais");
    }
    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        return (int) (Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
    }
}
