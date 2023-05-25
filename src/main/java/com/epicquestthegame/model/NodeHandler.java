package com.epicquestthegame.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.epicquestthegame.utils.Attribute.*;

public class NodeHandler implements Handler {
    protected final Handler nextNodeHandler;
    protected final Handler defeatNodeHandler;
    protected Node thisNode;

    public NodeHandler(Node thisNode, Handler nextNodeHandler) {
        this.defeatNodeHandler = DEFEAT_HANDLER;
        this.thisNode = thisNode;
        this.nextNodeHandler = nextNodeHandler;
    }

    public Handler getNextNodeHandler() {
        return nextNodeHandler;
    }

    @Override
    public Node getNode() {
        return thisNode;
    }

    @Override
    public void handle(Node node, HttpServletRequest request) {
        if (node == thisNode) {
            handleDecision(request);
        } else {
            nextNodeHandler.handle(node, request);
        }
    }

    private void handleDecision(HttpServletRequest request) {
        HttpSession currentSession = request.getSession();
        String decisionString = request.getParameter(DECISION.getValue());
        boolean decision = Boolean.TRUE.toString().equals(decisionString);
        if (decision) {
            handleEvent(request);
        } else {
            currentSession.setAttribute(GAME_END.getValue(), true);
            int defeatedTimes = (int) currentSession.getAttribute(DEFEATED_TIMES.getValue());
            currentSession.setAttribute(DEFEATED_TIMES.getValue(), defeatedTimes + 1);
            defeatNodeHandler.handle(thisNode, request);
        }
    }
    protected void handleEvent(HttpServletRequest request) {
        Node nextNode = nextNodeHandler.getNode();
        HttpSession currentSession = request.getSession();
        if (nextNode != null) {
            currentSession.setAttribute(NEXT_NODE.getValue(), nextNode);
        } else {
            int victoryTimes = (int) currentSession.getAttribute(VICTORY_TIMES.getValue());
            currentSession.setAttribute(VICTORY_TIMES.getValue(), victoryTimes + 1);
            currentSession.setAttribute(GAME_END.getValue(), true);
            nextNodeHandler.handle(thisNode, request);
        }
    }
}
