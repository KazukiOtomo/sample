package com.practice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.practice.domain.prepare.Field;
import com.practice.domain.prepare.IPrepareService;
import com.practice.repository.IPrepareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrepareService implements IPrepareService {

    final IPrepareRepository prepareRepository;

    @Autowired
    public PrepareService(IPrepareRepository prepareRepository) {
        this.prepareRepository = prepareRepository;
    }

    @Override
    public Field prepare() {
        return new Field();
    }

    @Override
    public void register(final Field field) throws JsonProcessingException {
        prepareRepository.register(field);
    }
}
