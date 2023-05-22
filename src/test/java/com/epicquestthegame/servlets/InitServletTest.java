package com.epicquestthegame.servlets;

import com.epicquestthegame.utils.Attribute;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
class InitServletTest {
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    ServletContext cont;
    RequestDispatcher disp;

    @BeforeEach
    void init() {
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        cont = Mockito.mock(ServletContext.class);
        disp = Mockito.mock(RequestDispatcher.class);
    }

    @Test
    void doGetMethod_allAttributesSetAndForwardingToStartJSPExpected() {
        Mockito.when(request.getSession(true)).thenReturn(session);
        Mockito.when(request.getRemoteAddr()).thenReturn("0");

        InitServlet servlet = new InitServlet() {
            @Override
            public ServletContext getServletContext() {
                return cont;
            }
        };
        Mockito.when(cont.getRequestDispatcher("/start")).thenReturn(disp);

        try {
            servlet.doGet(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

        Mockito.verify(session).setAttribute(Attribute.VICTORY_TIMES.getValue(), 0);
        Mockito.verify(session).setAttribute(Attribute.DEFEATED_TIMES.getValue(), 0);
        Mockito.verify(session).setAttribute(Attribute.IP.getValue(), "0");
        try {
            Mockito.verify(disp).forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}