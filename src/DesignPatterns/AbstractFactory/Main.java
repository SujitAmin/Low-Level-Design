package DesignPatterns.AbstractFactory;

public class Main {
    public static void main(String[] args) {
        // Create FutureVehicle factory
        Corporation futureVehicleFactory = new FutureVehicleCorporation();
        IMotorVehicle futureMotorcycle = futureVehicleFactory.createMotorVehicle();
        ElectricVehicle futureElectricCar = futureVehicleFactory.createElectricVehicle();

        // Build FutureVehicle products
        futureMotorcycle.build();
        futureElectricCar.build();

        // Create NextGen factory
        Corporation nextGenFactory = new NextGenCorporation();
        IMotorVehicle nextGenMotorcycle = nextGenFactory.createMotorVehicle();
        ElectricVehicle nextGenElectricCar = nextGenFactory.createElectricVehicle();

        // Build NextGen products
        nextGenMotorcycle.build();
        nextGenElectricCar.build();
    }
}

