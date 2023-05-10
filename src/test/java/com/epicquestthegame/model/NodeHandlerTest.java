package com.epicquestthegame.model;

import com.epicquestthegame.model.endNodes.DefeatNodeHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NodeHandlerTest {
    Node thisNode;
    Node nextNode;
    Handler defeatNode;
    Handler nodeHandler;
    Handler nextNodeHandler;
    HttpServletRequest request;
    HttpSession session;

    @BeforeEach
    void init() {
        thisNode = Mockito.mock(Node.class);
        nextNode = Mockito.mock(Node.class);
        defeatNode = Mockito.mock(DefeatNodeHandler.class);
        nextNodeHandler = Mockito.mock(NodeHandler.class);

        nodeHandler = new NodeHandler(defeatNode, thisNode);
        nodeHandler.setNext(nextNodeHandler);

        request = Mockito.mock(HttpServletRequest.class);
        session = Mockito.mock(HttpSession.class);
    }

    @Test
    void getThisNodeMethod_thisNodeProvided_theSameNodeExpected() {
        assertEquals(thisNode, nodeHandler.getThisNode());
    }

    @Test
    void setNextMethod_nextHandlerProvidedAndSet_theSameHandlerExpected() throws NoSuchFieldException,
            IllegalAccessException {
        final Field field = nodeHandler.getClass().getDeclaredField("nextNodeHandler");
        field.setAccessible(true);
        assertEquals(nextNodeHandler, field.get(nodeHandler));
    }

    @Test
    void handleMethod_nodeIsThisNode_decisionIsTrue_nextNodeHandlerProvided_nextNodeAttributeSetExpected() {
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(request.getParameter("decision")).thenReturn("true");
        Mockito.when(nextNodeHandler.getThisNode()).thenReturn(nextNode);

        nodeHandler.handle(thisNode, request);

        Mockito.verify(session).setAttribute("nextNode", nextNode);
    }

    @Test
    void handleMethod_nodeIsNotThisNode_nextNodeHandlerHandleMethodCallExpected() {
        nodeHandler.handle(nextNode, request);

        Mockito.verify(nextNodeHandler).handle(nextNode, request);
    }

    @Test
    void handleMethod_nodeIsThisNode_decisionIsFalse_defeatActionsExpected() {
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(request.getParameter("decision")).thenReturn("false");
        Mockito.when(session.getAttribute("defeatedTimes")).thenReturn(0);

        nodeHandler.handle(thisNode, request);

        Mockito.verify(session).setAttribute("gameEnd", true);
        Mockito.verify(session).setAttribute("defeatedTimes", 1);
        Mockito.verify(defeatNode).handle(thisNode, request);
    }

    @Test
    void handleMethod_nodeIsThisNode_decisionIsTrue_nextNodeHandlerNullProvided_victoryActionsExpected() {
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(request.getParameter("decision")).thenReturn("true");
        Mockito.when(nextNodeHandler.getThisNode()).thenReturn(null);
        Mockito.when(session.getAttribute("victoryTimes")).thenReturn(0);

        nodeHandler.handle(thisNode, request);

        Mockito.verify(session).setAttribute("victoryTimes", 1);
        Mockito.verify(session).setAttribute("gameEnd", true);
        Mockito.verify(nextNodeHandler).handle(thisNode, request);
    }
}