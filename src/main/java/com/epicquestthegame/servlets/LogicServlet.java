package com.epicquestthegame.servlets;

import com.epicquestthegame.model.Game;
import com.epicquestthegame.model.Node;

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
        Game game = (Game) currentSession.getAttribute("game");
        Node nextNode = (Node) currentSession.getAttribute("nextNode");
        String gameEndString = req.getParameter("gameEnd");
        boolean gameEnd = "true".equals(gameEndString);
        if (!gameEnd) {
            game.getStartedNode().handle(nextNode, req);
        }
        resp.sendRedirect("/game.jsp");
    }
}
