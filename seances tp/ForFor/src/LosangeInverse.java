public class LosangeInverse {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("\nEntrez n : ");
        int n=scanner.nextInt();
        int espace=0;
        int croix=n-1;
        for (int i = 0; i < n ; i++) {
            for(int j=0; j<=croix; j++) {
                System.out.print('X');
            }
            for(int j = 0; j<espace; j++){
                System.out.print(' ');
            }
            for(int j=0; j<=croix; j++) {
                System.out.print('X');
            }
            espace=espace+2;
            croix--;
            System.out.println();
        }
        croix=0;
        espace=(n*2)-2;
        for (int i = 0; i < n ; i++) {
            for(int j=0; j<=croix; j++) {
                System.out.print('X');
            }
            for(int j = 0; j<espace; j++){
                System.out.print(' ');
            }
            for (int j = 0; j <=croix; j++) {
                System.out.print('X');
            }
            espace=espace-2;
            croix++;
            System.out.println();
        }
    }
}