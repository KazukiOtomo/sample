package com.practice.linebot.replier;

import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.practice.domain.play.PlayField;
import com.practice.domain.showdown.IShowDownService;
import com.practice.domain.showdown.ShowDownField;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class ResultMessage implements Replier {

    final MessageEvent<TextMessageContent> event;
    final IShowDownService showDownService;
    final ShowDownField showDownField;

    @Autowired
    public ResultMessage(MessageEvent<TextMessageContent> event, IShowDownService showDownService, PlayField playField) {
        this.event = event;
        this.showDownService = showDownService;
        this.showDownField = new ShowDownField(playField);
    }

    @Override
    public Message reply() {
        var flag = showDownService.isPlayerWin(this.showDownField);
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
        var playerContent = "プレイヤー側：\n" +
                showDownField.getPlayer().getHand().getCards().stream()
                        .map(card -> card.getMessageContent())
                        .collect(Collectors.joining("\n"));
        var dealerContent = "ディーラー側：\n" +
                showDownField.getDealer().getHand().getCards().stream()
                        .map(card -> card.getMessageContent())
                        .collect(Collectors.joining("\n"));

        return playerContent + "\n" + dealerContent + "\n";
    }
}
