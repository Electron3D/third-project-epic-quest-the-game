package com.epicquestthegame.model;

import com.epicquestthegame.model.nodes.*;

public class Game {
    private NodeHandler startedNode;
    private String gamerName;

    public Game(String gamerName) {
        this.gamerName = gamerName;
    }

    public void createGame() {
        NodeHandler victoryNodeHandler = new VictoryNodeHandler();
        NodeHandler defeatNodeHandler = new DefeatNodeHandler();

        AbstractNodeHandler prisonNodeHandler = new PrisonNodeHandler(defeatNodeHandler);
        AbstractNodeHandler makeAGangNodeHandler = new MakeAGangNodeHandler(defeatNodeHandler);
        AbstractNodeHandler succubusNodeHandler = new SuccubusNodeHandler(defeatNodeHandler);
        AbstractNodeHandler killTheKingNodeHandler = new KillTheKingNodeHandler(defeatNodeHandler);

        prisonNodeHandler.init(makeAGangNodeHandler);
        makeAGangNodeHandler.init(succubusNodeHandler);
        succubusNodeHandler.init(killTheKingNodeHandler);
        killTheKingNodeHandler.init(defeatNodeHandler);

        startedNode = prisonNodeHandler;
    }

    public NodeHandler getStartedNode() {
        return startedNode;
    }

    public String getGamerName() {
        return gamerName;
    }
}
