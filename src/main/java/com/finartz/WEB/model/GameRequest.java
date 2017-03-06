package com.finartz.WEB.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * GameRequest
 */

public class GameRequest {

    private String firstPlayerName;
    private String firstPlayerMove;
    private String secondPlayerName;
    private String secondPlayerMove;

    public GameRequest() {}

    public String getFirstPlayerName() {
        return firstPlayerName;
    }

    public void setFirstPlayerName(String firstPlayerName) {
        this.firstPlayerName = firstPlayerName;
    }

    public String getFirstPlayerMove() {
        return firstPlayerMove;
    }

    public void setFirstPlayerMove(String firstPlayerMove) {
        this.firstPlayerMove = firstPlayerMove;
    }

    public String getSecondPlayerName() {
        return secondPlayerName;
    }

    public void setSecondPlayerName(String secondPlayerName) {
        this.secondPlayerName = secondPlayerName;
    }

    public String getSecondPlayerMove() {
        return secondPlayerMove;
    }

    public void setSecondPlayerMove(String secondPlayerMove) {
        this.secondPlayerMove = secondPlayerMove;
    }
}
