package com.epicquestthegame.model.endNodes;

import com.epicquestthegame.model.Handler;
import com.epicquestthegame.model.Node;
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
class DefeatNodeHandlerTest {
    Node thisNode;
    Handler defeatNodeHandler;
    HttpServletRequest request;
    HttpSession session;

    @BeforeEach
    void init() {
        thisNode = Mockito.mock(Node.class);
        request = Mockito.mock(HttpServletRequest.class);
        session = Mockito.mock(HttpSession.class);
    }

    @Test
    void getNodeMethod_nullExpected() {
        defeatNodeHandler = new DefeatNodeHandler();
        assertNull(defeatNodeHandler.getNode());
    }

    @Test
    void handleMethod_defeatInheritorProvided_correctSessionSetAttributeExpected() {
        defeatNodeHandler = new DefeatNodeHandler();
        Mockito.when(request.getSession()).thenReturn(session);
        String defeatedText = "Defeat";
        Mockito.when(thisNode.getDefeatText()).thenReturn(defeatedText);

        defeatNodeHandler.handle(thisNode, request);

        Mockito.verify(session).setAttribute(Attribute.RESULT_TEXT.getValue(), "Поражение! " + defeatedText);
    }
}