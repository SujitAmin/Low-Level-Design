package DesignPatterns.ObserverPattern;

public class Main {
    public static void main(String[] args) {
        PCLNewsAgency observable = new PCLNewsAgency();
        PCLNewsChannel observer = new PCLNewsChannel();

        observable.addPropertyChangeListener(observer);
        observable.setNews("my news");
        observable.removePropertyChangeListener(observer);
    }
}
