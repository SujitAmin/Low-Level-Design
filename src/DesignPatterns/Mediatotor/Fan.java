package DesignPatterns.Mediatotor;

public class Fan {
    private Mediator mediator;
    private boolean isOn = false;

    public Fan(Button button, Mediator mediator, boolean isOn) {
        this.mediator = mediator;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void turnOn() {
        mediator.turnOn();
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
        mediator.turnOff();
    }
}
