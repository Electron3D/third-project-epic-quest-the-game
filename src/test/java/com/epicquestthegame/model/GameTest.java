package com.epicquestthegame.model;

import com.epicquestthegame.model.endNodes.DefeatNodeHandler;
import com.epicquestthegame.model.nodes.PrisonNodeHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    NodeHandler prisonNodeHandler;
    Game game;

    @BeforeEach
    void init() {
        prisonNodeHandler = new PrisonNodeHandler(new DefeatNodeHandler());
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