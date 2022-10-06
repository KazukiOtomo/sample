package com.practice.domain.showdown;

import com.practice.domain.play.Deck;
import com.practice.domain.play.Hand;
import com.practice.domain.rule.ScoreRule;
import lombok.Getter;

@Getter
public class Dealer {

    final Hand hand;

    public Dealer(com.practice.domain.play.Dealer dealer) {
        this.hand = dealer.getHand();
    }

    public void drawOver17(Deck deck) {
        int score = ScoreRule.getScore(this.hand);
        while (score < 17) {
            draw(deck);
            score = ScoreRule.getScore(this.hand);
        }
    }

    public void draw(Deck deck) {
        var card = deck.pop();
        this.hand.getCards().add(card);
        return;
    }
}
