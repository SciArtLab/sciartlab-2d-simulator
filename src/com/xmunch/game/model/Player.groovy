package com.xmunch.game.model

import com.xmunch.game.utils.GameUtils



public class Player extends Agent {

    public Player(String type, String state){
        super()
        this.type = type
        this.state = state
        GameUtils.initializePlayer(this)
    }

    public Player(){
        super()
        GameUtils.initializePlayer(this)
    }

    void draw() {
        GameUtils.drawPlayer(this)
    }
}
