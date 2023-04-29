package com.epicquestthegame.model;

import com.epicquestthegame.model.endNodes.VictoryNodeHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class AbstractNodeHandler implements NodeHandler{
    protected NodeHandler nextNode;
    protected NodeHandler defeatNode;
    protected Node thisNode;

    public AbstractNodeHandler(NodeHandler defeatNode, Node thisNode) {
        this.defeatNode = defeatNode;
        this.thisNode = thisNode;
    }

    @Override
    public Node getThisNode() {
        return thisNode;
    }

    @Override
    public void setNext(NodeHandler nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public void handle(Node node, HttpServletRequest request) {
        HttpSession currentSession = request.getSession();
        if (node == thisNode) {
            handleDecision(request, currentSession);
        } else {
            nextNode.handle(node, request);
        }
    }

    private void handleDecision(HttpServletRequest request, HttpSession currentSession) {
        String decisionString = request.getParameter("decision");
        boolean decision = "true".equals(decisionString);
        if (decision) {
            handleEvent(currentSession);
        } else {
            currentSession.setAttribute("gameEnd", true);
            defeatNode.handle(thisNode, request);
        }
    }
    protected void handleEvent(HttpSession currentSession) {
        NodeHandler nextNodeHandler;
        if (nextNode instanceof VictoryNodeHandler) {
            nextNodeHandler = this;
            currentSession.setAttribute("gameEnd", true);
        } else {
            nextNodeHandler =  nextNode;
        }
        currentSession.setAttribute("nextNode", nextNodeHandler.getThisNode());
    }
}
