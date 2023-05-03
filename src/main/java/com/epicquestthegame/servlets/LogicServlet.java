package com.epicquestthegame.servlets;

import com.epicquestthegame.model.Node;
import com.epicquestthegame.model.NodeHandler;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession currentSession = req.getSession();
        NodeHandler firstNodeHandler = (NodeHandler) currentSession.getAttribute("firstNodeHandler");
        Node nextNode = (Node) currentSession.getAttribute("nextNode");
        firstNodeHandler.handle(nextNode, req);
        resp.sendRedirect("/game.jsp");
    }
}
