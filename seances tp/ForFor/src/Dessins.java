public class Dessins {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int choix;
        do{
            afficherMenu();
            System.out.print("\nEntrez votre choix : ");
            choix=scanner.nextInt();
            switch(choix){
                case 1: carre();
                    break;
                case 2: triangleVersion1();
                    break;
                case 3: triangleVersion2();
                    break;
                case 4: triangleVersion3();
                    break;
                case 5: pyramide();
                    break;
                case 6: pyramideVersion2();
                    break;
                case 7: pyramideVersion3();
                    break;
                case 8: losange();
                    break;
                default:
                    System.out.println("quitter");
                    break;
            }
            System.out.println();
        }
        while(choix>=1 && choix<=8);
    }

    private static void afficherMenu(){
        System.out.println("*********");
        System.out.println("Dessins :");
        System.out.println("*********");
        System.out.println("1 -> carre");
        System.out.println("2 -> triangle version 1");
        System.out.println("3 -> triangle version 2");
        System.out.println("4 -> triangle version 3");
        System.out.println("5 -> pyramide version 1");
        System.out.println("6 -> pyramide version 2");
        System.out.println("7 -> pyramide version 3");
        System.out.println("8 -> losange");
    }

    private static void carre() {
        System.out.print("\nEntrez n : ");
        int n=scanner.nextInt();
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("X");
            }
            System.out.println();
        }
    }

    private static void triangleVersion1() {
        System.out.print("\nEntrez n : ");
        int n=scanner.nextInt();
        int croix=1;
        for (int i = 1; i <=n ; i++) {
            for(int j = 1; j<=croix; j++){
                System.out.print('X');
            }
            croix++;
            System.out.println();
        }
    }
    private static void triangleVersion2(){
        System.out.print("\nEntrez n : ");
        int n=scanner.nextInt();
        int croix=n;
        for (int i = 1; i <=n ; i++) {
            for(int j = 1; j<=croix; j++){
                System.out.print('X');
            }
            croix--;
            System.out.println();
        }
    }
    private static void triangleVersion3(){
        System.out.print("\nEntrez n : ");
        int n=scanner.nextInt();
        int croix=n;
        int espace=0;
        for (int i = 1; i <=n ; i++) {
            for(int j=0; j<=espace; j++) {
                System.out.print(' ');
            }
            for(int j = 1; j<=croix; j++){
                System.out.print('X');
            }
            croix--;
            espace++;
            System.out.println();
        }
    }
    private static void pyramide(){
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
    }
    private static void pyramideVersion2(){
        System.out.print("\nEntrez n : ");
        int n=scanner.nextInt();
        int croix=1;
        int espace=n-1;

        for (int i = 0; i < n ; i++) {
            int nombre=0;
            for(int j=0; j<= espace; j++) {
                System.out.print(' ');
            }
            for(int j = 0; j< croix; j++){

                if(j<=i){nombre++;}
                else{nombre--;}
                System.out.print(nombre);
            }
            croix=croix+2;
            espace--;
            System.out.println();
        }

    }
    private static void pyramideVersion3(){
        System.out.print("\nEntrez n : ");
        int n=scanner.nextInt();
        System.out.print("\nEntrez le nbr au sommet : ");
        int s= scanner.nextInt();
        s--;
        int croix=1;
        int espace=n-1;

        for (int i = 0; i < n ; i++) {
            for(int j=0; j<= espace; j++) {
                System.out.print(' ');
            }
            for(int j = 0; j< croix; j++) {
                if(j<=i){
                    if(s<9 )
                        s++;
                    else
                        s = 0;
                }
                else{
                    if(s>0)
                        s--;
                    else
                        s=9;
                }
                System.out.print(s);
            }
            croix=croix+2;
            espace--;
            System.out.println();
        }
    }
    private static void losange(){
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
