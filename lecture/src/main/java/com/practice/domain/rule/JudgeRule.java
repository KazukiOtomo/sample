package com.practice.domain.rule;

import com.practice.domain.play.PlayField;

public class JudgeRule {

    /**
     * @param playField
     * @return プレイヤーの勝利ならtrue/敗北ならfalse
     */
    public static boolean judgementWinner(PlayField playField) {
        var playerScore = ScoreRule.getScore(playField.getPlayer().getHand());
        var dealerScore = ScoreRule.getScore(playField.getDealer().getHand());

        // プレイヤーがバーストした場合、ディーラーの勝利
        if (playerScore > 21) return false;
            // ディーラーがバーストした場合、プレイヤーの勝利
        else if (dealerScore > 21) return true;
        else {
            // プレイヤーの勝利
            if (playerScore > dealerScore) return true;
                // 引き分けの場合は、ディーラーの勝利
            else if (playerScore == dealerScore) return false;
                // ディーラーの勝利
            else return false;
        }
    }
}
