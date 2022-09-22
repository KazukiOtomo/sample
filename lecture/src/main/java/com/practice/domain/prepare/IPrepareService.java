package com.practice.domain.prepare;

public interface IPrepareService {

    /**
     * ゲームを開始する準備をする
     * (今回の"準備"とは、DealerとPlayerがお互いに2枚ずつCardを持っている状態に持っていくことを指している)
     * @return Player/Dealerが2枚ずつCardを引いた後のDeck
     */
    Field prepare();
}
