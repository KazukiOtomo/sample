package com.practice.domain.prepare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandTest {

    @Test
    void Handがインスタンス化された時点で2枚のCardを持っている() {
        var hand = new Hand(new Deck());
        assertEquals(hand.size(), 2);
    }
}
