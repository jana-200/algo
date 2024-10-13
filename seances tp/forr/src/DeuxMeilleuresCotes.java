public class DeuxMeilleuresCotes {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args){

        double coteMax = 0; // la plus petite cote possible
        double coteMax2 = 0;

        for (int i = 1; i <=5; i++) {
            System.out.print("Entrez cote numero "+ i + ": ");
            double cote = scanner.nextDouble();

            if(cote>coteMax) {
                coteMax2 = coteMax;
                coteMax = cote;
            }
            else
                if (cote>coteMax2)
                    coteMax2 = cote;
        }
        System.out.println("Vos meilleurs cotes sont "+ coteMax + " et "+ coteMax2);
    }
}
