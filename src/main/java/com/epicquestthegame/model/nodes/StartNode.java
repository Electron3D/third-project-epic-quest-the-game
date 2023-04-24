package com.epicquestthegame.model.nodes;

import com.epicquestthegame.model.AbstractNode;
import com.epicquestthegame.model.Node;

public class StartNode extends AbstractNode {

    public StartNode(AbstractNode nextNode, String text) {
        super(nextNode, text);
    }

    @Override
    public AbstractNode go(Node node, boolean decision) {
        return null;
    }
}
