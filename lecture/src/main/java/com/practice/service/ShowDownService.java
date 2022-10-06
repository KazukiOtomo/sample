package com.practice.service;

import com.practice.domain.rule.JudgeRule;
import com.practice.domain.showdown.IShowDownService;
import com.practice.domain.showdown.ShowDownField;

public class ShowDownService implements IShowDownService {

    @Override
    public boolean culculate(ShowDownField showDownField) {
        showDownField.getDealer().drawOver17(showDownField.getDeck());
        var isPlayerWin = JudgeRule.judgementWinner(showDownField);
        return isPlayerWin;
    }
}
