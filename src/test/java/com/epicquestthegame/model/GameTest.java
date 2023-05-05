package com.epicquestthegame.model;

import com.epicquestthegame.model.endNodes.DefeatNodeHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Handler prisonNodeHandler;
    Game game;

    @BeforeEach
    void init() {
        prisonNodeHandler = new NodeHandler(new DefeatNodeHandler(), Node.PRISON);
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