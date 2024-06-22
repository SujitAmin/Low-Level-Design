package DesignPatterns.FactoryPattern;

public class MotorCycleFactory extends BaseMotorVehicleFactory{
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Motorcycle();
    }
}
