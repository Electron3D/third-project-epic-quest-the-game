package com.epicquestthegame.model.nodes;

import com.epicquestthegame.model.AbstractNodeHandler;
import com.epicquestthegame.model.Node;
import com.epicquestthegame.model.NodeHandler;

public class PrisonNodeHandler extends AbstractNodeHandler {

    public PrisonNodeHandler(NodeHandler defeatNode) {
        super(defeatNode, Node.PRISON);
    }

    @Override
    protected void handleEvent(Boolean decision) {

    }

    @Override
    public void initStrings() {

    }
}
