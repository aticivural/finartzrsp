package com.finartz.logic;

import com.finartz.WEB.model.*;
import org.springframework.stereotype.Service;

/**
 * Created by vural on 05-Mar-17.
 */
@Service
public class GameLogic {

    private MoveRepository firstClass;
    private MoveRepository secondClass;
    private GameRequest gameRequest;

    public MoveRepository getFirstClass() {
        firstClass = createMove(gameRequest.getFirstPlayerMove());
        return firstClass;
    }

    public void setFirstClass(MoveRepository firstClass) {
        this.firstClass = firstClass;
    }

    public MoveRepository getSecondClass() {
        secondClass = createMove(gameRequest.getSecondPlayerMove());
        return secondClass;
    }

    public void setSecondClass(MoveRepository secondClass) {
        this.secondClass = secondClass;
    }

    public GameRequest getGameRequest() {
        return gameRequest;
    }

    public void setGameRequest(GameRequest gameRequest) {
        this.gameRequest = gameRequest;
    }

    private MoveRepository createMove (String moveName){

        if (moveName.equals(MoveRepository.ROCK)){
            return new Rock();
        }

        if (moveName.equals(MoveRepository.PAPER)){
            return new Paper();
        }

        if (moveName.equals(MoveRepository.SCISSORS)){
            return new Scissors();
        }

        return null;
    }
}
