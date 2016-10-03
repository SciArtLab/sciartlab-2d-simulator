package com.xmunch.test.maze

import com.xmunch.game.model.Agent
import com.xmunch.game.model.GridScreen
import com.xmunch.game.model.ScreenObject

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
        setScreenObjects(createScreenObjects())
    }


    @Override
    protected static ArrayList<Agent> createAgents(){
        List<Agent> agents = new ArrayList<Agent>()
        for(i in 0..1){
            Agent agent = new Agent()
            agents.add(agent)
        }
        return agents
    }

    @Override
    protected static ArrayList<ScreenObject> createScreenObjects(){
        List<ScreenObject> screenObjects = new ArrayList<ScreenObject>()

        for(i in 0..200){
            ScreenObject screenObject = new ScreenObject()
            screenObjects.add(screenObject)
        }

        return screenObjects
    }
}
