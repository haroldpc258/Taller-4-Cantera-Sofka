/**
 * Esta clase representa una bicicleta que hereda de la clase abstracta Vehicle.
 * Tiene un atributo adicional, el cual la diferencia de los otros vehículos y
 * que representa el número de velocidades de la bicicleta.
 */
package object.modeling.exercise5;

import java.util.Scanner;

public class Bicycle extends Vehicle {
    private int gearsNumber; // El número de velocidades de la bicicleta

    /**
     * Este método solicita al usuario que ingrese el atributo específico de las bicicletas
     * y lo asigna al atributo correspondiente.
     * @param scanner El objeto Scanner que se utiliza para leer la entrada del usuario.
     */
    @Override
    public void specificDataRequest(Scanner scanner) {
        System.out.print("Ingrese el número de velocidades de la Bicicleta: ");
        this.gearsNumber = scanner.nextInt();
        scanner.nextLine();
    }

    /**
     * Este método muestra el atributo específico de las bicicletas por consola
     */
    @Override
    public void specificDataDisplay(){
        System.out.println("Número de Velocidades: " + this.gearsNumber);
    }
}
