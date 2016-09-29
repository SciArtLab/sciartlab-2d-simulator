package com.xmunch.test

import processing.core.PApplet

import com.xmunch.game.GlobalSpace
import com.xmunch.game.model.Cursor
import com.xmunch.game.model.GridScreen
import com.xmunch.game.model.Player
import com.xmunch.game.model.Screen

public class TestGlobalSpace extends com.xmunch.game.CustomGlobalSpace {

    @Override
    public static GlobalSpace getInstance(PApplet game) {

        if (globalSpace == null) {
            globalSpace = new GlobalSpace()
            initializeGlobalSpace(game)
            globalSpace.setScreens(createScreens())
            globalSpace.setPlayer(new Player())
            globalSpace.setCursor(new Cursor())
        }

        return globalSpace
    }

    @Override
    protected static ArrayList<Screen> createScreens(){
        List<Screen> screens = new ArrayList<Screen>()
        Screen screen1 = new GridScreen("sandTexture.jpg")
        screens.add(screen1)
        return screens
    }
}