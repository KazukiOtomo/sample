package com.practice.linebot.replier;

import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import org.springframework.beans.factory.annotation.Autowired;

public class Prepare implements Replier {

    final MessageEvent<TextMessageContent> event;

    @Autowired
    public Prepare(MessageEvent<TextMessageContent> event) {
        this.event = event;
    }

    @Override
    public Message reply() {
        return null;
    }
}
