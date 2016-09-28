package com.xmunch.game.model

import processing.core.PImage

import com.xmunch.game.Constants



public class Agent extends PObject {

    public Agent(){
        super()
        width = Constants.AGENT_WIDTH
        height = Constants.AGENT_HEIGHT

        x = game.random(0, (float)(Constants.WIDTH - width))
        y = game.random(0,(float)(Constants.HEIGHT - height))
    }

    void draw() {

        if(global.getShowAgents()){

            if(global.getShowSprites()){

                PImage img = global.getGame().loadImage("images.agent/"+state+".png")
                global.getGame().image(img, x, y, width, height)
            } else {
                game.strokeWeight(1)
                game.stroke(0,235,0)
                game.fill(0,50,0)
                game.rect(x, y, width, height)
                game.strokeWeight(0)
                game.fill(0,255,255)
                game.ellipse(getCenterX(), getCenterY(), 3, 3)
            }
        }

        live()
    }

    void live(){

        moveRandomly()

        if(clickedByMouseListener()) die()
    }

    void die(){
        global.getAgentsToRemove().add(this)
    }

    void moveRandomly(){
        def movement = game.random(0,100)

        if(movement <= 10)
            moveUp()
        else if(movement <= 25)
            moveLeftUp()
        else if(movement <= 35)
            moveLeftDown()
        else
        if(movement <= 45)
            moveDown()
        else  if(movement <= 55)
            moveLeft()
        else if(movement <= 65)
            moveRightUp()
        else if(movement <= 85)
            moveRightDown()
        else
        if(movement <= 100)
            moveRight()
    }

    //Social
    boolean isNeighbor(float x, float y){
        if(game.dist(this.centerX, this.centerY, x, y) <= Constants.NEIGHBOR_DISTANCE)
            return true
        else return false
    }

    //Movements
    void moveUp(){
        if(y - Constants.AGENT_SPEED > 0){
            y = y-Constants.AGENT_SPEED
            state = "UP"
        }
    }
    void moveDown(){
        if(y + Constants.AGENT_SPEED + Constants.AGENT_HEIGHT < global.getSpaceWidth()){
            y = y + Constants.AGENT_SPEED
            state = "DOWN"
        }
    }
    void moveLeftUp(){
        if(y - Constants.AGENT_SPEED > 0){
            y = y-Constants.AGENT_SPEED
            x = x-Constants.AGENT_SPEED
            state = "UP_LEFT"
        }
    }
    void moveLeftDown(){
        if(y + Constants.AGENT_SPEED + Constants.AGENT_HEIGHT < global.getSpaceWidth()){
            y = y + Constants.AGENT_SPEED
            x = x - Constants.AGENT_SPEED
            state = "DOWN_LEFT"
        }
    }
    void moveRightUp(){
        if(y - Constants.AGENT_SPEED > 0){
            y = y-Constants.AGENT_SPEED
            x = x+Constants.AGENT_SPEED
            state = "UP_RIGHT"
        }
    }
    void moveRightDown(){
        if(y + Constants.AGENT_SPEED + Constants.AGENT_HEIGHT < global.getSpaceWidth()){
            y = y + Constants.AGENT_SPEED
            x = x + Constants.AGENT_SPEED
            state = "DOWN_RIGHT"
        }
    }
    void moveLeft(){
        if(x - Constants.AGENT_SPEED > 0){
            x = x-Constants.AGENT_SPEED
            state = "LEFT"
        }
    }
    void moveRight(){
        if(x + Constants.AGENT_SPEED + Constants.AGENT_WIDTH < global.getSpaceHeight()){
            x = x+Constants.AGENT_SPEED
            state = "RIGHT"
        }
    }

    boolean clickedByMouseListener()  {
        return (global.isMouseClicked && game.mouseX >= x && game.mouseX <= x+width &&
                game.mouseY >= y && game.mouseY <= y+height)
    }
}
