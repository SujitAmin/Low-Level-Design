package DesignPatterns.StatePattern;

public class TVOffState implements State {

    @Override
    public void doAction() {
        System.out.println("TV is turned OFF");
    }
}
