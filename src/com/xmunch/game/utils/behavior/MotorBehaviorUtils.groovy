package com.xmunch.game.utils.behavior

import com.xmunch.game.Constants
import com.xmunch.game.model.Agent

public class MotorBehaviorUtils  {

    static void moveRandomly(Agent agent){
        def movement = agent.game.random(0,100)

        if(movement <= 10)
            agent.moveUp()
        else if(movement <= 25)
            agent.moveLeftUp()
        else if(movement <= 35)
            agent.moveLeftDown()
        else
        if(movement <= 45)
            agent.moveDown()
        else  if(movement <= 55)
            agent.moveLeft()
        else if(movement <= 65)
            agent.moveRightUp()
        else if(movement <= 85)
            agent.moveRightDown()
        else
        if(movement <= 100)
            agent.moveRight()
    }

    static void moveUp(Agent agent){
        if(agent.y - agent.speed > 0){
            agent.animationFrame = agent.global.getAnimationFrame(2)
            agent.y = agent.y-agent.speed
            agent.state = "UP"
        }
    }

    static void moveDown(Agent agent){
        if(agent.y + agent.speed + Constants.AGENT_HEIGHT < agent.global.getSpaceWidth()){
            agent.animationFrame = agent.global.getAnimationFrame(2)
            agent.y = agent.y + agent.speed
            agent.state = "DOWN"
        }
    }

    static void moveLeftUp(Agent agent){
        if(agent.y - agent.speed > 0){
            agent.y = agent.y-agent.speed
            agent.x = agent.x-agent.speed
            agent.animationFrame = agent.global.getAnimationFrame(2)
            agent.state = "UP_LEFT"
        }
    }

    static void moveLeftDown(Agent agent){
        if(agent.y + agent.speed + Constants.AGENT_HEIGHT < agent.global.getSpaceWidth()){
            agent.y = agent.y + agent.speed
            agent.x = agent.x - agent.speed
            agent.animationFrame = agent.global.getAnimationFrame(2)
            agent.state = "DOWN_LEFT"
        }
    }

    static void moveRightUp(Agent agent){
        if(agent.y - agent.speed > 0){
            agent.y = agent.y-agent.speed
            agent.x = agent.x+agent.speed
            agent.animationFrame = agent.global.getAnimationFrame(2)
            agent.state = "UP_RIGHT"
        }
    }

    static void moveRightDown(Agent agent){
        if(agent.y + agent.speed + Constants.AGENT_HEIGHT < agent.global.getSpaceWidth()){
            agent.y = agent.y + agent.speed
            agent.x = agent.x + agent.speed
            agent.animationFrame = agent.global.getAnimationFrame(2)
            agent.state = "DOWN_RIGHT"
        }
    }

    static void moveLeft(Agent agent){
        if(agent.x - agent.speed > 0){
            agent.x = agent.x-agent.speed
            agent.animationFrame = agent.global.getAnimationFrame(2)
            agent.state = "LEFT"
        }
    }

    static void moveRight(Agent agent){
        if(agent.x + agent.speed + Constants.AGENT_WIDTH < agent.global.getSpaceHeight()){
            agent.x = agent.x+agent.speed
            agent.animationFrame = agent.global.getAnimationFrame(2)
            agent.state = "RIGHT"
        }
    }
}
