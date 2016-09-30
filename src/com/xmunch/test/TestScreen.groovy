package com.xmunch.test

import com.xmunch.game.model.Agent
import com.xmunch.game.model.GridScreen
import com.xmunch.game.model.ScreenObject
import com.xmunch.game.utils.GameUtils

public class TestScreen extends GridScreen {


    public TestScreen(){
        super()
        setup()
    }

    public TestScreen(String backgroundImage){
        super()
        this.backgroundImage = backgroundImage
        setup()
    }

    void setup(){
        setBackgroundObjects(createBackgroundObjects())
        setAgents(createAgents())
        setObjects(createObjects())
    }


    @Override
    protected static ArrayList<Agent> createAgents(){
        List<Agent> agents = new ArrayList<Agent>()
        for(i in 0..50){
            Agent agent = new Agent()
            agent.tintR = GameUtils.random(100,255)
            agent.tintG = GameUtils.random(100,255)
            agent.tintB = GameUtils.random(0,0)
            float randomSize = GameUtils.random(0.2,0.2)
            agent.width = randomSize * agent.width
            agent.height = randomSize * agent.height
            agent.speed =  randomSize * agent.speed

            agents.add(agent)
        }
        return agents
    }

    @Override
    protected static ArrayList<ScreenObject> createObjects(){
        List<ScreenObject> screenObjects = new ArrayList<ScreenObject>()
        for(i in 0..20){
            ScreenObject screenObject = new ScreenObject()
            screenObjects.add(screenObject)
        }
        return screenObjects
    }

    @Override
    protected static ArrayList<ScreenObject> createBackgroundObjects(){
        List<ScreenObject> backgoundObjects = new ArrayList<ScreenObject>()
        for(i in 0..1000){
            ScreenObject screenObject = new ScreenObject("egg", "static")
            screenObject.width = 5
            screenObject.height = 5
            backgoundObjects.add(screenObject)
        }

        return backgoundObjects
    }
}
