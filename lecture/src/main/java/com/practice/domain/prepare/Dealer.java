package com.practice.domain.prepare;

import lombok.Getter;

@Getter
public class Dealer {

    final Hand hand;

    public Dealer(final Deck deck) {
        this.hand = new Hand(deck);
    }

    public Card getHoleCard() {
        //Handが0枚のことはあり得ないので、例外処理は要らない
        return this.hand.publishOneCard();
    }
}
