package com.practice.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.practice.domain.prepare.Field;

public interface IPrepareRepository {

    void register(Field field) throws JsonProcessingException;

}
