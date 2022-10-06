package com.practice.domain.rule;

import com.practice.domain.play.Hand;
import com.practice.domain.prepare.Card;

public class ScoreRule {

    //今回の課題では、判定アルゴリズムが本題ではないので、Aは「１」として扱うことにする
    public static int getScore(Hand hand) {
        int score = 0;
        for (Card card : hand.getCards()) {
            // 10以上の数字(J,Q,K)は10として扱う
            if (card.getNumber().getValue() > 10) score += 10;
            else score += card.getNumber().getValue();
        }
        return score;
    }
}
