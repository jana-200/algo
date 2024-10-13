public class CombatAMort {

    public static void main(String[] args) {

        System.out.println("Bienvenue au combat entre CogneDur et FrappeFort !");
        int pointsDeVieCogneDur = 9;
        int pointsDeVieFrappeFort = 12;
        int forceCogneDur;
        int forceFrappeFort;

        while(pointsDeVieCogneDur>0 && pointsDeVieFrappeFort>0){
            forceCogneDur=lancerDe();
            System.out.println("CogneDur inflige " + forceCogneDur +" points de degats a FrappeFort.");
            pointsDeVieFrappeFort-=forceCogneDur;
            if(pointsDeVieFrappeFort>0)
                System.out.println("Il reste "+ pointsDeVieFrappeFort +" points de vie a FrappeFort.");
            else
                System.out.println("FrappeFort est mort. Paix a son ame, il est mort en brave.");

            forceFrappeFort=lancerDe();
            System.out.println("FrappeFort inflige "+ forceFrappeFort +" points de degats a CogneDur.");
            pointsDeVieCogneDur-=forceFrappeFort;
            if(pointsDeVieCogneDur>0)
                System.out.println("Il reste "+ pointsDeVieCogneDur +" points de vie a CogneDur.");
            else
                System.out.println("CogneDur est mort. Paix a son ame, il est mort en brave.");
        }
        if(pointsDeVieCogneDur>0)
            System.out.println("CogneDur est victorieux.");
        else
            if(pointsDeVieFrappeFort>0)
                System.out.println("FrappeFort est victorieux.");
    }

    public static int lancerDe(){
        return (int)((Math.random() * 6) + 1);
    }
}
