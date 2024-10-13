public class DuelGuerriers_VI {

    public static void main(String[] args) {

        FenetreCombatGuerriers jeu = new FenetreCombatGuerriers();
        jeu.afficherInformation("A CogneDur");
        int pointsDeVieCogneDur = jeu.lancerDe();
        jeu.afficherPointsDeVie(1, pointsDeVieCogneDur);
        jeu.afficherInformation("A FrappeFort");
        int pointsDeVieFrappeFort = jeu.lancerDe();
        jeu.afficherPointsDeVie(2, pointsDeVieFrappeFort);

        jeu.afficherEpee(1);
        jeu.afficherBouclier(2);
        jeu.afficherInformation("A CogneDur");
        int forceCogneDur = jeu.lancerDe();
        pointsDeVieFrappeFort=pointsDeVieFrappeFort-forceCogneDur;

        if (pointsDeVieFrappeFort<=0){
            jeu.afficherPointsDeVie(2,0);
            jeu.afficherInformation("Fin Du Jeu");
            jeu.afficherCroix(2);
            jeu.afficherCoupeOr(1);
        }
        else{
            jeu.afficherPointsDeVie(2,pointsDeVieFrappeFort);
            jeu.afficherEpee(2);
            jeu.afficherBouclier(1);
            jeu.afficherInformation("A FrappeFort");
            int forceFrappeFort = jeu.lancerDe();
            pointsDeVieCogneDur = pointsDeVieCogneDur - forceFrappeFort;
            if(pointsDeVieCogneDur<=0){
                jeu.afficherPointsDeVie(1, 0);
                jeu.afficherInformation("Fin Du Jeu");
                jeu.afficherCroix(1);
                jeu.afficherCoupeOr(2);
            }
            else{
                jeu.afficherPointsDeVie(1,pointsDeVieCogneDur);
                jeu.afficherInformation("Fin Du Jeu");
                if (pointsDeVieCogneDur == pointsDeVieFrappeFort) {
                    jeu.afficherCoupeOr(2);
                    jeu.afficherCoupeOr(1);
                }
                else{
                    if (pointsDeVieCogneDur < pointsDeVieFrappeFort) {
                        jeu.afficherCoupeOr(2);
                        jeu.afficherCoupeArgent(1);
                    }
                    else {
                        jeu.afficherCoupeOr(1);
                        jeu.afficherCoupeArgent(2);
                    }
                }
            }
        }
    }
}
