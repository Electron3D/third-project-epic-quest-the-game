package com.epicquestthegame.model.nodes;

import com.epicquestthegame.model.AbstractNodeHandler;
import com.epicquestthegame.model.Node;
import com.epicquestthegame.model.NodeHandler;

import javax.servlet.http.HttpSession;

public class MakeAGangNodeHandler extends AbstractNodeHandler {

    public MakeAGangNodeHandler(NodeHandler defeatNode) {
        super(defeatNode, Node.MAKE_A_GANG);
    }

    @Override
    protected void handleEvent(HttpSession currentSession) {

    }
}
