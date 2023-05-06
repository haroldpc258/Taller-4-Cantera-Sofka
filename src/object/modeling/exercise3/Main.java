/**
 * Este programa genera un array de números aleatorios y lo ordena según la opción del usuario.
 * Utiliza las clases RandomArray y Scanner para crear y manipular el array y leer la entrada del usuario.
 * El programa ofrece dos métodos de ordenación: burbuja y quick sort.
 * El programa imprime el array generado y el array ordenado por pantalla.
 */
package object.modeling.exercise3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner para leer la entrada del usuario

        RandomArray randomArray = new RandomArray(); // Crear un objeto RandomArray para generar y ordenar el array
        randomArray.requestLength(scanner); // Solicitar al usuario la longitud del array
        randomArray.buildRandomArray(); // Construir el array con números aleatorios


        System.out.println("El array generado aleatoriamente fue: ");
        System.out.println(Arrays.toString(randomArray.getArray())); // Imprimir el array generado

        System.out.println();
        System.out.println("Cómo desea ordenarlo?");
        System.out.println("1. Método Burbuja");
        System.out.println("2. Método Quick Sort");
        int option  = scanner.nextInt(); // Leer la opción del usuario

        switch (option) {
            case 1 -> {
                randomArray.bubbleSort(); // Ordenar el array usando el método burbuja
                System.out.println("Este es tu array ordenado: ");
                System.out.println(Arrays.toString(randomArray.getArray())); // Imprimir el array ordenado
            }
            case 2 -> {
                randomArray.quickSort(); // Ordenar el array usando el método quick sort
                System.out.println("Este es tu array ordenado: ");
                System.out.println(Arrays.toString(randomArray.getArray())); // Imprimir el array ordenado
            }
        }


    }
}