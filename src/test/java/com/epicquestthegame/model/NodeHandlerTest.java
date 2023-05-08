package com.epicquestthegame.model;

import com.epicquestthegame.model.endNodes.DefeatNodeHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NodeHandlerTest {
    Handler defeatNode;
    Node thisNode;
    NodeHandler handler;

    @BeforeEach
    void init() {
        defeatNode = Mockito.mock(DefeatNodeHandler.class);
        thisNode = Mockito.mock(Node.class);
        handler = new NodeHandler(defeatNode, thisNode);
    }

    @Test
    void getThisNodeMethod_thisNodeProvided_theSameNodeExpected() {
        assertEquals(thisNode, handler.getThisNode());
    }

    @Test
    void setNextMethod_nextHandlerProvidedAndSet_theSameHandlerExpected() throws NoSuchFieldException,
            IllegalAccessException {
        Handler nextHandler = new NodeHandler(defeatNode,thisNode);
        handler.setNext(nextHandler);

        final Field field = handler.getClass().getDeclaredField("nextNodeHandler");
        field.setAccessible(true);
        assertEquals(nextHandler, field.get(handler));
    }
}