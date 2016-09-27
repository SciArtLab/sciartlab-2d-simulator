package com.xmunch.game

import processing.core.PApplet

class Game extends PApplet{

    GlobalSpace global

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
        if(!global.getPaused()){
            global.drawWorld()

            if(global.getShowNeighborsInfo())
                global.drawNeighborsInfo()
        }
    }

    @Override
    void keyPressed() {

        println keyCode

        if(keyCode == Constants.KEY_SPACE){
            global.setPaused(!global.getPaused())
        }else if(keyCode == Constants.KEY_G){
            global.setShowGrid(!global.getShowGrid())
        }else if(keyCode == Constants.KEY_N){
            global.setShowNeighborsInfo(!global.getShowNeighborsInfo())
        }else if(keyCode == Constants.KEY_A){
            global.setShowAgents (!global.getShowAgents())
        }else if(keyCode == Constants.KEY_S){
            global.setShowSprites(!global.getShowSprites())
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