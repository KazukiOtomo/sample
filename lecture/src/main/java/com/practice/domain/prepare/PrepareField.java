package com.practice.domain.prepare;

import lombok.Getter;

@Getter
public class PrepareField {

    GameId gameId;
    final Player player;
    final Dealer dealer;
    final Deck deck;

    public PrepareField() {
        this.deck = new Deck();
        this.player = new Player(deck);
        this.dealer = new Dealer(deck);
    }

    public void setGameId(GameId gameId) {
        this.gameId = gameId;
    }
}
