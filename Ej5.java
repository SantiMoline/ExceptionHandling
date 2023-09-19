import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int secretNumber = (int) (Math.random() * 501);
        int attempts = 0;
        boolean active = true;
        int guess = 0;

        while (active) {
            try {
                guess = promptForNumber(scan);
                System.out.println(compareToSecretNumber(guess, secretNumber));
                if (guess == secretNumber) {
                    active = false;
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("You must enter an integer.");
                scan.nextLine(); //To catch the end of the incorrect input line.
            } finally {
                attempts++;
            }
        }
        showFinalStatus(secretNumber, attempts);
        scan.close();
    }

    public static int promptForNumber(Scanner scan) throws InputMismatchException{
        System.out.print("Enter a valid number (1-500): ");
        int n = scan.nextInt();
        return n;        
    }

    public static String compareToSecretNumber(int guess, int secretNumber) {
        if (guess > secretNumber)
            return "Secret number is lower than " + guess;
        if (guess < secretNumber)
            return "Secret number is higher than " + guess;
        return "Jackpot!";
    }

    public static void showFinalStatus(int secretNumber, int attempts) {
        System.out.println("Congratulations!! Secret number: " + secretNumber);
        System.out.println("Attempts needed to guess correctly: " + attempts);
    }

}
/*
 * Escribir un programa en Java que juegue con el usuario a adivinar un número. La computadora debe generar un número aleatorio entre 1 y 500, y el usuario tiene que intentar adivinarlo.
 * Para ello, cada vez que el usuario introduce un valor, la computadora debe decirle al usuario si el número que tiene que adivinar es mayor o menor que el que ha introducido el usuario.
 * Cuando consiga adivinarlo, debe indicárselo e imprimir en pantalla el número de veces que el usuario ha intentado adivinar el número. Si el usuario introduce algo que no es un número,
 * se debe controlar esa excepción e indicarlo por pantalla. En este último caso también se debe contar el carácter fallido como un intento.
 */