package com.practice.domain.showdown;

import com.practice.domain.play.Deck;
import lombok.Getter;

@Getter
public class ShowDownField {

    final Player player;
    final Dealer dealer;
    final Deck deck;

    public ShowDownField(com.practice.domain.play.Player player, com.practice.domain.play.Dealer dealer, Deck deck) {
        this.player = new Player(player);
        this.dealer = new Dealer(dealer);
        this.deck = deck;
    }

}
