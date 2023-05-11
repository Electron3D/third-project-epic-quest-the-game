package com.epicquestthegame.servlets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

class StartServletTest {
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;

    @BeforeEach
    void init() {
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
    }

    @Test
    void doGet() {
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(request.getParameter("gamerName")).thenReturn("gamer");

        StartServlet servlet = new StartServlet();
        try {
            servlet.doGet(request, response);

            /*It's needed to add more verifications
            Mockito.verify(session).setAttribute("game", game);
            Mockito.verify(session).setAttribute("currentNode", firstNode);
            Mockito.verify(session).setAttribute("nextNode", firstNode);*/
            Mockito.verify(session).setAttribute("gameEnd", false);
            Mockito.verify(response).sendRedirect("/game.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}