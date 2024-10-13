public class Deliberation {
    public static void main(String[] args) {
       int etudiants =2;
       double sommeMoyennes=0;
        double moyenne;
        for (int i = 1; i <= etudiants; i++) {
            System.out.println("étudiant n°"+i);
            moyenne = moyenne1();
            sommeMoyennes+=moyenne;
        }
        double moyenneClasse= sommeMoyennes/etudiants;
        System.out.println("La moyenne de la classe est "+ moyenneClasse);
    }

    public static double moyenne1(){
        int nombreCotes=0;
        double totalCotes = 0;
        double moyenne;
        while(nombreCotes<10) {
            System.out.print("Entrez une cote (sur 20) : ");
            double cote = Utilitaires.lireReelComprisEntre(0, 20);
            totalCotes += cote;
            nombreCotes++;
        }
        moyenne =totalCotes/nombreCotes;
        return moyenne;
    }
}
