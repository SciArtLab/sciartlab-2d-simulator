package com.xmunch.game.model

import processing.core.PApplet

import com.xmunch.game.Constants
import com.xmunch.game.GlobalSpace


public class Cursor extends PObject {

    String message = Constants.DEFAULT_CUR_MSG

    public Cursor(){
        super()
        width = 5
        height = 5
    }

    void draw() {
        drawCur()
        drawMessage()
    }

    void drawCur(){
        game.strokeWeight(0)
        game.fill(0, 230, 0)
        game.rect(game.mouseX,game.mouseY,width,height)
    }

    void drawMessage(){
        game.textSize(20)
        game.fill(255)
        game.text(message,game.mouseX + 10,game.mouseY + 10)
    }
}
