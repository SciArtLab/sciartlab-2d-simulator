package com.xmunch.game

import processing.core.PApplet

class Game extends PApplet{

    GlobalSpace global

    static void main(String[] args){
        args = new String[1]
        args[0]="com.xmunch.game.Game"
        PApplet.main(args)
    }

    @Override
    void settings() {
        if(!Constants.FULL_SCREEN_DEFAULT){
            size(Constants.WIDTH, Constants.HEIGHT, P3D)
            frame.setResizable(true)
        } else
            fullScreen()
    }

    @Override
    void setup() {
        frameRate(Constants.FRAME_RATE)
        global = GlobalSpace.getInstance(this, Constants.FULL_SCREEN_DEFAULT)
        global.setup()
    }

    @Override
    void draw() {
        global.draw()
    }

    @Override
    void keyPressed() {
        if(keyCode == UP)
            global.getPlayer().moveUp()
        else if(keyCode == DOWN)
            global.getPlayer().moveDown()
        else if(keyCode == LEFT)
            global.getPlayer().moveLeft()
        else if(keyCode == RIGHT)
            global.getPlayer().moveRight()
    }
}