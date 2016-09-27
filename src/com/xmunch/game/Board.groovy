package com.xmunch.game

import com.xmunch.game.model.Agent



class Board extends Game{

    @Override
    void settings() {
        if(!Constants.FULL_SCREEN_DEFAULT){
            size(Constants.WIDTH, Constants.HEIGHT)
        } else
            fullScreen()
    }

    @Override
    void setup() {
        frameRate(Constants.FRAME_RATE)
        global = GlobalSpace.getInstance()
    }

    @Override
    void draw() {
        background(0)
        for(Agent agent : global.getAgents()){
            stroke(random(0,255), random(200,255), random(200,255))
            line(agent.getX(),agent.getY(),global.getPlayer().getX(),global.getPlayer().getY())
        }
    }
}