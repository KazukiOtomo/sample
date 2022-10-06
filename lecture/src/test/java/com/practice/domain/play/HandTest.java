package com.practice.domain.play;

import com.practice.domain.prepare.PrepareField;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandTest {

    @Test
    void パッケージを跨いだ手札をインスタンス化できる() {
        var field = new PrepareField();

        var prepareHand = field.getPlayer().getHand();
        var playHand = new Hand(prepareHand);
        assertEquals(playHand.size(), 2);
    }
}
