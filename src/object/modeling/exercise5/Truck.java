/**
 * Esta clase representa un camión que hereda de la clase abstracta Vehicle.
 * Tiene un atributo adicional, el cual la diferencia de los otros vehículos y
 * que representa la capacidad de carga del camión.
 */
package object.modeling.exercise5;

import java.util.Scanner;

public class Truck extends Vehicle {
    private float transportCapacity;

    /**
     * Este método solicita al usuario que ingrese el atributo específico de los camiones
     * y lo asigna al atributo correspondiente.
     * @param scanner El objeto Scanner que se utiliza para leer la entrada del usuario.
     */
    @Override
    public void specificDataRequest(Scanner scanner) {
        System.out.print("Ingrese la Capacidad de Carga del camión en Kg: ");
        this.transportCapacity = scanner.nextFloat();
        scanner.nextLine();
    }

    /**
     * Este método muestra el atributo específico de los camiones por consola
     */
    @Override
    public void specificDataDisplay(){
        System.out.println("Capacidad de Carga: " + this.transportCapacity + " Kg.");
    }


}
