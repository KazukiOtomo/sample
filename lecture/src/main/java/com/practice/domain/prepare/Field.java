package com.practice.domain.prepare;

import lombok.Getter;

@Getter
public class Field {

    final Deck deck;
    final Player player;
    final Dealer dealer;

    public Field() {
        this.deck = new Deck();
        this.player = new Player(deck);
        this.dealer = new Dealer(deck);
    }

}
