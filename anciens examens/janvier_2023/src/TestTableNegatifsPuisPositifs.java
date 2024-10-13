import java.util.Arrays;

public class TestTableNegatifsPuisPositifs {
    
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    /**
     * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
     *
     * @param messageErreur message a afficher en cas de probleme
     * @param attendu la valeur qu'on s'attendait a recevoir
     * @param recu la valeur qu'on a recu en realite
     */

    private static void assertEquals(String messageErreur, Object attendu, Object recu) {
        if (attendu==null) {
            if (recu!=null) {
                System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
                System.exit(0);
            }
        } else if (!attendu.equals(recu)) {
            System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        int choix;

        System.out.println("**********************************************");
        System.out.println("Tests pour la classe TableNegatifsPuisPositifs");
        System.out.println("**********************************************");
        do{
            System.out.println("Menu");
            System.out.println("****");
            System.out.println("1 -> TableNegatifsPuisPositifs()");
            System.out.println("2 -> moyenneStrictementPositifs()");
            System.out.println("3 -> tousStrictementPlusPetits()");
            System.out.println("4 -> supprimerMax()");
            System.out.print("\nEntrez votre choix : ");

            choix=scanner.nextInt();

            switch(choix){
                case 1: testerConstructeur();
                    break;
                case 2: testerMoyenneStrictementPositifs();
                    break;
                case 3: testerTousStrictementPlusPetits();
                    break;
                case 4: testerSupprimerMax();
                    break;
            }
        }while(choix >=1 && choix<=4);

        System.out.println("\nFin des tests");
    }

    private static void testerConstructeur() {
        System.out.println();
        System.out.println("TableNegatifsPuisPositifs()");
        System.out.println("---------------------------");

        //test1
        int numeroTest = 1;
        System.out.println("test "+numeroTest);
        try{
            int[] tableFournie = {-5,7,-8,1,0,2,-1,1};
            System.out.println("table fournie : "+ Arrays.toString(tableFournie));
            int[] tableAttendue = {-5,-8,-1,7,1,0,2,1};
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableFournie);
            assertEquals("test "+numeroTest+" ko : nbNegatifs ko",3,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls ko",5,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != MAX (10)",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test "+ numeroTest +"ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NullPointerException e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception");
            System.out.println("Avez-vous cree (new) tableNP ?");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();

        //test2
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableFournie = {-5,-8};
            int[] tableAttendue = {-5,-8};
            System.out.println("table fournie : "+Arrays.toString(tableFournie));
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableFournie);
            assertEquals("test "+numeroTest+" ko : nbNegatifs ko",2,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls ko",0,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != MAX (10)",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test "+ numeroTest +"ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NullPointerException e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception");
            System.out.println("Avez-vous cree (new) tableNP ?");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();

        //test3
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableFournie = {9,8,7,6,5,4,3,2,1,0};
            int[] tableAttendue = {9,8,7,6,5,4,3,2,1,0};
            System.out.println("table fournie : "+Arrays.toString(tableFournie));
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableFournie);
            assertEquals("test "+numeroTest+" ko : nbNegatifs ko",0,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls ko",10,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != MAX (10)",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test "+ numeroTest +"ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NullPointerException e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception");
            System.out.println("Avez-vous cree (new) tableNP ?");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();

        //test4
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableFournie = {};
            int[] tableAttendue = {};
            System.out.println("table fournie : table vide : "+Arrays.toString(tableFournie));
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableFournie);
            assertEquals("test "+numeroTest+" ko : nbNegatifs ko",0,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls ko",0,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != MAX (10)",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test "+ numeroTest +"ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NullPointerException e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception");
            System.out.println("Avez-vous cree (new) tableNP ?");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+" ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+" ok");
        System.out.println();

        System.out.println("tous les tests ont reussi!");
        System.out.println();
    }

    private static void testerMoyenneStrictementPositifs() {
        System.out.println();
        System.out.println("moyenneStrictementPositifs()");
        System.out.println("----------------------------");

        int numeroTest = 1;
        //test1
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-8,3,1,2};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,2,3);
            assertEquals("test "+numeroTest+ " ko : moyenne ko",2.0,tableNP.moyenneStrictementPositifs());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test2
        numeroTest = 2;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-8,3,0,1,0,2,0};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println(Arrays.toString(tableARecopier));
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,2,6);
            assertEquals("test "+numeroTest+ " ko : moyenne ko",2.0,tableNP.moyenneStrictementPositifs());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test3
        numeroTest = 3;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-8, -2,3,1,0,2,0,4,0};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,3,7);
            assertEquals("test "+numeroTest+ " ko : moyenne ko",2.5,tableNP.moyenneStrictementPositifs());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test4
        numeroTest = 4;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,10,0);
            assertEquals("test "+numeroTest+ " ko : moyenne ko",0.0,tableNP.moyenneStrictementPositifs());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test5
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {};
            System.out.println("table testee : table vide : "+Arrays.toString(tableARecopier));
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,0,0);
            assertEquals("test "+numeroTest+ " ko : moyenne ko",0.0,tableNP.moyenneStrictementPositifs());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        System.out.println("tous les tests ont reussi!");
        System.out.println();
    }

    private static void testerTousStrictementPlusPetits() {
        System.out.println();
        System.out.println("tousStrictementPlusPetits()");
        System.out.println("---------------------------");

        //test1
        int numeroTest = 1;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-8,3,2,5};
            int nbNegatifs = 2;
            int nbPositifsOuNul = 3;
            int entierTeste = 10;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("tous strictement plus petits : "+entierTeste+ " ?");
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",true,tableNP.tousStrictementPlusPetits(entierTeste));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test2
        numeroTest = 2;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-8,3,5,2};
            int nbNegatifs = 2;
            int nbPositifsOuNul = 3;
            int entierTeste = 5;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("tous strictement plus petits : "+entierTeste+ " ?");
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",false,tableNP.tousStrictementPlusPetits(entierTeste));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test3
        numeroTest = 3;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-8,3,2,5};
            int nbNegatifs = 2;
            int nbPositifsOuNul = 3;
            int entierTeste = 5;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("tous strictement plus petits : "+entierTeste+ " ?");
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",false,tableNP.tousStrictementPlusPetits(entierTeste));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();


        //test4
        numeroTest = 4;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-7,-2,-5,-4,-9,-8,-10,-5,-7,-1};
            int nbNegatifs = 10;
            int nbPositifsOuNul = 0;
            int entierTeste = -1;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("tous strictement plus petits : "+entierTeste+ " ?");
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",false,tableNP.tousStrictementPlusPetits(entierTeste));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test5
        numeroTest = 5;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {7,2,5,4,9,8,10,5,7,6};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 10;
            int entierTeste = 11;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("tous strictement plus petits : "+entierTeste+ " ?");
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",true,tableNP.tousStrictementPlusPetits(entierTeste));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();


        //test6
        numeroTest = 6;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-7,-2,-5,-4,-9,-8,-10,-5,-7,-6};
            int nbNegatifs = 10;
            int nbPositifsOuNul = 0;
            int entierTeste = 1;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("tous strictement plus petits : "+entierTeste+ " ?");
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",true,tableNP.tousStrictementPlusPetits(entierTeste));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test7
        numeroTest = 7;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-4,-5,-6};
            int nbNegatifs = 3;
            int nbPositifsOuNul = 0;
            int entierTeste = -1;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("tous strictement plus petits : "+entierTeste+ " ?");
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",true,tableNP.tousStrictementPlusPetits(entierTeste));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test8
        numeroTest = 8;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-9,0,4,2};
            int nbNegatifs = 2;
            int nbPositifsOuNul = 3;
            int entierTeste = 0;
            System.out.println("table testee :"+Arrays.toString(tableARecopier));
            System.out.println("tous strictement plus petits : "+entierTeste+ " ?");
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",false,tableNP.tousStrictementPlusPetits(entierTeste));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test9
        numeroTest = 9;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-1,-7,-5,0};
            int nbNegatifs = 3;
            int nbPositifsOuNul = 1;
            int entierTeste = 0;
            System.out.println("table testee :"+Arrays.toString(tableARecopier));
            System.out.println("tous strictement plus petits : "+entierTeste+ " ?");
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",false,tableNP.tousStrictementPlusPetits(entierTeste));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test10
        numeroTest = 10;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-1,-7,-2,-9};
            int nbNegatifs = 4;
            int nbPositifsOuNul = 0;
            int entierTeste = 0;
            System.out.println("table testee :"+Arrays.toString(tableARecopier));
            System.out.println("tous strictement plus petits : "+entierTeste+ " ?");
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",true,tableNP.tousStrictementPlusPetits(entierTeste));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test11
        numeroTest = 11;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {0,0,0};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 3;
            int entierTeste = 0;
            System.out.println("table testee :"+Arrays.toString(tableARecopier));
            System.out.println("tous strictement plus petits : "+entierTeste+ " ?");
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",false,tableNP.tousStrictementPlusPetits(entierTeste));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test12
        numeroTest = 12;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-12,-15,-8};
            int nbNegatifs = 3;
            int nbPositifsOuNul = 0;
            int entierTeste = -8;
            System.out.println("table testee :"+Arrays.toString(tableARecopier));
            System.out.println("tous strictement plus petits : "+entierTeste+ " ?");
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",false,tableNP.tousStrictementPlusPetits(entierTeste));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test13
        numeroTest = 13;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5};
            int nbNegatifs = 1;
            int nbPositifsOuNul = 0;
            int entierTeste = 0;
            System.out.println("table testee :"+Arrays.toString(tableARecopier));
            System.out.println("tous strictement plus petits : "+entierTeste+ " ?");
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",true,tableNP.tousStrictementPlusPetits(entierTeste));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test14
        numeroTest = 14;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {3};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 1;
            int entierTeste = 0;
            System.out.println("table testee :"+Arrays.toString(tableARecopier));
            System.out.println("tous strictement plus petits : "+entierTeste+ " ?");
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",false,tableNP.tousStrictementPlusPetits(entierTeste));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test15
        numeroTest = 15;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 0;
            int entierTeste = 5;
            System.out.println("table testee : table vide :"+Arrays.toString(tableARecopier));
            System.out.println("tous strictement plus petits : "+entierTeste+ " ?");
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+ " ko : booleen ko",true,tableNP.tousStrictementPlusPetits(entierTeste));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        System.out.println();
        System.out.println("tous les tests ont reussi!");
        System.out.println();
  
    }

    private static void testerSupprimerMax() {

        System.out.println();
        System.out.println("supprimerMax()");
        System.out.println("--------------");

        System.out.println();
        //test1
        int numeroTest = 1;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-8,5,2,3};
            int nbNegatifs = 2;
            int nbPositifsOuNul = 3;
            int[]tableAttendue = {-5,-8,2,3};
            int max = 5;
            int nbNegatifsAttendu = 2;
            int nbPositifsOuNulAttendu = 2;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+" ko : max renvoye",max,tableNP.supprimerMax());
            assertEquals("test "+numeroTest+" ko : nbNegatifs (apres suppression max) ko",nbNegatifsAttendu,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls (apres suppression max) ko",nbPositifsOuNulAttendu,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP (apres suppression max) ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != 10 (apres suppression max)",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test2
        numeroTest = 2;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-8,5,2,9,4,5,9,7,6};
            int nbNegatifs = 2;
            int nbPositifsOuNul = 8;
            int[]tableAttendue = {-5,-8,5,2,4,5,9,7,6};
            int max = 9;
            int nbNegatifsAttendu = 2;
            int nbPositifsOuNulAttendu = 7;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+" ko : max renvoye",max,tableNP.supprimerMax());
            assertEquals("test "+numeroTest+" ko : nbNegatifs (apres suppression max) ko",nbNegatifsAttendu,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls (apres suppression max) ko",nbPositifsOuNulAttendu,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP (apres suppression max) ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != 10 (apres suppression max)",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test3
        numeroTest = 3;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,5,2,7};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 4;
            int[]tableAttendue = {1,5,2};
            int max = 7;
            int nbNegatifsAttendu = 0;
            int nbPositifsOuNulAttendu = 3;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+" ko : max renvoye",max,tableNP.supprimerMax());
            assertEquals("test "+numeroTest+" ko : nbNegatifs (apres suppression max) ko",nbNegatifsAttendu,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls (apres suppression max) ko",nbPositifsOuNulAttendu,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP (apres suppression max) ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != 10 (apres suppression max)",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();
        
        //test4
        numeroTest = 4;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {0,0};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 2;
            int[]tableAttendue = {0};
            int max = 0;
            int nbNegatifsAttendu = 0;
            int nbPositifsOuNulAttendu = 1;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+" ko : max renvoye",max,tableNP.supprimerMax());
            assertEquals("test "+numeroTest+" ko : nbNegatifs (apres suppression max) ko",nbNegatifsAttendu,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls (apres suppression max) ko",nbPositifsOuNulAttendu,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP (apres suppression max) ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != 10 (apres suppression max)",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test5
        numeroTest = 5;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-7,-2,-8,-3,-3,-9};
            int nbNegatifs = 6;
            int nbPositifsOuNul = 0;
            int[]tableAttendue = {-7,-8,-3,-3,-9};
            int max = -2;
            int nbNegatifsAttendu = 5;
            int nbPositifsOuNulAttendu = 0;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+" ko : max renvoye",max,tableNP.supprimerMax());
            assertEquals("test "+numeroTest+" ko : nbNegatifs (apres suppression max) ko",nbNegatifsAttendu,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls (apres suppression max) ko",nbPositifsOuNulAttendu,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP (apres suppression max) ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != 10 (apres suppression max)",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test6
        numeroTest = 6;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-1};
            int nbNegatifs = 1;
            int nbPositifsOuNul = 0;
            int[]tableAttendue = {};
            int max = -1;
            int nbNegatifsAttendu = 0;
            int nbPositifsOuNulAttendu = 0;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+" ko : max renvoye",max,tableNP.supprimerMax());
            assertEquals("test "+numeroTest+" ko : nbNegatifs (apres suppression max) ko",nbNegatifsAttendu,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls (apres suppression max) ko",nbPositifsOuNulAttendu,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP (apres suppression max) ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != 10 (apres suppression max)",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test7
        numeroTest = 7;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {0};
            int nbNegatifs = 0;
            int nbPositifsOuNul = 1;
            int[]tableAttendue = {};
            int max = 0;
            int nbNegatifsAttendu = 0;
            int nbPositifsOuNulAttendu = 0;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+" ko : max renvoye",max,tableNP.supprimerMax());
            assertEquals("test "+numeroTest+" ko : nbNegatifs (apres suppression max) ko",nbNegatifsAttendu,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls (apres suppression max) ko",nbPositifsOuNulAttendu,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP (apres suppression max) ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != 10 (apres suppression max)",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test8
        numeroTest = 8;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-6,-7,-6,-3,-8,-7,-2,-7,-3,-1};
            int nbNegatifs = 10;
            int nbPositifsOuNul = 0;
            int[]tableAttendue = {-6,-7,-6,-3,-8,-7,-2,-7,-3};
            int max = -1;
            int nbNegatifsAttendu = 9;
            int nbPositifsOuNulAttendu = 0;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+" ko : max renvoye",max,tableNP.supprimerMax());
            assertEquals("test "+numeroTest+" ko : nbNegatifs (apres suppression max) ko",nbNegatifsAttendu,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls (apres suppression max) ko",nbPositifsOuNulAttendu,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP (apres suppression max) ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != 10 (apres suppression max)",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test9
        numeroTest = 9;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-1,-7,-6,-3,-8,-7,-2,-7,-3,-6};
            int nbNegatifs = 10;
            int nbPositifsOuNul = 0;
            int[]tableAttendue = {-7,-6,-3,-8,-7,-2,-7,-3,-6};
            int max = -1;
            int nbNegatifsAttendu = 9;
            int nbPositifsOuNulAttendu = 0;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableNegatifsPuisPositifs tableNP = new TableNegatifsPuisPositifs(tableARecopier,nbNegatifs,nbPositifsOuNul);
            assertEquals("test "+numeroTest+" ko : max renvoye",max,tableNP.supprimerMax());
            assertEquals("test "+numeroTest+" ko : nbNegatifs (apres suppression max) ko",nbNegatifsAttendu,tableNP.getNbNegatifs() );
            assertEquals("test "+numeroTest+" ko : nbPositifsEtNuls (apres suppression max) ko",nbPositifsOuNulAttendu,tableNP.getNbPositifsEtNuls() );
            assertEquals("test "+numeroTest+" ko : contenu tableNP (apres suppression max) ko",Arrays.toString(tableAttendue),tableNP.toString());
            assertEquals("test "+numeroTest+" ko : taille physique tableNP != 10 (apres suppression max)",10,tableNP.getNbNegatifs()+tableNP.getNbPositifsEtNuls()+ tableNP.nbAjoutsPossible());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        System.out.println("tous les tests ont reussi!");
        System.out.println();
    }
    
}
