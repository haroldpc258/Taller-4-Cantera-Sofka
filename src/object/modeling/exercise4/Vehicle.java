/**
 * Esta clase representa un vehículo genérico con sus atributos y métodos comunes.
 * Un vehículo tiene un identificador, una marca, una fecha de matrícula, un número de pasajeros,
 * una presencia de tripulación, un número de ruedas, un medio de transporte, una velocidad máxima y un peso.
 */
package object.modeling.exercise4;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Vehicle {
    protected String id; // El identificador único del vehículo
    protected String brand; // La marca del vehículo
    protected LocalDate registrationDate; // La fecha de matrícula del vehículo
    protected int passengersNumber; // El número de pasajeros que puede transportar el vehículo
    protected int wheelsNumber; // El número de ruedas que tiene el vehículo
    protected String transportMeans; // El medio por el que se desplaza el vehículo (aire, tierra, agua, etc.)
    protected float maximumSpeed; // La velocidad máxima que puede alcanzar el vehículo en km/h
    protected float weight; // El peso del vehículo en kg

    /**
     * Este método solicita al usuario los datos del vehículo y los asigna a los atributos correspondientes.
     *
     * @param scanner El objeto Scanner que se utiliza para leer la entrada del usuario.
     * @return validation La validación de la solicitud de ingreso de los atributos del vehículo
     *         true si todos los atributos se ingresaron y no arrojaron ninguna excepción de
     *         false si se capturó excepción al momento de ingresar al algún atributo
     *
     */
    public boolean dataRequest(Scanner scanner) {
        boolean validation = false;
        try {
            System.out.print("Ingrese la placa o identificador del vehículo: ");
            this.id = scanner.nextLine();

            System.out.print("Ingrese la marca del vehículo: ");
            this.brand = scanner.nextLine();

            System.out.print("Ingrese la fecha de Matrícula del vehículo en formato (AAAA-MM-DD): ");
            this.registrationDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Ingrese el número de pasajeros del vehículo: ");
            this.passengersNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ingrese la cantidad de ruedas con la que cuenta el vehículo: ");
            this.wheelsNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ingrese la máxima velocidad alcanzada por el vehículo en Km/h: ");
            this.maximumSpeed = scanner.nextFloat();
            scanner.nextLine();

            System.out.print("Ingrese el peso del vehículo en Kg: ");
            this.weight = scanner.nextFloat();
            scanner.nextLine();

            System.out.print("Ingrese el medio por el que se desplaza el vehículo: ");
            this.transportMeans = scanner.nextLine();

            validation = true;
        } catch (DateTimeParseException ex) {
            //Si se ingresa una fecha de matrícula no válida, se imprime un mensaje de error.
            System.err.println("La fecha ingresada no es válida.\nIngrese la información nuevamente...");
        } catch (InputMismatchException ex) {
            //Cuando el tipo de valor ingresado no es válido.
            System.err.println("El valor ingresado no corresponde.\nIngrese la información nuevamente...");
        }
        finally { return validation; }
    }


    /**
     * Este método muestra por pantalla los datos del vehículo almacenados en sus atributos.
     */
    public void dataDisplay() {
        System.out.println("Placa o identificador: " + this.id);
        System.out.println("Marca: " + this.brand);
        System.out.println("Fecha de matrícula: " + this.registrationDate);
        System.out.println("Número de pasajeros: " + this.passengersNumber);
        System.out.println("Cantidad de ruedas: " + this.wheelsNumber);
        System.out.println("Velocidad máxima: " + this.maximumSpeed + " Km/h");
        System.out.println("Peso: " + this.weight + " Kg");
        System.out.println("Medio por el que se desplaza: " + this.transportMeans);
    }
    /**
     * Este método enciende el vehículo y muestra un mensaje por pantalla.
     */
    public void turnOn() {
        System.out.println("El vehículo se ha encendido...");
    }

    /**
     * Este método apaga el vehículo y muestra un mensaje por pantalla.
     */
    public void turnOff() {
        System.out.println("El vehículo se ha apagado...");
    }

    /**
     * Este método arranca el vehículo y muestra un mensaje por pantalla.
     */
    public void start() {
        System.out.println("El vehículo se ha arrancado...");
    }


    /**
     * Este método es el punto de entrada de la aplicación. Crea una lista de 10 objetos de tipo Vehicle y los muestra por consola.
     * @param args Los argumentos de la línea de comandos. No se utilizan en este caso.
     */
    public static void main(String[] args) {
        List<Vehicle> vehicleInventory = new ArrayList<>(); // Lista que almacena los objetos Vehicle creados
        Scanner scanner = new Scanner(System.in); // Objeto Scanner que se utiliza para leer los datos del usuario

        System.out.println("BIENVENIDO!");
        System.out.println("A continuación deberá ingresar los datos correspondientes a 10 vehículos.");

        for (int i = 0; i <3; i++) { // Bucle que se repite 10 veces para crear 10 objetos Vehicle
            boolean validation;
            System.out.println("\nVehículo " + (i + 1));
            Vehicle vehicle = new Vehicle(); // Se crea un nuevo objeto Vehicle
            validation = vehicle.dataRequest(scanner); // Se llama al método dataRequest para solicitar los datos del vehículo al usuario

            if (validation) {
                vehicleInventory.add(vehicle); // Se añade el objeto Vehicle a la lista vehicleInventory
            }
            else {
                i--;
            }
        }

        System.out.println("\nLISTADO DE VEHÍCULOS CREADOS...");
        for (int i = 0; i <3; i++) { // Bucle que se repite 10 veces para mostrar los datos de los 10 objetos Vehicle creados
            System.out.println("\nVehículo " + (i + 1));
            vehicleInventory.get(i).dataDisplay(); // Se llama al método dataDisplay para mostrar los datos del vehículo por consola
        }
    }
}
