package com.xmunch.game.utils

import processing.core.PImage

import com.xmunch.game.Constants
import com.xmunch.game.model.Agent
import com.xmunch.game.model.Player

public class GameUtils {

    public static void initializePlayer(Player player){
        if(player.type == null) player.type = Constants.DEFAULT_PLAYER_TYPE

        player.x = (float)player.global.getSpaceWidth()/2
        player.y = (float)player.global.getSpaceHeight()/2
        player.width = Constants.AGENT_WIDTH*2
        player.height = Constants.AGENT_HEIGHT*2
        player.speed = Constants.AGENT_SPEED*2
    }

    public static void initializeAgent(Agent agent){
        if(agent.type == null) agent.type = Constants.DEFAULT_AGENT_TYPE

        agent.width = Constants.AGENT_WIDTH
        agent.height = Constants.AGENT_HEIGHT
        agent.speed = Constants.AGENT_SPEED

        agent.x = agent.game.random(0, (float)(Constants.WIDTH - agent.width))
        agent.y = agent.game.random(0,(float)(Constants.HEIGHT - agent.height))
    }

    public static void drawPlayer(Player player){
        if(player.global.getShowAgents()){

            if(player.global.getShowSprites()){

                PImage img = player.global.getGame().loadImage(Constants.PLAYER_SPRITES_FOLDER+player.type+"/"+player.state+player.animationFrame+".png")
                player.global.getGame().image(img, player.x, player.y, player.width, player.height)
            } else {

                player.game.strokeWeight(1)
                player.game.stroke(100,110,255)
                player.game.fill(50,60,60)
                player.game.rect(player.x,player.y,player.width,player.height)
            }
        }
    }

    public static void drawAgent(Agent agent){

        if(agent.global.getShowAgents()){

            if(agent.global.getShowSprites()){

                PImage img = agent.game.loadImage(Constants.AGENT_SPRITES_FOLDER+agent.type+"/"+agent.state+agent.animationFrame+".png")
                agent.game.image(img, agent.x, agent.y, agent.width, agent.height)
            } else {
                agent.game.strokeWeight(1)
                agent.game.stroke(0,235,0)
                agent.game.fill(0,50,0)
                agent.game.rect(agent.x, agent.y, agent.width, agent.height)
                agent.game.strokeWeight(0)
                agent.game.fill(0,255,255)
                agent.game.ellipse(getCenterX(), getCenterY(), 3, 3)
            }
        }
    }
}
