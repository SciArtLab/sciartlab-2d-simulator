package com.xmunch.game

import processing.core.PApplet

import com.xmunch.game.model.Cursor
import com.xmunch.game.model.GridScreen
import com.xmunch.game.model.Player
import com.xmunch.game.model.Screen

public class GlobalSpace {

    static GlobalSpace globalSpace
    ArrayList<Screen> screens = new ArrayList<Screen>()
    Boolean fullscreen
    float spaceWidth
    float spaceHeight
    PApplet game
    Player player
    Cursor cursor

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
        } else{
            globalSpace.setSpaceWidth(globalSpace.getGame().displayWidth)
            globalSpace.setSpaceHeight(globalSpace.getGame().displayHeight)
        }

        globalSpace.setScreens(createScreens())
        globalSpace.setPlayer(new Player())
        globalSpace.setCursor(new Cursor())
    }

    public void setup() {
        globalSpace.getScreens().get(0).setup()
    }

    public void draw() {
        globalSpace.getScreens().get(0).draw()
        globalSpace.getPlayer().draw()
        globalSpace.getCursor().draw()
    }

    private static ArrayList<Screen> createScreens(){
        List<Screen> screens = new ArrayList<Screen>()
        Screen screen1 = new GridScreen()
        screens.add(screen1)
        return screens
    }
}
