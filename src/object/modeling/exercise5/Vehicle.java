/**
 * La clase abstracta Vehicle es una extensión de la clase Vehicle del Ejercicio 4 y tiene como objetivo representar
 * a los vehículos en general, definiendo atributos y métodos comunes que todos los vehículos pueden compartir.
 */
package object.modeling.exercise5;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Vehicle extends object.modeling.exercise4.Vehicle{
    /**
     * Este método es utilizado para solicitar al usuario la información del vehículo y almacenarla en los atributos correspondientes.
     * @param scanner es un objeto de la clase Scanner que se utiliza para leer la entrada de datos proporcionada por el usuario.
     * @return un valor booleano que indica si la validación de los datos ingresados por el usuario fue exitosa o no.
     */
    @Override
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

            specificDataRequest(scanner);

            validation = true;
        } catch (DateTimeParseException ex) {
            //Si se ingresa una fecha de matrícula no válida, se imprime un mensaje de error.
            System.err.println("La fecha ingresada no es válida.\nIngrese la información nuevamente...");
        } catch (InputMismatchException ex) {
            //Cuando el tipo de valor ingresado no es válido.
            System.err.println("El valor ingresado no corresponde.\nIngrese la información nuevamente...");
            scanner.next();
        }
        finally { return validation; }
    }

    /**
     * Este método muestra por pantalla los datos del vehículo almacenados en sus atributos.
     */
    @Override
    public void dataDisplay() {
        super.dataDisplay();
        specificDataDisplay();
    }

    /**
     * Este método abstracto es utilizado para solicitar información específica del vehículo que debe ser implementada
     * en las clases hijas.
     * @param scanner es un objeto de la clase Scanner que se utiliza para leer la entrada de datos proporcionada por el usuario.
     */
    protected abstract void specificDataRequest(Scanner scanner);

    /**
     * Este método abstracto es utilizado para mostrar por pantalla la información específica del vehículo que debe ser
     * implementada en las clases hijas.
     */
    protected abstract void specificDataDisplay();
}