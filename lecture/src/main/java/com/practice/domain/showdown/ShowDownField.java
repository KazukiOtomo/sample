package com.practice.domain.showdown;

import com.practice.domain.play.Deck;
import com.practice.domain.play.PlayField;
import lombok.Getter;

@Getter
public class ShowDownField {

    final Player player;
    final Dealer dealer;
    final Deck deck;

    public ShowDownField(final PlayField playField) {
        this.player = new Player(playField.getPlayer());
        this.dealer = new Dealer(playField.getDealer());
        this.deck = playField.getDeck();
    }

}
