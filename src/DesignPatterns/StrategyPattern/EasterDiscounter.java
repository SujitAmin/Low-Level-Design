package DesignPatterns.StrategyPattern;

public class EasterDiscounter implements Discounter {

    @Override
    public Float discount(Float amount) {
        return amount * 0.8f;
    }
}
