package com.epicquestthegame.model.endNodes;

import com.epicquestthegame.model.Node;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DefeatNodeHandlerTest {

    @Test
    void handleResultMethod_textSampleProvided_correctConcatenatedInnerTextAndTheGivenSampleExpected() {
        DefeatNodeHandler handler = new DefeatNodeHandler();
        Node node = Mockito.mock(Node.class);
        String defeatedText = "Defeat";
        Mockito.when(node.getDefeatText()).thenReturn(defeatedText);
        assertEquals("Поражение! " + defeatedText, handler.handleResult(node));
    }
}