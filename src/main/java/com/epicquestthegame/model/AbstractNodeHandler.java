package com.epicquestthegame.model;

public abstract class AbstractNodeHandler implements NodeHandler{
    protected NodeHandler nextNode;
    protected NodeHandler defeatNode;
    protected Node thisNode;
    private String eventDescription;
    private String positiveDecision;
    private String negativeDecision;

    public AbstractNodeHandler(NodeHandler defeatNode, Node thisNode) {
        this.defeatNode = defeatNode;
        this.thisNode = thisNode;
    }
    public void init(NodeHandler nextNode) {
        if (this.nextNode == null) {
            this.nextNode = nextNode;
            initStrings();
            return;
        }
        throw new IllegalStateException("Init method should be called only once!");
    }

    @Override
    public void handle(Node node, boolean decision) {
        if (node == thisNode) {
            handleDecision(decision);
        } else {
            nextNode.handle(node, decision);
        }
    }

    private void handleDecision(Boolean decision) {
        if (decision) {
            handleEvent(decision);
        } else {
            defeatNode.handle(thisNode, decision);
        }
    }
    protected abstract void handleEvent(Boolean decision);
}
