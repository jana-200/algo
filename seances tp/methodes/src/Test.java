public class Test {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
        public static void main(String[] args) {
            String s1 = "Hello world!";
            lireCharPermis(s1);
        }
    public static char lireCharPermis(String characteresPermis){
        System.out.println("Entrez un caractére");
        char caractère = scanner.next().charAt(0);
        while (!characteresPermis.contains(String.valueOf(caractère))) {
            System.out.println("Veuillez entrer un autre caractère ");
            caractère = scanner.next().charAt(0);
        }
        return caractère;
    }

}
