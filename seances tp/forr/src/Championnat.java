public class Championnat {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args){

        int nombreCote = 8;
        double coteMax = 0; // la plus petite cote possible
        double coteMin = 20;
        double sommeCote =0;

        for (int i = 1; i <=8; i++) {
            System.out.print("Entrez cote numero "+ i + ": ");
            double cote = scanner.nextDouble();
            sommeCote = sommeCote + cote;

            if(cote>coteMax){
                coteMax = cote;
            }
            if(cote<coteMin){
                coteMin = cote;
            }
        }
        double moyenne = (sommeCote-coteMax-coteMin)/(nombreCote-2);
        System.out.println("le résultat est " + (moyenne));
        if(moyenne>=8){
            System.out.println("vous avez reussi ");
        }
        else System.out.println("vous avez échoué ");
    }
}
