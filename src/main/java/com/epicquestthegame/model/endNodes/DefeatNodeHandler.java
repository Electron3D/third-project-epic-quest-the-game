package com.epicquestthegame.model.endNodes;

import com.epicquestthegame.model.AbstractEndNodeHandler;
import com.epicquestthegame.model.Node;

public class DefeatNodeHandler extends AbstractEndNodeHandler {
    private static final String DEFEAT_TEXT = "Поражение! ";

    @Override
    public String handleResult(Node node) {
        return DEFEAT_TEXT + node.getDefeatText();
    }

    @Override
    public Node getNode() {
        return null;
    }
}
