package com.practice.domain.play;

/**
 * 判定ロジックは"複雑"なので、17を超えるまで引く動作はshowDownコンテキストに分離する
 */

public class Dealer {

    final Hand hand;

    public Dealer(com.practice.domain.prepare.Dealer dealer) {
        this.hand = new Hand(dealer.getHand());
    }

}
