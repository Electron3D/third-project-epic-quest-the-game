package com.epicquestthegame.model;

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

    public Node getThisNode() {
        return thisNode;
    }
    public void init(NodeHandler nextNode) {
        if (this.nextNode == null) {
            this.nextNode = nextNode;
            return;
        }
        throw new IllegalStateException("Init method should be called only once!");
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
            defeatNode.handle(thisNode, request);
        }
    }
    protected void handleEvent(HttpSession currentSession) {
        AbstractNodeHandler nextNodeHandler = (AbstractNodeHandler) nextNode;
        currentSession.setAttribute("nextNode", nextNodeHandler.getThisNode());
    }
}
