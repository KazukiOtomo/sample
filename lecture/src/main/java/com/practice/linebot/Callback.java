package com.practice.linebot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import com.practice.domain.prepare.IPrepareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@LineMessageHandler
public class Callback {

    final IPrepareService prepareService;
    static final Logger log = LoggerFactory.getLogger(Callback.class);

    @Autowired
    public Callback(IPrepareService prepareService) {
        this.prepareService = prepareService;
    }

    @EventMapping
    public Message handleMessage(MessageEvent<TextMessageContent> event) throws JsonProcessingException {
        var message = event.getMessage().getText();
        switch (message) {
            case "準備":
                var field = prepareService.prepare();
                prepareService.register(field);
                return null;
        }
        return null;
    }
}
