public class Prueba {
    public static void main(String[] args) {
        int valor = 0;
        try {
            valor++;
            valor += Integer.parseInt("w");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(valor);
    }
}
