package com.practice.domain.prepare;

import lombok.Getter;

@Getter
public class Card {

    final Number number;
    final Mark mark;

    public Card(Number number, Mark mark) {
        if (number.getValue() <= 0 || number.getValue() >= 14) throw new IllegalArgumentException("不正な数字");
        this.number = number;
        this.mark = mark;
    }

    public String getContent() {
        return this.mark.toString() + "," + this.getNumber().getValue();
    }
}
