package com.rbfactory.bbscore;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Player {
    private final PlayerColor playerColor;
    private int score;

    public void updateScore(int additionalScore){
        if(additionalScore > 0){
            score += additionalScore;
        }
    }
}
