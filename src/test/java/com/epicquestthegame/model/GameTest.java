package com.epicquestthegame.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GameTest {
    static Game game;

    @BeforeAll
    static void init() {
        game = new Game("gamer");
    }

    @Test
    void getStartedNode() {

    }

    @Test
    void getGamerNameMethodTest() {
        assertEquals("gamer", game.getGamerName());
    }
}