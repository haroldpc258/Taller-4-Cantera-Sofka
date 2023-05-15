package object.modeling.exercise1;

public class Main {
    /**
     * El método principal de la aplicación que crea un sistema planetario, añade objetos celestes y luego calcula la atracción gravitacional entre dos de ellos.
     * @param args los argumentos de línea de comandos, no se utilizan en este programa.
     */
    public static void main(String[] args) {

        // Crea un nuevo sistema planetario con nombre "Sistema Solar" y tipo "Estelar"
        PlanetarySystem planetarySystem = new PlanetarySystem("Sistema Solar", "Estelar");

        // Añade tres objetos celestes al sistema planetario: "Sol", "Tierra" y "Júpiter"
        planetarySystem.addCelestialObject(0, "Sol", 1.99e30, 1.41, 1392000, 0);
        planetarySystem.addCelestialObject(1, "Tierra", 5.97e24, 5.52, 12756, 149.6e6);
        planetarySystem.addCelestialObject(2, "Júpiter", 1.90e27, 1.33, 139822, 778.5e6);

        // Establece dos identificadores de objetos celestes a ser utilizados para el cálculo de la atracción gravitacional.
        int idObject1 = 0;
        int idObject2 = 1;

        try {
            // Obtiene los nombres de los dos objetos celestes que se van a utilizar para el cálculo.
            String nameCelestialObject1 = planetarySystem.getPlanetarySystemObjects().get(idObject1).getName();
            String nameCelestialObject2 = planetarySystem.getPlanetarySystemObjects().get(idObject2).getName();

            // Calcula la atracción gravitacional entre los dos objetos celestes utilizando el método gravitationalAttraction() de la clase PlanetarySystem.
            double gravitationalAttraction = planetarySystem.gravitationalAttraction(idObject1, idObject2);

            // Imprime el resultado del cálculo de la atracción gravitacional.
            System.out.println("La atracción Gravitacional entre: " + nameCelestialObject1 + " y " + nameCelestialObject2 + " es de " + gravitationalAttraction + " N·m^2/kg");

        } catch (NullPointerException ex) {
            // Si se introduce un identificador de objeto celeste que no está asociado a ningún objeto celeste en el sistema planetario, se imprime un mensaje de error.
            System.err.println("Se introdujo un ID que no está asociado a ningún Objeto Celeste...");
        }
    }
}
