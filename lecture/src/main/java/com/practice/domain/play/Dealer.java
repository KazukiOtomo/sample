package com.practice.domain.play;

import com.practice.domain.rule.ScoreRule;
import lombok.Getter;

@Getter
public class Dealer {

    final Hand hand;

    public Dealer(com.practice.domain.prepare.Dealer dealer) {
        this.hand = new Hand(dealer.getHand());
    }

    public void drawOver17(Deck deck) {
        int score = ScoreRule.getScore(this.hand);
        while (score < 17) {
            var card = deck.getTop();
            this.hand.getCards().add(card);
            score = ScoreRule.getScore(this.hand);
        }
    }

}
