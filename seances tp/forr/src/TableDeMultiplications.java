import java.util.Scanner;

public class TableDeMultiplications {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("vous voulez voir la table de multiplication de : " );
        int constante = scanner.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " x " + constante + " = " + (i*constante));
        }
    }
}

