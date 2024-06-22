package DesignPatterns.StrategyPattern;

public class ChristmasDiscounter implements Discounter {

    @Override
    public Float discount(Float amount) {
        return amount * 0.75f;
    }
}
