package com.practice.sample;

import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 手札の表示() {
        var hand = new Hand();
        hand.draw(new Card(new Number(1), Mark.スペード));
        hand.draw(new Card(new Number(4), Mark.ダイヤ));
        var player = new Player(hand);
        player.openHand();
    }

}