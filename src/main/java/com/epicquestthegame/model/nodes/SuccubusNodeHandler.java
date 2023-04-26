package com.epicquestthegame.model.nodes;

import com.epicquestthegame.model.AbstractNodeHandler;
import com.epicquestthegame.model.Node;
import com.epicquestthegame.model.NodeHandler;

import javax.servlet.http.HttpSession;

public class SuccubusNodeHandler extends AbstractNodeHandler {

    public SuccubusNodeHandler(NodeHandler defeatNode) {
        super(defeatNode, Node.SUCCUBUS);
    }

    @Override
    protected void handleEvent(HttpSession currentSession) {

    }
}
