package com.practice.domain.play;

import com.practice.domain.prepare.Card;

import java.util.List;

public class Deck {

    final List<Card> cards;

    public Deck(com.practice.domain.prepare.Deck deck) {
        this.cards = deck.getCards();
    }

    public Card getTop() {
        return this.cards.remove(0);
    }
}
