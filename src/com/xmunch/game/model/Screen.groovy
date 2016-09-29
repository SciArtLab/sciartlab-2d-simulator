package com.xmunch.game.model

import processing.core.PApplet

import com.xmunch.game.Constants

public class Screen extends PObject {

    protected int red = 0, green = 0, blue = 0

    ArrayList<Agent> agents = new ArrayList<Agent>()
    ArrayList<Agent> agentsToAdd = new ArrayList<Agent>()
    ArrayList<Agent> agentsToRemove = new ArrayList<Agent>()

    ArrayList<ScreenObject> objects = new ArrayList<ScreenObject>()
    ArrayList<ScreenObject> objectsToAdd = new ArrayList<ScreenObject>()
    ArrayList<ScreenObject> objectsToRemove = new ArrayList<ScreenObject>()

    public Screen(){
        super()
        setAgents(createAgents())
        setObjects(createObjects())
    }

    void setup(){
        game.background(red, green, blue)
    }

    void draw() {

        for(ScreenObject screenObject : getObjects())
            screenObject.draw()

        for(ScreenObject screenObject : getObjectsToAdd())
            getObjects().add(screenObject)

        objectsToAdd.clear()

        for(ScreenObject screenObject : getObjectsToRemove())
            getObjects().remove(screenObject)

        objectsToRemove.clear()

        for(Agent agent : getAgents())
            agent.draw()

        for(Agent agent : getAgentsToAdd())
            getAgents().add(agent)

        agentsToAdd.clear()

        for(Agent agent : getAgentsToRemove())
            getAgents().remove(agent)

        agentsToRemove.clear()

        global.getPlayer().draw()
        global.getCursor().draw()

        if(global.getShowNeighborsInfo())
            drawNeighborsInfo()
    }

    void drawNeighborsInfo(){

        for(Agent agent : getAgents()){

            if(global.getPlayer().isNeighbor(agent.getCenterX(), agent.getCenterY())){
                global.getGame().strokeWeight(3)
                global.getGame().stroke(255, 100, 100)
            } else {
                global.getGame().strokeWeight(0.5)
                global.getGame().stroke(global.getGame().random(0,255),global.getGame().random(200,255),global.getGame().random(200,255))
            }

            global.getGame().line(agent.getCenterX(), agent.getCenterY(), global.getPlayer().getCenterX(), global.getPlayer().getCenterY())
        }
    }

    protected static ArrayList<Agent> createAgents(){
        List<Agent> agents = new ArrayList<Agent>()
        for(i in 0..Constants.AGENTS_NUMBER){
            Agent agent = new Agent()
            agents.add(agent)
        }
        return agents
    }

    protected static ArrayList<ScreenObject> createObjects(){
        List<ScreenObject> screenObjects = new ArrayList<ScreenObject>()
        for(i in 0..Constants.OBJECTS_NUMBER){
            ScreenObject screenObject = new ScreenObject()
            screenObjects.add(screenObject)
        }
        return screenObjects
    }
}
