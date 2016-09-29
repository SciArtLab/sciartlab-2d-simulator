package com.xmunch.game.utils.behavior

import com.xmunch.game.model.Agent

public class BiologicalBehaviorUtils {

    static void live(Agent agent){

        agent.moveRandomly()

        if(agent.isClickedByMouse()) agent.die()
    }

    static void die(Agent agent){
        agent.global.getAgentsToRemove().add(agent)
    }
}
