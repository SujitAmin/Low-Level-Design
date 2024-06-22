package DesignPatterns.FactoryPattern;

public class Motorcycle implements MotorVehicle{

    @Override
    public void build() {
        System.out.println("Motorcycle is built.");
    }
}
