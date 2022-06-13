package org.example.domain.pricing;


import lombok.Getter;

public class Merchandise {

    @Getter
    private final Price price;

    public Merchandise(Price price) {
        this.price = price;
        if(this.price.getValue() < 0 || this.price.getValue() > 10000)
            throw new IllegalArgumentException("価格に問題があります");
    }

}
