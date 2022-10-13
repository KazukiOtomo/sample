package com.practice.domain.prepare;

import lombok.Getter;

@Getter
public class Player {

    final Hand hand;

    public Player(final Deck deck) {
        this.hand = new Hand(deck);
    }
}
