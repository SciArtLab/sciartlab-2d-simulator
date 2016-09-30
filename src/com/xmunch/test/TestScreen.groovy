package com.xmunch.test

import com.xmunch.game.Constants
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
        setScreenObjects(createScreenObjects())
    }


    @Override
    protected static ArrayList<Agent> createAgents(){
        List<Agent> agents = new ArrayList<Agent>()
        for(i in 0..200){
            Agent agent = new Agent()
            agent.tintR = GameUtils.random(100,255)
            agent.tintG = GameUtils.random(100,255)
            agent.tintB = GameUtils.random(0,0)
            float randomSize = GameUtils.random(0.2,0.2)
            agent.width = randomSize * agent.width
            agent.height = randomSize * agent.height
            agent.state = GameUtils.randomAgentState()
            agent.x = agent.global.game.width/2
            agent.y= agent.global.game.height/2

            if(agent.width+ agent.x >agent.getGame().width){
                println "Fuera de area: x"
                agent.x = 10
            }

            if(agent.height+ agent.y >agent.getGame().height){
                println "Fuera de area: y"
                agent.y = 10
            }

            agents.add(agent)
        }
        return agents
    }

    @Override
    protected static ArrayList<ScreenObject> createScreenObjects(){
        List<ScreenObject> screenObjects = new ArrayList<ScreenObject>()
        for(i in 0..100){
            ScreenObject screenObject = new ScreenObject()
            float randomSize = GameUtils.random(0.1,0.3)
            screenObject.width = screenObject.width * randomSize
            screenObject.height = screenObject.height * randomSize

            if(screenObject.width+ screenObject.x >screenObject.getGame().width){
                println "Fuera de area: x"
                screenObject.x = 10
            }
            if(screenObject.height+ screenObject.y >screenObject.getGame().height){
                println "Fuera de area: y"
                screenObject.y = 10
            }
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

        ScreenObject screenObject = new ScreenObject("hole", "static")
        screenObject.width = 100
        screenObject.height = 100
        screenObject.x = Constants.WIDTH/2 - screenObject.width/2
        screenObject.y = Constants.HEIGHT/2 - screenObject.height/2

        backgoundObjects.add(screenObject)

        return backgoundObjects
    }
}
