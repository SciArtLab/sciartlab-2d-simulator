package com.xmunch.game.utils.behavior

import com.xmunch.game.Constants
import com.xmunch.game.model.Agent
import com.xmunch.game.utils.GameUtils

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
        agent.state = "UP"
        if(agent.y - agent.speed > 0 && GameUtils.thereIsNotObstacle(agent, agent.centerX, agent.centerY-agent.speed)){
            agent.animationFrame = agent.global.getAnimationFrame(2)
            agent.y = agent.y-agent.speed
        } else {
            moveRightUp(agent)
        }
    }

    static void moveDown(Agent agent){
        agent.state = "DOWN"
        if(agent.y + agent.speed + Constants.AGENT_HEIGHT < agent.global.getSpaceWidth()
        && GameUtils.thereIsNotObstacle(agent, agent.centerX, agent.centerY+agent.speed)){
            agent.animationFrame = agent.global.getAnimationFrame(2)
            agent.y = agent.y + agent.speed
        } else {
            moveLeftDown(agent)
        }
    }

    static void moveLeftUp(Agent agent){
        agent.state = "UP_LEFT"
        if(agent.y - agent.speed > 0 && GameUtils.thereIsNotObstacle(agent, agent.centerX -agent.speed, agent.centerY -agent.speed)){
            agent.y = agent.y-agent.speed
            agent.x = agent.x-agent.speed
            agent.animationFrame = agent.global.getAnimationFrame(2)
        } else {
            moveUp(agent)
        }
    }

    static void moveLeftDown(Agent agent){
        agent.state = "DOWN_LEFT"
        if(agent.y + agent.speed + Constants.AGENT_HEIGHT < agent.global.getSpaceWidth()
        && GameUtils.thereIsNotObstacle(agent, agent.centerX -agent.speed, agent.centerY +agent.speed)){
            agent.y = agent.y + agent.speed
            agent.x = agent.x - agent.speed
            agent.animationFrame = agent.global.getAnimationFrame(2)
        } else {
            moveLeft(agent)
        }
    }

    static void moveRightUp(Agent agent){
        agent.state = "UP_RIGHT"
        if(agent.y - agent.speed > 0 &&
        GameUtils.thereIsNotObstacle(agent, agent.centerX +agent.speed, agent.centerY -agent.speed)){
            agent.y = agent.y-agent.speed
            agent.x = agent.x+agent.speed
            agent.animationFrame = agent.global.getAnimationFrame(2)
        } else {
            moveRight(agent)
        }
    }

    static void moveRightDown(Agent agent){
        agent.state = "DOWN_RIGHT"
        if(agent.y + agent.speed + Constants.AGENT_HEIGHT < agent.global.getSpaceWidth() &&
        GameUtils.thereIsNotObstacle(agent, agent.centerX +agent.speed, agent.centerY +agent.speed)){
            agent.y = agent.y + agent.speed
            agent.x = agent.x + agent.speed
            agent.animationFrame = agent.global.getAnimationFrame(2)
        } else {
            moveDown(agent)
        }
    }

    static void moveLeft(Agent agent){
        agent.state = "LEFT"
        if(agent.x - agent.speed > 0
        && GameUtils.thereIsNotObstacle(agent, agent.centerX -agent.speed, agent.centerY )){
            agent.x = agent.x-agent.speed
            agent.animationFrame = agent.global.getAnimationFrame(2)
        } else {
            moveLeftUp(agent)
        }
    }

    static void moveRight(Agent agent){
        agent.state = "RIGHT"
        if(agent.x + agent.speed + Constants.AGENT_WIDTH < agent.global.getSpaceHeight()
        && GameUtils.thereIsNotObstacle(agent, agent.centerX +agent.speed, agent.centerY )){
            agent.x = agent.x+agent.speed
            agent.animationFrame = agent.global.getAnimationFrame(2)
        } else {
            moveRightDown(agent)
        }
    }
}
