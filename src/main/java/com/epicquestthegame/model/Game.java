package com.epicquestthegame.model;

import com.epicquestthegame.model.nodes.*;

public class Game {
    private AbstractNodeHandler startedNode;
    private String gamerName;

    public Game(String gamerName) {
        this.gamerName = gamerName;
        NodeHandler victoryNodeHandler = new VictoryNodeHandler();
        NodeHandler defeatNodeHandler = new DefeatNodeHandler();

        AbstractNodeHandler prisonNodeHandler = new PrisonNodeHandler(defeatNodeHandler);
        AbstractNodeHandler makeAGangNodeHandler = new MakeAGangNodeHandler(defeatNodeHandler);
        AbstractNodeHandler succubusNodeHandler = new SuccubusNodeHandler(defeatNodeHandler);
        AbstractNodeHandler killTheKingNodeHandler = new KillTheKingNodeHandler(defeatNodeHandler);

        prisonNodeHandler.init(makeAGangNodeHandler);
        makeAGangNodeHandler.init(succubusNodeHandler);
        succubusNodeHandler.init(killTheKingNodeHandler);
        killTheKingNodeHandler.init(victoryNodeHandler);

        startedNode = prisonNodeHandler;
    }

    public AbstractNodeHandler getStartedNode() {
        return startedNode;
    }

    public String getGamerName() {
        return gamerName;
    }
}
