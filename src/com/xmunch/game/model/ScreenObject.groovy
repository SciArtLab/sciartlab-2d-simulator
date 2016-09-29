package com.xmunch.game.model

import com.xmunch.game.utils.GameUtils


public class ScreenObject extends PObject {

    protected String type

    public ScreenObject(String type, String state){
        super()
        this.type = type
        this.state = state
        GameUtils.initializeScreenObject(this)
    }

    public ScreenObject(){
        super()
        GameUtils.initializeScreenObject(this)
    }

    void draw() {
        GameUtils.drawScreenObject(this)
    }
}
