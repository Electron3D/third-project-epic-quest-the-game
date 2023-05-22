package com.epicquestthegame.utils;

public enum Attribute {
    GAMER_NAME("gamerName"),
    GAME("game"),
    GAME_END("gameEnd"),
    CURRENT_NODE("currentNode"),
    NEXT_NODE("nextNode"),
    VICTORY_TIMES("victoryTimes"),
    DEFEATED_TIMES("defeatedTimes"),
    IP("ip"),
    DECISION("decision"),
    RESULT_TEXT("resultText");

    final String value;
    Attribute(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
