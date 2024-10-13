import java.util.Scanner;

public class NombreNegatifsParmi10 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int nombresNegatifs = 0;
        for (int i = 0; i <10 ; i++) {
            System.out.print("donnez un nombre :");
            int nombre = scanner.nextInt();

            if(nombre < 0){
                nombresNegatifs ++;
            }
        }
        System.out.println(nombresNegatifs);
    }
}
