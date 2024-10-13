public class CalculBMI {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Quel est votre poids en kg? ");
        int poids= scanner.nextInt();
        System.out.println("Quel est votre taille en mètre? ");
        double taille= scanner.nextDouble();
        double BMI = poids/(taille*taille);

        if(BMI>=20 && BMI<=25)
            System.out.println("Votre BMI est "+ BMI+ ". Vous êtes en forme!");
        else
            if(BMI<20)
                System.out.println("Votre BMI est "+ BMI+ ". Vous êtes en sous-poids");
            else
                if(BMI>30)
                    System.out.println("Votre BMI est "+ BMI+ ". Vous êtes obèse");
                else
                    System.out.println("Votre BMI est "+ BMI+ ". Vous êtes en sur-poids");
    }
}
