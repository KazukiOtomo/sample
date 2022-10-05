package com.practice.linebot.replier;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.practice.domain.prepare.Field;
import com.practice.domain.prepare.IPrepareService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class PrepareMessage implements Replier {

    final MessageEvent<TextMessageContent> event;
    final IPrepareService prepareService;

    @Autowired
    public PrepareMessage(MessageEvent<TextMessageContent> event, IPrepareService prepareService) {
        this.event = event;
        this.prepareService = prepareService;
    }

    @Override
    public Message reply() throws JsonProcessingException {
        var field = prepareService.prepare();
        prepareService.register(field);
        return new TextMessage(CreateMessage(field) +
                "\n");
    }

    private String CreateMessage(Field field) {
        var playerContent = "プレイヤー側：\n" +
                field.getPlayer().getHand().getCards().stream()
                        .map(card -> card.getContent())
                        .collect(Collectors.joining("\n")
                        );

        var dealerContent = "ディーラー側：\n" +
                field.getDealer().getHoleCard().getContent();

        return playerContent + "\n" + dealerContent;
    }
}
