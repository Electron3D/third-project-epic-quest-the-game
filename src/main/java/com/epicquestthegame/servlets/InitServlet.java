package com.epicquestthegame.servlets;

import com.epicquestthegame.model.Game;
import com.epicquestthegame.model.Node;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession currentSession = req.getSession(true);
        String name = req.getParameter("gamerName");
        Game game = new Game(name);
        Node firstNode = game.getStartedNode().getThisNode();
        currentSession.setAttribute("game", game);
        currentSession.setAttribute("nextNode", firstNode);
        getServletContext().getRequestDispatcher("/logic").forward(req, resp);
    }
}
