package com.finartz.WEB.controller;

import com.finartz.WEB.model.GameRequest;
import com.finartz.WEB.model.GameResponse;
import com.finartz.logic.GameLogic;
import com.finartz.WEB.model.MoveRepository;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * GameController
 */
@RestController
@RequestMapping("/game")
public class GameController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @RequestMapping(value = "/play", method = RequestMethod.POST)
    public GameResponse play(@RequestBody GameRequest request) {

        GameLogic gameLogic = applicationContext.getBean(GameLogic.class);
        gameLogic.setGameRequest(request);
        MoveRepository firstMoveClass = gameLogic.getFirstClass();
        MoveRepository secondMoveClass = gameLogic.getSecondClass();

        boolean same = firstMoveClass.isSame(secondMoveClass);
        if (same) {
            GameResponse gameResponse = new GameResponse();
            gameResponse.setFirstPlayerWins(false);
            gameResponse.setSecondPlayerWins(false);
            gameResponse.setWinner("");
            gameResponse.setMessage(request.getFirstPlayerName() + " and " + request.getSecondPlayerName() + " made same move.");
            return gameResponse;
        }

        GameResponse gameResponse = new GameResponse();

        boolean firstPlayerWins = firstMoveClass.isFirstWins(secondMoveClass);

        if (firstPlayerWins) {
            gameResponse.setFirstPlayerWins(true);
            gameResponse.setSecondPlayerWins(false);
        } else {
            gameResponse.setFirstPlayerWins(false);
            gameResponse.setSecondPlayerWins(true);
        }

        gameResponse.setWinner(firstPlayerWins ? request.getFirstPlayerName() : request.getSecondPlayerName());

        prepareWinningMessage(request, firstPlayerWins, gameResponse);

        return gameResponse;
    }

    private void prepareWinningMessage(GameRequest request, boolean firstPlayerWins, GameResponse gameResponse) {
        String winningMessage = " won the game";
        gameResponse.setMessage(firstPlayerWins ? request.getFirstPlayerName() + winningMessage : request.getSecondPlayerName() + winningMessage);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.applicationContext = applicationContext;
    }
}
