package com.xmunch.game

import processing.core.PApplet

import com.xmunch.game.model.Agent
import com.xmunch.game.model.Cursor
import com.xmunch.game.model.Player
import com.xmunch.game.model.Screen


public class GlobalSpace {

    protected static GlobalSpace globalSpace

    boolean paused = false
    boolean showNeighborsInfo = false
    boolean showAgents = true
    boolean showSprites = true
    boolean showGrid = false
    boolean showBackground = true
    int currentScreen = 0

    float spaceWidth
    float spaceHeight

    PApplet game
    Player player
    Cursor cursor

    ArrayList<Agent> agents = new ArrayList<Agent>()
    ArrayList<Screen> screens = new ArrayList<Screen>()


    public GlobalSpace(){}

    public static GlobalSpace getInstance() {
        return globalSpace
    }

    public void drawWorld() {

        globalSpace.getGame().background(30)
        globalSpace.getScreens().get(currentScreen).draw()

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
}
