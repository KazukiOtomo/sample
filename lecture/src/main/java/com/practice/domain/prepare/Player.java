package com.practice.domain.prepare;

public class Player {

    private final Hand hand;

    public Player(Deck deck) {
        this.hand = new Hand(deck);
    }

    public Hand getHand() {
        return hand;
    }
}
