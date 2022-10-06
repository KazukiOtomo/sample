package com.practice.domain.rule;

import com.practice.domain.showdown.ShowDownField;

public class JudgeRule {

    /**
     * @param showDownField
     * @return プレイヤーの勝利ならtrue/敗北ならfalse
     */
    public static boolean judgementWinner(ShowDownField showDownField) {
        var playerScore = ScoreRule.getScore(showDownField.getPlayer().getHand());
        var dealerScore = ScoreRule.getScore(showDownField.getDealer().getHand());

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
