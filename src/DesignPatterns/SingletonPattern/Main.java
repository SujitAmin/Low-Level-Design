package DesignPatterns.SingletonPattern;

public class Main {
    public static void main(String[] args) {
        DBConnection.getInstance();
        DBConnection.getInstance();

    }
}
