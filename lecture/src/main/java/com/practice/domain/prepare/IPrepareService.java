package com.practice.domain.prepare;

public interface IPrepareService {

    /**
     * ゲームを開始する準備をする
     * (今回の"準備"とは、DealerとPlayerがお互いに2枚ずつCardを持っている状態に持っていくことを指している)
     * @return 準備済みのPlayer/Dealer,Deckが含まれたField
     */
    Field prepare();
}