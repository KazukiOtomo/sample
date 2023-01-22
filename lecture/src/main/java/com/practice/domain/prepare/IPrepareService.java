package com.practice.domain.prepare;

public interface IPrepareService {

    /**
     * ゲームを開始する準備をする
     * (今回の"準備"とは、DealerとPlayerがお互いに2枚ずつCardを持っている状態に持っていくことを指している)
     * また、準備段階でのお互いの手札の状態をDBに記録する
     *
     */
    PrepareField prepare();
}
