package com.practice.domain.prepare;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PrepareTest {

    final IPrepareService prepareService;

    @Autowired
    public PrepareTest(IPrepareService prepareService) {
        this.prepareService = prepareService;
    }

    @Test
    void ゲームを開始する準備が問題なくできている() {
        var field = new PrepareField();
        assertEquals(field.getPlayer().getHand().size(), 2);
    }

    @Test
    void 初期状態をDBに格納する事ができている() {
        var prepareField = prepareService.prepare();
    }

    @Test
    void PrepareコンテキストでのPlayerの手札情報が取得できる() {
        var field = new PrepareField();

        var playerContent = "プレイヤー側：\n" + field.getPlayer().getHand().getCards().stream()
                .map(card -> card.getMessageContent())
                .collect(Collectors.joining("\n"));

        System.out.println(playerContent);
    }

    @Test
    void Dealerの手札情報が１枚だけ公開されている() {
        var field = new PrepareField();

        var dealerContent = "ディーラー側：\n" + field.getDealer().getHoleCard().getMessageContent();

        System.out.println(dealerContent);
    }

}
