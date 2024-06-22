package DesignPatterns.Mediatotor;

public class Mediator {
    private Button button;
    private PowerSupplier powerSupplier;
    private Fan fan;

    public Mediator(Button button, PowerSupplier powerSupplier, Fan fan) {
        this.button = button;
        this.powerSupplier = powerSupplier;
        this.fan = fan;
    }


    public void turnOn() {
        powerSupplier.turnOn();
    }

    public void turnOff() {
        powerSupplier.turnOff();
    }

    public void press() {
        if(fan.isOn()){
            fan.turnOff();
        } else {
            fan.turnOn();
        }
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public PowerSupplier getPowerSupplier() {
        return powerSupplier;
    }

    public void setPowerSupplier(PowerSupplier powerSupplier) {
        this.powerSupplier = powerSupplier;
    }

    public Fan getFan() {
        return fan;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }
}
