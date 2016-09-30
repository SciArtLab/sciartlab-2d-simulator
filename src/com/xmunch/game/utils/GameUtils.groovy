package com.xmunch.game.utils

import processing.core.PImage

import com.xmunch.game.Constants
import com.xmunch.game.GlobalSpace
import com.xmunch.game.model.Agent
import com.xmunch.game.model.Player
import com.xmunch.game.model.Screen
import com.xmunch.game.model.ScreenObject



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
        if(agent.state == null) agent.state = Constants.DEFAULT_AGENT_STATE

        agent.width = Constants.AGENT_WIDTH
        agent.height = Constants.AGENT_HEIGHT
        agent.speed = Constants.AGENT_SPEED

        agent.x = agent.game.random(0, (float)(Constants.WIDTH - agent.width))
        agent.y = agent.game.random(0,(float)(Constants.HEIGHT - agent.height))
    }

    public static void initializeScreenObject(ScreenObject screenObject){
        if(screenObject.type == null) screenObject.type = Constants.DEFAULT_OBJECT_TYPE
        if(screenObject.state == null) screenObject.state = Constants.DEFAULT_OBJECT_STATE

        screenObject.width = Constants.OBJECT_WIDTH
        screenObject.height = Constants.OBJECT_HEIGHT

        screenObject.x = screenObject.game.random(0, (float)(Constants.WIDTH - screenObject.width))
        screenObject.y = screenObject.game.random(0,(float)(Constants.HEIGHT - screenObject.height))
    }


    public static void drawPlayer(Player player){
        if(player.global.getShowAgents()){

            if(player.global.getShowSprites()){

                String image = Constants.PLAYER_SPRITES_FOLDER+player.type+"/"+player.state+player.animationFrame+".png"

                if(getImage(player.global, image) == null)
                    setImage(player.global, image)

                player.game.tint(player.tintR, player.tintG, player.tintB, player.alpha)
                player.global.getGame().image(getImage(player.global, image), player.x, player.y, player.width, player.height)
                player.game.tint(255)
            } else {

                player.game.strokeWeight(1)
                player.game.stroke(100,110,255)
                player.game.fill(50,60,60)
                player.game.rect(player.x,player.y,player.width,player.height)
            }
        }
    }


    public static PImage getImage(GlobalSpace global, String image){
        return global.screens.get(global.currentScreen).getImages().get(image)
    }

    public static PImage setImage(GlobalSpace global, String image){
        return global.screens.get(global.currentScreen).getImages().put(image, global.getGame().loadImage(image))
    }

    public static void drawAgent(Agent agent){

        if(agent.global.getShowAgents()){

            if(agent.global.getShowSprites()){

                String image = Constants.AGENT_SPRITES_FOLDER+agent.type+"/"+agent.state+agent.animationFrame+".png"

                if(getImage(agent.global, image) == null)
                    setImage(agent.global, image)

                agent.game.tint(agent.tintR, agent.tintG, agent.tintB,, agent.alpha)
                agent.game.image(getImage(agent.global, image) , agent.x, agent.y, agent.width, agent.height)
                agent.game.tint(255)
            } else {
                agent.game.strokeWeight(1)
                agent.game.stroke(0,235,0)
                agent.game.fill(0,50,0)
                agent.game.rect(agent.x, agent.y, agent.width, agent.height)
                agent.game.strokeWeight(0)
                agent.game.fill(0,255,255)
                agent.game.ellipse(agent.getCenterX(), agent.getCenterY(), 3, 3)
            }
        }
    }

    public static void drawScreenObject(ScreenObject screenObject){

        if(screenObject.global.getShowAgents()){

            if(screenObject.global.getShowSprites()){

                String image = Constants.OBJECT_SPRITES_FOLDER+screenObject.type+"/"+screenObject.state+screenObject.animationFrame+".png"

                if(getImage(screenObject.global, image) == null)
                    setImage(screenObject.global, image)

                screenObject.game.tint(screenObject.tintR, screenObject.tintG, screenObject.tintB,, screenObject.alpha)
                screenObject.game.image(getImage(screenObject.global, image), screenObject.x, screenObject.y, screenObject.width, screenObject.height)
                screenObject.game.tint(255)
            } else {
                screenObject.game.strokeWeight(1)
                screenObject.game.stroke(235,0,0)
                screenObject.game.fill(255,255,0)
                screenObject.game.rect(screenObject.x, screenObject.y, screenObject.width, screenObject.height)
                screenObject.game.strokeWeight(0)
                screenObject.game.fill(0,0,255)
                screenObject.game.ellipse(screenObject.getCenterX(), screenObject.getCenterY(), 3, 3)
            }
        }
    }

    static void createObject(Screen screen, ScreenObject object){
        screen.objectsToAdd.add(object)
    }

    static Boolean thereIsNotObstacle(Agent agent, x, y){
        return thereIsNotObstacle(agent.global.screens.get(agent.global.currentScreen), (float)x, (float)y)
    }

    static Boolean thereIsNotObstacle(Screen screen, x,  y){

        Boolean result = true

        if(screen != null && screen.objects != null && screen.objects.size > 0) {

            //            for(ScreenObject object : screen.objects){
            //
            //                println x +" - " + object.x + " - " + object.width + " - " + y + " - " + object.y+ " - "+object.height
            //                println ((Double)(x) >= (Double)(object.x))
            //                println ((float)x <= (float)(object.x + object.width) )
            //                println ((float)y >= (float)object.y)
            //                println ((float)y <= (float)(object.y + object.height))
            //
            //                if(
            //                (float)x >= (float)object.x &&
            //                (float)x <= (float)(object.x + object.width) &&
            //                (float)y >= (float)object.y &&
            //                (float)y <= (float)(object.y + object.height))
            //                    result = false
            //            }
        }

        return result
    }

    public static float random(float min, float max) {
        return (float)( min + (Math.random() * ((1 + max) - min)))
    }
}
