package com.practice.service;

import com.practice.domain.prepare.IPrepareService;
import com.practice.domain.prepare.PrepareField;
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
    public PrepareField prepare() {
        var prepareField = prepareRepository.register(new PrepareField());
        return prepareField;
    }
}
