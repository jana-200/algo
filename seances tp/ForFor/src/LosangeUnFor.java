import java.util.Scanner;
public class LosangeUnFor {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Entrez la taille (n) : ");
        int n = scanner.nextInt();
        int nbElem = 4*n*n;
        for (int j = 1; j <= nbElem; j++) {
            int i = j/(2*n);
            if(j%(2*n)<=n-i || j%(2*n)>=n+1+i){
                System.out.print("X");
            }
            else {
                System.out.print(" ");
            }
            if((j)%(2*n)==0){
                System.out.println();
            }
        }
        // à completer !!!!!!!!!!!!!! //
    }
}
