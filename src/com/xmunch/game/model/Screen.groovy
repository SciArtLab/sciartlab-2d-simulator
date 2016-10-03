package com.xmunch.game.model

import processing.core.PImage

import com.xmunch.game.Constants

public class Screen extends PObject {

    protected int red = 0, green = 0, blue = 0

    Map<String, PImage> images = new HashMap<String, PImage>()

    ArrayList<Agent> agents = new ArrayList<Agent>()
    ArrayList<Agent> agentsToAdd = new ArrayList<Agent>()
    ArrayList<Agent> agentsToRemove = new ArrayList<Agent>()

    ArrayList<ScreenObject> screenObjects = new ArrayList<ScreenObject>()
    ArrayList<ScreenObject> screenObjectsToAdd = new ArrayList<ScreenObject>()
    ArrayList<ScreenObject> screenObjectsToRemove = new ArrayList<ScreenObject>()

    ArrayList<ScreenObject> backgroundObjects = new ArrayList<ScreenObject>()
    ArrayList<ScreenObject> backgroundObjectsToAdd = new ArrayList<ScreenObject>()
    ArrayList<ScreenObject> backgroundObjectsToRemove = new ArrayList<ScreenObject>()

    public Screen(){
        super()
        setBackgroundObjects(createBackgroundObjects())
        setAgents(createAgents())
        setScreenObjects(createScreenObjects())
    }

    void setup(){
        game.background(red, green, blue)
    }

    void draw() {

        for(ScreenObject backgroundObject : getBackgroundObjects())
            backgroundObject.draw()

        for(ScreenObject backgroundObject : getBackgroundObjectsToAdd())
            getBackgroundObjects().add(backgroundObject)

        backgroundObjectsToAdd.clear()

        for(ScreenObject backgroundObject : getBackgroundObjectsToRemove())
            getBackgroundObjects().remove(backgroundObject)

        backgroundObjectsToRemove.clear()

        for(Agent agent : getAgents())
            agent.draw()

        for(Agent agent : getAgentsToAdd())
            getAgents().add(agent)

        agentsToAdd.clear()

        for(Agent agent : getAgentsToRemove())
            getAgents().remove(agent)

        agentsToRemove.clear()

        for(ScreenObject screenObject : getScreenObjects())
            screenObject.draw()

        for(ScreenObject screenObject : getScreenObjectsToAdd())
            getScreenObjects().add(screenObject)

        screenObjectsToAdd.clear()

        for(ScreenObject screenObject : getScreenObjectsToRemove())
            getScreenObjects().remove(screenObject)

        screenObjectsToRemove.clear()

        global.getPlayer().draw()
        global.getCursor().draw()

        if(global.getShowNeighborsInfo())
            drawNeighborsInfo()

        // else calculateSocialInfo

        if(global.getShowObstaclesInfo())
            drawObstaclesInfo()
        else {
            calculateObstaclesInfo()
        }
    }

    void drawNeighborsInfo(){

        for(Agent agent : getAgents()){

            if(global.getPlayer().isNeighbor(agent.getCenterX(), agent.getCenterY())){
                global.getGame().strokeWeight(3)
                global.getGame().stroke(255, 100, 100)
            } else {
                global.getGame().strokeWeight(0.5)
                global.getGame().stroke(0, 255, 255)
            }

            global.getGame().line(agent.getCenterX(), agent.getCenterY(), global.getPlayer().getCenterX(), global.getPlayer().getCenterY())
        }
    }

    void calculateObstaclesInfo(){

        global.player.resetPotentialCollitions()

        for(Agent agent : getAgents())
            agent.resetPotentialCollitions()

        for(ScreenObject object : getScreenObjects()){

            if(global.player.isObstacle(object.getCenterX(), object.getCenterY())){
                global.player.addPotentialCollition(new PotentialCollition(object.getX(), object.getY(), object.getWidth(), object.getHeight()))
            }

            for(Agent agent : getAgents()){
                if(agent.isObstacle(object.getCenterX(), object.getCenterY())){

                    PotentialCollition potentialCollition = new PotentialCollition(object.getX(), object.getY(), object.getWidth(), object.getHeight())
                    agent.addPotentialCollition(potentialCollition)
                }
            }
        }
    }

    void drawObstaclesInfo(){

        global.player.resetPotentialCollitions()

        for(Agent agent : getAgents())
            agent.resetPotentialCollitions()

        for(ScreenObject object : getScreenObjects()){


            if(global.player.isObstacle(object.getCenterX(), object.getCenterY())){
                global.getGame().fill(255,0,0,150)
                global.getGame().strokeWeight(1)
                global.getGame().ellipse(global.player.getCenterX(), global.player.getCenterY(), Constants.OBSTACLE_DISTANCE, Constants.OBSTACLE_DISTANCE)
                global.getGame().strokeWeight(5)
                global.getGame().stroke(0, 100, 200)
                global.getGame().line(object.getCenterX(), object.getCenterY(), global.player.getCenterX(), global.player.getCenterY())
                global.player.addPotentialCollition(new PotentialCollition(object.getX(), object.getY(), object.getWidth(), object.getHeight()))
            }

            for(Agent agent : getAgents()){
                if(agent.isObstacle(object.getCenterX(), object.getCenterY())){
                    global.getGame().fill(245,0,0,150)
                    global.getGame().strokeWeight(1)
                    global.getGame().ellipse(agent.getCenterX(), agent.getCenterY(), Constants.OBSTACLE_DISTANCE, Constants.OBSTACLE_DISTANCE)
                    global.getGame().strokeWeight(5)
                    global.getGame().stroke(255, 0, 30)
                    global.getGame().line(object.getCenterX(), object.getCenterY(), agent.getCenterX(), agent.getCenterY())

                    PotentialCollition potentialCollition = new PotentialCollition(object.getX(), object.getY(), object.getWidth(), object.getHeight())
                    agent.addPotentialCollition(potentialCollition)

                    global.getGame().strokeWeight(2)
                    global.getGame().fill(255, 0, 100, 100)
                    global.getGame().rect(potentialCollition.x, potentialCollition.y, potentialCollition.width, potentialCollition.height)
                }
            }
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

    protected static ArrayList<ScreenObject> createScreenObjects(){
        List<ScreenObject> screenObjects = new ArrayList<ScreenObject>()
        for(i in 0..Constants.OBJECTS_NUMBER){
            ScreenObject screenObject = new ScreenObject()
            screenObjects.add(screenObject)
        }

        return screenObjects
    }

    protected static ArrayList<ScreenObject> createBackgroundObjects(){
        List<ScreenObject> backgroundObjects = new ArrayList<ScreenObject>()
        for(i in 0..Constants.OBJECTS_NUMBER* 10){
            ScreenObject screenObject = new ScreenObject("egg", "static")
            screenObject.width = 5
            screenObject.height = 5
            backgroundObjects.add(screenObject)
        }

        return backgroundObjects
    }
}
