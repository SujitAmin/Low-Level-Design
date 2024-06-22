package DesignPatterns.AbstractFactory;

import DesignPatterns.FactoryPattern.MotorVehicle;

public class NextGenMotorcycle implements IMotorVehicle {

    @Override
    public void build() {
        System.out.println("NextGen Motorcycle");
    }
}
