package com.practice.domain.prepare;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    final List<Card> cards;

    public Hand(Deck deck) {
        this.cards = new ArrayList<>();
        init(deck);
    }

    private void init(Deck deck) {
        for (int i = 0; i < 2; i++) {
            cards.add(deck.pop());
        }
    }

    public int size() {
        return cards.size();
    }
}
