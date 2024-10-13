public class DessinCarresEmboites {
    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        int taille=50;
        for (int i = 0; i < 5; i++) {
            taille+=25;
            for (int j = 0; j < 4; j++) {
                tortue.avancer(taille);
                tortue.tournerADroite(90);
            }
        }
    }
}
