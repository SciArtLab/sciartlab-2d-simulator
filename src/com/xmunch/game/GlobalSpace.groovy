package com.xmunch.game

import processing.core.PApplet
import processing.core.PImage

import com.xmunch.game.model.Agent
import com.xmunch.game.model.Cursor
import com.xmunch.game.model.GridScreen
import com.xmunch.game.model.Player
import com.xmunch.game.model.Screen


public class GlobalSpace {

    static GlobalSpace globalSpace //Singleton

    boolean fullscreen
    boolean paused = false
    boolean showNeighborsInfo = false
    boolean showAgents = true
    boolean showSprites = true
    boolean showGrid = false
    boolean showBackground = true

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
        } else {
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

    public void drawWorld() {

        globalSpace.getGame().background(30)

        if(globalSpace.getShowGrid()){
            globalSpace.getScreens().get(0).draw()

        } else if(globalSpace.getShowBackground()){
            PImage img = globalSpace.getGame().loadImage("backgroundSand.jpg")
            globalSpace.getGame().image(img, 0, 0, globalSpace.getSpaceWidth(), globalSpace.getSpaceHeight())
        }

        //TODO: Show real screen according to GlobalSpace Status

        for(Agent agent : globalSpace.getAgents())
            agent.draw()

        globalSpace.getPlayer().draw()
        globalSpace.getCursor().draw()
    }

    void drawNeighborsInfo(){
        for(Agent agent : globalSpace.getAgents()){

            if(globalSpace.getPlayer().isNeighbor(agent.getX(), agent.getY())){
                globalSpace.getGame().strokeWeight(3)
                globalSpace.getGame().stroke(255, 100, 100)
            } else {
                globalSpace.getGame().strokeWeight(0.5)
                globalSpace.getGame().stroke(globalSpace.getGame().random(0,255),globalSpace.getGame().random(200,255),globalSpace.getGame().random(200,255))
            }

            globalSpace.getGame().line((float)agent.getX(),(float)agent.getY(), (float)globalSpace.getPlayer().getX(),(float)globalSpace.getPlayer().getY())
        }
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
