package com.xmunch.game.model

public class PotentialCollition {

    float x, y, width, height
    Boolean collide

    public PotentialCollition(x, y, width, height){
        this.x = x
        this.y = y
        this.width = width
        this.height = height
    }

    public String toString(){
        return "x:"+x+" y:"+y+" width:"+width+" height:"+height
    }

    public void collide(referenceX, referenceY){
        Boolean a = (referenceX >= x)
        Boolean b = ((referenceX <= (x + width)))
        Boolean c = (referenceY >= y)
        Boolean d = (referenceY <= (y + height))
        Boolean e = a && b && c && d

        this.collide = e
    }
}
