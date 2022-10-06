package com.practice.linebot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import com.practice.domain.play.IPlayService;
import com.practice.domain.prepare.PrepareField;
import com.practice.domain.prepare.IPrepareService;
import com.practice.linebot.replier.HitMessage;
import com.practice.linebot.replier.PrepareMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@LineMessageHandler
public class Callback {

    final IPrepareService prepareService;
    final IPlayService playService;
    static final Logger log = LoggerFactory.getLogger(Callback.class);

    private PrepareField prepareField;

    @Autowired
    public Callback(IPrepareService prepareService, IPlayService playService) {
        this.prepareService = prepareService;
        this.playService = playService;
    }

    @EventMapping
    public Message handleMessage(MessageEvent<TextMessageContent> event) throws JsonProcessingException {
        var message = event.getMessage().getText();

        switch (message) {
            case "開始":
                this.prepareField = prepareService.prepare();

                var prepareMessage = new PrepareMessage(event, prepareService, this.prepareField);
                return prepareMessage.reply();
            case "ヒット":
                var hitMessage = new HitMessage(event, playService, this.prepareField);
                return hitMessage.reply();
            case "勝負":

        }
        return null;
    }
}
