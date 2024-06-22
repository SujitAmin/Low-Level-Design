package DesignPatterns.FactoryPattern;

public class Car implements MotorVehicle{
    @Override
    public void build() {
        System.out.println("Car built");
    }
}
