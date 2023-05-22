package com.epicquestthegame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GameTest {
    Handler nextNodeHandler;
    Handler prisonNodeHandler;
    Game game;

    @BeforeEach
    void init() {
        nextNodeHandler = Mockito.mock(NodeHandler.class);
        prisonNodeHandler = new NodeHandler(Node.PRISON, nextNodeHandler);
        game = new Game(prisonNodeHandler, "gamer");
    }

    @Test
    void getGamerNameMethod_correctNameProvided_theSameNameExpected() {
        assertEquals("gamer", game.getGamerName());
    }

    @Test
    void getStartedNodeHandlerMethod_PrisonNodeHandlerProvided_theSameNodeHandlerExpected() {
        assertEquals(prisonNodeHandler, game.getStartedNode());
    }
}