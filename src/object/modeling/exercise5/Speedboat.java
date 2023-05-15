/**
 * Esta clase representa una lancha que hereda de la clase abstracta Vehicle.
 * Tiene un atributo adicional, el cual la diferencia de los otros vehículos y
 * que representa el largo de la lancha.
 */
package object.modeling.exercise5;

import java.util.Scanner;

public class Speedboat extends Vehicle {
    float length;

    /**
     * Este método solicita al usuario que ingrese el atributo específico de las lanchas
     * y lo asigna al atributo correspondiente.
     * @param scanner El objeto Scanner que se utiliza para leer la entrada del usuario.
     */
    @Override
    public void specificDataRequest(Scanner scanner) {
        System.out.print("Ingrese la Longitud de la Lancha en metros: ");
        this.length = scanner.nextFloat();
        scanner.nextLine();
    }

    /**
     * Este método muestra el atributo específico de las lanchas por consola
     */
    @Override
    public void specificDataDisplay(){
        System.out.println("Longitud de la Lancha: " + this.length + " metros.");
    }
}
