package DesignPatterns.Mediatotor;

public class Button {
    private Fan fan;
    private Mediator mediator;

    public Button(Mediator mediator) {
        this.mediator = mediator;
    }

    public Fan getFan() {
        return fan;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

    public void press(){
        mediator.press();
    }
}
