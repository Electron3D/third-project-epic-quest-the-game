package com.epicquestthegame.model;

import com.epicquestthegame.model.endNodes.DefeatNodeHandler;
import com.epicquestthegame.model.endNodes.VictoryNodeHandler;
import com.epicquestthegame.model.nodes.*;

public class Game {
    private NodeHandler startedNode;
    private String gamerName;

    public Game(String gamerName) {
        this.gamerName = gamerName;
        NodeHandler victoryNodeHandler = new VictoryNodeHandler();
        NodeHandler defeatNodeHandler = new DefeatNodeHandler();

        NodeHandler prisonNodeHandler = new PrisonNodeHandler(defeatNodeHandler);
        NodeHandler makeAGangNodeHandler = new MakeAGangNodeHandler(defeatNodeHandler);
        NodeHandler succubusNodeHandler = new SuccubusNodeHandler(defeatNodeHandler);
        NodeHandler killTheKingNodeHandler = new KillTheKingNodeHandler(defeatNodeHandler);

        prisonNodeHandler.setNext(makeAGangNodeHandler);
        makeAGangNodeHandler.setNext(succubusNodeHandler);
        succubusNodeHandler.setNext(killTheKingNodeHandler);
        killTheKingNodeHandler.setNext(victoryNodeHandler);

        startedNode = prisonNodeHandler;
    }

    public NodeHandler getStartedNode() {
        return startedNode;
    }

    public String getGamerName() {
        return gamerName;
    }
}
