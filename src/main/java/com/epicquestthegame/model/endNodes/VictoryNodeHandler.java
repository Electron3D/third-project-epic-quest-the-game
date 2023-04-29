package com.epicquestthegame.model.endNodes;

import com.epicquestthegame.model.AbstractEndNodeHandler;
import com.epicquestthegame.model.Node;

public class VictoryNodeHandler extends AbstractEndNodeHandler {
    private static final String VICTORY_TEXT = "Победа, ты король мира!";

    @Override
    public String handleResult(Node node) {
        return VICTORY_TEXT;
    }
}