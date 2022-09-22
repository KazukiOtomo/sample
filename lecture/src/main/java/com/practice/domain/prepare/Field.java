package com.practice.domain.prepare;

import lombok.Getter;

@Getter
public class Field {

    private final Deck deck;
    private final Player player;
    private final Dealer dealer;

    public Field() {
        this.deck = new Deck();
        this.player = new Player(deck);
        this.dealer = new Dealer(deck);
    }

}
