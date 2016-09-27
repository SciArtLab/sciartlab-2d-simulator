package com.xmunch.game.model

import com.xmunch.game.Constants
import com.xmunch.game.GlobalSpace



public class Player extends PObject {

    public Player(){
        super()
        x = (float)global.getSpaceWidth()/2
        y = (float)global.getSpaceHeight()/2
        width = Constants.PLAYER_WIDTH
        height = Constants.PLAYER_HEIGHT
    }

    void draw() {
        game.strokeWeight(1)
        game.stroke(0,255,0)
        game.fill(0,50,0)
        game.rect(x,y,width,height)
    }

    void moveUp(){
        if(y - Constants.PLAYER_SPEED > 0)
            y = y-Constants.PLAYER_SPEED
    }
    void moveDown(){
        if(y + Constants.PLAYER_SPEED + Constants.PLAYER_HEIGHT < global.getSpaceWidth())
            y = y + Constants.PLAYER_SPEED
    }
    void moveLeft(){
        if(x - Constants.PLAYER_SPEED > 0)
            x = x-Constants.PLAYER_SPEED
    }
    void moveRight(){
        if(x + Constants.PLAYER_SPEED + Constants.PLAYER_WIDTH < global.getSpaceHeight())
            x = x+Constants.PLAYER_SPEED
    }
}
