/**
 * Esta clase Java representa un array aleatorio y proporciona métodos para ordenarlo usando
 * el algoritmo de ordenamiento de burbuja o el algoritmo de ordenamiento rápido.
 */
package object.modeling.exercise3;
import java.util.Scanner;

public class RandomArray {
    private int length; // longitud del array
    private double[] array; // array de números aleatorios

    /**
     * Crea un objeto RandomArray sin inicializar su longitud ni su arreglo de números aleatorios.
     */
    public RandomArray() {
    }

    /**
     * Obtiene el array de números aleatorios actual.
     *
     * @return el array de números aleatorios
     */
    public double[] getArray() {
        return this.array;
    }

    /**
     * Solicita al usuario que ingrese la longitud del array y almacena el valor en la variable de instancia "length".
     *
     * @param scanner el objeto Scanner utilizado para leer la entrada del usuario
     */
    public void requestLength(Scanner scanner) {
        System.out.print("Ingrese la longitud del array: ");
        this.length = scanner.nextInt();
    }

    /**
     * Crea un nuevo arreglo de números aleatorios entre 0 y 100 con la longitud especificada por el usuario.
     * Los números aleatorios se generan utilizando el método Math.random() y se almacenan en el arreglo.
     */
    public void buildRandomArray() {
        this.array = new double[this.length];

        for (int i = 0; i < this.length; i++) {
            this.array[i] = Math.random() * 100; // números aleatorios entre 0 y 100
        }
    }

    /**
     * Ordena el array actual usando el algoritmo de ordenamiento de burbuja.
     */
    public void bubbleSort() {
        double aux;
        for (int i = 0; i < this.length - 1; i++) {
            for (int j = 0; j < this.length - 1; j++) {
                if (this.array[j] > this.array[j+1]) {
                    aux = this.array[j];
                    this.array[j] = this.array[j+1];
                    this.array[j+1] = aux;
                }
            }
        }
    }

    /**
     *  Inicia el proceso de ordenamiento del array utilizando el algoritmo QuickSort.
     *  Llama al método sort(), y le pasa como argumentos el arreglo y los índices del primer y último elemento
     *  del arreglo
     */
    public void quickSort() {
        sort(this.array, 0, this.length-1);
    }

    /**
     *  Ordena un array de doubles utilizando el algoritmo de ordenamiento QuickSort.
     *
     * @param arr el arreglo que se debe ordenar.
     * @param left el índice del primer elemento del array que se va a ordenar.
     * @param right el índice del último elemento del array que se va a ordenar.
     */
    public void sort(double[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right); // El índice del pivote
            sort(arr, left, pivotIndex - 1); // Ordena la subsección izquierda del pivote
            sort(arr, pivotIndex + 1, right); // Ordena la subsección derecha del pivote
        }
    }

    /**
     * Método de ayuda utilizado por el método sort() para realizar la partición del arreglo.
     * Coloca los elementos menores que el pivote a la izquierda y los mayores a la derecha.
     *
     * @param arr el arreglo que se debe ordenar.
     * @param left el índice del primer elemento de la subsección.
     * @param right el índice del último elemento de la subsección.
     * @return el índice del pivote después de haber sido colocado en su posición correcta.
     */
    public int partition(double[] arr, int left, int right) {
        double pivotValue = arr[right]; // El valor del pivote
        int i = left - 1; // El índice del último elemento menor que el pivote
        for (int j = left; j < right; j++) {
            if (arr[j] < pivotValue) {
                i++;
                swap(arr, i, j); // Intercambia los elementos en los índices i y j
            }
        }
        swap(arr, i + 1, right); // Intercambia el pivote con el primer elemento mayor que él
        return i + 1; // Devuelve el índice final del pivote
    }

    /**
     * * Método de ayuda utilizado por el método partition() para intercambiar dos elementos en el array.
     *
     * @param arr el arreglo que contiene los elementos a intercambiar.
     * @param i el índice del primer elemento.
     * @param j el índice del segundo elemento.
     */
    public void swap(double[] arr, int i, int j) {
        double temp = arr[i]; // Guarda el valor del primer elemento en una variable temporal
        arr[i] = arr[j]; // Asigna el valor del segundo elemento al primer elemento
        arr[j] = temp; // Asigna el valor temporal al segundo elemento
    }
}

