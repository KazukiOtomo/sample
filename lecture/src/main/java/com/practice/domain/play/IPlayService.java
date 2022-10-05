package com.practice.domain.play;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IPlayService {

    /**
     * 判定直前での両者の手札の状況を記録する
     *
     * @return 更新回数
     */
    int registerResult(Field field) throws JsonProcessingException;


}
