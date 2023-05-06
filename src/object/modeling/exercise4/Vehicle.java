package object.modeling.exercise4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vehicle {
    private String id;
    String brand;
    private LocalDate registrationDate;
    int passengersNumber;
    boolean crewPresence;
    int wheelsNumber;
    String transportMeans;
    float maximumSpeed;
    float weight;

    public void dataRequest(Scanner scanner) {
        System.out.print("Ingrese la placa o identificador del vehículo: ");
        this.id = scanner.nextLine();

        System.out.print("Ingrese la marca del vehículo: ");
        this.brand = scanner.nextLine();

        System.out.print("Ingrese la fecha de Matrícula del vehículo en formato (AAAA-MM-DD): ");
        String date = scanner.nextLine();
        this.registrationDate = LocalDate.parse(date);

        System.out.print("Ingrese el número de pasajeros del vehículo: ");
        this.passengersNumber = scanner.nextInt();

        System.out.print("Ingrese la cantidad de ruedas con la que cuenta el vehículo: ");
        this.wheelsNumber = scanner.nextInt();

        System.out.print("Ingrese la máxima velocidad alcanzada por el vehículo en Km/h: ");
        this.maximumSpeed = scanner.nextFloat();

        System.out.print("Ingrese el peso del vehículo en Kg: ");
        this.weight = scanner.nextFloat();

        System.out.print("Indique la presencia de tripulación en el vehículo (True/False): ");
        this.crewPresence = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Ingrese el medio por el que se desplaza el vehículo: ");
        this.transportMeans = scanner.nextLine();
    }

    public void dataDisplay() {
        System.out.println("Placa o identificador: " + this.id);
        System.out.println("Marca: " + this.brand);
        System.out.println("Fecha de matrícula: " + this.registrationDate);
        System.out.println("Número de pasajeros: " + this.passengersNumber);
        System.out.println("Cantidad de ruedas: " + this.crewPresence);
        System.out.println("Velocidad máxima: " + this.maximumSpeed + " Km/h");
        System.out.println("Peso: " + this.weight + " Kg");
        System.out.println("Presencia de tripulación: " + this.crewPresence);
        System.out.println("Medio por el que se desplaza: " + this.transportMeans);
    }


    public static void main(String[] args) {
        List<Vehicle> vehicleInventory = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("BIENVENIDO!");
        System.out.println("A continuación deberá ingresar los datos correspondientes a 10 vehículos.");

        for (int i = 0; i <3; i++) {
            System.out.println("\nVehículo " + (i + 1));
            Vehicle vehicle = new Vehicle();
            vehicle.dataRequest(scanner);
            vehicleInventory.add(vehicle);
        }

        System.out.println("\nLISTADO DE VEHÍCULOS CREADOS...");
        for (int i = 0; i <3; i++) {
            System.out.println("\nVehículo " + (i + 1));
            vehicleInventory.get(i).dataDisplay();
        }
    }





}
