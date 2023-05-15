/**
 * Esta clase representa el programa principal que permite almacenar números enteros sin repetición en un vector.
 */
package object.modeling.exercise6;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    /**
     * Método principal que ejecuta el programa y muestra el resultado final.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {

        // Crea un vector para almacenar los números enteros.
        Vector<Integer> numbers = new Vector<>();

        // Imprime un mensaje para solicitar al usuario que ingrese números enteros.
        System.out.println("A continuación puedes introducir todos los números enteros que desees. Presiona enter después de cada uno de estos para almacenarlos. \nIntroduce el mismo número dos veces para terminar.");

        // Llama al método addNumbers para permitir al usuario agregar números enteros al vector.
        addNumbers(numbers);

        // Si se agregaron números al vector, imprime todos los números almacenados.
        if (numbers.size() > 0) {
            System.out.println("\nLos números almacenados fueron los siguientes: ");
            for (Integer number : numbers) {
                System.out.println(number);
            }
        }
    }

    /**
     * Este método añade números enteros a un vector, solicitándolos al usuario por consola.
     * El método termina cuando el usuario introduce dos números iguales seguidos.
     * Si el usuario introduce un valor que no es entero, se muestra un mensaje de error y se vuelve a pedir el número.
     * @param numbers el vector donde se almacenan los números introducidos por el usuario
     */
    public static void addNumbers(Vector<Integer> numbers) {
        Scanner scanner = new Scanner(System.in);

        int currentNumber = 0;
        int previousNumber = 0;

        // Continúa solicitando al usuario que ingrese números enteros hasta que el usuario ingrese el mismo número dos veces seguidas.
        do {
            try {
                // Si no hay números en el vector, solicita al usuario que ingrese el primer número.
                if (numbers.size() == 0) {
                    System.out.print("\nNúmero que desea almacenar: ");
                    currentNumber = scanner.nextInt();
                    numbers.add(currentNumber);

                    // Establece el número anterior como el número actual menos uno.
                    previousNumber = currentNumber - 1;
                }
                // Si ya hay números en el vector, compara el número actual con el número anterior.
                else {
                    // Establece el número anterior como el número actual.
                    previousNumber = currentNumber;

                    System.out.print("\nNúmero que desea almacenar: ");
                    currentNumber = scanner.nextInt();

                    // Si el número actual es diferente al número anterior, se agrega al vector.
                    if (previousNumber != currentNumber) {
                        numbers.add(currentNumber);
                    }
                }
            } catch (InputMismatchException ex) {
                // Si el usuario ingresa un valor que no es un número entero, muestra un mensaje de error y continua con el siguiente número.
                System.err.println("Se han ingresado valores que no son enteros...");
                scanner.next();
                previousNumber = currentNumber - 1;
            }

        } while (currentNumber != previousNumber); // Continúa solicitando al usuario que ingrese números enteros hasta que el usuario ingrese el mismo número dos veces seguidas.
    }
}

