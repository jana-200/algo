public class AffichageTablesDeMultiplications {

    public static void main(String[] args){

        for (int i = 1; i <=10; i++) {
            for (int j = 1; j <=10; j++) {
                int nombre=i*j;
                System.out.print("\t"+nombre);
            }
            System.out.print("\n");
        }
    }
}

