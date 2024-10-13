public class DessinCarresEmboites {
    public static void main(String[] args) {
        Tortue tortue=new Tortue();
        int taille=100;
        for (int i = 0; i < 5; i++) {
            tortue.accelerer();
            tortue.dessinerUnCarre(taille);
            taille-=10;
        }
    }
}
