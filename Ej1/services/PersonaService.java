package Ej1.services;


import java.util.Scanner;
import Ej1.Entities.Persona;


public class PersonaService {
    
    Scanner scan = new Scanner(System.in);
    private Persona persona = new Persona();

    public void crearPersona() {
        System.out.print("\nIndique el nombre de la persona: ");
        String nombre = scan.nextLine();
        System.out.print("\nIngrese el sexo de la persona (H, M, O): ");
        String sexo = scan.nextLine();
        
        while (!validarSexo(sexo)) {
            System.out.print("\nSexo incorrecto. Ingrese 'H', 'M' u 'O'");
            sexo = scan.nextLine();
        }
        System.out.print("\nIngrese la edad de la persona: ");
        int edad = scan.nextInt();
        System.out.print("\nIngrese la altura de la persona: ");
        double altura = scan.nextDouble();
        System.out.print("\nIngrese el peso de la persona: ");
        double peso = scan.nextDouble();
        scan.nextLine();
        persona = new Persona(nombre, sexo, edad, peso, altura);
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    } 

    private boolean validarSexo(String sexo) {
        return (sexo.equalsIgnoreCase("H") || sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("O"));
    }

    /**
     * Function name: calcularIMC
     * @return          (int)
     * Function returns -1 if the person is too skinny, 0 if its ok, and 1 if it has overweight.
     */
    public int calcularIMC() {
        double imc = persona.getPeso() / Math.pow(persona.getAltura(), 2);
        if (imc < 20) {
            return -1;
        } else if (imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad() throws NullPointerException {
        return persona.getEdad() >= 18;
    }
}