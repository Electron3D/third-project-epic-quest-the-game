package com.epicquestthegame.model;

import javax.servlet.http.HttpServletRequest;

public interface Handler {
    void handle(Node node, HttpServletRequest request);
    void setNext(Handler handler);
    Node getThisNode();
}
