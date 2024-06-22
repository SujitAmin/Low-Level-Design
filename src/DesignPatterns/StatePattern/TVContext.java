package DesignPatterns.StatePattern;

import javax.naming.Context;

public class TVContext implements State {
    private State tvState;

    TVContext(State tvState) {
        this.tvState = tvState;
    }

    @Override
    public void doAction() {
        this.tvState.doAction();
    }
}
