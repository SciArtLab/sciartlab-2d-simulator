package com.xmunch.game.model

import com.xmunch.game.Constants



public class Agent extends PObject {

    public Agent(){
        super()
        x = game.random(0, width) % Constants.AGENT_WIDTH
        y = game.random(0,height) % Constants.AGENT_HEIGHT
        width = Constants.AGENT_WIDTH
        height = Constants.AGENT_HEIGHT
    }

    void draw() {
        game.strokeWeight(1)
        game.stroke(0,235,0)
        game.fill(0,50,0)
        game.rect(x, y, width, height)
        moveRandomly()
    }

    void moveRandomly(){
        def movement = game.random(0,100)

        if(movement <= 25)
            moveUp()
        else
        if(movement <= 50)
            moveDown()
        else  if(movement <= 75)
            moveLeft()
        else
        if(movement <= 100)
            moveRight()
    }

    //Social
    boolean isNeighbor(float x, float y){
        if(game.dist((float)this.x, (float)this.y, (float)x,(float) y) <= Constants.NEIGHBOR_DISTANCE)
            return true
        else return false
    }

    //Movements
    void moveUp(){
        if(y - Constants.AGENT_SPEED > 0)
            y = y-Constants.AGENT_SPEED
    }
    void moveDown(){
        if(y + Constants.AGENT_SPEED + Constants.AGENT_HEIGHT < global.getSpaceWidth())
            y = y + Constants.AGENT_SPEED
    }
    void moveLeft(){
        if(x - Constants.AGENT_SPEED > 0)
            x = x-Constants.AGENT_SPEED
    }
    void moveRight(){
        if(x + Constants.AGENT_SPEED + Constants.AGENT_WIDTH < global.getSpaceHeight())
            x = x+Constants.AGENT_SPEED
    }
}
