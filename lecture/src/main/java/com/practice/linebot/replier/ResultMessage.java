package com.practice.linebot.replier;

import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.practice.domain.play.IPlayService;
import com.practice.domain.play.PlayField;
import com.practice.domain.rule.ScoreRule;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class ResultMessage implements Replier {

    final MessageEvent<TextMessageContent> event;
    final IPlayService playService;
    final PlayField playField;

    @Autowired
    public ResultMessage(MessageEvent<TextMessageContent> event, IPlayService playService, PlayField playField) {
        this.event = event;
        this.playService = playService;
        this.playField = playField;
    }

    @Override
    public Message reply() {
        var flag = playService.isPlayerWin(this.playField);
        return new TextMessage(flag ? createWinMessage() : createLoseMessage());
    }

    private String createWinMessage() {
        var contentMessage = this.ContentMessage();
        return contentMessage + "あなたの勝ちです！";
    }

    private String createLoseMessage() {
        var contentMessage = this.ContentMessage();
        return contentMessage + "あなたの負けです...";
    }

    private String ContentMessage() {
        var playerContent = "プレイヤー側：" + ScoreRule.getScore(this.playField.getPlayer().getHand()) + "\n" +
                this.playField.getPlayer().getHand().getCards().stream()
                        .map(card -> card.getMessageContent())
                        .collect(Collectors.joining("\n"));
        var dealerContent = "ディーラー側：" + ScoreRule.getScore(this.playField.getDealer().getHand()) + "\n" +
                this.playField.getDealer().getHand().getCards().stream()
                        .map(card -> card.getMessageContent())
                        .collect(Collectors.joining("\n"));

        return playerContent + "\n" + dealerContent + "\n";
    }
}
