package com.practice.domain.prepare;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.repository.IPrepareRepository;
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

    final IPrepareRepository prepareRepository;
    final IPrepareService prepareService;

    @Autowired
    public PrepareTest(IPrepareRepository prepareRepository, IPrepareService prepareService) {
        this.prepareRepository = prepareRepository;
        this.prepareService = prepareService;
    }

    @Test
    void ゲームを開始する準備が問題なくできている() {
        var field = new PrepareField();

        assertEquals(field.getPlayer().getHand().size(), 2);
    }

    @Test
    void 手札の情報を正しいJson形式に変換できている() throws JsonProcessingException {
        var field = new PrepareField();
        var mapper = new ObjectMapper();
        var s = mapper.writeValueAsString(field.getPlayer());
        System.out.println(s);
    }

    @Test
    void 初期状態をDBに格納する事ができている() throws JsonProcessingException {
        var flag = prepareRepository.register(new PrepareField());
        assertEquals(flag, 1);
    }

    @Test
    void PrepareコンテキストでのPlayerの手札情報が取得できる() {
        var field = prepareService.prepare();

        var playerContent = "プレイヤー側：\n" + field.getPlayer().getHand().getCards().stream()
                .map(card -> card.getContent())
                .collect(Collectors.joining("\n"));

        System.out.println(playerContent);
    }

    @Test
    void Dealerの手札情報が１枚だけ公開されている() {
        var field = prepareService.prepare();

        var dealerContent = "ディーラー側：\n" + field.getDealer().getHoleCard().getContent();

        System.out.println(dealerContent);
    }

}
