import java.util.Scanner;

public class B6 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int nombresNegatifs = 0;
        int nombresPositifs = 0;

        for (int i = 0; i <10 ; i++) {
            System.out.print("donnez un nombre :");
            int nombre = scanner.nextInt();

            if(nombre < 0){
                nombresNegatifs ++;
            }
            else
                nombresPositifs ++;
        }
        System.out.println("Nombres négatifs : "+nombresNegatifs +"\n"+ "Nombres positifs : "+nombresPositifs);
    }
}
