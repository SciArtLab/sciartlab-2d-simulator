package com.xmunch.game.model

import com.xmunch.game.utils.GameUtils
import com.xmunch.game.utils.behavior.ActuatorBehaviorUtils
import com.xmunch.game.utils.behavior.BiologicalBehaviorUtils
import com.xmunch.game.utils.behavior.MotorBehaviorUtils
import com.xmunch.game.utils.behavior.SensorBehaviorUtils


public class Agent extends PObject {

    protected String type

    public Agent(String type, String state){
        super()
        this.type = type
        this.state = state
        GameUtils.initializeAgent(this)
    }

    public Agent(){
        super()
        GameUtils.initializeAgent(this)
    }


    void draw() {
        GameUtils.drawAgent(this)
        live()
    }

    //Biological

    void live(){
        BiologicalBehaviorUtils.live(this)
    }

    void die(){
        BiologicalBehaviorUtils.die(this)
    }

    // Sensor
    boolean isNeighbor(float x, float y){
        return SensorBehaviorUtils.isNeighbor(this, x, y)
    }

    boolean isClickedByMouse()  {
        return SensorBehaviorUtils.isClickedByMouse(this)
    }

    //Motor
    void moveRandomly(){
        MotorBehaviorUtils.moveRandomly(this)
    }

    void moveUp(){
        MotorBehaviorUtils.moveUp(this)
    }

    void moveDown(){
        MotorBehaviorUtils.moveDown(this)
    }

    void moveLeftUp(){
        MotorBehaviorUtils.moveLeftUp(this)
    }

    void moveLeftDown(){
        MotorBehaviorUtils.moveLeftDown(this)
    }

    void moveRightUp(){
        MotorBehaviorUtils.moveRightUp(this)
    }

    void moveRightDown(){
        MotorBehaviorUtils.moveRightDown(this)
    }

    void moveLeft(){
        MotorBehaviorUtils.moveLeft(this)
    }

    void moveRight(){
        MotorBehaviorUtils.moveRight(this)
    }

    //Actuator
    void eraseEnvironment(){
        ActuatorBehaviorUtils.eraseEnvironment(this)
    }

}
