import java.util.Scanner;

import Ej3.NumberDivision;

public class Ej3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Insert number 1: ");
        String n1 = scan.nextLine();
        System.out.print("Insert number 2: ");
        String n2 = scan.nextLine();
    
        try {
            int number1 = Integer.parseInt(n1);
            int number2 = Integer.parseInt(n2);

            NumberDivision numbDiv = new NumberDivision(number1, number2);
            double result = numbDiv.division();
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("Cannot convert the input to Integer.");
        } catch (ArithmeticException e) {
            System.out.println( "Cannot " + e.getMessage());
        } finally {
            System.out.println("See you soon!");
            scan.close();
        }
    }
}
/*Defina una clase llamada DivisionNumero. En el método main utilice un Scanner para leer dos números en forma de cadena.
A continuación, utilice el método parseInt() de la clase Integer, para convertir las cadenas al tipo int y guardarlas
en dos variables de tipo int. Por ultimo realizar una división con los dos numeros y mostrar el resultado. */