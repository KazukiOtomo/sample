package com.practice.domain.prepare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrepareTest {

    @Test
    void ゲームを開始する準備が問題なくできている() {
        var field = new Field();

        assertEquals(field.getPlayer().getHand().size(), 2);
        assertEquals(field.getDealer().getHand().size(), 2);
    }
}
