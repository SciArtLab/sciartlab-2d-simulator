package com.xmunch.test.network

import processing.core.PApplet

import com.xmunch.game.GlobalSpace
import com.xmunch.game.model.Screen

public class TestGlobalSpace extends com.xmunch.game.CustomGlobalSpace {

    @Override
    public static GlobalSpace getInstance(PApplet game) {

        if (globalSpace == null) {
            globalSpace = new GlobalSpace()
            initializeGlobalSpace(game)
            globalSpace.setScreens(createScreens())
        }

        return globalSpace
    }

    @Override
    protected static ArrayList<Screen> createScreens(){
        List<Screen> screens = new ArrayList<Screen>()
        Screen screen1 = new TestScreen()
        screens.add(screen1)
        return screens
    }
}
