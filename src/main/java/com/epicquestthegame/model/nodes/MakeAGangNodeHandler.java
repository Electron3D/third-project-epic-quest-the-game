package com.epicquestthegame.model.nodes;

import com.epicquestthegame.model.AbstractNodeHandler;
import com.epicquestthegame.model.Node;
import com.epicquestthegame.model.NodeHandler;

public class MakeAGangNodeHandler extends AbstractNodeHandler {

    public MakeAGangNodeHandler(NodeHandler defeatNode) {
        super(defeatNode, Node.MAKE_A_GANG);
    }

    @Override
    protected void handleEvent(Boolean decision) {

    }

    @Override
    public void initStrings() {

    }
}
