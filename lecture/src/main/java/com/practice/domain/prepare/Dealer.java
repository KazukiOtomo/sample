package com.practice.domain.prepare;

public class Dealer {

    final Hand hand;

    public Dealer(Deck deck) {
        this.hand = new Hand(deck);
    }

    public Hand getHand() {
        return hand;
    }
}
