public class CombatAMort_VI {

    public static void main(String[] args) {

        FenetreCombatGuerriers jeu = new FenetreCombatGuerriers();
        System.out.println("Bienvenue au combat entre CogneDur et FrappeFort !");
        int pointsDeVieCogneDur = jeu.lancerDe();
        jeu.afficherPointsDeVie(1, pointsDeVieCogneDur);
        int pointsDeVieFrappeFort = jeu.lancerDe();
        jeu.afficherPointsDeVie(2,pointsDeVieFrappeFort );
        int forceCogneDur;
        int forceFrappeFort;

        while(pointsDeVieCogneDur>0 && pointsDeVieFrappeFort>0) {

            jeu.afficherInformation("A CogneDur");
            jeu.afficherEpee(1);
            jeu.afficherBouclier(2);
            forceCogneDur = jeu.lancerDe();
            pointsDeVieFrappeFort -= forceCogneDur;
            if (pointsDeVieFrappeFort > 0) {
                jeu.afficherPointsDeVie(2, pointsDeVieFrappeFort);
                jeu.afficherInformation("A FrappeFort");
                jeu.afficherEpee(2);
                jeu.afficherBouclier(1);
                forceFrappeFort = jeu.lancerDe();
                pointsDeVieCogneDur -= forceFrappeFort;
                if(pointsDeVieCogneDur>0){
                   jeu.afficherPointsDeVie(1,pointsDeVieCogneDur);
                }
                else{
                    jeu.afficherInformation("Fin du jeu :( ");
                    jeu.afficherPointsDeVie(1,0);
                    jeu.afficherCroix(1);
                    jeu.afficherCoupeOr(2);
                }
            }
            else {
                jeu.afficherInformation("Fin du jeu :( ");
                jeu.afficherPointsDeVie(2, 0);
                jeu.afficherCroix(2);
                jeu.afficherCoupeOr(1);
            }
        }
    }
}
