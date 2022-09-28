package com.practice.domain.prepare;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Deck {

    final List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        generate();
        Collections.shuffle(cards);
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
}
