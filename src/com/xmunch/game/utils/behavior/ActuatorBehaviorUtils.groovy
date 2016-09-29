package com.xmunch.game.utils.behavior

import com.xmunch.game.model.Agent
import com.xmunch.game.model.PObject

public class ActuatorBehaviorUtils extends PObject {

    static void createObject(Agent agent, Object object)  {
        //TODO
        agent.game.fill(0,0,0)
        agent.game.ellipse(agent.getCenterX(), agent.getCenterY(),agent.getHeight(),agent.getWidth())
    }

    static void eraseEnvironment(Agent agent)  {
        //TODO
        agent.game.fill(0,0,0)
        agent.game.ellipse(agent.getCenterX(), agent.getCenterY(),agent.getHeight(),agent.getWidth())
    }
}
