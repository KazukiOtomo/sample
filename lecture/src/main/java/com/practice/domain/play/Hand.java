package com.practice.domain.play;

import com.practice.domain.prepare.Card;
import lombok.Getter;

import java.util.List;

@Getter
public class Hand {

    final List<Card> cards;

    public Hand(final com.practice.domain.prepare.Hand hand) {
        if (hand.size() < 2) throw new IllegalStateException("手札が足りていない");
        this.cards = hand.getCards();
    }

    public int size() {
        return this.cards.size();
    }

}
