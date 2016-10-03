package com.xmunch.test.network

import com.xmunch.game.model.Agent


public class TestAgent extends Agent {


    @Override
    void draw() {

        global.game.strokeWeight(3)
        global.game.stroke(0, 255, 0, 255)
        global.game.fill(0, 255, 0, 100)
        global.game.ellipse(centerX, centerY, width, height)
        live()
        global.game.smooth()
    }
}
