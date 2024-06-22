package DesignPatterns.FactoryPattern;

public class CarFactory extends BaseMotorVehicleFactory{

    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Car();
    }
}
