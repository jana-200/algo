public class RechercheMax3V2 {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Entrez l'entier 1 : ");
        int entier1 = scanner.nextInt();
        System.out.print("Entrez l'entier 2 : ");
        int entier2 = scanner.nextInt();
        System.out.print("Entrez l'entier 3 : ");
        int entier3 = scanner.nextInt();

        int max= max3(entier1, entier2, entier3);
        System.out.println("La plus grande valeur est " + max);
    }
    public static int max3(int a,int b, int c) {
        if (a > b && b > c)
            return a;
        if (b > a && a > c)
            return b;
        else
            return c;
    }
}
