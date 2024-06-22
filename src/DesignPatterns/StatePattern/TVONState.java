package DesignPatterns.StatePattern;

public class TVONState implements State {

    @Override
    public void doAction() {
        System.out.println("TV is turned ON");
    }
}
