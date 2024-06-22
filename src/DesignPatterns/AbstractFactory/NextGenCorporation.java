package DesignPatterns.AbstractFactory;

public class NextGenCorporation extends Corporation {
    @Override
    public IMotorVehicle createMotorVehicle() {
        return new NextGenMotorcycle();
    }
    @Override
    public ElectricVehicle createElectricVehicle() {
        return new NextGenElectricCar();
    }
}
