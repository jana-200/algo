import java.util.Scanner;

public class Calendrier {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Longueur du mois: ");
        int mois= scanner.nextInt();
        System.out.println("1er jour du mois : ");
        int debut = scanner.nextInt();
        int jour =1;

        for (int i = 0; i < 6; i++) {
            if(i==0){
                System.out.println("\t"+"Lu"+"\t"+"Ma"+"\t"+"Me"+"\t"+"Je"+"\t"+"Ve"+"\t"+"Sa"+"\t"+"Di");
            }
            for (int k = 0; k < 7; k++) {
                if(debut==1) {
                    if (jour <= mois) {
                        System.out.print("\t" + jour );
                        jour++;
                    }
                }
                else{
                    if(debut>1){
                        System.out.print("\t");
                        debut--;
                    }
                }
            }
        System.out.print("\n");
        }
    }
}
