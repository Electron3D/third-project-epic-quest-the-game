package com.epicquestthegame.model.endNodes;

import com.epicquestthegame.model.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VictoryNodeHandlerTest {

    @Test
    void handleResultMethod_correctInnerTextReturnExpected() {
        VictoryNodeHandler handler = new VictoryNodeHandler();
        Node node = Mockito.mock(Node.class);
        assertEquals("Победа, ты король мира!", handler.handleResult(node));
    }
}