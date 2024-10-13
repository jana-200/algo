public class Losange {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("\nEntrez n : ");
        int n=scanner.nextInt();
        int croix=1;
        int espace=n-1;
        for (int i = 0; i < n ; i++) {
            for(int j=0; j<=espace; j++) {
                System.out.print(' ');
            }
            for(int j = 0; j<croix; j++){
                System.out.print('X');
            }
            croix=croix+2;
            espace--;
            System.out.println();
        }
        espace=1;
        croix=(n*2)-3;
        for (int i = 0; i < n ; i++) {
            for(int j=0; j<=espace; j++) {
                System.out.print(' ');
            }
            for(int j = 0; j<croix; j++){
                System.out.print('X');
            }
            croix=croix-2;
            espace++;
            System.out.println();
        }
    }
}
