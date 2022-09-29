package com.practice.linebot.replier;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.linecorp.bot.model.message.Message;

public interface Replier {

    Message reply() throws JsonProcessingException;

}
