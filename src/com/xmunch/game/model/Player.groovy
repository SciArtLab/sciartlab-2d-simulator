package com.xmunch.game.model

import com.xmunch.game.Constants
import com.xmunch.game.GlobalSpace



public class Player extends Agent {

    public Player(){
        super()
        x = (float)global.getSpaceWidth()/2
        y = (float)global.getSpaceHeight()/2
        width = Constants.AGENT_WIDTH
        height = Constants.AGENT_HEIGHT
    }

    void draw() {
        game.strokeWeight(1)
        game.stroke(100,110,255)
        game.fill(50,60,60)
        game.rect(x,y,width,height)
    }
}
