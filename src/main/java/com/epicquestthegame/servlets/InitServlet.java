package com.epicquestthegame.servlets;

import com.epicquestthegame.model.Game;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Game game = new Game();
        req.setAttribute("game", game);
        getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
    }
}
