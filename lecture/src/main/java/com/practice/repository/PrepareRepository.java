package com.practice.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.domain.prepare.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PrepareRepository implements IPrepareRepository {

    final JdbcTemplate jdbc;
    final ObjectMapper mapper;

    @Autowired
    public PrepareRepository(JdbcTemplate jdbc, ObjectMapper mapper) {
        this.jdbc = jdbc;
        this.mapper = mapper;
    }

    @Override
    public int register(final Field field) throws JsonProcessingException {
        var sql = """
                INSERT INTO initial_hand 
                VALUES (?, ?)
                """;
        return jdbc.update(sql,
                mapper.writeValueAsString(field.getDealer()), mapper.writeValueAsString(field.getPlayer()));
    }


}
