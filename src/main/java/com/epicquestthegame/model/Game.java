package com.epicquestthegame.model;

public class Game {
    private final NodeHandler startedNode;
    private final String gamerName;

    public Game(NodeHandler startedNodeHandler, String gamerName) {
        this.startedNode = startedNodeHandler;
        this.gamerName = gamerName;
    }

    public NodeHandler getStartedNode() {
        return startedNode;
    }

    public String getGamerName() {
        return gamerName;
    }
}