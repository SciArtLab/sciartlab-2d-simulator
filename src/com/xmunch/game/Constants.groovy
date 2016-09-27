package com.xmunch.game

class Constants {

    //Game configuration
    public final static boolean FULL_SCREEN_DEFAULT = false //todo: ver que pasa con los buenos
    public final static int HEIGHT = 700
    public final static int WIDTH = 700
    public final static int OBJECT_SIZE = 25
    public final static float FRAME_RATE = 10
    public final static DEFAULT_CUR_MSG = "..."
    public final static CELL_SIZE = OBJECT_SIZE

    //Player configuration
    public final static int AGENT_SPEED = OBJECT_SIZE
    public final static int AGENT_WIDTH = OBJECT_SIZE
    public final static int AGENT_HEIGHT = OBJECT_SIZE

    //Agents configuration
    public final static int AGENTS_NUMBER = 50
    public final static float NEIGHBOR_DISTANCE = 3*OBJECT_SIZE

    //Keys codes
    public final static KEY_SPACE = 32

}
