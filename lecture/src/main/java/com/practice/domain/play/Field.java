package com.practice.domain.play;

import lombok.Getter;

@Getter
public class Field {

    final Player player;
    final Dealer dealer;
    final Deck deck;

    public Field(com.practice.domain.prepare.Player player, com.practice.domain.prepare.Dealer dealer, com.practice.domain.prepare.Deck deck) {
        this.player = new Player(player);
        this.dealer = new Dealer(dealer);
        this.deck = new Deck(deck);
    }

}
