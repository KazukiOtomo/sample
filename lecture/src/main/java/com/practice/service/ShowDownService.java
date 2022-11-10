package com.practice.service;

import com.practice.domain.rule.JudgeRule;
import com.practice.domain.showdown.IShowDownService;
import com.practice.domain.showdown.ShowDownField;
import org.springframework.stereotype.Service;

@Service
public class ShowDownService implements IShowDownService {

    @Override
    public boolean isPlayerWin(ShowDownField showDownField) {
        showDownField.getDealer().drawOver17(showDownField.getDeck());
        var isPlayerWin = JudgeRule.judgementWinner(showDownField);
        return isPlayerWin;
    }
}
