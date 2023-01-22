package com.practice.linebot;

import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import com.practice.domain.play.IPlayService;
import com.practice.domain.play.PlayField;
import com.practice.domain.prepare.IPrepareService;
import com.practice.domain.prepare.PrepareField;
import com.practice.domain.showdown.IShowDownService;
import com.practice.linebot.replier.HitMessage;
import com.practice.linebot.replier.PrepareMessage;
import com.practice.linebot.replier.ResultMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@LineMessageHandler
public class Callback {

    final IPrepareService prepareService;
    final IPlayService playService;
    final IShowDownService showDownService;
    static final Logger log = LoggerFactory.getLogger(Callback.class);

    private PrepareField prepareField;
    private PlayField playfield;

    @Autowired
    public Callback(IPrepareService prepareService, IPlayService playService, IShowDownService showDownService) {
        this.prepareService = prepareService;
        this.playService = playService;
        this.showDownService = showDownService;
    }

    @EventMapping
    public Message handleMessage(MessageEvent<TextMessageContent> event) {
        var message = event.getMessage().getText();

        switch (message) {
            case "開始" -> {
                this.prepareField = prepareService.prepare();
                var prepareMessage = new PrepareMessage(event, prepareService, this.prepareField);
                return prepareMessage.reply();
            }
            case "ヒット" -> {
                this.playfield = new PlayField(this.prepareField);
                var hitMessage = new HitMessage(event, playService, this.prepareField);
                return hitMessage.reply();
            }
            case "勝負" -> {
                var resultMessage = new ResultMessage(event, showDownService, this.playfield);
                return resultMessage.reply();
            }
        }

        return new TextMessage("該当文字列なし");
    }
}
