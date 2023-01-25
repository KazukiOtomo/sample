package com.practice.service;

import com.practice.domain.play.IPlayService;
import com.practice.domain.play.PlayField;
import com.practice.domain.prepare.Card;
import com.practice.domain.rule.JudgeRule;
import org.springframework.stereotype.Service;

@Service
public class PlayService implements IPlayService {

    @Override
    public Card hit(PlayField playField) {
        var deck = playField.getDeck();
        return playField.getPlayer().draw(deck);
    }

    @Override
    public boolean isPlayerWin(PlayField playField) {
        playField.getDealer().drawOver17(playField.getDeck());
        return JudgeRule.judgementWinner(playField);
    }

}
