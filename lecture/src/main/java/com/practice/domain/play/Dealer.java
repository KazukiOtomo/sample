package com.practice.domain.play;

import lombok.Getter;

/**
 * 判定ロジックは"複雑"なので、17を超えるまで引く動作はshowDownコンテキストに分離する
 */
@Getter
public class Dealer {

    final Hand hand;

    public Dealer(com.practice.domain.prepare.Dealer dealer) {
        this.hand = new Hand(dealer.getHand());
    }

}
