package DesignPatterns.StatePattern;

public class TVRemote {


    public static void main(String[] args) {
        State tvStartDate = new TVONState();
        TVContext contexts;
        contexts = new TVContext(tvStartDate);
        contexts.doAction();

        State tvOffState = new TVOffState();
        contexts = new TVContext(tvOffState);
        contexts.doAction();
    }
}
