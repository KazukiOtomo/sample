package com.practice.domain.showdown;

import com.practice.domain.play.Hand;
import lombok.Getter;

@Getter
public class Player {

    final Hand hand;

    public Player(com.practice.domain.play.Player player) {
        this.hand = player.getHand();
    }

}
