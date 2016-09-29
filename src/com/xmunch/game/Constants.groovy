package com.xmunch.game

class Constants {

    //Game configuration
    public final static boolean FULL_SCREEN_DEFAULT = false //todo: ver que pasa con los buenos
    public final static int HEIGHT = 700
    public final static int WIDTH = 700
    public final static int ELEMENT_SIZE = 100
    public final static float FRAME_RATE = 60
    public final static DEFAULT_CUR_MSG = "..."
    public final static CELL_SIZE = ELEMENT_SIZE

    //Player configuration
    public final static String DEFAULT_PLAYER_TYPE = "ant"
    public final static String PLAYER_SPRITES_FOLDER = "images/agent/"

    //Agents configuration
    public final static int AGENT_SPEED = ELEMENT_SIZE/10
    public final static int AGENT_WIDTH = ELEMENT_SIZE/2
    public final static int AGENT_HEIGHT = ELEMENT_SIZE/2
    public final static int AGENTS_NUMBER = 100
    public final static float NEIGHBOR_DISTANCE = 3*ELEMENT_SIZE
    public final static String DEFAULT_AGENT_TYPE = "ant"
    public final static String DEFAULT_AGENT_STATE =  "UP"
    public final static String AGENT_SPRITES_FOLDER = "images/agent/"


    //Objects configuration
    public final static int OBJECT_WIDTH = ELEMENT_SIZE/2
    public final static int OBJECT_HEIGHT = ELEMENT_SIZE/2
    public final static int OBJECTS_NUMBER = 20
    public final static String DEFAULT_OBJECT_TYPE = "stone"
    public final static String DEFAULT_OBJECT_STATE =  "STATIC"
    public final static String OBJECT_SPRITES_FOLDER = "images/object/"

    //Keys codes
    public final static KEY_SPACE = 32
    public final static KEY_G = 71
    public final static KEY_N = 78
    public final static KEY_A = 65
    public final static KEY_S = 83
    public final static KEY_B = 66
    public final static KEY_M = 77
    public final static KEY_L = 76

}
