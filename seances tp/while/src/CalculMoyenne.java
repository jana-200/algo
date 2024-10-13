public class CalculMoyenne {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        char reponse = 'Y';
        int nbrCotes =0 ;
        int somme = 0;

        do{
            System.out.print("Entrez une cote :");
            int cote = scanner.nextInt();
            somme= somme +cote;
            nbrCotes++;

            System.out.print("Encore une cote ?");
            reponse = scanner.next().charAt(0);
        }while(reponse=='Y' || reponse=='y' || reponse=='O' || reponse=='o' );

        System.out.println("Votre moyenne arrondie est de "+(somme/nbrCotes));
    }

}
