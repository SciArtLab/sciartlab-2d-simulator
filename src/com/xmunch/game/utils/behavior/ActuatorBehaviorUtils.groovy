package com.xmunch.game.utils.behavior

import com.xmunch.game.model.Agent
import com.xmunch.game.model.PObject
import com.xmunch.game.model.ScreenObject
import com.xmunch.game.utils.GameUtils

public class ActuatorBehaviorUtils extends PObject {

    static void createObject(Agent agent, ScreenObject object)  {
        object.x = agent.x
        object.y = agent.y
        GameUtils.createObject(agent.global.screens.get(agent.global.currentScreen))
    }

    static void eraseEnvironment(Agent agent)  {
        //TODO
        agent.game.fill(0,0,0)
        agent.game.ellipse(agent.getCenterX(), agent.getCenterY(),agent.getHeight(),agent.getWidth())
    }
}
