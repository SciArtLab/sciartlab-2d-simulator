package com.xmunch.processing.testing;

public class Cell {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setState(float state) {
        this.state = (int) state;
    }

}
