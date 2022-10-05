package com.practice.domain.play;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.practice.repository.IPlayRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PlayTest {

    final IPlayRepository playRepository;
    private Field field;

    @Autowired
    public PlayTest(IPlayRepository playRepository) {
        this.playRepository = playRepository;
    }

    @BeforeEach
    void setup() {
        var firstField = new com.practice.domain.prepare.Field();
        this.field = new Field(firstField.getPlayer(), firstField.getDealer(), firstField.getDeck());
    }

    @Test
    void プレイヤーが引くかどうかを決定できる() {

    }

    /**
     * TODO:Json変換の途中で失敗しているぽい
     * Getterは元々つけていた
     * デフォルトコンストラクタを追加してもダメ
     *
     * @throws JsonProcessingException
     */
    @Test
    void 判定直前時点でのお互いの手札の内容を記録できる() throws JsonProcessingException {
        var flag = playRepository.registerResult(field);
        assertEquals(flag, 1);
    }
}
