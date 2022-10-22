package com.practice.linebot.replier;

import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.practice.domain.play.IPlayService;
import com.practice.domain.play.PlayField;
import com.practice.domain.prepare.PrepareField;
import org.springframework.beans.factory.annotation.Autowired;

public class HitMessage implements Replier {

    final MessageEvent<TextMessageContent> event;
    final IPlayService playService;
    final PlayField playField;

    @Autowired
    public HitMessage(MessageEvent<TextMessageContent> event, IPlayService playService, PrepareField prepareField) {
        this.event = event;
        this.playService = playService;
        this.playField = new PlayField(prepareField);
    }

    @Override
    public Message reply() {
        var card = playService.hit(this.playField);
        return new TextMessage("引いたカードは、\n" + card.getMessageContent());
    }
}
