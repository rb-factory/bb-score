package com.rb_factory.bb_score.calculator;

import com.rb_factory.bb_score.Player;

import java.util.Map;

public interface Calculator {

    Map<Player, Integer> calculatePoints();
}
