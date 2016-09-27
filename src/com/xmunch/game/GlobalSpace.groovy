package com.xmunch.game

import processing.core.PApplet

import com.xmunch.game.model.Agent
import com.xmunch.game.model.Cursor
import com.xmunch.game.model.GridScreen
import com.xmunch.game.model.Player
import com.xmunch.game.model.Screen

public class GlobalSpace {

    static GlobalSpace globalSpace //Singleton

    Boolean fullscreen
    float spaceWidth
    float spaceHeight

    PApplet game
    Player player
    Cursor cursor

    ArrayList<Agent> agents = new ArrayList<Agent>()
    ArrayList<Screen> screens = new ArrayList<Screen>()


    public GlobalSpace(){}

    public static GlobalSpace getInstance(PApplet game, fullscreen) {

        if (globalSpace == null) {
            globalSpace = new GlobalSpace()
            initializeInstance(game, fullscreen)
        }

        return globalSpace
    }

    public static GlobalSpace getInstance() {
        return globalSpace
    }

    private static GlobalSpace initializeInstance(PApplet game, Boolean fullscreen) {
        globalSpace.setGame(game)
        globalSpace.setFullscreen(fullscreen)

        if(!fullscreen){
            globalSpace.setSpaceWidth(Constants.WIDTH)
            globalSpace.setSpaceHeight(Constants.HEIGHT)
        } else{
            globalSpace.setSpaceWidth(globalSpace.getGame().displayWidth)
            globalSpace.setSpaceHeight(globalSpace.getGame().displayHeight)
        }

        globalSpace.setScreens(createScreens())
        globalSpace.setAgents(createAgents())
        globalSpace.setPlayer(new Player())
        globalSpace.setCursor(new Cursor())
    }

    public void setup() {
        globalSpace.getScreens().get(0).setup()
    }

    public void draw() {
        globalSpace.getScreens().get(0).draw()

        for(Agent agent : globalSpace.getAgents())
            agent.draw()

        globalSpace.getPlayer().draw()
        globalSpace.getCursor().draw()
    }

    private static ArrayList<Screen> createScreens(){
        List<Screen> screens = new ArrayList<Screen>()
        Screen screen1 = new GridScreen()
        screens.add(screen1)
        return screens
    }

    private static ArrayList<Screen> createAgents(){
        List<Agent> agents = new ArrayList<Agent>()
        for(i in 0..Constants.AGENTS_NUMBER){
            Agent agent = new Agent()
            agents.add(agent)
        }
        return agents
    }
}
