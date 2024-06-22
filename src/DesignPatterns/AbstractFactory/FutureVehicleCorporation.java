package DesignPatterns.AbstractFactory;

public class FutureVehicleCorporation extends Corporation {
    @Override
    public IMotorVehicle createMotorVehicle() {
        return new FutureVehicleMotorCycle();
    }
    @Override
    public ElectricVehicle createElectricVehicle() {
        return new FutureVehicleElectricCar();
    }
}
