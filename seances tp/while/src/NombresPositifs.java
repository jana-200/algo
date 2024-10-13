public class NombresPositifs {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        int nbrPositifs=0;
        while( nbrPositifs<5 ){
            System.out.print("Entrez un nombre : ");
            int nombre= scanner.nextInt();
            if(nombre>0)
                nbrPositifs++;
        }
        System.out.println("Merci, Ciao");
    }
}
