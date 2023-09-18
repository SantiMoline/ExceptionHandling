import Ej1.services.PersonaService;

public class Ej1 {
    public static void main(String[] args) {
        PersonaService ps = new PersonaService();
        //By default, PersonaService has a field Persona that initializes empty;
        ps.setPersona(null);

        try {
            System.out.println(ps.esMayorDeEdad());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("Persona cannot be null.");
        }
    }
}

 /*Inicializar un objeto de la clase Persona ejercicio 7 de la guía 8 - "POO", a null y tratar de invocar el método
 esMayorDeEdad() a través de ese objeto. Luego, englobe el código con una cláusula try-catch para probar la nueva excepción
 que debe ser controlada. */