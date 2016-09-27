package com.xmunch.game




class Board extends Game{

    @Override
    void settings() {
        if(!Constants.FULL_SCREEN_DEFAULT){
            size(Constants.WIDTH, Constants.HEIGHT)
        } else
            fullScreen()
    }

    @Override
    void setup() {
        frameRate(Constants.FRAME_RATE)
        global = GlobalSpace.getInstance()
    }

    @Override
    void draw() {
        background(0)
    }
}