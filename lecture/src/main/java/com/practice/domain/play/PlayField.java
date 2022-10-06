package com.practice.domain.play;

import com.practice.domain.prepare.PrepareField;
import lombok.Getter;

@Getter
public class PlayField {

    final Player player;
    final Dealer dealer;
    final Deck deck;

    public PlayField(PrepareField prepareField) {
        this.player = new Player(prepareField.getPlayer());
        this.dealer = new Dealer(prepareField.getDealer());
        this.deck = new Deck(prepareField.getDeck());
    }

}
