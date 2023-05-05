package com.epicquestthegame.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class NodeHandler implements Handler {
    protected Handler nextNodeHandler;
    protected Handler defeatNode;
    protected Node thisNode;

    public NodeHandler(Handler defeatNode, Node thisNode) {
        this.defeatNode = defeatNode;
        this.thisNode = thisNode;
    }

    @Override
    public Node getThisNode() {
        return thisNode;
    }

    @Override
    public void setNext(Handler nextNodeHandler) {
        this.nextNodeHandler = nextNodeHandler;
    }

    @Override
    public void handle(Node node, HttpServletRequest request) {
        HttpSession currentSession = request.getSession();
        if (node == thisNode) {
            handleDecision(request, currentSession);
        } else {
            nextNodeHandler.handle(node, request);
        }
    }

    private void handleDecision(HttpServletRequest request, HttpSession currentSession) {
        String decisionString = request.getParameter("decision");
        boolean decision = "true".equals(decisionString);
        if (decision) {
            handleEvent(request, currentSession);
        } else {
            currentSession.setAttribute("gameEnd", true);
            int defeatedTimes = (int) currentSession.getAttribute("defeatedTimes");
            currentSession.setAttribute("defeatedTimes", defeatedTimes + 1);
            defeatNode.handle(thisNode, request);
        }
    }
    protected void handleEvent(HttpServletRequest request, HttpSession currentSession) {
        Node nextNode = nextNodeHandler.getThisNode();
        if (nextNode != null) {
            currentSession.setAttribute("nextNode", nextNode);
        } else {
            int victoryTimes = (int) currentSession.getAttribute("victoryTimes");
            currentSession.setAttribute("victoryTimes", victoryTimes + 1);
            currentSession.setAttribute("gameEnd", true);
            nextNodeHandler.handle(thisNode, request);
        }
    }
}
