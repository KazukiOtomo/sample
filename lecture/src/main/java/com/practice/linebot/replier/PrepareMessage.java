package com.practice.linebot.replier;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.practice.domain.prepare.PrepareField;
import com.practice.domain.prepare.IPrepareService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class PrepareMessage implements Replier {

    final MessageEvent<TextMessageContent> event;
    final IPrepareService prepareService;
    final PrepareField prepareField;

    @Autowired
    public PrepareMessage(MessageEvent<TextMessageContent> event, IPrepareService prepareService, PrepareField prepareField) {
        this.event = event;
        this.prepareService = prepareService;
        this.prepareField = prepareField;
    }

    @Override
    public Message reply() throws JsonProcessingException {
        prepareService.register(this.prepareField);
        return new TextMessage(CreateMessage(this.prepareField) +
                "\n");
    }

    private String CreateMessage(PrepareField prepareField) {
        var playerContent = "プレイヤー側：\n" +
                prepareField.getPlayer().getHand().getCards().stream()
                        .map(card -> card.getMessageContent())
                        .collect(Collectors.joining("\n")
                        );

        var dealerContent = "ディーラー側：\n" +
                prepareField.getDealer().getHoleCard().getMessageContent();

        return playerContent + "\n" + dealerContent;
    }
}
