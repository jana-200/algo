public class Test {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
        public static void main(String[] args) {
            String s1 = "Hello world!";
            lireCharPermis(s1);
        }
    public static char lireCharPermis(String characteresPermis){
        System.out.println("Entrez un caract�re");
        char caract�re = scanner.next().charAt(0);
        while (!characteresPermis.contains(String.valueOf(caract�re))) {
            System.out.println("Veuillez entrer un autre caract�re ");
            caract�re = scanner.next().charAt(0);
        }
        return caract�re;
    }

}
