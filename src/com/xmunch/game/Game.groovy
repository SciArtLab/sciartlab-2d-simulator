package com.xmunch.game

import processing.core.PApplet

class Game extends PApplet{

    GlobalSpace global
    boolean paused = false

    static void main(String[] args){
        args = new String[1]
        args[0]="com.xmunch.game.Game"
        PApplet.main(args)

        //          TODO: Uncomment
        //        args[0]="com.xmunch.game.Board"
        //        PApplet.main(args)
    }

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
        global = GlobalSpace.getInstance(this, Constants.FULL_SCREEN_DEFAULT)
        global.setup()
        smooth()
    }

    @Override
    void draw() {
        if(!paused){
            global.drawWorld()
            global.drawNeighborsInfo()
        }
    }

    @Override
    void keyPressed() {

        if(keyCode == Constants.KEY_SPACE){
            paused = !paused
        }else if(keyCode == UP)
            global.getPlayer().moveUp()
        else if(keyCode == DOWN)
            global.getPlayer().moveDown()
        else if(keyCode == LEFT)
            global.getPlayer().moveLeft()
        else if(keyCode == RIGHT)
            global.getPlayer().moveRight()
    }
}