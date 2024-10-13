public class DessinFleur {
    public static void main(String[] args) {
        Tortue tortue = new Tortue();
        for (int i = 0; i < 4; i++) {
            tortue.accelerer();
            tortue.dessinerUnTriangle(100);
            tortue.tournerADroite(90);
        }
    }
}
