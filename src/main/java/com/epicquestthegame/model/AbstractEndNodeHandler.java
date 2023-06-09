package com.epicquestthegame.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.epicquestthegame.utils.Attribute.*;

public abstract class AbstractEndNodeHandler implements Handler {
    protected String resultText;

    @Override
    public void handle(Node node, HttpServletRequest request) {
        HttpSession currentSession = request.getSession();
        resultText = handleResult(node);
        currentSession.setAttribute(RESULT_TEXT.getValue(), resultText);
    }

    protected abstract String handleResult(Node node);
}
