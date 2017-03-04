package com.finartz.WEB.model;

/**
 * GameResponse
 */
public class GameResponse {

    private boolean isFirstPlayerWins;
    private boolean isSecondPlayerWins;
    private String message;
    private String winner;

    public GameResponse() {}

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public boolean isFirstPlayerWins() {
        return isFirstPlayerWins;
    }

    public void setFirstPlayerWins(boolean firstPlayerWins) {
        isFirstPlayerWins = firstPlayerWins;
    }

    public boolean isSecondPlayerWins() {
        return isSecondPlayerWins;
    }

    public void setSecondPlayerWins(boolean secondPlayerWins) {
        isSecondPlayerWins = secondPlayerWins;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
