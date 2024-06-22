package DesignPatterns.AbstractFactory;


public class FutureVehicleMotorCycle implements IMotorVehicle {

    @Override
    public void build() {
        System.out.println("Future Vehicle Motorcycle");
    }
}
