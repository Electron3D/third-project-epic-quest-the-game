package com.epicquestthegame.servlets;

import com.epicquestthegame.model.Game;
import com.epicquestthegame.model.Node;
import com.epicquestthegame.model.Handler;
import com.epicquestthegame.model.NodeHandler;
import com.epicquestthegame.model.endNodes.VictoryNodeHandler;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.epicquestthegame.utils.Attribute.*;

@WebServlet(name = "StartServlet", value = "/start")
public class StartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession currentSession = req.getSession();

        String gamerName = req.getParameter(GAMER_NAME.getValue());
        Handler firstNodeHandler = initChainOfNodes();
        Node firstNode = firstNodeHandler.getNode();

        Game game = new Game(firstNodeHandler, gamerName);

        currentSession.setAttribute(GAME.getValue(), game);
        currentSession.setAttribute(CURRENT_NODE.getValue(), firstNode);
        currentSession.setAttribute(NEXT_NODE.getValue(), firstNode);
        currentSession.setAttribute(GAME_END.getValue(), false);

        resp.sendRedirect("/game.jsp");
    }

    private Handler initChainOfNodes() {
        Handler victoryNodeHandler = new VictoryNodeHandler();

        Handler killTheKingNodeHandler = new NodeHandler(Node.KILL_THE_KING, victoryNodeHandler);
        Handler succubusNodeHandler = new NodeHandler(Node.SUCCUBUS, killTheKingNodeHandler);
        Handler makeAGangNodeHandler = new NodeHandler(Node.MAKE_A_GANG, succubusNodeHandler);
        Handler prisonNodeHandler = new NodeHandler(Node.PRISON, makeAGangNodeHandler);

        return prisonNodeHandler;
    }
}
