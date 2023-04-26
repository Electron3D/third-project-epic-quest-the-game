package com.epicquestthegame.model.nodes;

import com.epicquestthegame.model.Node;
import com.epicquestthegame.model.NodeHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class VictoryNodeHandler implements NodeHandler {
    private static final String VICTORY_TEXT = "Победа, ты король мира!";

    @Override
    public void handle(Node node, HttpServletRequest request) {
        HttpSession currentSession = request.getSession();
        currentSession.setAttribute("victoryText", VICTORY_TEXT);
    }
}