package com.xmunch.game.model

import com.xmunch.game.utils.GameUtils



public class Player extends Agent {

    public Player(){
        super()
        GameUtils.initializePlayer(this)
    }

    void draw() {
        GameUtils.drawPlayer(this)
    }
}
