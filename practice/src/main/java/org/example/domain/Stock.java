package org.example.domain;

public class Stock {

    final SuggestedPrice suggestedPrice;

    public Stock(SuggestedPrice suggestedPrice) {
        this.suggestedPrice = suggestedPrice;
        if(this.suggestedPrice.getValue() < 0 || this.suggestedPrice.getValue() > 10000) throw new IllegalArgumentException("希望小売価格に問題があります");
    }

}
