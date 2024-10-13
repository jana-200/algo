public class Arithmetique {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale) {
        return (int) ((Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale);
    }

    public static int uneOperationAuHasard (int valeurMinimale, int valeurMaximale) {
        return (int) ((Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale);
    }

    public static void main(String[] args) {
        int nombre1 = unEntierAuHasardEntre (0, 10);
        int nombre2 = unEntierAuHasardEntre (0, 10);
        int operation = uneOperationAuHasard(1,4);

        if (operation==1) {
            System.out.println("Donnez la réponse à " + nombre1 + " * " + nombre2);
            int reponse = scanner.nextInt();
            if (reponse == nombre1 * nombre2)
                System.out.println("Correcte");
            else System.out.println("Mauvaise reponse");
        }
        else
            if (operation==2) {
                System.out.println("Donnez la réponse entiére à " + nombre1 + "/" + nombre2);
                int reponse = scanner.nextInt();
                if (reponse == nombre1 / nombre2)
                    System.out.println("Correcte");
                else System.out.println("Mauvaise reponse");
            }
            else{
                if(operation==3) {
                    System.out.println("Donnez la réponse à " + nombre1 + "-" + nombre2);
                    int reponse = scanner.nextInt();
                    if (reponse == nombre1 - nombre2)
                        System.out.println("Correcte");
                    else System.out.println("Mauvaise reponse");
                }
                else {
                    System.out.println("Donnez la réponse à " + nombre1 + "+" + nombre2);
                    int reponse = scanner.nextInt();
                    if (reponse == nombre1 + nombre2)
                        System.out.println("Correcte");
                    else System.out.println("Mauvaise reponse");
                }
            }
    }
}
