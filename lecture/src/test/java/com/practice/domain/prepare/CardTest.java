package com.practice.domain.prepare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {

    @Test
    void 不正な数字のトランプは作れない() {
        try {
            new Card(new Number(14), Mark.CLOVER);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "不正な数字");
        }
    }


}