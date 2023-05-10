package com.epicquestthegame.model;

import com.epicquestthegame.model.endNodes.DefeatNodeHandler;
import com.epicquestthegame.model.endNodes.VictoryNodeHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AbstractEndNodeHandlerTest {
    Node thisNode;
    Handler defeatNodeHandler;
    Handler victoryNodeHandler;
    HttpServletRequest request;
    HttpSession session;

    @BeforeEach
    void init() {
        thisNode = Mockito.mock(Node.class);
        request = Mockito.mock(HttpServletRequest.class);
        session = Mockito.mock(HttpSession.class);
    }

    @Test
    void getThisNodeMethod_nullExpected() {
        defeatNodeHandler = new DefeatNodeHandler();
        assertNull(defeatNodeHandler.getThisNode());
    }

    @Test
    void handleMethod_defeatInheritorProvided_correctSessionSetAttributeExpected() {
        defeatNodeHandler = new DefeatNodeHandler();
        Mockito.when(request.getSession()).thenReturn(session);
        String defeatedText = "Defeat";
        Mockito.when(thisNode.getDefeatText()).thenReturn(defeatedText);

        defeatNodeHandler.handle(thisNode, request);

        Mockito.verify(session).setAttribute("resultText", "Поражение! " + defeatedText);
    }

    @Test
    void handleMethod_victoryInheritorProvided_correctSessionSetAttributeExpected() {
        victoryNodeHandler = new VictoryNodeHandler();
        Mockito.when(request.getSession()).thenReturn(session);

        victoryNodeHandler.handle(thisNode, request);

        Mockito.verify(session).setAttribute("resultText", "Победа, ты король мира!");
    }
}