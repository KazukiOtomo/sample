package com.practice.domain.prepare;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrepareTest {

    @Test
    void ゲームを開始する準備が問題なくできている() {
        var field = new Field();

        assertEquals(field.getPlayer().getHand().size(), 2);
        assertEquals(field.getDealer().getHand().size(), 2);
    }

    @Test
    void 手札の情報を正しいJson形式に変換できている() throws JsonProcessingException {
        var field = new Field();
        var mapper = new ObjectMapper();
        var s = mapper.writeValueAsString(field.getPlayer());
        System.out.println(s);
    }

}
