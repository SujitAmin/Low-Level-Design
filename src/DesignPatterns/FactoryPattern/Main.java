package DesignPatterns.FactoryPattern;

public class Main {
    public static void main(String[] args) {
        BaseMotorVehicleFactory motorVehicleFactory = new MotorCycleFactory();
        BaseMotorVehicleFactory carFactory = new CarFactory();

        MotorVehicle motorVehicle = motorVehicleFactory.create();
        MotorVehicle car = carFactory.create();
    }
}
