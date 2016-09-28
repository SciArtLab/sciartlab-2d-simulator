package com.xmunch.game.model

import processing.core.PApplet

import com.xmunch.game.GlobalSpace

public class Screen extends PObject {

    protected int red = 0, green = 0, blue = 0

    public Screen(){
        super()
    }

    void setup(){
        game.background(red, green, blue)
    }

    void draw() {}
}
