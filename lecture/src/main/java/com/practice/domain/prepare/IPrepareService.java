package com.practice.domain.prepare;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IPrepareService {

    /**
     * ゲームを開始する準備をする
     * (今回の"準備"とは、DealerとPlayerがお互いに2枚ずつCardを持っている状態に持っていくことを指している)
     *
     * @return 準備済みのPlayer/Dealer,Deckが含まれたField
     */
    PrepareField prepare();

    /**
     * 準備段階での状態をDBに記録する
     * @param prepareField
     * @throws JsonProcessingException
     */
    void register(PrepareField prepareField) throws JsonProcessingException;
}
