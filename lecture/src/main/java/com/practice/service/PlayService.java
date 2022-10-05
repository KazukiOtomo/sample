package com.practice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.practice.domain.play.Field;
import com.practice.domain.play.IPlayService;
import com.practice.repository.IPlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayService implements IPlayService {

    final IPlayRepository playRepository;

    @Autowired
    public PlayService(IPlayRepository playRepository) {
        this.playRepository = playRepository;
    }

    @Override
    public int registerResult(Field field) throws JsonProcessingException {
        return playRepository.registerResult(field);
    }
}
