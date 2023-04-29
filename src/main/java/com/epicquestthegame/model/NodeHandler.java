package com.epicquestthegame.model;

import javax.servlet.http.HttpServletRequest;

public interface NodeHandler {
    void handle(Node node, HttpServletRequest request);
    void setNext(NodeHandler handler);
    Node getThisNode();
}
