package com.practice.domain.play;

import com.practice.domain.prepare.Card;

public interface IPlayService {

    /**
     * プレイヤーがカードを引く動作を行う
     *
     * @param playField
     * @return 新しく引いたカード
     */
    Card hit(PlayField playField);
}
