package com.xmunch.game.model

import processing.core.PApplet

import com.xmunch.game.GlobalSpace



class PObject {
    long id
    String name
    String state = "UP"
    int animationFrame = 0
    PApplet game
    GlobalSpace global
    float x, y, width, height, speed

    public PObject(){
        game = GlobalSpace.getInstance().getGame()
        global = GlobalSpace.getInstance()
    }

    public float getCenterX(){
        return (float)(x+width/2)
    }

    public float getCenterY(){
        return (float)(y+height/2)
    }
}
