package com.epicquestthegame.model.nodes;

import com.epicquestthegame.model.AbstractNodeHandler;
import com.epicquestthegame.model.Node;
import com.epicquestthegame.model.NodeHandler;

import javax.servlet.http.HttpSession;

public class KillTheKingNodeHandler extends AbstractNodeHandler {
    public KillTheKingNodeHandler(NodeHandler defeatNode) {
        super(defeatNode, Node.KILL_THE_KING);
    }

    @Override
    protected void handleEvent(HttpSession currentSession) {

    }
}
