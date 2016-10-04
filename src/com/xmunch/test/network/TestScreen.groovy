package com.xmunch.test.network

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
        return agents
    }

    @Override
    protected static ArrayList<ScreenObject> createScreenObjects(){
        List<ScreenObject> screenObjects = new ArrayList<ScreenObject>()
        return screenObjects
    }

    @Override
    protected static ArrayList<ScreenObject> createBackgroundObjects(){
        List<ScreenObject> screenObjects = new ArrayList<ScreenObject>()
        return screenObjects
    }
}
