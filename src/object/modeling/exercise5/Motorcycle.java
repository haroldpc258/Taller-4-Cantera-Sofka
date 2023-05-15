/**
 * Esta clase representa una motocicleta que hereda de la clase abstracta Vehicle.
 * Tiene un atributo adicional, el cual la diferencia de los otros vehículos y
 * que representa el cilindraje del motor de la moto.
 */
package object.modeling.exercise5;

import java.util.Scanner;

public class Motorcycle extends Vehicle{
    private int engineDisplacement;

    /**
     * Este método solicita al usuario que ingrese el atributo específico de las motots
     * y lo asigna al atributo correspondiente.
     * @param scanner El objeto Scanner que se utiliza para leer la entrada del usuario.
     */
    @Override
    public void specificDataRequest(Scanner scanner) {
        System.out.print("Ingrese el Cilindraje del motor en cm^3: ");
        this.engineDisplacement = scanner.nextInt();
    }

    /**
     * Este método muestra el atributo específico de las motos por consola
     */
    @Override
    public void specificDataDisplay(){
        System.out.println("Cilindraje del motor: " + this.engineDisplacement + " cm^3");
    }
}
