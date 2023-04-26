package com.epicquestthegame.model.nodes;

import com.epicquestthegame.model.Node;
import com.epicquestthegame.model.NodeHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DefeatNodeHandler implements NodeHandler {
    private static final String DEFEAT_TEXT = "Пупупу, ну ты проиграл, вот и все ребята!";

    public String getDefeatText(Node lastNode) {
        return lastNode.getDefeatText() + DEFEAT_TEXT;
    }

    @Override
    public void handle(Node node, HttpServletRequest request) {
        HttpSession currentSession = request.getSession();
        currentSession.setAttribute("defeatText", getDefeatText(node));
    }
}
