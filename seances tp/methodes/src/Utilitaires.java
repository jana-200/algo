public class Utilitaires {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    /**
     * genere un entier compris entre les 2 valeurs passees en parametre
     * @param valeurMinimale la valeur minimale de l'entier genere
     * @param valeurMaximale la valeur maximale de l'entier genere
     * @return l'entier genere
     */
    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        return (int) (Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
    }

    /**
     * lit un nombre reel positif ou nul
     * @return un nombre reel positif
     */
    public static double lireReelPositif(){
        double x = scanner.nextDouble();
        while(x < 0){
            System.out.println("Attention le reel doit etre positif");
            System.out.print("Recommencez : ");
            x = scanner.nextDouble();
        }
        return x;
    }

    /**
     * lit un entier positif ou nul
     * @return l'entier positif
     */
    public static int lireEntierPositif(){
        int x = scanner.nextInt();
        while(x < 0){
            System.out.println("Attention l'entier doit etre positif");
            System.out.print("Recommencez : ");
            x = scanner.nextInt();
        }
        return x;
    }

    /**
     * lit un nombre reel compris entre les 2 valeurs passees en parametre
     * @param min le plus petit reel accepte
     * @param max le plus grand reel accepte
     * @return un nombre reel compris entre 2 bornes
     */
    public static double lireReelComprisEntre(double min, double max ){
        double x = scanner.nextDouble();
        while(x<min || x>max){
            System.out.println("Attention le reel doit etre compris entre "+ min + " et "+ max);
            System.out.print("réessayez : ");
            x= scanner.nextDouble();
        }
        return x;
    }

    /**
     * lit le caractere o ou n
     * @return le caractere o un n
     */
    public static char lireOouN(){
        char x = scanner.next().charAt(0);
        while(x!='o' && x!='n'){
            System.out.println("vous devez répondre par o ou n");
            System.out.print("réessayez : ");
            x = scanner.next().charAt(0);
        }
        return x;
    }

    /**
     * lit un entier différent de 0
     * @return l'entier non nul
     */
    public static int lireEntierNonNul(){
        int x= scanner.nextInt();
        while(x==0){
            System.out.println("vous ne pouvez pas diviser par 0");
            System.out.print("Réessayez : ");
            x= scanner.nextInt();
        }
        return x;
    }

    public static char lireCharPermis(String characteresPermis){
        System.out.println("Entrez un caractére");
        char caractere = scanner.next().charAt(0);
        while (!characteresPermis.contains(String.valueOf(caractere))) {
            System.out.println("Veuillez entrer un caractère parmi les suivants : " + characteresPermis);
            caractere = scanner.next().charAt(0);
        }
        return caractere;
    }
}
