package com.practice.domain.prepare;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    static final int FIRST_CARD_NUMBER = 2;

    /**
     * ここにGetterをつけたくない（でもJacksonの都合上つけなきゃいけない）
     */
    @Getter
    final List<Card> cards;

    public Hand(Deck deck) {
        this.cards = new ArrayList<>();
        init(deck);
    }

    private void init(Deck deck) {
        for (int i = 0; i < FIRST_CARD_NUMBER; i++) {
            cards.add(deck.pop());
        }
    }

    public int size() {
        return cards.size();
    }
}
