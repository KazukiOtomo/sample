package com.practice.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.practice.domain.prepare.PrepareField;

public interface IPrepareRepository {

    int register(PrepareField prepareField) throws JsonProcessingException;

}
