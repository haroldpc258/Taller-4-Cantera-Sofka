
/**
 * Esta clase representa la clase principal del programa.
 * Se encarga de solicitar al usuario la creación de varios objetos Vehicle y luego mostrar la información de cada uno.
 */
package object.modeling.exercise5;
import java.util.*;

public class Main {
    /**
     * El método main es el punto de entrada del programa.
     * Se encarga de solicitar al usuario la cantidad de objetos Vehicle que desea crear y luego llamar a los métodos create y display para crear los objetos y mostrar su información, respectivamente.
     * @param args Argumentos de línea de comandos (no se utilizan en este programa)
     */
    public static void main(String[] args) {
        List<Vehicle> vehicleInventory = new ArrayList<>(); // Lista que almacena los objetos Vehicle creados
        Scanner scanner = new Scanner(System.in); // Objeto Scanner que se utiliza para leer los datos del usuario

        try {
            System.out.println("BIENVENIDO!");
            System.out.print("\nIndique la cantidad de Vehículos que desea crear: ");
            int vehiclesNumber = scanner.nextInt(); // Se lee la cantidad de objetos Vehicle que el usuario desea crear

            System.out.println("\nA continuación deberá ingresar los datos correspondientes a " + vehiclesNumber + " vehículos.");

            create(scanner, vehiclesNumber, vehicleInventory); // Se llama al método create para crear los objetos Vehicle

            display(vehiclesNumber, vehicleInventory); // Se llama al método display para mostrar la información de los objetos Vehicle creados

        } catch (InputMismatchException ex) {
            System.err.println("El valor ingresado no es válido. Hasta luego...");
        }
    }

    /**
     * Este método se encarga de mostrar la información de cada objeto Vehicle creado.
     * @param vehiclesNumber La cantidad de objetos Vehicle creados
     * @param vehicleInventory La lista que almacena los objetos Vehicle creados
     */
    private static void display(int vehiclesNumber, List<Vehicle> vehicleInventory) {
        System.out.println("\nLISTADO DE VEHÍCULOS CREADOS...");
        for (int i = 0; i < vehiclesNumber; i++) { // Bucle que se repite 10 veces para mostrar los datos de los 10 objetos Vehicle creados
            System.out.println("\nVehículo " + (i + 1));
            vehicleInventory.get(i).dataDisplay(); // Se llama al método dataDisplay para mostrar los datos del vehículo por consola
        }
    }

    /**
     * Este método se encarga de crear los objetos Vehicle solicitando al usuario la información necesaria.
     * @param scanner El objeto Scanner utilizado para leer los datos del usuario
     * @param vehiclesNumber La cantidad de objetos Vehicle que el usuario desea crear
     * @param vehicleInventory La lista que almacena los objetos Vehicle creados
     */
    private static void create(Scanner scanner, int vehiclesNumber, List<Vehicle> vehicleInventory) {
        for (int i = 0; i < vehiclesNumber; i++) { // Bucle que se repite para crear el número de objetos Vehicle deseado
            boolean validation;

            System.out.println("\nVehículo " + (i + 1)); // Se muestra el número de vehículo que se esta creando
            System.out.println("\nQué tipo de vehículo desea ingresar?");
            System.out.println("1. Bicicleta");
            System.out.println("2. Coche");
            System.out.println("3. Motocicleta");
            System.out.println("4. Lancha");
            System.out.println("5. Camión");
            System.out.print("Opción: ");

            int option = scanner.nextInt(); // Leer la opción
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    Vehicle vehicle = new Bicycle(); // Se crea un nuevo objeto Vehicle
                    validation = vehicle.dataRequest(scanner); // Se llama al método dataRequest para solicitar los datos del vehículo al usuario
                    i = validation(vehicleInventory, i, validation, vehicle);
                }
                case 2 -> {
                    Vehicle vehicle = new Car(); // Se crea un nuevo objeto Vehicle
                    validation = vehicle.dataRequest(scanner); // Se llama al método dataRequest para solicitar los datos del vehículo al usuario
                    i = validation(vehicleInventory, i, validation, vehicle);
                }
                case 3 -> {
                    Vehicle vehicle = new Motorcycle(); // Se crea un nuevo objeto Vehicle
                    validation = vehicle.dataRequest(scanner); // Se llama al método dataRequest para solicitar los datos del vehículo al usuario
                    i = validation(vehicleInventory, i, validation, vehicle);
                }
                case 4 -> {
                    Vehicle vehicle = new Speedboat(); // Se crea un nuevo objeto Vehicle
                    validation = vehicle.dataRequest(scanner); // Se llama al método dataRequest para solicitar los datos del vehículo al usuario
                    i = validation(vehicleInventory, i, validation, vehicle);
                }
                case 5 -> {
                    Vehicle vehicle = new Truck(); // Se crea un nuevo objeto Vehicle
                    validation = vehicle.dataRequest(scanner); // Se llama al método dataRequest para solicitar los datos del vehículo al usuario
                    i = validation(vehicleInventory, i, validation, vehicle);
                }
                default -> {
                    System.err.println("La opción no es válida.");
                    i--;
                }
            }
        }

    }

    /**
     * Método que se encarga de realizar la validación, en caso de que la variable "validation" sea verdadera se añade
     * el vehículo creado a la lista de vehículos, en caso de que esta sea falsa, se repite la iteración para volver a solicitar
     * por consola la información para el vehículo que se desea crear
     * @param vehicleInventory La lista que almacena los objetos Vehicle creados
     * @param i El contador de la iteración con la que se están creando los vehículos
     * @param validation La validación de la solicitud de ingreso de los atributos del vehículo
     * @param vehicle El objeto que se acabó de crear durante la iteración
     * @return El índice de iteración
     */
    private static int validation(List<Vehicle> vehicleInventory, int i, boolean validation, Vehicle vehicle){
        if (validation) {
            vehicleInventory.add(vehicle); // Se añade el objeto Vehicle a la lista vehicleInventory
            return i;
        }
        else {
            int j = i;
            j--;
            return j;
        }
    }
}

