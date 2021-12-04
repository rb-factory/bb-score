package com.rbfactory.bbscore.dto;

import com.rbfactory.bbscore.Player;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GameResult {
    private final List<Player> players;

    public GameResult() {
        players = new ArrayList<>();
    }
}
