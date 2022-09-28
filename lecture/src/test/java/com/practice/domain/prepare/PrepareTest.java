package com.practice.domain.prepare;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.repository.IPrepareRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PrepareTest {

    final IPrepareRepository prepareRepository;

    @Autowired
    public PrepareTest(IPrepareRepository prepareRepository) {
        this.prepareRepository = prepareRepository;
    }

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

    @Test
    void 初期状態をDBに格納する事ができている() throws JsonProcessingException {
        var flag = prepareRepository.register(new Field());
        assertEquals(flag, 1);
    }

}
