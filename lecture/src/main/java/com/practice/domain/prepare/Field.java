package com.practice.domain.prepare;

import lombok.Getter;

@Getter
public class Field {

    final Player player;
    final Dealer dealer;
    final Deck deck;

    public Field() {
        this.deck = new Deck();
        this.player = new Player(deck);
        this.dealer = new Dealer(deck);
    }

}
