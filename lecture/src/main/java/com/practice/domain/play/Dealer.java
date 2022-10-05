package com.practice.domain.play;

public class Dealer {

    final Hand hand;

    public Dealer(com.practice.domain.prepare.Dealer dealer) {
        this.hand = new Hand(dealer.getHand());
    }

    public void draw(Deck deck) {
        var card = deck.pop();
        this.hand.cards.add(card);
    }
}
