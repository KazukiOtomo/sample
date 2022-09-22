package com.practice.domain.prepare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeckTest {

    @Test
    void Deckを生成した際に52枚のカードを持っている状態になっている() {
        var deck = new Deck();
        assertEquals(52, deck.getCards().size());
    }

}
