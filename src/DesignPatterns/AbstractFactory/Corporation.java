package DesignPatterns.AbstractFactory;

public abstract class Corporation {
    public abstract IMotorVehicle createMotorVehicle();
    public abstract ElectricVehicle createElectricVehicle();
}
