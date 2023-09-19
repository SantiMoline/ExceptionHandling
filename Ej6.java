public class Ej6 {
    public static void main(String[] args) {
        //a) sentencia_a1, sentencia_a2, sentencia_a6. Does not execute sentence_a5 because it's not inside a finally block.
        //b) sentencia_a1, sentencia_a2, sentencia_a3, sentencia_a4, sentencia_a5; 
    }
}

/**
 * Dado el método metodoA de la clase A, indique:
a) ¿Qué sentencias y en qué orden se ejecutan si se produce la excepción MioException?
b) ¿Qué sentencias y en qué orden se ejecutan si no se produce la excepción MioException?
    class A {

        public void metodoA() {
            sentencia_a1
            sentencia_a2
            try {
                sentencia_a3
                sentencia_a4
            } catch (MioException e){
                sentencia_a6
            }
        sentencia_a5
        }
    }
 */