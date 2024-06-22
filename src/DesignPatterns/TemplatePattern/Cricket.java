package DesignPatterns.TemplatePattern;

public class Cricket extends Game {

    @Override
    void initialize() {
        System.out.println("Cricket initialized");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Ended");
    }
}
