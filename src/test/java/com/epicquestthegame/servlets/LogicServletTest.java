package com.epicquestthegame.servlets;

import com.epicquestthegame.model.Game;
import com.epicquestthegame.model.Handler;
import com.epicquestthegame.model.Node;
import com.epicquestthegame.utils.Attribute;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

class LogicServletTest {
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    Game game;
    Handler firstNodeHandler;
    Node nextNode;

    @BeforeEach
    void init() {
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        game = Mockito.mock(Game.class);
        firstNodeHandler = Mockito.mock(Handler.class);
        nextNode = Mockito.mock(Node.class);
    }

    @Test
    void doGetMethod_handleMethodInvocationAndRedirectToGameJSPExpected() {
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(session.getAttribute(Attribute.GAME.getValue())).thenReturn(game);
        Mockito.when(game.getStartedNode()).thenReturn(firstNodeHandler);
        Mockito.when(session.getAttribute(Attribute.NEXT_NODE.getValue())).thenReturn(nextNode);

        LogicServlet servlet = new LogicServlet();
        try {
            servlet.doGet(request, response);

            Mockito.verify(firstNodeHandler).handle(nextNode, request);
            Mockito.verify(response).sendRedirect("/game.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}