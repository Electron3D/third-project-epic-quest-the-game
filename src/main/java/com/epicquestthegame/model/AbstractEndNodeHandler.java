package com.epicquestthegame.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class AbstractEndNodeHandler implements Handler {
    protected String resultText;
    @Override
    public Node getThisNode() {
        return null;
    }

    @Override
    public void setNext(Handler handler) {

    }

    @Override
    public void handle(Node node, HttpServletRequest request) {
        HttpSession currentSession = request.getSession();
        resultText = handleResult(node);
        currentSession.setAttribute("resultText", resultText);
    }

    protected abstract String handleResult(Node node);
}
