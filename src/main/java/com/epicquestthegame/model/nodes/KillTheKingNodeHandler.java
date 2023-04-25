package com.epicquestthegame.model.nodes;

import com.epicquestthegame.model.AbstractNodeHandler;
import com.epicquestthegame.model.Node;
import com.epicquestthegame.model.NodeHandler;

public class KillTheKingNodeHandler extends AbstractNodeHandler {
    public KillTheKingNodeHandler(NodeHandler defeatNode) {
        super(defeatNode, Node.KILL_THE_KING);
    }

    @Override
    public void initStrings() {

    }

    @Override
    protected void handleEvent(Boolean decision) {

    }
}
