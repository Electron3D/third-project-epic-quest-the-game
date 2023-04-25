package com.epicquestthegame.model;

import com.epicquestthegame.model.nodes.*;

import java.util.ArrayList;

public class Game {
    public static void createGame() {
        NodeHandler defeatNodeHandler = new DefeatNodeHandler();

        AbstractNodeHandler prisonNodeHandler = new PrisonNodeHandler(defeatNodeHandler);
        AbstractNodeHandler makeAGangNodeHandler = new MakeAGangNodeHandler(defeatNodeHandler);
        AbstractNodeHandler succubusNodeHandler = new SuccubusNodeHandler(defeatNodeHandler);
        AbstractNodeHandler killTheKingNodeHandler = new KillTheKingNodeHandler(defeatNodeHandler);

        prisonNodeHandler.init(makeAGangNodeHandler);
        makeAGangNodeHandler.init(succubusNodeHandler);
        succubusNodeHandler.init(killTheKingNodeHandler);
        killTheKingNodeHandler.init(defeatNodeHandler);
    }
}
