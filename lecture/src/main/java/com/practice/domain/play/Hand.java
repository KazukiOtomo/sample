package com.practice.domain.play;

import com.practice.domain.prepare.Card;

import java.util.List;

public class Hand {

    private final List<Card> cards;

    public Hand(final com.practice.domain.prepare.Hand hand) {
        if (hand.size() < 2) throw new IllegalStateException("手札が足りていない");
        this.cards = hand.getCards();
    }

    public int size() {
        return this.cards.size();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }
}
