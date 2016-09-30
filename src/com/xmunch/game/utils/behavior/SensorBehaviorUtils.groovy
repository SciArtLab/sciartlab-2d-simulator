package com.xmunch.game.utils.behavior

import com.xmunch.game.Constants
import com.xmunch.game.model.Agent
import com.xmunch.game.model.PObject

public class SensorBehaviorUtils extends PObject {

    static boolean isNeighbor(Agent agent, float x, float y){
        if(agent.game.dist(agent.centerX, agent.centerY, x, y) <= Constants.NEIGHBOR_DISTANCE)
            return true
        else return false
    }

    static boolean isObstacle(Agent agent, float x, float y){
        if(agent.game.dist(agent.centerX, agent.centerY, x, y) <= Constants.OBSTACLE_DISTANCE)
            return true
        else return false
    }


    static boolean isClickedByMouse(Agent agent)  {
        return (agent.global.isMouseClicked && agent.game.mouseX >= agent.x && agent.game.mouseX <= agent.x+agent.width &&
                agent.game.mouseY >= agent.y && agent.game.mouseY <= agent.y+agent.height)
    }
}
