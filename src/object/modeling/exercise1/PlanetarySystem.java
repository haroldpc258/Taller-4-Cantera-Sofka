/**
 * La clase PlanetarySystem representa un sistema planetario.
 * Almacena los cuerpos celestes en un mapa identificándolos por su identificador único.
 * Proporciona métodos para agregar un cuerpo celeste y calcular la atracción gravitatoria entre dos cuerpos celestes del sistema.
 */
package object.modeling.exercise1;
import java.util.HashMap;

public class PlanetarySystem {
    /**
     * Mapa para almacenar los cuerpos celestes por su identificador único.
     */
    public static HashMap<Integer, CelestialObject> planetarySystemObjects;

    /**
     * Nombre del sistema planetario.
     */
    private final String name;

    /**
     * Tipo del sistema planetario.
     */
    private final String type;

    /**
     * Crea un objeto PlanetarySystem con el nombre y tipo especificados.
     * Inicializa el mapa planetarySystemObjects.
     *
     * @param name el nombre del sistema planetario
     * @param type el tipo del sistema planetario
     */
    public PlanetarySystem(String name, String type) {
        planetarySystemObjects = new HashMap<>();
        this.name = name;
        this.type = type;
    }

    /**
     * Obtiene el mapa con los cuerpos celestes creados.
     * @return El mapa con los cuerpos celestes creados
     */
    public static HashMap<Integer, CelestialObject> getPlanetarySystemObjects() {
        return planetarySystemObjects;
    }

    /**
     * Agrega un cuerpo celeste al sistema planetario.
     *
     * @param id el identificador único del cuerpo celeste
     * @param name el nombre del cuerpo celeste
     * @param mass la masa del cuerpo celeste en kg
     * @param density la densidad del cuerpo celeste en kg/m^3
     * @param diameter el diámetro del cuerpo celeste en m
     * @param distanceToSun la distancia del cuerpo celeste al Sol en m
     */
    public void addCelestialObject(int id, String name, double mass, double density, double diameter, double distanceToSun) {
        CelestialObject celestialObject = new CelestialObject(id, name, mass, density, diameter, distanceToSun);
        planetarySystemObjects.put(id, celestialObject);
    }

    /**
     * Calcula la atracción gravitatoria entre dos cuerpos celestes del sistema.
     *
     * @param idObject1 el identificador único del primer cuerpo celeste
     * @param idObject2 el identificador único del segundo cuerpo celeste
     * @return la atracción gravitatoria entre los dos cuerpos celestes en N·m^2/kg
     */
    public double gravitationalAttraction(int idObject1, int idObject2) {
        CelestialObject celestialObject1 = planetarySystemObjects.get(idObject1);
        CelestialObject celestialObject2 = planetarySystemObjects.get(idObject2);

        // Distancia entre los dos cuerpos celestes
        double distance = Math.abs(celestialObject1.getDistanceToSun() - celestialObject2.getDistanceToSun());

        // Se suman los radios de los dos cuerpos celestes a la distancia entre ellos
        distance = distance + (celestialObject1.getDiameter() / 2) + (celestialObject2.getDiameter() / 2);

        // Atracción gravitacional entre los dos planeas según su fórmula
        double attraction = (6.67430e-11) * (celestialObject1.getMass() * celestialObject1.getMass()) / (distance * distance); // Fórmula de la atracción gravitatoria

        return attraction;
    }

    /**
     * Método para calcular la atracción gravitatoria entre dos cuerpos celestes del sistema,
     * dada una distancia específica entre ellos.
     *
     * @param idObject1 Identificador del primer cuerpo celeste
     * @param idObject2 Identificador del segundo cuerpo celeste
     * @param objectDistance Distancia entre los dos cuerpos celestes en metros
     * @return Atracción gravitatoria entre los dos cuerpos celestes en N·m^2/kg
     */
    public double gravitationalAttraction(int idObject1, int idObject2, double objectDistance) {
        CelestialObject celestialObject1 = planetarySystemObjects.get(idObject1);
        CelestialObject celestialObject2 = planetarySystemObjects.get(idObject2);

        // Se suman los radios de los dos cuerpos celestes a la distancia entre ellos
        objectDistance = objectDistance + (celestialObject1.getDiameter() / 2) + (celestialObject2.getDiameter() / 2);

        // Atracción gravitacional entre los dos planeas según su fórmula
        double attraction = (6.67430e-11) * (celestialObject1.getMass() * celestialObject1.getMass()) / (objectDistance * objectDistance); // Fórmula de la atracción gravitatoria

        return attraction;
    }

    /**
     * La clase interna CelestialObject representa un objeto celeste en el sistema planetario.
     * Cada objeto celeste tiene un identificador único, un nombre, una masa, una densidad,
     * un diámetro y una distancia con respecto al sol.
     */
    public static class CelestialObject {
        private final int id; // El identificador único del objeto celeste
        private final String name; // El nombre del objeto celeste
        private double mass; // La masa del objeto celeste
        private double density; // La densidad del objeto celeste
        private double diameter; // El diámetro del objeto celeste
        private double distanceToSun; // La distancia del objeto celeste al sol

        /**
         * Crea un objeto CelestialObject con un identificador único, un nombre, una masa, una densidad,
         * un diámetro y una distancia con respecto al sol especificados.
         * @param id El identificador único del objeto celeste
         * @param name El nombre del objeto celeste
         * @param mass La masa del objeto celeste
         * @param density La densidad del objeto celeste
         * @param diameter El diámetro del objeto celeste
         * @param distanceToSun La distancia del objeto celeste al sol
         */
        public CelestialObject(int id, String name, double mass, double density, double diameter, double distanceToSun) {
            this.id = id;
            this.name = name;
            this.mass = mass;
            this.density = density;
            this.diameter = diameter;
            this.distanceToSun = distanceToSun;
        }

        /**
         * Obtiene el nombre del objeto celeste.
         * @return El nombre del objeto celeste
         */
        public String getName() {
            return this.name;
        }

        /**
         * Obtiene la masa del objeto celeste.
         * @return La masa del objeto celeste
         */
        public double getMass() {
            return this.mass;
        }

        /**
         * Obtiene la densidad del objeto celeste.
         * @return La densidad del objeto celeste
         */
        public double getDensity() {
            return this.density;
        }

        /**
         * Obtiene el diámetro del objeto celeste.
         * @return El diámetro del objeto celeste
         */
        public double getDiameter() {
            return this.diameter;
        }

        /**
         * Obtiene la distancia al sol del objeto celeste.
         * @return La distancia al sol del objeto celeste
         */
        public double getDistanceToSun() {
            return this.distanceToSun;
        }
    }

}








