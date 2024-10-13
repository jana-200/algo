public class DessinJeuxOlympiques {
    public static Tortue turtle = new Tortue();
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            turtle.definirCouleur("noir");
            turtle.tournerADroite(72 * i - 90); // tourner selon l'angle correspondant au cercle
            turtle.avancer(20); // avancer selon le rayon du cercle
            turtle.tournerADroite(90); // tourner à droite pour faire face au cercle
            turtle.definirCouleur("blanc");

            // tracer le cercle avec une boucle for
            for (int j = 0; j < 360; j++) {
                turtle.accelerer();
                turtle.avancer(2 * Math.PI * 20 / 360); // avancer selon la longueur d'un arc de cercle
                turtle.tournerADroite(1); // tourner d'un degré
            }

            // revenir à la position initiale
            turtle.definirCouleur("noir");
            turtle.tournerADroite(-90); // tourner à gauche pour faire face au centre
            turtle.avancer(-20); // reculer selon le rayon du cercle
            turtle.tournerADroite(-72 * i + 90); // tourner selon l'angle inverse du cercle
            turtle.definirCouleur("blanc");

        }

    }
}
