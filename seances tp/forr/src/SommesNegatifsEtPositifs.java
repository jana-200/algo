import java.util.Scanner;

public class SommesNegatifsEtPositifs {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int sommeNegatifs = 0;
        int sommePositif = 0;

        for (int i = 0; i <5 ; i++) {
            System.out.print("donnez un nombre :");
            int nombre = scanner.nextInt();

            if (nombre>=0){
                sommePositif = sommePositif + nombre;
            }
            else{
                sommeNegatifs = sommeNegatifs + nombre;
            }
        }

        System.out.println("La somme des nombres positifs est :" + sommePositif);
        System.out.println("La somme des nombres négatifs est : "+sommeNegatifs);
    }
}
