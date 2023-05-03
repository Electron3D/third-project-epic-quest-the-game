package com.epicquestthegame.servlets;

import com.epicquestthegame.model.Game;
import com.epicquestthegame.model.Node;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "StartServlet", value = "/start")
public class StartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession currentSession = req.getSession();
        String name = (String) currentSession.getAttribute("gamerName");
        Game game = new Game(name);
        Node firstNode = game.getStartedNode().getThisNode();
        currentSession.setAttribute("game", game);
        currentSession.setAttribute("currentNode", firstNode);
        currentSession.setAttribute("nextNode", firstNode);

        currentSession.setAttribute("gameEnd", false);
        resp.sendRedirect("/game.jsp");
    }
}
