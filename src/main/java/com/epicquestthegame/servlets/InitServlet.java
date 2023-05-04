package com.epicquestthegame.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "InitServlet", value = "/init")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession(true);
        currentSession.setAttribute("victoryTimes", 0);
        currentSession.setAttribute("defeatedTimes", 0);
        String ip = req.getRemoteAddr();
        currentSession.setAttribute("ip", ip);
        getServletContext().getRequestDispatcher("/start").forward(req, resp);
    }
}