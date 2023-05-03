package com.epicquestthegame.model;

public enum Node {
    PRISON("Тюрьма",
            "Ты очнулся в тюрьме. Что будешь делать?",
            "Честно ждать пока отпустят",
            "Попытаться сбежать",
            "Тебя поймали и казнили."),
    MAKE_A_GANG("Возвращение былого величия",
            "Ты честно отсидел свой срок. " +
            "Тебя выпустили, но время проведенное в тюрьме не прошло бесследно. " +
            "Ты затаил злобу. Тебе нужно собрать свою банду чтобы отомстить.",
            "Построить карьерную лестницу в криминальном мире",
            "Зазывать на улице",
            "Тебя поймали и казнили."),
    SUCCUBUS("Трудный выбор",
            "Ты стал иметь вес, твоя банда держит всех в страхе, а твое имя боятся произносить. " +
            "Однажды, когда ты был один, расслаблялся и отдыхал к тебе подсела миловидная девушка, " +
            "которая явно проявляла к тебе симпатию.",
            "Поддаться соблазну и отдаться утехам",
            "Заподозрить неладное и разобраться с ней",
            "Девушка оказалась суккубом, разозлилась и убила тебя и всю твою банду."),
    KILL_THE_KING("Месть",
            "Девушка оказалась суккубом, но в замен на твою любовь она " +
            "примкнула к твоей банде и ты стал еще могущественнее. Пришло время разобраться с тем кто упек " +
            "тебя в тюрьму.",
            "Влететь в замок короля с двух ног",
            "Разобраться по стелсу",
            "Твой ассасин оказался двойным агентом и сдал тебя королю. " +
            "Король отправил королевскую стражу и застав тебя в расплох убил.");
    final String name;
    final String eventDescription;
    final String positiveDecision;
    final String negativeDecision;
    final String defeatText;

    Node(String name, String eventDescription, String positiveDecision, String negativeDecision, String defeatText) {
        this.name = name;
        this.eventDescription = eventDescription;
        this.positiveDecision = positiveDecision;
        this.negativeDecision = negativeDecision;
        this.defeatText = defeatText;
    }

    public String getName() {
        return name;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getPositiveDecision() {
        return positiveDecision;
    }

    public String getNegativeDecision() {
        return negativeDecision;
    }

    public String getDefeatText() {
        return defeatText;
    }
}
