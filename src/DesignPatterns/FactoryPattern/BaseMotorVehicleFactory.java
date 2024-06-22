package DesignPatterns.FactoryPattern;

public abstract class BaseMotorVehicleFactory {
    public MotorVehicle create() {
        MotorVehicle motorVehicle = createMotorVehicle();
        motorVehicle.build();
        return motorVehicle;
    }

    protected abstract MotorVehicle createMotorVehicle();
}
