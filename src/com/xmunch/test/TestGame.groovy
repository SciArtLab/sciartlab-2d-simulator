package com.xmunch.test

import processing.core.PApplet

import com.xmunch.game.Constants
import com.xmunch.game.Game
import com.xmunch.game.model.ScreenObject
import com.xmunch.game.utils.GameUtils

class TestGame extends Game{

    static void main(String[] args){
        args = new String[1]
        args[0]="com.xmunch.test.TestGame" //Important to change
        PApplet.main(args)
    }

    @Override
    void setup() {
        frameRate(Constants.FRAME_RATE)
        global = TestGlobalSpace.getInstance(this)
        smooth()
    }

    @Override
    void draw(){
        super.draw() //Do not remove

        // Example: Adding specific object on click
        if(mousePressed){
            ScreenObject egg = new ScreenObject("egg","static")
            egg.x = mouseX
            egg.y = mouseY
            egg.width = (float)(egg.width/5)
            egg.height = (float)(egg.height/5)
            GameUtils.createObject(global.getScreens().get(global.currentScreen), egg)
        }

        //fill(153);rect(30, 20, 55, 55)
    }

    @Override
    void keyPressed() {

        if(keyCode == Constants.KEY_SPACE){
            global.setPaused(!global.getPaused())
        }else if(keyCode == Constants.KEY_G){
            global.setShowGrid(!global.getShowGrid())
        }else if(keyCode == Constants.KEY_B){
            global.setShowBackground(!global.getShowBackground())
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
        else
            println("Se ha pulsado una tecla no mapeada: " +keyCode)
    }
}