package com.epicquestthegame.servlets;

import com.epicquestthegame.model.Game;
import com.epicquestthegame.model.Node;
import com.epicquestthegame.model.Handler;
import com.epicquestthegame.model.NodeHandler;
import com.epicquestthegame.model.endNodes.DefeatNodeHandler;
import com.epicquestthegame.model.endNodes.VictoryNodeHandler;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "StartServlet", value = "/start")
public class StartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession currentSession = req.getSession();

        String gamerName = req.getParameter("gamerName");
        Handler firstNodeHandler = initChainOfNodes();
        Node firstNode = firstNodeHandler.getThisNode();

        Game game = new Game(firstNodeHandler, gamerName);

        currentSession.setAttribute("game", game);
        currentSession.setAttribute("currentNode", firstNode);
        currentSession.setAttribute("nextNode", firstNode);
        currentSession.setAttribute("gameEnd", false);

        resp.sendRedirect("/game.jsp");
    }

    private Handler initChainOfNodes() {
        Handler victoryNodeHandler = new VictoryNodeHandler();
        Handler defeatNodeHandler = new DefeatNodeHandler();

        Handler prisonNodeHandler = new NodeHandler(defeatNodeHandler, Node.PRISON);
        Handler makeAGangNodeHandler = new NodeHandler(defeatNodeHandler, Node.MAKE_A_GANG);
        Handler succubusNodeHandler = new NodeHandler(defeatNodeHandler, Node.SUCCUBUS);
        Handler killTheKingNodeHandler = new NodeHandler(defeatNodeHandler, Node.KILL_THE_KING);

        prisonNodeHandler.setNext(makeAGangNodeHandler);
        makeAGangNodeHandler.setNext(succubusNodeHandler);
        succubusNodeHandler.setNext(killTheKingNodeHandler);
        killTheKingNodeHandler.setNext(victoryNodeHandler);

        return prisonNodeHandler;
    }
}
