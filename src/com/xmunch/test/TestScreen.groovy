package com.xmunch.test

import com.xmunch.game.model.Agent
import com.xmunch.game.model.GridScreen
import com.xmunch.game.model.ScreenObject

public class TestScreen extends GridScreen {

    @Override
    protected static ArrayList<Agent> createAgents(){
        List<Agent> agents = new ArrayList<Agent>()
        for(i in 0..2){
            Agent agent = new Agent()
            agents.add(agent)
        }
        return agents
    }

    @Override
    protected static ArrayList<ScreenObject> createObjects(){
        List<ScreenObject> screenObjects = new ArrayList<ScreenObject>()
        for(i in 0..4){
            ScreenObject screenObject = new ScreenObject()
            screenObjects.add(screenObject)
        }
        return screenObjects
    }

    @Override
    protected static ArrayList<ScreenObject> createBackgroundObjects(){
        List<ScreenObject> screenObjects = new ArrayList<ScreenObject>()
        for(i in 0..10){
            ScreenObject screenObject = new ScreenObject("egg", "static")
            screenObject.width = 5
            screenObject.height = 5
            screenObjects.add(screenObject)
        }

        return screenObjects
    }
}
