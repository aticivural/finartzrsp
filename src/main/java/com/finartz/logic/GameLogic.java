package com.finartz.logic;

import com.finartz.WEB.model.MapPopulator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.finartz.WEB.model.MapPopulator.build;

/**
 * GameLogic
 */
@Service
public class GameLogic{

    private static Map<String, Boolean> firstWins;
    static {

        firstWins = MapPopulator.build();
    }

    public synchronized boolean isSame(String firstPlayerMove, String secondPlayerMove) {
        /*if (firstWins == null) {
            firstWins = new HashMap<>();
            firstWins.put("paper-scissors", false);
            firstWins.put("paper-rock", true);
            firstWins.put("rock-scissors", true);
            firstWins.put("rock-paper", false);
            firstWins.put("scissors-paper", true);
            firstWins.put("scissors-rock", false);
        }*/

        //firstWins = MapPopulator.build();

        return firstPlayerMove.equals(secondPlayerMove);

        /*if (firstPlayerMove.equals(secondPlayerMove)) {
            return true;
        }*/

        //return false;
    }

    public synchronized boolean isFirstWins(String firstPlayerMove, String secondPlayerMove) {

        /*if (firstWins == null) {
            firstWins = build();
        }*/

        return firstWins.get(firstPlayerMove + "-" + secondPlayerMove);
    }


}
