package com.practice.domain.prepare;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Hand {

    static final int FIRST_CARD_NUMBER = 2;

    final List<Card> cards;

    public Hand(final Deck deck) {
        this.cards = new ArrayList<>();
        init(deck);
    }

    private void init(final Deck deck) {
        for (int i = 0; i < FIRST_CARD_NUMBER; i++) {
            cards.add(deck.pop());
        }
    }

    public int size() {
        return cards.size();
    }

    public Card publishOneCard(){
        return this.cards.get(0);
    }
}
