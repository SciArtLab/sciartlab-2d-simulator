package com.xmunch.game.utils.behavior

import com.xmunch.game.Constants
import com.xmunch.game.model.Agent
import com.xmunch.game.utils.GameUtils

public class MotorBehaviorUtils  {

    static void rotateRight45(Agent agent){
        if(agent.state.equals("UP"))
            agent.state = "UP_RIGHT"
        if(agent.state.equals("UP_RIGHT"))
            agent.state = "RIGHT"
        if(agent.state.equals("RIGHT"))
            agent.state = "DOWN_RIGHT"
        else if(agent.state.equals("DOWN_RIGHT"))
            agent.state = "DOWN"
        else if(agent.state.equals("DOWN"))
            agent.state = "DOWN_LEFT"
        else if(agent.state.equals("DOWN_LEFT"))
            agent.state = "LEFT"
        else if(agent.state.equals("LEFT"))
            agent.state = "UP_LEFT"
        else if(agent.state.equals("UP_LEFT"))
            agent.state = "UP"
    }

    static void rotateLeft45(Agent agent){
        if(agent.state.equals("UP"))
            agent.state = "UP_LEFT"
        if(agent.state.equals("UP_LEFT"))
            agent.state = "LEFT"
        if(agent.state.equals("LEFT"))
            agent.state = "DOWN_LEFT"
        else if(agent.state.equals("DOWN_LEFT"))
            agent.state = "DOWN"
        else if(agent.state.equals("DOWN"))
            agent.state = "DOWN_RIGHT"
        else if(agent.state.equals("DOWN_RIGHT"))
            agent.state = "RIGHT"
        else if(agent.state.equals("RIGHT"))
            agent.state = "UP_RIGHT"
        else if(agent.state.equals("UP_RIGHT"))
            agent.state = "UP"
    }

    static void rotateRight90(Agent agent){
        if(agent.state.equals("UP"))
            agent.state = "RIGHT"
        if(agent.state.equals("UP_RIGHT"))
            agent.state = "DOWN_RIGHT"
        if(agent.state.equals("RIGHT"))
            agent.state = "DOWN"
        else if(agent.state.equals("DOWN_RIGHT"))
            agent.state = "DOWN_LEFT"
        else if(agent.state.equals("DOWN"))
            agent.state = "LEFT"
        else if(agent.state.equals("DOWN_LEFT"))
            agent.state = "UP_LEFT"
        else if(agent.state.equals("LEFT"))
            agent.state = "UP"
        else if(agent.state.equals("UP_LEFT"))
            agent.state = "UP_RIGHT"
    }

    static void rotate180(Agent agent){
        if(agent.state.equals("UP"))
            agent.state = "DOWN"
        if(agent.state.equals("UP_RIGHT"))
            agent.state = "DOWN_LEFT"
        if(agent.state.equals("RIGHT"))
            agent.state = "LEFT"
        else if(agent.state.equals("DOWN_RIGHT"))
            agent.state = "UP_LEFT"
        else if(agent.state.equals("DOWN"))
            agent.state = "UP"
        else if(agent.state.equals("DOWN_LEFT"))
            agent.state = "UP_RIGHT"
        else if(agent.state.equals("LEFT"))
            agent.state = "RIGHT"
        else if(agent.state.equals("UP_LEFT"))
            agent.state = "DOWN_RIGHT"
    }

    static void moveAhead(Agent agent){
        if(agent.state.equals("UP"))
            agent.moveUp()
        if(agent.state.equals("UP_RIGHT"))
            agent.moveRightUp()
        if(agent.state.equals("RIGHT"))
            agent.moveRight()
        else if(agent.state.equals("DOWN_RIGHT"))
            agent.moveRightDown()
        else if(agent.state.equals("DOWN"))
            agent.moveDown()
        else if(agent.state.equals("DOWN_LEFT"))
            agent.moveLeftDown()
        else if(agent.state.equals("LEFT"))
            agent.moveLeft()
        else if(agent.state.equals("UP_LEFT"))
            agent.moveLeftUp()
    }

    static void moveRandomly(Agent agent){
        def movement = agent.game.random(0,100)

        if(movement > 20 && movement < 25)
            rotateRight45(agent)

        else if(movement > 55 && movement < 60)
            rotateLeft45(agent)

        moveAhead(agent)
    }

    static void moveUp(Agent agent){
        agent.state = "UP"
        if(agent.y - agent.speed > 0
        && GameUtils.thereIsNotObstacle(agent, agent.centerX, agent.centerY-agent.speed)){
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
        if(agent.x - agent.speed > 0 &&
        agent.y - agent.speed > 0
        && GameUtils.thereIsNotObstacle(agent, agent.centerX -agent.speed, agent.centerY -agent.speed)){
            agent.y = agent.y-agent.speed
            agent.x = agent.x-agent.speed
            agent.animationFrame = agent.global.getAnimationFrame(2)
        } else {
            moveUp(agent)
        }
    }

    static void moveLeftDown(Agent agent){
        agent.state = "DOWN_LEFT"
        if(agent.x - agent.speed > 0 &&
        agent.y + agent.speed
        + Constants.AGENT_HEIGHT < agent.global.getSpaceWidth()
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
        if(agent.x + agent.speed + Constants.AGENT_WIDTH < agent.global.getSpaceHeight()
        && agent.y - agent.speed > 0
        &&  GameUtils.thereIsNotObstacle(agent, agent.centerX +agent.speed, agent.centerY -agent.speed)){
            agent.y = agent.y-agent.speed
            agent.x = agent.x+agent.speed
            agent.animationFrame = agent.global.getAnimationFrame(2)
        } else {
            moveRight(agent)
        }
    }

    static void moveRightDown(Agent agent){
        agent.state = "DOWN_RIGHT"
        if(agent.x + agent.speed + Constants.AGENT_WIDTH < agent.global.getSpaceHeight()
        && agent.y + agent.speed + Constants.AGENT_HEIGHT < agent.global.getSpaceWidth()
        && GameUtils.thereIsNotObstacle(agent, agent.centerX +agent.speed, agent.centerY +agent.speed)){
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
