package com.xmunch.game

class Constants {

    //Game configuration
    public final static boolean FULL_SCREEN_DEFAULT = false //todo: ver que pasa con los buenos
    public final static int HEIGHT = 500
    public final static int WIDTH = 500
    public final static int OBJECT_SIZE = 10
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
    public final static KEY_UP = 40
    public final static KEY_DOWN =38
    public final static KEY_LEFT =37
    public final static KEY_RIGHT =39

}
