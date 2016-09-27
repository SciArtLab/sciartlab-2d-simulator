package com.xmunch.game.model

import processing.core.PApplet

import com.xmunch.game.GlobalSpace



class PObject {
    long id
    String name
    String state = "UP"
    PApplet game
    GlobalSpace global
    float x, y, width, height

    public PObject(){
        game = GlobalSpace.getInstance().getGame()
        global = GlobalSpace.getInstance()
    }
}
