package com.practice.domain.play;

import com.practice.domain.prepare.PrepareField;
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

    final IPlayService playService;
    private PlayField playField;

    @Autowired
    public PlayTest(IPlayService playService) {
        this.playService = playService;
    }

    @BeforeEach
    void setup() {
        var firstField = new PrepareField();
        this.playField = new PlayField(firstField);
    }

    @Test
    void プレイヤーがカードを追加で引くことができる() {
        playService.hit(this.playField);
        assertEquals(this.playField.getPlayer().open().size(), 3);
    }

}
