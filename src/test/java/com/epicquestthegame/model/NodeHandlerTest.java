package com.epicquestthegame.model;

import com.epicquestthegame.utils.Attribute;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NodeHandlerTest {
    Node thisNode;
    Node nextNode;
    NodeHandler nodeHandler;
    Handler nextNodeHandler;
    HttpServletRequest request;
    HttpSession session;

    @BeforeEach
    void init() {
        thisNode = Mockito.mock(Node.class);
        nextNode = Mockito.mock(Node.class);
        nextNodeHandler = Mockito.mock(NodeHandler.class);

        nodeHandler = new NodeHandler(thisNode, nextNodeHandler);

        request = Mockito.mock(HttpServletRequest.class);
        session = Mockito.mock(HttpSession.class);
    }

    @Test
    void getThisNodeMethod_thisNodeProvided_theSameNodeExpected() {
        assertEquals(thisNode, nodeHandler.getNode());
    }

    @Test
    void setNextMethod_nextHandlerProvidedAndSet_theSameHandlerExpected() {

        assertEquals(nextNodeHandler, nodeHandler.getNextNodeHandler());
    }

    @Test
    void handleMethod_nodeIsThisNode_decisionIsTrue_nextNodeHandlerProvided_nextNodeAttributeSetExpected() {
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(request.getParameter(Attribute.DECISION.getValue())).thenReturn("true");
        Mockito.when(nextNodeHandler.getNode()).thenReturn(nextNode);

        nodeHandler.handle(thisNode, request);

        Mockito.verify(session).setAttribute(Attribute.NEXT_NODE.getValue(), nextNode);
    }

    @Test
    void handleMethod_nodeIsNotThisNode_nextNodeHandlerHandleMethodCallExpected() {
        nodeHandler.handle(nextNode, request);

        Mockito.verify(nextNodeHandler).handle(nextNode, request);
    }

    @Test
    void handleMethod_nodeIsThisNode_decisionIsFalse_defeatActionsExpected() {
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(request.getParameter(Attribute.DECISION.getValue())).thenReturn("false");
        Mockito.when(session.getAttribute(Attribute.DEFEATED_TIMES.getValue())).thenReturn(0);

        nodeHandler.handle(thisNode, request);

        Mockito.verify(session).setAttribute(Attribute.GAME_END.getValue(), true);
        Mockito.verify(session).setAttribute(Attribute.DEFEATED_TIMES.getValue(), 1);
    }

    @Test
    void handleMethod_nodeIsThisNode_decisionIsTrue_nextNodeHandlerNullProvided_victoryActionsExpected() {
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(request.getParameter(Attribute.DECISION.getValue())).thenReturn("true");
        Mockito.when(nextNodeHandler.getNode()).thenReturn(null);
        Mockito.when(session.getAttribute(Attribute.VICTORY_TIMES.getValue())).thenReturn(0);

        nodeHandler.handle(thisNode, request);

        Mockito.verify(session).setAttribute(Attribute.VICTORY_TIMES.getValue(), 1);
        Mockito.verify(session).setAttribute(Attribute.GAME_END.getValue(), true);
        Mockito.verify(nextNodeHandler).handle(thisNode, request);
    }
}