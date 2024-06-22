package DesignPatterns.StrategyPattern;

public class Main {
    public static void main(String[] args) {
        Discounter christmasDiscounter = new ChristmasDiscounter();
        System.out.println(christmasDiscounter.discount(100f));

        Discounter easterDiscounter = new EasterDiscounter();
        System.out.println(easterDiscounter.discount(100f));

    }
}
