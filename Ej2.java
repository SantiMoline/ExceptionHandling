import Ej2.ArrayClass;

public class Ej2 {
    public static void main(String[] args) {
        ArrayClass array = new ArrayClass();

        try {
            array.getIndexFromSeries(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Incorrect index, max index allowed is " + (array.getLength() - 1));
        }

    }
}
/*Definir una Clase que contenga algún tipo de dato de tipo array y agregue el código para generar y
capturar una excepción ArrayIndexOutOfBoundsException (índice de arreglo fuera de rango). */