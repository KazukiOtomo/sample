package com.practice.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.practice.domain.play.Field;

public interface IPlayRepository {

    /**
     * 判定直前での両者の手札の状況を記録する
     *
     * @return
     */
    int registerResult(Field field) throws JsonProcessingException;
}
