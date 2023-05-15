/**
 * Esta clase representa un coche que hereda de la clase abstracta Vehicle.
 * Tiene un atributo adicional, el cual la diferencia de los otros vehículos y
 * que representa el número de puertas con las que cuenta el coche.
 */
package object.modeling.exercise5;

import java.util.Scanner;

public class Car extends Vehicle {
    private int doorsNumber;

    /**
     * Este método solicita al usuario que ingrese el atributo específico de los coches
     * y lo asigna al atributo correspondiente.
     * @param scanner El objeto Scanner que se utiliza para leer la entrada del usuario.
     */
    @Override
    public void specificDataRequest(Scanner scanner) {
        System.out.print("Ingrese el Número de Puertas del coche: ");
        this.doorsNumber = scanner.nextInt();
        scanner.nextLine();
    }

    /**
     * Este método muestra el atributo específico de los coches por consola
     */
    @Override
    public void specificDataDisplay(){
        System.out.println("Número de Puertas: " + this.doorsNumber);
    }

}
