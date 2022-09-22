package com.practice.domain.prepare;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        generate();
    }

    private void generate() {
        for (Mark mark : Mark.values()) {
            for (int number = 1; number < 14; number++) {
                cards.add(new Card(new Number(number), mark));
            }
        }
    }

    public Card pop() {
        return this.cards.remove(0);
    }

    public List<Card> getCards() {
        return cards;
    }
}
