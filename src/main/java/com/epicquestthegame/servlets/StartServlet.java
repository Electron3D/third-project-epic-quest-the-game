package com.epicquestthegame.servlets;

import com.epicquestthegame.model.Node;
import com.epicquestthegame.model.NodeHandler;
import com.epicquestthegame.model.endNodes.DefeatNodeHandler;
import com.epicquestthegame.model.endNodes.VictoryNodeHandler;
import com.epicquestthegame.model.nodes.KillTheKingNodeHandler;
import com.epicquestthegame.model.nodes.MakeAGangNodeHandler;
import com.epicquestthegame.model.nodes.PrisonNodeHandler;
import com.epicquestthegame.model.nodes.SuccubusNodeHandler;

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

        NodeHandler firstNodeHandler = initChainOfNodes();
        Node firstNode = firstNodeHandler.getThisNode();

        currentSession.setAttribute("firstNodeHandler", firstNodeHandler);
        currentSession.setAttribute("currentNode", firstNode);
        currentSession.setAttribute("nextNode", firstNode);
        currentSession.setAttribute("gameEnd", false);

        resp.sendRedirect("/game.jsp");
    }

    private NodeHandler initChainOfNodes() {
        NodeHandler victoryNodeHandler = new VictoryNodeHandler();
        NodeHandler defeatNodeHandler = new DefeatNodeHandler();

        NodeHandler prisonNodeHandler = new PrisonNodeHandler(defeatNodeHandler);
        NodeHandler makeAGangNodeHandler = new MakeAGangNodeHandler(defeatNodeHandler);
        NodeHandler succubusNodeHandler = new SuccubusNodeHandler(defeatNodeHandler);
        NodeHandler killTheKingNodeHandler = new KillTheKingNodeHandler(defeatNodeHandler);

        prisonNodeHandler.setNext(makeAGangNodeHandler);
        makeAGangNodeHandler.setNext(succubusNodeHandler);
        succubusNodeHandler.setNext(killTheKingNodeHandler);
        killTheKingNodeHandler.setNext(victoryNodeHandler);

        return prisonNodeHandler;
    }
}
