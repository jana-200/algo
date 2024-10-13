public class Buzz {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args){

        // creation des 2 equipes

        Equipe equipe1 = chargerEquipe1();
        Equipe equipe2 = chargerEquipe2();

        // creation du questionnaire

        Questionnaire questionnaire = chargerQuestions();

        System.out.println("Quizz - Capitales des pays de l'union europeenne");

       //TODO
        int points1=0;
        int points2=0;

        while(equipe1.getNombreCandidatsEnJeu()>0 && equipe2.getNombreCandidatsEnJeu()>0 ) {
            System.out.println("Voici les candidats en jeu de l'equipe 1 :");
            System.out.println(equipe1);
            System.out.println("Voici les candidats en jeu de l'equipe 2 :");
            System.out.println(equipe2);
            System.out.println();
            System.out.println("Nouvelle question");
            System.out.println("Selectionnez les 2 candidats");
            String candidat1 = equipe1.selectionnerCandidat();
            System.out.println("Le candidat selectionne de l'equipe 1 est " + candidat1);
            String candidat2 = equipe2.selectionnerCandidat();
            System.out.println("Le candidat selectionne de l'equipe 2 est " + candidat2);

            if (questionnaire.getNombreQuestionsRestantes() == 0) {
                questionnaire.reinitialiser();
            }
            QuestionCM qcm = questionnaire.fournirQuestion();
            System.out.println("Voici la question : ");
            System.out.println(qcm);

            System.out.print("Entrez le numero de l'equipe qui a buzze (1 ou 2) : ");
            int nEquipe = scanner.nextInt();

            System.out.print("Entrez son choix (1, 2 ou 3) : ");
            int choix = scanner.nextInt();

            if (choix == qcm.getNumeroChoixCorrect()) {
                System.out.println("Bravo! La reponse est bonne");
                System.out.println("l'equipe " + nEquipe + " a gagne 1 point");
                if (nEquipe == 1) points1++;

                else points2++;

                equipe2.remettreEnJeu(candidat2);
                equipe1.remettreEnJeu(candidat1);
            }
            else {
                System.out.println("La reponse n'est pas bonne");
                if (nEquipe == 1) {
                    System.out.println(candidat1 + " est elimine");
                    equipe2.remettreEnJeu(candidat2);
                }
                else{
                    System.out.println(candidat2 + " est elimine");
                    equipe1.remettreEnJeu(candidat1);
                }
            }

            System.out.println();

            System.out.println("l'equipe 1 a "+ points1+" point(s)");
            System.out.println("l'equipe 2 a "+ points2+" point(s)");

            System.out.println();
        }

        System.out.println("Le jeu est termine");
        if(equipe1.getNombreCandidatsEnJeu()==0) {
            System.out.println("l'equipe 1 n'a plus de candidat");
            System.out.println("l'equipe 2 a gagne !");
        }
        else{
            System.out.println("l'equipe 2 n'a plus de candidat");
            System.out.println("l'equipe 1 a gagne !");
        }

    }

    public static Questionnaire chargerQuestions(){
        QuestionCM[] questions = new QuestionCM[5];
        questions[0]= new QuestionCM("Allemagne","Amsterdam","Dublin","Berlin",3);
        questions[1]= new QuestionCM("France","Paris","Prague", "Vilnius",1);
        questions[2]= new QuestionCM("Belgique","Amsterdam", "Bruxelles","Paris",2);
        questions[3]= new QuestionCM("Espagne"	,"Madrid","Budapest","Bucarest",1);
        questions[4]= new QuestionCM("Italie","Nicosie","Riga","Rome",3);
        return new Questionnaire(questions);
    }

    public static Equipe chargerEquipe1(){
        String[] candidats = new String[4];
        candidats[0] = "Lea";
        candidats[1] = "Marie";
        candidats[2] = "Chloe";
        candidats[3] = "Julie";
        return new Equipe(1,candidats);
    }

    public static Equipe chargerEquipe2(){
        String[] candidats = new String[4];
        candidats[0] = "Pierre";
        candidats[1] = "Sam";
        candidats[2] = "Tom";
        candidats[3] = "Hugo";
        return new Equipe(2,candidats);
    }

}


