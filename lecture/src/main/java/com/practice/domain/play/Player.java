package com.practice.domain.play;

public class Player {

    final Hand hand;

    public Player(com.practice.domain.prepare.Player player) {
        this.hand = new Hand(player.getHand());
    }

    public void draw(Deck deck) {
        var card = deck.pop();
        this.hand.cards.add(card);
    }

    public Hand open() {
        return this.hand;
    }
}
