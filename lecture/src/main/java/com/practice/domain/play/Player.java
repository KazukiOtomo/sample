package com.practice.domain.play;

import com.practice.domain.prepare.Card;
import lombok.Getter;

@Getter
public class Player {

    final Hand hand;

    public Player(com.practice.domain.prepare.Player player) {
        this.hand = new Hand(player.getHand());
    }

    public Card draw(Deck deck) {
        var card = deck.pop();
        this.hand.cards.add(card);
        return card;
    }
}
