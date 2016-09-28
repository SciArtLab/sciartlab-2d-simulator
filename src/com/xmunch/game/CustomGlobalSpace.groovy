package com.xmunch.game

import processing.core.PApplet

import com.xmunch.game.model.Agent
import com.xmunch.game.model.Cursor
import com.xmunch.game.model.GridScreen
import com.xmunch.game.model.Player
import com.xmunch.game.model.Screen

public class CustomGlobalSpace extends GlobalSpace {

    public static GlobalSpace getInstance(PApplet game) {

        if (globalSpace == null) {
            globalSpace = new GlobalSpace()
            globalSpace.setGame(game)
            globalSpace.setSpaceWidth(Constants.WIDTH)
            globalSpace.setSpaceHeight(Constants.HEIGHT)
            globalSpace.setScreens(createScreens())
            globalSpace.setAgents(createAgents())
            globalSpace.setPlayer(new Player())
            globalSpace.setCursor(new Cursor())
        }

        return globalSpace
    }

    //Customize
    protected static ArrayList<Screen> createScreens(){
        List<Screen> screens = new ArrayList<Screen>()
        Screen screen1 = new GridScreen("backgroundSand.jpg")
        screens.add(screen1)
        return screens
    }

    //Customize
    protected static ArrayList<Agent> createAgents(){
        List<Agent> agents = new ArrayList<Agent>()
        for(i in 0..Constants.AGENTS_NUMBER){
            Agent agent = new Agent()
            agents.add(agent)
        }
        return agents
    }
}
