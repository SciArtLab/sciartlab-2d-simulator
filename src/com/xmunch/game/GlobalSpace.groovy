package com.xmunch.game

import processing.core.PApplet

import com.xmunch.game.model.Cursor
import com.xmunch.game.model.Player
import com.xmunch.game.model.Screen


public class GlobalSpace {

    protected static GlobalSpace globalSpace

    boolean paused = false
    boolean isMouseClicked = false
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

    ArrayList<Screen> screens = new ArrayList<Screen>()

    public GlobalSpace(){}

    public static GlobalSpace getInstance() {
        return globalSpace
    }

    public void drawWorld() {
        Screen currentScreen = globalSpace.getScreens().get(currentScreen);
        println currentScreen.getName()
        currentScreen.draw()
    }

    Integer getAnimationFrame(Integer spritesNumber){
        if(game.frameCount % spritesNumber) return 0 else return 1
    }
}
