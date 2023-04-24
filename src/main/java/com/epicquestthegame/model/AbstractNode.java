package com.epicquestthegame.model;

import java.util.Map;

public abstract class AbstractNode {
    public AbstractNode(AbstractNode nextNode, String text) {
        this.nextNode = nextNode;
        this.text = text;
    }

    private AbstractNode nextNode;
    private String text;
    public abstract AbstractNode go(Node node, boolean decision);
}
