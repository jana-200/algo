public class DessinMontgolfiere {

    public static void main(String[] args) {

         Tortue tortue = new Tortue();

        for (int i = 0; i < 470; i++) {
           tortue.accelerer();
           tortue.definirCouleur("bleu");
           tortue.avancer(1.7);
           tortue.tournerADroite(1);
        }

        tortue.definirCouleur("blanc");
        tortue.tournerAGauche(10);
        tortue.avancer(200);
        tortue.tournerAGauche(10);

        for (int i = 0; i < 4; i++) {
            tortue.definirCouleur("bleu");
            tortue.avancer(50);
            tortue.tournerADroite(90);
            tortue.avancer(100);
            tortue.tournerADroite(90);
        }

        tortue.tournerADroite(90);
        tortue.avancer(100);

        tortue.tournerADroite(90);
        tortue.avancer(100);
        tortue.definirCouleur("blanc");
        tortue.tournerADroite(76);
        tortue.avancer(200);

        tortue.definirCouleur("noir");
        tortue.avancer(300);
        tortue.tournerADroite(90);
        tortue.avancer(50);

        for (int i = 0; i < 470; i++) {
            tortue.accelerer();
            tortue.definirCouleur("jaune");
            tortue.avancer(1);
            tortue.tournerADroite(1);
        }

        tortue.definirCouleur("noir");
        tortue.tournerADroite(270);
        tortue.avancer(400);

        for (int i = 0; i < 2; i++) {
            tortue.definirCouleur("blanc");
            tortue.tournerADroite(120);
            tortue.avancer(50);
        }
    }
}
