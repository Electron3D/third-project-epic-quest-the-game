package com.epicquestthegame.model;

import com.epicquestthegame.model.endNodes.DefeatNodeHandler;

import javax.servlet.http.HttpServletRequest;

public interface Handler {
    Handler DEFEAT_HANDLER = new DefeatNodeHandler();
    void handle(Node node, HttpServletRequest request);
    Node getNode();
}
