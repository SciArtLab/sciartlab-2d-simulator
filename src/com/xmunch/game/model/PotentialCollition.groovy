package com.xmunch.game.model

public class PotentialCollition {

    float x, y, width, height

    public PotentialCollition(x, y, width, height){
        this.x = x
        this.y = y
        this.width = width
        this.height = height
    }

    public String toString(){
        return "x:"+x+" y:"+y+" width:"+width+" height:"+height
    }
}
