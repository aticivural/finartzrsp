package com.finartz.WEB.model;

/**
 * Created by vural on 05-Mar-17.
 */
public interface MoveRepository {

    String PAPER = "paper";
    String ROCK = "rock";
    String SCISSORS = "scissors";

    String getClassName();

    boolean isFirstWins(MoveRepository moveRepository);

    boolean isSame(MoveRepository moveRepository);

}
