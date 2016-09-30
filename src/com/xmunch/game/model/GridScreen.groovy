package com.xmunch.game.model

import com.xmunch.game.Constants
import com.xmunch.game.utils.GameUtils


public class GridScreen extends Screen {

    String backgroundImage

    public GridScreen(){
        super()
    }

    public GridScreen(String backgroundImage){
        super()
        this.backgroundImage = backgroundImage
    }


    @Override
    void setup(){
    }

    @Override
    void draw() {

        if(global.getShowBackground()){
            game.background(red, green, blue)

            if(backgroundImage != null && backgroundImage.length() != 0){

                String image = backgroundImage
                if(GameUtils.getImage(global, image) == null)
                    GameUtils.setImage(global, image)

                global.getGame().image(GameUtils.getImage(global, image), 0, 0, global.getSpaceWidth(), global.getSpaceHeight())
            }
        } else if (global.getShowGrid()){


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

        super.draw()
    }
}

