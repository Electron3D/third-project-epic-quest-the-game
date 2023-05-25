package com.epicquestthegame.model;

public class Game {
    private final Handler startedNode;
    private final String gamerName;

    public Game(Handler startedNodeHandler, String gamerName) {
        this.startedNode = startedNodeHandler;
        this.gamerName = gamerName;
    }

    public Handler getStartedNode() {
        return startedNode;
    }

    public String getGamerName() {
        return gamerName;
    }
}