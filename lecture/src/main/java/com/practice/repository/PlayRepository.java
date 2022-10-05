package com.practice.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.domain.play.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PlayRepository implements IPlayRepository {

    final JdbcTemplate jdbc;
    final ObjectMapper mapper;

    @Autowired
    public PlayRepository(JdbcTemplate jdbc, ObjectMapper mapper) {
        this.jdbc = jdbc;
        this.mapper = mapper;
    }

    @Override
    public int registerResult(Field field) throws JsonProcessingException {
        var sql = """
                INSERT INTO final_hand
                VALUES (?, ?)
                """;
        return jdbc.update(sql,
                mapper.writeValueAsString(field.getDealer()),
                mapper.writeValueAsString(field.getPlayer()));
    }
}
