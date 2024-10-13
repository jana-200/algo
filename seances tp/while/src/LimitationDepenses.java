import java.util.ArrayList ;

public class LimitationDepenses {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Quel est la limite de la somme que vous pouvez dépenser ? ");
        int budget = scanner.nextInt();
        int montantRestant=budget;
        int achat = 0;
        ArrayList achats = new ArrayList();
        if(budget<0) {
            System.out.print("vous devez entrer un nombre positif");
            budget= scanner.nextInt();
        }
        while(budget>=montantRestant && montantRestant!=0 ){
            System.out.print("Entrez la valeur de votre achats : ");
            achat= scanner.nextInt();
            if(achat<= montantRestant){
                montantRestant-=achat;
                achats.add(achat);
            }
            else
                break;
        }
        System.out.println("Budget : " + budget+ "\n" + "Achats : "+ achats + "\n" + "Montant restant : " + montantRestant );
    }
}
