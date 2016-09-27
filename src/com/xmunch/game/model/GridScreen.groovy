package com.xmunch.game.model

import com.xmunch.game.Constants


public class GridScreen extends Screen {

    public GridScreen(){
        super()
    }

    @Override
    void setup(){
    }

    @Override
    void draw() {
        game.background(red, green, blue)

        for(int i = 0; i < global.getSpaceWidth(); i = i + Constants.CELL_SIZE){
            for(int j = 0; j < global.getSpaceHeight(); j = j + Constants.CELL_SIZE){
                //game.text(cellIndex, i + Constants.CELL_SIZE/2-1, j + Constants.CELL_SIZE/2-1 )
                game.strokeWeight(0.5)
                if(i == 0 || i == global.getSpaceWidth() - Constants.CELL_SIZE ||
                j == 0 || j == global.getSpaceHeight() - Constants.CELL_SIZE ){
                    game.stroke(0,255,255)
                    game.fill(10,50,70)
                } else {
                    game.stroke(0,245,245)
                    game.fill(0,0,0)
                }

                game.rect(i, j, Constants.CELL_SIZE, Constants.CELL_SIZE)
            }
        }
    }
}

