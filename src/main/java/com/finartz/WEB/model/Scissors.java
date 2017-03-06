package com.finartz.WEB.model;

/**
 * Created by vural on 05-Mar-17.
 */
public class Scissors implements MoveRepository {

    public boolean isFirstWins (MoveRepository moveRepository) {

        if (moveRepository.getClassName().equalsIgnoreCase(PAPER)){
            return true;
        }

        return false;
    }

    @Override
    public boolean isSame(MoveRepository moveRepository) {
        if (this.getClassName().equalsIgnoreCase(moveRepository.getClassName()))
            return true;

        return false;
    }

    @Override
    public String getClassName() {
        return SCISSORS;
    }
}
