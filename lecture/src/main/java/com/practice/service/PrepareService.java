package com.practice.service;

import com.practice.domain.prepare.Field;
import com.practice.domain.prepare.IPrepareService;
import org.springframework.stereotype.Service;

@Service
public class PrepareService implements IPrepareService {

    @Override
    public Field prepare() {
        return new Field();
    }

}
